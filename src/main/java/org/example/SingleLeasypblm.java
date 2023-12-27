package org.example;

/*class Node {

    Node head;
    int key;
    Node next;

    Node(int key) {
        this.key = key;
        this.next = null;
    }
}*/
public class SingleLeasypblm {

    static Node push(Node head, int key){
        Node newnode=new Node(key);
        newnode.next= head;
        head = newnode;
        return head;
    }
    static int countnode(Node node){
        int count=0;
        Node temp=node;
        while(temp!=null){
            count++;
            temp=temp.next;
        }
        return count;
    }

    static String checkidentical(Node a,Node b){
        System.out.println("checkidentical(a,b)");
        String result=null;
        Node atemp=a;
        Node btemp=b;
        while (atemp !=null && btemp!=null){

                if(atemp.key==btemp.key) {
                    atemp = atemp.next;
                    btemp = btemp.next;
                    result = "identical";
                }
                else
                    result="not identical";
                    break;

        }
        return result;
    }

    //get middlenode
    int getMiddlenode1(Node head) {
        Node current = head;
        int result = 0;


        int size = getcount(current);
       /* if (size >= 2) {
            if (size % 2 == 0)
                result = size / 2;
            else {
                result = (size / 2) + 1;
            }
        }
        if (size == 1)
         result=1;*/
        result = (size%2 == 0)? (size+1)/2 : (size/2);
        return result;
    }

    int getMiddlenodeelement(Node head,int result)
    {
        Node current=head;

        int middle=0;

        int size=getcount(current);
        if(size>=2)
        {
            for(int i=0;i<=result;i++){
                middle=current.key;
                current=current.next;

            }
            System.out.println("result--"+result);
        }
        if(size==1)
            middle=current.key;
        return middle;
    }

    //move middle node to head node
  /*  Input  : 1 2 3 4 5
      Output : 3 1 2 4 5  */
    static Node middletohead(Node head,int middle){

        Node prev=head;
        Node current=head;
        Node nextnode=current.next;


        for(int i=0;i<middle;i++){
            prev=current;
            current=current.next;
            nextnode=current.next;

        }

        System.out.println("prev--"+prev.key+"  current--"+ current.key+"  next--"+ nextnode.key);
        current.next=head;
        head=current;
        System.out.println("current--"+ current.key);
        prev.next=nextnode;
        return head;

    }
    int getMiddlenode(Node head)
    {
        Node slow = head;
        Node fast = head;
        while(fast != null && fast.next != null)
        {
            slow = slow.next;
            // this pointer moves 1 nodes ahead everytime loop is run

            fast = fast.next.next;
            // this pointer moves 2 nodes ahead everytime loop is run
        }

        return slow.key;
        // since slow was moving with half speed, it is there at halfway point
    }


    //move the last element to first node of LL
    static Node lasttofirst(Node head){
        Node prev=null;
        Node current=head;
        Node nextnode=head.next;
        while(current.next!=null){
            prev=current;
            current=current.next;

        }
        prev.next=null;
        current.next=head;
        head=current;
        //prev.next=null;

        return head;

    }

    static void printlist(Node node){
        while(node!=null){
            System.out.print(node.key+" ");
            node=node.next;

        }
    }
    int getcount(Node head){
        int count=0;
        Node temp=head;
        while(temp!=null){
            count++;
            temp=temp.next;
        }
        return count;
    }

    public static void main(String[] args) {
        SingleLeasypblm mn = new SingleLeasypblm();

        // add elements to Node A
        Node a = new Node(7);
        a = mn.push(a, 6);
         a = mn.push(a, 5);
        a = mn.push(a, 4);
        a = mn.push(a, 3);
        a = mn.push(a, 2);
       // a = mn.push(a, 1);
        mn.printlist(a);
       // a = mn.push(a, 1);
      /* a=mn.push(a, 3);
        a=mn.push(a, 4);
        a=mn.push(a, 5);*/

        // add elements to Node B
        Node b = new Node(1);
        b = mn.push(a, 2);
        b=mn.push(a, 3);
        b=mn.push(a, 4);
        b=mn.push(a, 5);

      //  System.out.println(mn.getMiddlenode(a));
        //a=mn.lasttofirst(a);
        System.out.println("before--");
        System.out.println("count==="+mn.countnode(a));
        mn.printlist(a);
        System.out.println(mn.getMiddlenodeelement(a,mn.getMiddlenode1(a)));

       // a=mn.middletohead(a,mn.getMiddlenode1(a));
        System.out.println("after --");
        mn.printlist(a);
        //System.out.println(mn.checkidentical(a,b));
    }
}
