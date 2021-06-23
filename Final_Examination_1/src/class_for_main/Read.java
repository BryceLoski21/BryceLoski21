package class_for_main;

import java.util.Scanner;

public class Read {

    public Object[] read(Scanner inputData) {
        Object[] dataRead = new Object[2];
        try{
            inputData.nextLine(); // to read ""
            new ShowUi().inputName(); // System.out.print("输入姓名:");
            dataRead[0] = inputData.nextLine();
            new ShowUi().inputId(); // System.out.print("输入ID:");
            dataRead[1] = inputData.nextLine();
        }catch (Exception e){
            new ShowUi().wrongInput();
        }
        return dataRead;
    }
}
