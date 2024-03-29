package LinkedList.PrintReverse;

import java.util.*;

public class print_reverse {
    public static void main(String[] args) {
        LinkedL1 list = new LinkedL1();
        list.insert(1);
        list.insert(2);
        list.insert(3);
        list.insert(4);
        list.insert(4);
//        list.print();
//        System.out.println();
//        list.printR();
        list.RemoveDuplicate();
//        list.print();
//        list.printR();
//        list.countNode();
//        list.length();
//        list.getNNode(4);
//        list.getEndNode(2);
//        list.findMiddle();
//        list.RemoveDuplicate();
//        list.print();
//        System.out.println(list.hasCycle());

//        list.printR1();
        list.print();
    }
}

class LinkedL1 {
    Node head;
    Node tail;

    int totalNode = 0;

//    LinkedL1() {
//        head = null;
//        tail = null;
//    }

    public boolean hasCycle() {
        if (head == null) {
            return false;
        }
        Node hare = head;
        Node turtle = head;

        while (hare != null && hare.next != null) {
            hare = hare.next.next;
            turtle = turtle.next;

            if (hare == turtle) {
                return true;
            }
        }
        return false;
    }

    public void getNNode(int value) {
        Node temp = head;
        int count = 0;

        while (temp != null) {
            count++;
            if (count == value) {
                System.out.print("Get nth node in linked list: " + temp.data + " ");
                break;
            }
            temp = temp.next;
        }
        System.out.println();
    }

    public void getEndNode(int value) {
        if (value > totalNode) {
            System.out.println("Enter Correct Position..!!");
            return;
        }
        Node temp = head;
        for (int i = 0; i < totalNode - value; i++) {
            temp = temp.next;
        }
        System.out.println("Get nth node from end in linked linked list: " + temp.data);
    }

    public void countNode() {
        Node temp = head;
        int count = 0;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        System.out.println("Count nodes: " + count);
    }

    public void length() {
        Node temp = head;

        while (temp != null) {
            totalNode++;
            temp = temp.next;
        }
        System.out.println("Total Nodes In LinkedList is: " + totalNode);
    }

    public void insert(int data) {
        Node node = new Node(data);
        if (head == null) {
            head = node;
            tail = node;
        } else {
            tail.next = node;
            tail = tail.next;
        }
    }

    public void update(int old, int newValue) {
        Node temp = head;
        while (temp != null) {
            if (temp.data == old) {
                temp.data = newValue;
            }
            temp = temp.next;
        }
    }

    public void find(int value) {
        Node temp = head;
        while (temp != null) {
            if (temp.data == value) {
                System.out.println("present");
                return;
            }
            temp = temp.next;
        }
        System.out.println("not present");
    }

    public void print() {
        if (head == null) {
            System.out.println("LinkedList is empty");
            return;
        }
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }

    public void printR() {
        Stack<Integer> stack = new Stack<>();
        Node temp = head;

        while (temp != null) {
            stack.push(temp.data);
            temp = temp.next;
        }
        while (!stack.isEmpty()) {
            System.out.print(stack.peek() + " ");
            stack.pop();
        }
        System.out.println();
    }

    public void printR1(){
        Node prev = null;
        Node temp=head;
        Node next=null;

        while(temp != null){
            next = temp.next;
            temp.next=prev;
            prev=temp;
            temp=next;
        }
        head = prev;
    }

    public void delete(int data) {
        if (head.data == data) {
            head = head.next;
        } else {
            Node temp = head;
            while (temp != null) {
                if (temp.next.data == data) {
                    if (temp.next == tail) {
                        temp.next = null;
                        tail = temp;
                        return;
                    } else {
                        temp.next = temp.next.next;
                        return;
                    }
                }
                temp = temp.next;
            }
        }
    }

    public void RemoveDuplicate() {
        Node temp = head;
        Node curr = head;
        HashSet<Integer> set = new HashSet<>();

        while (temp != null){
            if(set.isEmpty()){
                set.add(temp.data);
            }else if (set.contains(temp.data)){
                if(curr.next != null){
                    curr.next = curr.next.next;
                }else {
                    curr.next = null;
                }
            }else {
                set.add(temp.data);
                curr = curr.next;
            }
            temp = temp.next;
        }
    }

    public void findMiddle(){
        Node hare = head;
        Node turtle = head;

        while(hare.next != null && hare.next.next != null) {
            hare = hare.next.next;
            turtle = turtle.next;
        }
        System.out.println("Middle = " + turtle.data);
    }
}

class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
    }
}