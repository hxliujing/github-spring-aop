package com.javens.aop.entity;

public class AopEntity {
    private int id;
    private String name;

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
        System.out.println("====change====="+name);
        this.name = name;
    }

    private void test(){}
}
