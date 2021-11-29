import java.util.*;

public class Mp2{
    public static int hjtmp2(int A[], int n)
    {     
        if(n == 1)
            return A[0];

        return Math.min(A[n-1], hjtmp2(A, n-1));
    }

    public static void main(String args[])
    {
        int A[] = {4, 7, 32, 64, 2, 10, 23, 66, 1, 6, 3, 100};
        int n = A.length;

        System.out.print("Given Array:");
        System.out.println(Arrays.toString(A));
        System.out.print("Minimum element of array:");
        System.out.println(hjtmp2(A, n));
    }
}