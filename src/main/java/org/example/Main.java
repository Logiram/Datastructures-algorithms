package org.example;
//basic operations
class Node{

    Node head;
    int key;
    Node next;
    Node prev;
    Node(int key){
        this.key=key;
        this.next=null;
    }
}
class Main{//insert node in beginning
    static Node push(Node head, int key){
        Node newnode=new Node(key);
        newnode.next= head;
        head = newnode;
        return head;
    }
    //insert node at last
    static Node pushlast(Node head, int key){
        Node newnode=new Node(key);
        Node temp =head;
        while (temp.next!=null){
            temp=temp.next;
        }
        temp.next=newnode;
        newnode.next=null;
        temp=newnode;
        return head;
    }

    //search element of the node is present(true/false)
    boolean searchelement(Node node,int value){
        Node current =node;
        Boolean result=false;
        while(current!=null){
            if(current.key==value)
                result= true;
            current=current.next;
        }
return result;
    }

    //find length of the linked list
    static int countnode(Node node){
        int count=0;
        Node temp=node;
        while(temp!=null){
            count++;
            temp=temp.next;
        }
        return count;
    }

    //reverse the linked list
    static Node reverselist(Node head){

        Node prev=null;
        Node nextnode=null;
        Node current=head;
        while(current !=null){
            nextnode=current.next;
           // prev.next=current;
            current.next=prev;
            prev=current;
            current=nextnode;

        }
        return prev;
    }

    //delete given key of the node
    static Node deletekey(Node head,int value){
//given key is head
        // if given is in middle position

        Node current =head;
        Node nextnode=current.next;
        Node prevnode=head;


        while(current!=null){
           //given key is head
            if(current.key==value) {
                head = nextnode;
                current = head;
                break;
            }
            //given key is in middle position

            //3,2,1,33
            while(current!=null){


                if(current.key==value){
                    prevnode.next=nextnode;
                    break;
                }
                prevnode=current;
                current=nextnode;
                nextnode=nextnode.next;
            }

        }
        return head;
    }
    //delete the key using given position
    static Node deleteposition(Node head, int pos){
        Node current =head;
        Node nextnode=current.next;
        Node prevnode=head;
        int poscount=1;


        while(current!=null){
            //given key is head
            if(pos==0) {
                head = nextnode;
                current = head;
                break;
            }
            //given key is in middle position

            //3,2,1,33


                if(poscount==pos){
                    prevnode.next=nextnode;
                    break;
                }
                prevnode=current;
                current=nextnode;
                nextnode=nextnode.next;
                poscount++;
            }


        return head;
    }

    // function to get Nth node in a Linked List
    static int getnodelist(Node head, int position) {
        Node current = head;
        int length = countnode(head);
        int pos = 1;
        int result=0;

        while (current != null) {
            if(pos>length)
                result=-1;
            if (pos == position) {
                result= current.key;
                break;
            }
            pos++;
            current = current.next;


        }
return result;
    }
//Nth node from the end of a Linked List
static int getnodefromlast (Node head, int position) {
    Node current = head;
    int length = countnode(head);
    int pos = 0;
    int result=-1;

    while (current != null) {

        if(pos>length)
            result=-1;
        if (length-pos == position) {
            result = current.key;
            break;
        }
        pos++;
        current = current.next;


    }
    return result;
}
//print the nodes
    static void printlist(Node node){
        while(node!=null){
            System.out.print(node.key+" ");
            node=node.next;

        }
    }

    public static void main(String[] args){
        Main mn=new Main();
        Node newnode=new Node(1);
        newnode=mn.push(newnode,2);
        newnode=mn.push(newnode,3);
        newnode=mn.pushlast(newnode,33);
        mn.printlist(newnode);
        System.out.println("search for the element--"+mn.searchelement(newnode,3));
        System.out.println("length of the list"+mn.countnode(newnode));
        //newnode=mn.reverselist(newnode);
       // mn.printlist(newnode);
        /*newnode=mn.push(newnode,2);*/
        //newnode=mn.push(newnode,3);
       // newnode=mn.deletekey(newnode,2);
        //newnode=mn.deleteposition(newnode,2);
        System.out.println("element in the position is "+mn.getnodelist(newnode,4));
        System.out.println("element in the last position is "+mn.getnodefromlast(newnode,5));
        mn.printlist(newnode);
    }

}