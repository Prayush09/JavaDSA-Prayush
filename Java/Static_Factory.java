package com.Data_Structures_byprayush.Java;

public class Static_Factory {
    private final String name;
    private final int age;
    private Static_Factory(String name, int age){
        this.name = name;
        this.age = age;
    }

    //static factory method
    public static Static_Factory of(String name, int age){
        return new Static_Factory(name,age);
    }

    //getters

    public int getAge() {
        return age;
    }

    public String getName(){
        return name;
    }

    @Override
    public String toString(){
        return "name = "+name+" Age "+age;
    }

    public static void main(String[] args) {
        Static_Factory ss = new Static_Factory("prayush",10);
        System.out.println(ss);
    }
}
