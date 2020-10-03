import java.util.*;

//import jdk.internal.org.jline.terminal.Size;

class HeapTree{

    int array[];
    static int i=-1;
    int size;
    public HeapTree(int size){
        array = new int[size];
        this.size = size;
    }

    public void insertKey(int data)
    {
        size++;
        int new_array[] = new int[size];
        int xx=0;
        for(xx=0;xx<size-1;xx++)
        {
            new_array[xx] = array[xx];
        }
        new_array[xx] = data;
        array = new_array;
        while(xx!=0 && new_array[xx]<new_array[xx/2])
        {
            int tem = array[xx];
            array[xx] = array[xx/2];
            array[xx/2] = tem;
            xx/=2;
        }
    }

    public void MinHeapify(int x)
    {
        if(array[x]>array[2*x + 1] || array[x]>array[2*x + 2])
        {
            if(array[2*x + 1]<array[2*x + 2])
            {
                int tt = array[2*x + 1];
                array[2*x + 1] = array[x];
                array[x] = tt;
                MinHeapify(2*x + 1);
            }
            else
            {
                int tt = array[2*x + 2];
                array[2*x + 2] = array[x];
                array[x] = tt;
                MinHeapify(2*x + 2);
            }
        }
    }

    public void minHeap()
    {
        int pos = size/2;
        pos--;
        if(size%2==0)
            pos--;
        for(int xx=pos;xx>=1;xx--)
        {
            MinHeapify(xx);
        }
    }

    public void print()
    {
        for(int i=0;i<size;i++)
        {
            System.out.print(array[i] + " ");
        }
    }

}

public class heap{
    public static void main(String arg[])
    {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter number of elements in the tree ");
        int size = in.nextInt();
        HeapTree tree = new HeapTree(size);
        System.out.println("Enter " + size + " elements ");
        for(int i=0;i<size;i++)
        {
            int x = in.nextInt();
            tree.insertKey(x);
        }
        tree.minHeap();
        tree.print();
    }
}