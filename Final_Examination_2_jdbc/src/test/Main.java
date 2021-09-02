package test;

import input_and_output.*;
import database.Connect;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import static jdk.nashorn.internal.runtime.JSType.isNumber;

public class Main {

    public static void main(String[] args){

        // variable about user
        int choice = 0; // save user's choice
        Scanner scanner = new Scanner(System.in); // new a valuable scanner type of Scanner, scan user's input
        Read inputData = new Read(); // Read.cass, valuable inputData for reading input and return Object[]
        Object[] oldEmployeeData; // save employee's data( only name and id)
        Object[] newEmployeeData; // sava employee's data(name, id, sex, age)

        // variable about mysql
        String url = "jdbc:mysql://localhost:3306/FinalExamination?useSSL=true&useUnicode=true&characterEncoding=UTF-8";
        // serverTimezone=UTC -> NullPointerException: statement
        String name = "root";
        String password = "220616";
        Statement statement = null;

        // variable shower for showing menu or something else
        Write shower = new Write();

        // connect MsSQL
        Connect conn = new Connect();
        try {
            statement = conn.connect(url, name, password);
        } catch (SQLException e) {
            shower.wrongConnect();
        }

        // #######
        assert statement != null;

        // show User Interface
        shower.write();

        do{
            shower.ready();// println("\n选择要进行的操作?");

            // set the scanner to read line by line
            scanner.useDelimiter("\n");

            // read a number to save what is your choice
            try {
                choice = scanner.nextInt(); // ########bug
            }catch (Exception e){
                shower.wrongInput(); // println("请输入正确的数字！")
            }

            try{
                // is a number?
                if (isNumber(choice)) {
                    // do sth by choice
                    if (choice == 1) {
                        scanner.nextLine(); // read ""
                        oldEmployeeData = inputData.inputEmployeeData(scanner);
                        if (conn.sqlAdd(statement, oldEmployeeData)) // add (return true/false)
                            shower.executeRight();// println("执行成功!");
                        else
                            shower.executeWrong();// println("执行失败!")
                    }
                    if (choice == 2) {
                        oldEmployeeData = inputData.read(scanner);
                        if (!conn.sqlDelete(statement,oldEmployeeData)) // delete (return true/false)
                            shower.executeRight();// println("执行成功!");
                        else
                            shower.executeWrong();// println("执行失败!")
                    }
                    if (choice == 3) {
                        oldEmployeeData = inputData.read(scanner); // before
                        if(!conn.sqlSelect(statement, oldEmployeeData).next()) { // not null
                            shower.executeWrong();
                            continue;
                        }
                        System.out.println("输入更改后的数据:");
                        newEmployeeData = inputData .inputEmployeeData(scanner); // after
                        if (conn.sqlUpdate(statement, oldEmployeeData, newEmployeeData)) // alter (return true/false)
                            shower.executeRight();// println("执行成功!");
                        else
                            shower.executeWrong();// println("执行失败!")
                    }
                    if (choice == 4) {
                        oldEmployeeData = inputData.read(scanner);
                        ResultSet temp = conn.sqlSelect(statement, oldEmployeeData);
                        if(temp.next()) // ResultSet isn't null
                            shower.printTable(temp); // print data
                        else
                            shower.executeWrong();// println("执行失败!")
                        }
                    if (choice == 5) {
                        ResultSet temp = conn.sqlSelectAll(statement);
                        if(temp.next()) // ResultSet isn't null
                            shower.printTable(temp); // print data
                        else
                            shower.executeWrong();// println("执行失败!")
                    }
                    if (choice == 0)
                        break;
                    if(choice!=1 & choice!=2 & choice!=3 & choice!=4 & choice!=5) {
                        shower.wrongInput(); // print "请输入正确的数字！" if choice isn't 1|2|3|4|5|0
                    }
                }else {
                    shower.wrongInput(); // print "请输入正确的数字！" if choice is not a number
                }
            }catch (SQLException e){
                shower.executeWrong(); // print "执行失败！"
            }
        }while (true);
        try {
            // #######
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        // ######
        scanner.close();
    }
}
