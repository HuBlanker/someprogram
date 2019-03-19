package money.studen_homework;

/**
 * created by huyanshi on 2019/2/22
 */
public class M {

  public static void main(String [] args ){

    Controller controller = new Controller();
    Student s = new Student();
    s.setName("pfliu");
    s.setEmail("pp");
    s.setCGPA(new Double("4.100"));
    controller.addStudent(s);

//    //获取
    Student ss = new Student();
    ss.setPID("1");
    System.out.println(controller.getStudent(ss).toString());
//
//    //list
//    IBaseResponse IBaseResponse = controller.getAllStudents();
//    System.out.println(IBaseResponse);
//
//    //修改信息
    Student s2 = new Student();
    s.setName("pfliu");
    s.setEmail("9999");
    s.setPID("1");
    controller.addStudent(s);

    Student ss2 = new Student();
    ss.setPID("1");
    IResponse stsss = controller.getStudent(ss);
    System.out.println(stsss);
//
//    //添加第二个
//    Student kk = new Student();
//    kk.setName("pfldasiu");
//    kk.setEmail("嘿嘿嘿");
//    kk.setPID("4");
//    controller.addStudent(kk);
//
//    //删除信息
//    Student de = new Student();
//    de.setPID("1");
//    controller.removeStudent(de);


  }
}
