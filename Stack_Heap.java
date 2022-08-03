package com.Data_Structures_byprayush;
class heck{
    int id;
    String emp_name;
    public heck(int id, String emp_name){
        this.id = id;
        this.emp_name = emp_name;
    }
}
public class Stack_Heap {
    private static heck Stack_Heap(int id, String emp_name) {
        return new heck(id, emp_name);
    }

    public static void main(String[] args) {
        int id = 21;
        String emp_name = "Prayush";
        heck person_ = null;
        person_ = Stack_Heap(id, emp_name);
    }
}