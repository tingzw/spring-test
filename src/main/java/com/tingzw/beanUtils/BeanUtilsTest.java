package com.tingzw.beanUtils;

import org.springframework.beans.BeanUtils;

import java.util.Date;

/**
 * @author tingzw
 * @date 2017-03-03 15:37
 **/
public class BeanUtilsTest {
    public static void main(String[] args) {

        Student student = new Student();
        //student.setId(1);
        student.setName("tingzw");
        student.setCredate(new Date());
        System.out.println(student);

        FormStudent fstudent = new FormStudent();

        BeanUtils.copyProperties(student, fstudent);

        System.out.println(fstudent);
    }


    public void sayHello(String name, String password) {
    }

}
