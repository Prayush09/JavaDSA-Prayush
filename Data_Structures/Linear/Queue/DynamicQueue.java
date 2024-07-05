package com.Data_Structures_byprayush.Data_Structures.Linear.Queue;

public class DynamicQueue extends CircularQueue{
    public DynamicQueue(){
        super();
    }

    public DynamicQueue(int size){
        super();
    }

    @Override
    public boolean insert(int item){
        //this takes care of the data array being full
        if(this.isFull()){
            //double the array size;
            int[] temp = new int[data.length*2];

            //copy all the previous items into this new data

            for (int i = 0; i < data.length; i++) {
                //front + i means that the front of the queue is first added,
                //then i is incremented by 1 and so
                // we move ahead in the circular queue until end is reached
                //the for loop represent the insertion for the temp circular queue.
                temp[i] = data[(front+i)%data.length];
            }
            front = 0;
            end = data.length; //since the array(queue) is full, the end is the whole length.
            data = temp;
        }
        //at this point we know the array is not full
        //we can insert normally
        return super.insert(item);
    }
}
