package org.example;
// basic operations and problems for Doubly LL


public class DoublyLL {
    //add newnode at the beginning
    static Node push(Node head, int value){
        Node Newnode= new Node(value);
        Newnode.next=head;
        Newnode.prev=null;
        head=Newnode;
        return head;
    }
    //add node at the end
    static Node pushend(Node head, int value){
        Node temp=head;
        Node Newnode= new Node(value);
        while (temp.next!=null){
            temp=temp.next;
        }
        temp.next=Newnode;
        Newnode.next=null;

        return head;
    }

    void printNode(Node head){
        Node temp=head;
        while(temp!=null){
          System.out.print(temp.key+" ");
          temp=temp.next;
        }
    }

    public static void main(String args[]){
        DoublyLL dl= new DoublyLL();
        Node Newnode= new Node(1);
        Newnode=dl.push(Newnode,2);
        Newnode=dl.push(Newnode,3);
        dl.printNode(Newnode);
        System.out.println(" After adding newnode to end ");
        Newnode=dl.pushend(Newnode,4);
        dl.printNode(Newnode);
    }
}
