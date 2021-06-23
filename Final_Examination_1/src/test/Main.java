package test;

import class_for_main.*;
import database.DataBase;

import java.util.Scanner;

import static jdk.nashorn.internal.runtime.JSType.isNumber;

public class Main {

    public static void main(String[] args){

        int choice = 0;
        Scanner scanner = new Scanner(System.in);
        Read inputData = new Read();
        DataBase doSth = new DataBase();
        Object[] staffData;

        // show User Interface
        new ShowUi().show();

        do{
            System.out.println("选择要进行的操作？");

            // set the scanner to read line by line
            scanner.useDelimiter("\n");

            // read a number what you choose
            try {
                choice = scanner.nextInt();
            }catch (Exception e){
                new ShowUi().wrongInput();
            }

            // is a number?
            if (isNumber(choice)) {
                // do sth by choice
                if (choice == 1) {
                    staffData = inputData.read(scanner);
                    if (doSth.add(staffData)) // add
                        System.out.println("添加数据成功！");
                }
                if (choice == 2) {
                    staffData = inputData.read(scanner);
                    if (doSth.delete(staffData)) // delete
                        System.out.println("删除数据成功！");
                }
                if (choice == 3) {
                    staffData = inputData.read(scanner);
                    if (doSth.alter(staffData, scanner)) // alter
                        System.out.println("修改数据成功！");
                }
                if (choice == 4) {
                    staffData = inputData.read(scanner);
                    if (!doSth.select(staffData)) // select
                        System.out.println("查询失败！");
                }
                if (choice == 5)
                    doSth.selectAll();
                if (choice == 0)
                    break;
                // if choice is't 1|2|3|4|5|0 to print "请输入正确的数字！"
                if(choice!=1 & choice!=2 & choice!=3 & choice!=4 & choice!=5)
                    new ShowUi().wrongInput();
            }else // choice is not a number to print "请输入正确的数字！"
                new ShowUi().wrongInput();
        }while (true);
        // ######
        scanner.close();
    }
}
