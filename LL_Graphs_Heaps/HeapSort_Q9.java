
/*
Author : Namit Shah
*/

import java.util.Scanner;

class Heap{
    int[] arr;
    int heapSize;
    int arrLen;

    Heap(int givArr[]){
        arr = new int[givArr.length];
        arr = givArr;
        heapSize = givArr.length;
        arrLen = givArr.length;
        buildMaxHeap();
    }

    void maxHeapify(int i){
        int l = 2*i+1;
        int r = 2*i+2;
        int largest = i;
        if(l<heapSize && arr[l]>arr[largest]){
            largest = l;
        }
        if(r<heapSize && arr[r]>arr[largest]) {
            largest = r;   
        }
        if(largest!=i) {
            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp; 
            maxHeapify(largest);
        }
    }

    void buildMaxHeap(){
        for(int i=arrLen/2-1;i>=0;i--){
            maxHeapify(i);
        }
    }

    int extractMax(){
        int min = arr[0];
        arr[0] = arr[heapSize-1];
        heapSize--;
        maxHeapify(0);
        arrLen--;
        return min;
    }

    void sort(){
        buildMaxHeap();
        for(int i=arrLen-1;i>=1;i--){
            int temp = arr[i];
            arr[i] = arr[0];
            arr[0] = temp;
            heapSize--;
            maxHeapify(0); 
        }
    }

    void print(){
        for(int i=0;i<arrLen;i++){
            System.out.print(arr[i] + " ");
        }
    }
}

class HeapSort_Q9{
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter size of array : ");
        int size = sc.nextInt();
        int[] newArr = new int[size];
        System.out.print("Enter array elements : ");
        for(int i=0;i<size;i++){
            newArr[i] = sc.nextInt();
        }
        Heap hp = new Heap(newArr);
        System.out.print("Max Heap : ");
        hp.print();
        hp.sort();
        System.out.print("\nHeap after sorting : ");
        hp.print();
        sc.close();
    }
}