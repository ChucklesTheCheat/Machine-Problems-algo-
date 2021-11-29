import java.util.ArrayList;
import java.util.Collections;

public class EquationSystem {

    private ArrayList<Equation> equations;

    public EquationSystem() {  //Generate New System
        this.equations = new ArrayList<>();
    }

    public void clearAllEquations() { //clear all equations
        equations.clear();
    }

    public void solveByGausian() throws Exception {
        ArrayList<Equation> result = new ArrayList<>();
        ArrayList<Equation> allEquationToCheck = new ArrayList<>(equations);
        while (!checkReducedRowEshlonForm(equations) || equations.size() > 0) {
            System.out.println(this);
            int leadingIndex;
            leadingIndex = makeFirstNonZeroColInZeroIndexAndEqualOne();
            makeAllItemsInColEqualZeroExceptFirst(leadingIndex);
            result.add(equations.get(0));
            equations.remove(0);
            copyNewValsToCheckedList(result, equations, allEquationToCheck);
        }

        equations.forEach((equation) -> {
            result.add(equation);
        });
        equations = result;
    }

    public boolean checkReducedRowEshlonForm(ArrayList<Equation> equationsToCheck) {
        int lastLeadingRowIndex = Integer.MIN_VALUE;
        int lastLeadingColIndex = Integer.MIN_VALUE;

        for (int i = 0; i < equationsToCheck.size(); i++) {
            Equation equation = equationsToCheck.get(i);
            boolean isLeadingOne = equation.isLeadingOne();

            //----------Todo:Make Refactor----------//
            //Check Leading = 1 & if 2 leadings after each other the secound must 
            //Be in the right of the first
            if (isLeadingOne && i == lastLeadingRowIndex + 1) {
                int leadingIndex = equation.getFirstNonZeroIndex();
                if (!(leadingIndex > lastLeadingColIndex)) {
                    return false;
                } else {
                    lastLeadingRowIndex = i;
                    lastLeadingColIndex = leadingIndex;
                }
            } else if (isLeadingOne) {
                lastLeadingRowIndex = i;
                lastLeadingColIndex = equation.getFirstNonZeroIndex();
            }

            //Check if not leading but not zero
            if (!isLeadingOne && !equation.isZeroRow()) {
                return false;
            }

            //Check all zero rows in the end of system
            if (!checkAllZeroEquationInEnd(equationsToCheck)) {
                return false;
            }

            //Check all Items With Leading = 0
            if (!checkAllItemsInLeadingColEquualZero(equationsToCheck, lastLeadingRowIndex, lastLeadingColIndex)) {
                return false;
            }
        }
        return true;
    }


    public boolean checkAllItemsInLeadingColEquualZero(ArrayList<Equation> equationsToCheck, int leadingRowToStart, int leadingColToCheck) {
        if (!(leadingRowToStart >= 0 && leadingColToCheck >= 0)) {
            return false;
        }
        for (int i = leadingRowToStart + 1; i < equationsToCheck.size(); i++) {
            Equation equation = equationsToCheck.get(i);
            if (equation.getColValInIndex(leadingColToCheck) != 0) {
                return false;
            }
        }
        return true;

    }
    public boolean checkAllZeroEquationInEnd(ArrayList<Equation> equationsToCheck) {
        int lastZeroEquation = Integer.MAX_VALUE;
        for (int i = 0; i < equationsToCheck.size(); i++) {
            Equation equation = equationsToCheck.get(i);
            if (equation.isZeroRow()) {
                lastZeroEquation = i;
            } else {
                if (i > lastZeroEquation) {
                    return false;
                }
            }
        }
        return true;
    }

    public void makeAllItemsInColEqualZeroExceptFirst(int indexOfColToChange) {
        Equation currentRow = equations.get(0);
        for (int i = 1; i < equations.size(); i++) {
            Equation equation = equations.get(i);
            double numToMul = -equation.getColValInIndex(indexOfColToChange);
            equation.addEquation(currentRow.mulWithNumberGetEquationCopy(numToMul));
        }
    }

    public int makeFirstNonZeroColInZeroIndexAndEqualOne() {
        makeFirstNonZeroColAtZeroRowIndex();
        int firstNonZeroIndex = equations.get(0).getFirstNonZeroIndex();
        equations.get(0).makeIndexOne(firstNonZeroIndex);
        return firstNonZeroIndex;
    }

    public void makeFirstNonZeroColAtZeroRowIndex() {
        int firstNonZeroColRowIndex = getFirstNonZeroColRowIndex();
        if (firstNonZeroColRowIndex == -1) {
            throw new NumberFormatException("First -Non Zero- Col Can't Be Zero");
        }
        if (firstNonZeroColRowIndex != 0) {
            swapEquations(firstNonZeroColRowIndex, 0);
        }
    }

    public int getFirstNonZeroColRowIndex() {
        int firstNonZeroCol = Integer.MAX_VALUE;
        int row_index = -1;
        for (int i = 0; i < equations.size(); i++) {
            Equation equation = equations.get(i);
            int tempeFirstNonZeroCol = equation.getFirstNonZeroIndex();
            if (tempeFirstNonZeroCol != -1 && tempeFirstNonZeroCol < firstNonZeroCol) {
                firstNonZeroCol = tempeFirstNonZeroCol;
                row_index = i;
            }
        }
        return row_index;
    }

   
    public void swapEquations(int from, int to) {
        Equation tempToEquation = equations.get(to);
        equations.set(to, equations.get(from));
        equations.set(from, tempToEquation);
    }

    
    public EquationSystem addEquationToSystem(Equation equation) {
        this.equations.add(equation);
        return this;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        equations.forEach((equation) -> {
            builder.append(equation).append("");
        });
        return builder.toString();
    }

    private void copyNewValsToCheckedList(ArrayList<Equation> result, ArrayList<Equation> equations, ArrayList<Equation> allEquationToCheck) {
        allEquationToCheck.clear();
        allEquationToCheck.addAll(result);
        allEquationToCheck.addAll(equations);
    }

 
    public Equation getEquatinInIndex(int index) {
        return equations.get(index);
    }

    public void setEquations(ArrayList<Equation> equations) {
        this.equations = equations;
    }

   
    public int getEquationCount() {
        return equations.size();
    }

}