import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

class Heap{
    
    Integer[] heap;
    int size;
    int currentPosition=-1;
    
    public Heap(int n){
        this.heap = new Integer[n];
        size = n;
    }
    
    public void insert(int data){
        //full heap exception
        heap[++currentPosition] = data;
        fixUp(currentPosition);
    }
    
    public int delete(){
        int result = heap[0];
        heap[0] = heap[currentPosition--];
        heap[currentPosition+1] = null;
        fixDown(0,-1);
        return result;
    }
    
    public int getMin(){
        return heap[0];
    }
    
    
    public void fixUp(int index){
        int parentIndex = (index-1)/2;
        while(parentIndex>=0 &&  heap[index]>heap[parentIndex]){
            int temp;
           
                temp = heap[index];
                heap[index] = heap[parentIndex];
                heap[parentIndex] = temp;
                index = parentIndex;
            
            parentIndex = (index-1)/2;
        }
        
    }
    
    public void fixDown(int index, int upto){
        if(upto <0)
            upto = currentPosition;
        
        while(index<=upto){
            int leftChild = (2*index) + 1;
            int rightChild = (2*index) + 2;
            
            if(leftChild<=upto){
                int swapChildIndex;
                if(rightChild<=upto){
                    swapChildIndex = (heap[leftChild]<heap[rightChild])?leftChild:rightChild;
                }
                else{
                    swapChildIndex = leftChild;
                }
                if(heap[index]>heap[swapChildIndex]){
                    int temp = heap[index];
                    heap[index] = heap[swapChildIndex];
                    heap[swapChildIndex] = temp;
                }
                index = swapChildIndex;
            }
            else{
                break;
            }
        }     
    }
    //End of fixDown    
    
}

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        System.out.println("start");
        System.out.println();
        int n = Integer.parseInt(sc.nextLine());
        Heap heap = new Heap(n);
        for(int i = 0 ; i <n ; i++){
            String[] input = sc.nextLine().split(" ");
            if(Integer.parseInt(input[0])==1)
                heap.insert(Integer.parseInt(input[1]));
            else if(Integer.parseInt(input[0])==2)
                heap.delete();
            else if(Integer.parseInt(input[0])==3)
                System.out.println(heap.getMin());
        }
    }
    
    
}