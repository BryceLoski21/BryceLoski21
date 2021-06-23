package database;

import class_for_main.ShowUi;

import java.util.InputMismatchException;
import java.util.Scanner;

public class DataBase {
    private static String[] name;
    private static String[] id;
    private static int length;
    private static int index;
    // Constructor
    public DataBase() {
        name = new String[100];
        id = new String[100];
        length = 0;
        index = 0;
    }

    public boolean add(Object[] staff){
            if (length == 100) {
                System.out.println("数据库已满！");
                return false;
            }else{
                name[index] = staff[0].toString();
                id[index] = staff[1].toString();
                index++;
                length++;
                return true;
            }
    }
    public boolean delete(Object[] staff){
        if (isEmptyByLength())
            return false;
        for(int count = 0; count <= length; count++) {
            boolean judge1 = false;
            boolean judge2 = false;
            try {
                judge1 = staff[0].toString().equals(name[count]);
                judge2 = staff[1].toString().equals(id[count]);
            }catch (Exception e){
                e.printStackTrace();
            }
            if(judge1 & judge2) {
                name[count] = null;
                id[count] = null;
                index--;
                length--;
                return true;
            }
        }
        return false;
    }
    public boolean alter(Object[] staff, Scanner scan){
        if(isEmptyByLength())
            return false;
        for (int count = 0; count <= length; count++) {
            boolean judge1 = false;
            boolean judge2 = false;
            try {
                judge1 = staff[0].toString().equals(name[count]);
                judge2 = staff[1].toString().equals(id[count]);
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (judge1 && judge2) {
                select(staff);
                System.out.println("输入修改后的姓名和ID:");
                try{
                    name[count] = scan.nextLine();
                    id[count] = scan.nextLine();
                }catch (InputMismatchException e){
                    new ShowUi().wrongInput();
                }
                return true;
            }
        }
        return false;
    }
    public boolean select(Object[] staff){
        if(isEmptyByLength())
            return false;
        for(int count = 0; count <= length; count++){
            boolean judge1 = false;
            boolean judge2 = false;
            try {
                judge1 = staff[0].toString().equals(name[count]);
                judge2 = staff[1].toString().equals(id[count]);
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (judge1 | judge2) {
                System.out.println("查询结果:");
                System.out.println("姓名:" + name[count] + "\tID:" + id[count]);
                return true;
            }
        }
        return false;
    }
    public void selectAll(){
        if(!isEmptyByLength()){
            System.out.println("查询结果:");
            for(int count=0; count<=length; count++){
                System.out.println("姓名:" + name[count] + "\tID:" + id[count]);
            }
        }
    }
    private boolean isEmptyByLength(){
        if(length == 100){
            System.out.println("当前数据库为空！");
            return true;
        }
        return false;
    }
}
