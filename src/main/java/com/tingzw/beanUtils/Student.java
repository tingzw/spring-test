package com.tingzw.beanUtils;

import org.springframework.remoting.rmi.RmiProxyFactoryBean;
import org.springframework.remoting.rmi.RmiServiceExporter;

import java.util.Date;

/**
 * @author tingzw
 * @date 2017-03-03 15:35
 **/
public class Student {
    RmiProxyFactoryBean rmiProxyFactoryBean=null;
    RmiServiceExporter rmiServiceExporter=null;
    private Integer id;
    private String name;
    private Integer age;
    private Date credate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCredate() {
        return credate;
    }

    public void setCredate(Date credate) {
        this.credate = credate;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", credate=" + credate +
                '}';
    }

    public static void main(String[] args) {

        System.out.println(Integer.MAX_VALUE);
    }
}
