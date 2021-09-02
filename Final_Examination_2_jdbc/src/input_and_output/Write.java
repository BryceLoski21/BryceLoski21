package input_and_output;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Write {
    // Constructor
    public Write() {
    }

     public void write(){
        System.out.println("-------------------------------------\n"
                            + "\t\t\t员工管理系统\n"
                            + "\t学号:1906010810\t姓名:印兆庭\n"
                            + "\t1.添加员工信息\t" + "2.删除员工信息\n"
                            + "\t3.修改员工信息\t" + "4.查询员工信息\n"
                            + "\t5.查看所有员工\t" + "0.退出\n"
                            + "-------------------------------------\n");
    }
    // ready
    public void ready(){
        System.out.println("\n选择要进行的操作?");
    }
    // input name
    protected void inputName(){
        System.out.println("输入姓名:");
    }
    // input ID
    protected void inputId(){
        System.out.println("输入ID:");
    }
    // input sex
    protected void inputSex(){
        System.out.println("输入性别:");
    }
    // input age
    protected void inputAge(){
        System.out.println("输入年龄:");
    }
    // wrong input
    public void wrongInput(){
        System.out.println("请输入正确的数字！");
    }
    // execute sql rightly
    public void executeRight(){
        System.out.println("执行成功！");
    }
    // wrong with execute sql
    public void executeWrong(){
        System.out.println("执行失败！");
    }
    // wrong connect
    public void wrongConnect(){
        System.out.println("可能没有启动Mysql?");
    }
    // print table
    public void printTable(ResultSet temp) throws SQLException {
        do{
            System.out.println("姓名:" + temp.getString("name")
                    + "\tID:" + temp.getString("id")
                    + "\t性别:" + temp.getString("sex")
                    + "\t年龄:" + temp.getString("age"));
        }while (temp.next());
    }
}
