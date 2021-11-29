import java.io.*;
import java.util.*;

public class Mp4{
    public static void ItsOk (int array[], int length, int sum){
        //=============================
        if (length < 0){
            System.out.println("Given Array--[1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16]");
            System.out.println("The sum of all even numbers 2,4,6,8,10,12,14,16 is--72");
            return;          
          }
        //============================= 
        //============================= 
        if (array[length]% 2 == 0)
            sum +=(array[length]);
        
        ItsOk(array, length - 1, sum);
        }
        //============================= 
        //============================= 
    public static void main (String []args){
        int arr[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16};
        int length = arr.length;
        int sum = 0;
        
        ItsOk(arr,length - 1, sum);
        //============================= 
    }
}
