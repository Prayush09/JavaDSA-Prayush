package com.Data_Structures_byprayush;

    class QNode {
        int key;
        QNode next;

        // constructor to create a new linked list node
        public QNode(int key)
        {
            this.key = key;
            this.next = null;
        }
    }

    // A class to represent a queue
// The queue, front stores the front node of LL and rear stores the
// last node of LL
  public class Queue_Operations{
        QNode front, rear;

        public Queue_Operations()
        {
            this.front = this.rear = null;
        }

        // Method to add an key to the queue.
        void enqueue(int key)
        {

            // Create a new LL node
            QNode temp = new QNode(key);

            // If queue is empty, then new node is front and rear both
            if (this.rear == null) {
                this.front = this.rear = temp;
                return;
            }

            // Add the new node at the end of queue and change rear
            this.rear.next = temp;
            this.rear = temp;
        }

        // Method to remove an key from queue.
        void dequeue()
        {
            // If queue is empty, return NULL.
            if (this.front == null)
                return;

            // Store previous front and move front one node ahead
            QNode temp = this.front;
            this.front = this.front.next;

            // If front becomes NULL, then change rear also as NULL
            if (this.front == null)
                this.rear = null;
        }
    }

    // Driver class
    class Test {
        public static void main(String[] args)
        {
            Queue_Operations q = new Queue_Operations();
            q.enqueue(21);
            q.enqueue(38);
            q.dequeue();
            q.dequeue();
            q.enqueue(78);
            q.enqueue(64);
            q.enqueue(88);
            q.dequeue();
            System.out.println("Queue Front : " + q.front.key);
            System.out.println("Queue Rear : " + q.rear.key);
        }
    }

