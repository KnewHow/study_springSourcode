package test;

import org.junit.Test;

import study.spring.BeanFactory;
import study.spring.dao.StudentDao;
import study.spring.domain.Student;
import study.spring.service.StudentService;

public class Demo1 {

    @Test
    public void fun1() {
        BeanFactory bf = new BeanFactory("beans.xml");
        Student stu = (Student) bf.getBean("stu1");
        System.out.println(stu);
    }

    @Test
    public void fun2() {
        BeanFactory bf = new BeanFactory("beans.xml");
        Student stu1 = (Student) bf.getBean("stu1");
        Student stu2 = (Student) bf.getBean("stu1");
        System.out.println(stu1 == stu2);
    }

    @Test
    public void fun3() {
        BeanFactory bf = new BeanFactory("beans.xml");
        Student stu = (Student) bf.getBean("stu2");
        System.out.println(stu.getTeacher());
    }

    @Test
    public void fun4() {
        BeanFactory bf = new BeanFactory("beans.xml");
        Student stu1 = (Student) bf.getBean("stu1");
        Student stu2 = (Student) bf.getBean("stu2");
        System.out.println(stu1.getTeacher() == stu2.getTeacher());
    }

    @Test
    public void fun5() {
        BeanFactory bf = new BeanFactory("beans.xml");
        StudentDao dao = (StudentDao) bf.getBean("studentDao");
        dao.add();
        dao.update();
    }

    @Test
    public void fun6() {
        BeanFactory bf = new BeanFactory("beans.xml");
        StudentService service = (StudentService) bf.getBean("studentService");
        service.login();
    }
}
