import java.util.Scanner;

/*
Author : Namit Shah
*/

class SingleLinkedList{
    int size;
    Node head;

    static class Node{
        int data;
        Node next;

        Node(int d){
            data = d;
            next = null;
        }
    }

    SingleLinkedList(){
        size = 0;
        head = null;
    }

    void insert(int data){
        Node new_node = new Node(data);
        if(this.head==null) this.head = new_node;
        else{
            Node last = this.head;
            while(last.next != null) last = last.next;
            last.next = new_node;
        }
        //System.out.println("Inserted\n");
        size++;
    }

    void insertFront(int data){
        Node new_front = new Node(data);
        new_front.next = this.head;
        this.head = new_front;
        //System.out.println("Inserted\n");
        size++;
    }

    void insertAt(int keyind,int data){
        Node newNode = new Node(data);
        if(keyind==0){
            this.insertFront(data);
            size++;
        } else if(keyind<=size){
            Node currNode = this.head;
            for(int i=0;i<keyind-1;i++){
                currNode = currNode.next;
            }
            newNode.next = currNode.next;
            currNode.next = newNode;
            size++;
            //System.out.println("Inserted\n");
        }
        else{
            System.out.println("\nCannot Insert");
            return;
        }
        
    }

    void delFront(){
        if(!isEmpty()){
            this.head = this.head.next;
            size--;
        }
        else{
            System.out.print("Empty\n");
            return;
        }
        System.out.println("Deleted\n");
    }

    void delLast(){
        if(!isEmpty()){
            if(size==1) delFront();
            else{
                Node nxt = this.head;
                while(nxt.next.next!=null) nxt = nxt.next;
                nxt.next = null;
                System.out.println("Deleted\n");
                size--;
            }
        }
        else{
            System.out.print("Empty\n");
            return;
        }
        
    }

    void deleteAt(int ind){
        if(!isEmpty()){
            Node currNode = this.head, prev = null; 
            if (ind == 0 && currNode != null) { 
                this.head = currNode.next;
                System.out.println(ind + " position element deleted");
            } 
            int counter = 0; 
            while (currNode != null) { 
                if (counter == ind) { 
                    prev.next = currNode.next; 
                    System.out.println(ind + " position element deleted"); 
                    break; 
                } 
                else { 
                    prev = currNode; 
                    currNode = currNode.next; 
                    counter++; 
                } 
            } 
            if (currNode == null) { 
                System.out.println(ind + " position element not found"); 
            } 
            size--;
        }
        else{
            System.out.print("Empty\n");
        }
    }

    int getSize(){
        return size;
    }

    int getSum(){
        if(isEmpty()) return 0;
        else{
            Node node = this.head;
            int sum = 0;
            while(node!=null){
                sum += node.data;
                node = node.next;
            }
            return sum;
        }
    }

    SingleLinkedList linkcopy(){
        SingleLinkedList newLink = new SingleLinkedList();
        Node temp = this.head;
        while(temp!=null){
            newLink.insert(temp.data);
            temp = temp.next;
        }
        return newLink;
    }

    SingleLinkedList sublist(int start,int end){
        if(start > size || end > size || start < 0 || end < 0 || (start > end)){
            System.out.print("Naah");
            return null;
        }
        else{
            SingleLinkedList sub = new SingleLinkedList();
            Node temp = head;
            for(int i=0;i<start;i++){
                temp = temp.next;
            }
            for(int i=0;i<end-start;i++){
                sub.insert(temp.data);
                temp = temp.next;
            }
            return sub;
        }
    }

    void append(SingleLinkedList list2){
        if(this.size >= 1 && list2.size > 0){
            Node temp = list2.head;
            while(temp!=null){
                insert(temp.data);
                temp = temp.next;
            }
            System.out.print("Linked List after appending : ");
            printSingleLinkedList();
            System.out.println();
        }
        else{
            System.out.println("Doesn't match the requirements");
        }
    }

    SingleLinkedList concat(SingleLinkedList list2){
        if(this.size >= 1 && list2.size > 0){
            SingleLinkedList final1 = new SingleLinkedList();
            Node temp = this.head;
            while(temp!=null){
                final1.insert(temp.data);
                temp = temp.next;
            }
            temp = list2.head;
            while(temp!=null){
                final1.insert(temp.data);
                temp = temp.next;
            }
            return final1;
        }
        else{
            System.out.println("Doesn't match the requirements");
            return null;
        }
    }

    void sortList() {   
        Node current = this.head, index = null;   
        if(this.head == null) {  
            return;  
        }  
        else {  
            while(current != null) {  
                index = current.next;  
                while(index != null) {  
                    if(current.data > index.data) {  
                        int temp = current.data;  
                        current.data = index.data;  
                        index.data = temp;  
                    }  
                    index = index.next;  
                }  
                current = current.next;  
            }      
        }  
        System.out.print("Linked List after sorting : ");
        printSingleLinkedList();
        System.out.println();
    }  

    void replace(int data,int ind){
        if(!isEmpty() || (ind>=0 && ind<=this.size)){
            Node temp = this.head;
            for(int i=0;i<ind;i++){
                temp = temp.next;
            }
            temp.data = data;
            System.out.println("\nReplace Successfully");
        }
        else{
            System.out.println("Cannot Replace");
        }
    }

