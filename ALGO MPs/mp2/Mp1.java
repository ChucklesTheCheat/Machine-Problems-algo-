import java.util.*;

public class Mp1 {
    public static void main (String [] args){
        
        String words1 = "xAAxhxBBxaxCCxdxDDxjxEExixFFxpxGGxoxHHxgxIIxixJJx";
        System.out.println( words1 + " = " + hjtpogi(words1));
        //============================
        String words2 = "xhIIxaIIXdIIXjIIxiIIx";
        System.out.println( words2 + " = " + hjtpogi(words2));
        //============================
        String words3 = "zxXhXXXiXxz";
        System.out.println( words3 + " = " + hjtpogi(words3));
        
    }
 //detects the small and big Xs
    static int hjtpogi (String s){
        if (s.length() == 0)
            return 0;
        else if (s.charAt(0) == 'X')
            return 1 + hjtpogi (s.substring(1));
        else if (s.charAt(0) == 'x')
            return 1 + hjtpogi (s.substring(1));
        else 
            return hjtpogi (s.substring(1));
    }
}