
import java.util.Vector;

public class KnapsackGreedyAlgo {
    Vector<Integer> objects = new Vector(); //vector of object
    Vector<Float> profits;  //vector for profits
    Vector<Float> weights;  //vector for weights
    float maxWeights; //maximum weight
    String sumProfits_sumWeights; //contains the results
    
    //constructor
    public KnapsackGreedyAlgo(int nbr_object, Vector<Float> weights, Vector<Float> profits, float maxWeights){
        //initialize those vectors
        this.profits = profits;
        this.weights = weights;
        this.maxWeights = maxWeights;        
            
        for(int i = 0; i < nbr_object; i++){ //set a number of the object
            objects.add(i);
            
        }
        
    }
        //solve method
        Vector<Integer>solve(){
        Vector<Float> fraction = new Vector<>(); //contains each profits by its weights
        Vector<Integer> results_objects = new Vector<>();
             
            for(int i = 0; i <objects.size(); i++){
                  fraction.add(profits.elementAt(i) / weights.elementAt(i)); //calculating the profit divide by weights
            
        }
        int max_object_profit;
        float sum_weights = 0;
        float sum_profits = 0;
        boolean test = true;
        
        while(test){
            max_object_profit = getIndexMax(fraction); //recieve the IndexMax fraction
            test = false;
            float temp = sum_weights + weights.elementAt(max_object_profit); //adding the old weights to the recent weights and put the result to a variable temp
               
                if(temp <= maxWeights){ //compare the variable temp to Maximum weights 
                    test = true; 
                    sum_weights = temp; //if true the sum weight will recieve the varible temp
                    results_objects.add(max_object_profit); // add to object vector
                    sum_profits = sum_profits + profits.elementAt(max_object_profit); // calculating the submission of the profits
            
        }
    }
        sumProfits_sumWeights = "\n               WEIGHTS  = " + sum_weights + "\n               PROFITS  = " + sum_profits; //try to evaluate the final results
        return results_objects; // then if it sucessfully solve return to the vector contains objects
    
}
        int getIndexMax(Vector<Float> tab){
        int index_max = 0;
    
        for(int i =0; i < tab.size(); i++){ //calculate the maximum IndexMax
             if(tab.elementAt(index_max) < tab.elementAt(i)){
                index_max = i;
     }
 }
        tab.set(index_max, (float) -1); //replace the maximum number by -1 beacause of weights object are more than zero
        return index_max;
}
}