    boolean isEmpty(){
        return getSize()==0;
    }

    boolean search(int value){
        if(isEmpty()) return false;
        else{
            Node node = this.head;
            while(node.next != null){
                if(node.data==value){
                    return true;
                }else{
                    node = node.next;
                }
            }
            return false;
        }
    }

    void printSingleLinkedList(){
        if(isEmpty()) {
            System.out.print("Empty\n");
        }
        else{
            Node current_Node = this.head;
            while(current_Node!=null){
                System.out.print(current_Node.data + " ");
                current_Node = current_Node.next;
            }
            System.out.println();
        }
    }
}
class SingleLinkedList_Q4{
    public static void main(String args[]) {

        SingleLinkedList ls = new SingleLinkedList();
        int choice=0;
        Scanner sc = new Scanner(System.in);
        while(choice!=17)
        {
            System.out.println("\n----------------------------------------------------------------------------");
            System.out.println("1) Insert element at any position in Linked List");
            System.out.println("2) Insert element at last in Linked List");
            System.out.println("3) Insert element at first in Linked List");
            System.out.println("4) Delete element from last in Linked List");
            System.out.println("5) Delete element from specific position in Linked List");
            System.out.println("6) Delete element from first in Linked List");
            System.out.println("7) Get size of Linked List");
            System.out.println("8) Get sum of all the elements in Linked List");
            System.out.println("9) Copy this Linked List");
            System.out.println("10) Get sublist of the Linked List");
            System.out.println("11) Append another Linked List");
            System.out.println("12) Concatenate another Linked List");
            System.out.println("13) Replace element at given position in Linked List");
            System.out.println("14) Find element in Linked List");
            System.out.println("15) Sort Linked List");
            System.out.println("16) Print elements of a Linked List");
            System.out.println("17) Exit");
            System.out.println("----------------------------------------------------------------------------");
            System.out.print("Enter your choice ");
            choice = sc.nextInt();
            switch(choice)
            {
                case 1:
                    System.out.println("Enter number and position to be inserted in linked list");
                    int data = sc.nextInt();
                    int pos = sc.nextInt();
                    ls.insertAt(pos, data);
                    System.out.println("Inserted");
                    break;
                case 2:   
                    System.out.println("Enter number to be inserted at last in linked list ");
                    data = sc.nextInt();
                    ls.insert(data);
                    System.out.println("Inserted");
                    break;
                case 3:
                    System.out.println("Enter number to be inserted at first in linked list ");
                    data = sc.nextInt();
                    ls.insertFront(data);
                    System.out.println("Inserted");
                    break;
                case 4:
                    ls.delLast();
                    break;
                case 5:   
                    System.out.println("Enter position to be deleted in linked list ");
                    pos = sc.nextInt();
                    ls.deleteAt(pos);
                    break;
                case 6:
                    ls.delFront();
                    break;
                case 7:
                    System.out.println("Size of the Linked List is : " +ls.getSize());
                    break;
                case 8:
                    System.out.println("Sum of all the elements of the Linked List is : " +ls.getSum());
                    break;
                case 9:
                    SingleLinkedList copy = new SingleLinkedList();
                    copy = ls.linkcopy();
                    System.out.println("Copied List : ");
                    copy.printSingleLinkedList();
                    break;
                case 10:
                    SingleLinkedList subl = new SingleLinkedList();
                    System.out.println("Enter starting and ending index of which you want the sublist : ");
                    int start = sc.nextInt();
                    int end = sc.nextInt();
                    subl = ls.sublist(start, end);
                    System.out.print("Sublist : ");
                    subl.printSingleLinkedList();
                    break;
                case 11:
                    SingleLinkedList apendList = new SingleLinkedList();
                    System.out.println("Enter number of elements you want to add in the Linked List which you want to append :");
                    int num = sc.nextInt();
                    for(int i=0;i<num;i++){
                        System.out.print("Enter element : ");
                        int el = sc.nextInt();
                        apendList.insert(el);
                    }
                    ls.append(apendList);
                    break;
                case 12:
                    SingleLinkedList concList = new SingleLinkedList();
                    System.out.println("Enter number of elements you want to add in the Linked List which you want to concat :");
                    int n = sc.nextInt();
                    for(int i=0;i<n;i++){
                        System.out.print("Enter element : ");
                        int el = sc.nextInt();
                        concList.insert(el);
                    }
                    SingleLinkedList final1 = new SingleLinkedList();
                    final1 = ls.concat(concList);
                    if(final1!=null) {
                        System.out.print("\nLinked List after concatenation : ");
                        final1.printSingleLinkedList();
                    }
                    System.out.println();
                    break;
                case 13:
                    System.out.println("Enter the index at which you want to replace and the data you want to change : ");
                    int ind = sc.nextInt();
                    int dat = sc.nextInt();
                    ls.replace(dat, ind);
                    break;
                case 14:
                    System.out.println("Enter the element you want to search for : ");
                    int ser = sc.nextInt();
                    if(ls.search(ser)) System.out.println("Found");
                    else System.out.println("Not Found");
                    break;
                case 15:
                    ls.sortList();
                    break;
                case 16:
                    System.out.print("Linked List : ");
                    ls.printSingleLinkedList();
                    break;   
                case 17:
                    break;         

            }
        }
        sc.close();
    }
}