import java.util.Vector;

public class DynamicKnapsack{
    
    Vector<Integer> objects = new Vector<>();
    Vector<Float> profits;
    Vector<Float> weights;
    float maxWeights;  //maximum weights
    int nbr_objects;   //number of objects
    int[] result;  //to convert from decimal to a binary form
    String sumProfits_sumWeights = "";  //storing the possible cases
    
    public DynamicKnapsack(int nbr_objects, Vector<Float>weights, Vector<Float>profits, float maxWeights)
    {   //initialize each vectors
        this.profits = profits;
        this.weights = weights;
        this.maxWeights = maxWeights;
        this.nbr_objects = nbr_objects;
        
        for(int i =0; i < nbr_objects; i++){ //sets number of objects
            objects.add(i);
        }
        result = new int[nbr_objects];
    }
    //convert the number of object to binary
    int[] ConvertToBinary(int number){
        int i = nbr_objects - 1; 
        while (0 <= i){
            int k = number % 2;
            number = number / 2;
            result[i] =k;
            i--;
        }
        return result;
    }
   //solve method
    public void solve(){
    
    int number = 1; //starts with number 1 because the profits and weights initialize as 0
    int max_profits = 0;
    int max_weights =0;
    int[] array_res= null;
    String s =" ";
    
    while(number <= Math.pow(2, nbr_objects) -1){ //possible cases  2 raise to power of the number of objects -1
        int sum_of_weights = 0, sum_profits = 0;
        array_res = ConvertToBinary(number); //table receive the table of binary numbers
        
        for(int i = 0; i <array_res.length; i++){
            //represent the solutions in dynamic programming knapsack
            sum_of_weights += array_res[i] * weights.elementAt(i);
            sum_profits += array_res[i] * profits.elementAt(i);
            
        }
        
        if(sum_of_weights <= maxWeights){
            sumProfits_sumWeights += showVector(array_res) + "\tWEIGHTS : " + sum_of_weights + "\t\tPROFITS : " + sum_profits + "\n"; //showing all the possible cases

            

            //all possible cases and take the best one
            if(max_profits < sum_profits){
                max_profits = sum_profits; //the max profits receive the sum profits
                max_weights = sum_of_weights;  //the max weights receive the sum of profits
                s = showVector(array_res);
                        
            }
                    
        }
        number++;
    }
    sumProfits_sumWeights += "\nMAXIMUM PROFITS : " + max_profits + "\tWEIGHT : " + max_weights +"\tOBJECTS  [ " + showObjects(s) + " ]";
    
}
        String showVector(int[] result){
        String s ="";
        for(int i=0; i < result.length; i++){
            s = s + result[i] + "";
        }
        return s;
    }
        //function return the objects
        private String showObjects(String s){
        String obj ="";
         for(int i=0; i < s.length(); i++){
         if(s.charAt(i) == '1'){ //if the table contains 1 return to the i
             obj += i + " " ;     // 0 is not a object it represent by number 1
         }
     }
     return obj;
 }
         
}