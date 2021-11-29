import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Equation {

    private final double[] varsParametersAndConstant;

    public Equation(double[] varsParametersAndConstant) {
        this.varsParametersAndConstant = varsParametersAndConstant;
    }

 
    public double[] makeIndexOne(int index) {
        double paramToDev = varsParametersAndConstant[index];
        return mulWithNumber(1 / paramToDev);
    }

    public double[] mulWithNumber(double number) {
        for (int i = 0; i < varsParametersAndConstant.length; i++) {
            varsParametersAndConstant[i] *= number;
        }
        return varsParametersAndConstant;
    }

    public Equation mulWithNumberGetEquationCopy(double number) {
        double[] copy = new double[varsParametersAndConstant.length];
        System.arraycopy(
                varsParametersAndConstant,
                0,
                copy,
                0,
                varsParametersAndConstant.length
        );

        for (int i = 0; i < copy.length; i++) {
            copy[i] *= number;
        }

        return new Equation(copy);
    }
    
    public Equation addEquation(Equation equation) {
        for (int i = 0; i < equation.getVarsParametersAndConstant().length; i++) {
            this.varsParametersAndConstant[i] += equation.getVarsParametersAndConstant()[i];
        }
        return this;
    }

   
    public int getFirstNonZeroIndex() {
        for (int i = 0; i < varsParametersAndConstant.length; i++) {
            if (!checkZeroInIndex(i)) {
                return i;
            }
        }
        return -1;
    }

    
    public boolean checkZeroInIndex(int index) {
        return varsParametersAndConstant[index] == 0;
    }

    public double[] getVarsParametersAndConstant() {
        return varsParametersAndConstant;
    }

    
    public double getColValInIndex(int index) {
        return varsParametersAndConstant[index];
    }

    
    public boolean isLeadingOne() {
        int firstNonZeroIndex = getFirstNonZeroIndex();
        return firstNonZeroIndex != -1
                && varsParametersAndConstant[firstNonZeroIndex] == 1;
    }

    
    public boolean isZeroRow() {
        for (double d : varsParametersAndConstant) {
            if (d != 0) {
                return false;
            }
        }
        return true;
    }

    public void inverse() { //Inverse The Equation (Result Of Equation Not Inverted)
        List<Double> list = Arrays.stream(varsParametersAndConstant).boxed().collect(Collectors.toList());
        Collections.reverse(list);
        for (int i = 0; i < list.size() - 1; i++) {
            varsParametersAndConstant[i] = (double) list.get(i + 1);
        }
    }

    @Override
    public String toString() {
        return Arrays.toString(varsParametersAndConstant);
    }

    DecimalFormat df = new DecimalFormat("#.##"); //set to two decimal places

    public void roundDoubles() {
        for (int i = 0; i < varsParametersAndConstant.length; i++) {
            varsParametersAndConstant[i] = Double.valueOf(df.format(varsParametersAndConstant[i]));
        }
    }

}