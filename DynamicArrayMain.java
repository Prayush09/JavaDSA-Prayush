package com.Data_Structures_byprayush;

public class DynamicArrayMain{
    public static void main(String[] args) {
        Dynamic_Arrays dynamicarray = new Dynamic_Arrays(6);
        Another_Dynamic_Array ds = new Another_Dynamic_Array(10);
        ds.add("Prayush");
        ds.add(10000);
        ds.add("VIT_AP");
        ds.add("DYNAMICARRAY");
        System.out.println(ds.iterator());
        System.out.println(ds);
        dynamicarray.add("A");
        dynamicarray.add(20);
        dynamicarray.add("Prayush");
        dynamicarray.delete("A");
       // dynamicarray.delete("Prayush");
        dynamicarray.insert(1,44);
        dynamicarray.add("P");
        dynamicarray.add("Ps");
        dynamicarray.add("Push");
        dynamicarray.add("rush");
        dynamicarray.add("Pray");
        System.out.println(dynamicarray);//We don't necessarily need to type toString. BUT WHY?
        System.out.println("Empty: "+dynamicarray.isEmpty());
        System.out.println("Size: "+dynamicarray.size);
        System.out.println("Capacity: "+dynamicarray.capacity);
    }
}
