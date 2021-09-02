package input_and_output;

import java.util.Scanner;

public class Read {

    public Object[] read(Scanner scanner){

        Object[] nameAndId = new Object[2];

        scanner.nextLine(); // to read ""
        new Write().inputName(); // System.out.print("输入姓名:");
        nameAndId[0] = scanner.nextLine();

        new Write().inputId(); // System.out.print("输入ID:");
        nameAndId[1] = scanner.nextLine();

        return nameAndId;
    }

    public Object[] inputEmployeeData(Scanner scanner) {

        Object[] dataRead = new Object[4];

        new Write().inputName(); // System.out.print("输入姓名:");
        dataRead[0] = scanner.nextLine();

        new Write().inputId(); // System.out.print("输入ID:");
        dataRead[1] = scanner.nextLine();

        new Write().inputSex(); // System.out.print("输入性别:");
        dataRead[2] = scanner.nextLine();

        new Write().inputAge(); // System.out.print("输入年龄:");
        dataRead[3] = scanner.nextLine();

        return dataRead;
    }
}
