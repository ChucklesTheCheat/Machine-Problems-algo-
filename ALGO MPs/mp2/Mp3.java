public class Mp3 {
    public static void main (String[] args){     
        //ayoxyoxyoxyoxyo
        //ayobyoayobhadhadjipogiyoayobyo
        //xyoxhadjiohiyoyoyo
        //yoyooyoxhadjiohioyooyoyoxxyoyo
        System.out.println("ayoxyoxyoxyoxyo" + "=" + hjtthegreat("ayoxyoxyoxyoxyo"));
        //===================================
        System.out.println("ayobyoayobhadhadjipogiyoayobyo" + ":" + hjtthegreat("ayobyoayobhadhadjipogiyoayobyo"));
        //===================================
        System.out.println("xyoxhadjiohiyoyoyo" + "=" + hjtthegreat("xyoxhadjiohiyoyoyo"));
        //===================================
        System.out.println("yoyooyoxhadjiohioyooyoyoxxyoyo" + ":" + hjtthegreat("yoyooyoxhadjiohioyooyoyoxxyoyo"));       
    }
    public static int hjtthegreat(String str){
        //======================
        if (str.length() <2 )
        {
            return 0;
        }
        //======================
        //======================
        if (str.length() == 2)
        {
            return (str.equals("yo")) ? 1 : 0;
            
        }
        //=====================
        //=====================
        if (str.charAt(0) == 'o')
        {
            if (str.substring(1,3).equals("yo")){
                return hjtthegreat(str.substring(3));
            }
            return hjtthegreat(str.substring(1));
        }
        //=====================
        //=====================
        if (str.substring(0,2).equals("yo"))
        {
            return 1 + hjtthegreat(str.substring(2));
        }
        //=====================
        //=====================
        if (str.substring(1,3).equals("yo"))
        {
            return 1 + hjtthegreat(str.substring(3));
        }
        //=====================
        //=====================
        return hjtthegreat(str.substring(2));      
    }
}