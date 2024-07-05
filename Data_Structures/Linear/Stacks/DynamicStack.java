package com.Data_Structures_byprayush.Data_Structures.Linear.Stacks;

public class DynamicStack extends Custom_Stack{
    public DynamicStack(){
        super(); //calls the CustomStack();
    }

    public DynamicStack(int size){
        super(size);
    }

    @Override
    public boolean push(int item) {
        //this takes care of the data array being full
        if(this.isFull()){
            //double the array size;
            int[] temp = new int[data.length*2];

            //copy all the previous items into this new data
            System.arraycopy(data,0,temp,0,data.length);
//            for (int i = 0; i < data.length; i++) {
//                temp[i] = data[i];
//            }
        data = temp;
        }
        //at this point we know the array is not full
        //we can insert normally
        return super.push(item);
    }
}
