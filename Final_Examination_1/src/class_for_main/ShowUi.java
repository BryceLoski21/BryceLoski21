package class_for_main;

public class ShowUi {
    // Constructor
    public ShowUi() {
    }

     public void show(){
        System.out.println("-------------------------------------\n"
                            + "\t\t\t员工管理系统\n"
                            + "\t学号:1906010810\t姓名:印兆庭\n"
                            + "\t1.添加员工信息\t" + "2.删除员工信息\n"
                            + "\t3.修改员工信息\t" + "4.查询员工信息\n"
                            + "\t5.查看所有员工\t" + "0.退出\n"
                            + "-------------------------------------\n");
    }
    // input name
    protected void inputName(){
        System.out.println("输入姓名:");
    }
    // input ID
    protected void inputId(){
        System.out.println("输入ID:");
    }
    // wrong input
    public void wrongInput(){
        System.out.println("请输入正确的数字！");
    }
}
