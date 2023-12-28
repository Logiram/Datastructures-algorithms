package org.example;

//basic operations of circular LL
/* 1->2->3->1
  */
public class CircularLL {
    //push newnode at beginning of circular single LL
    static Node pushbeginning(Node head,int key){
        Node newnode = new Node(key);
        newnode.next=head;

        //check if head node is not null
        if(head!=null) {
            Node temp = head;
            while (temp.next != head) {
                temp = temp.next;
                temp.next = newnode;
            }
        }

        else {
            newnode.next=newnode;
        }
        head=newnode;
        return head;
    }

    void printNode(Node head){
        Node temp=head;
        while(temp!=null){
            System.out.print(temp.key+" ");
            temp=temp.next;
        }
    }

    public static void main(String args[]) {
        CircularLL dl = new CircularLL();
        Node Newnode = new Node(1);
        Newnode = dl.pushbeginning(Newnode, 2);
        Newnode = dl.pushbeginning(Newnode, 3);
        dl.printNode(Newnode);
    }

}
