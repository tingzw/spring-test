package com.tingzw.model;

import java.util.Date;

/**
 * @author tingzw
 * @date 2017-01-16 10:59
 **/
public class User {
    private int id;
    private String name;
    private int age;


    public User() {
    }

    public User(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public static void main(String[] args) throws Exception {
//		String code = delByCard();
//		System.out.println(code);
       /* SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = sdf.parse("1970-01-01 08:00:00");
        System.out.println(sdf.format(date));
        System.out.println(date.getTime());*/

        Date date=new Date();
        System.out.println(date.getTime()/1000);

    }
}
