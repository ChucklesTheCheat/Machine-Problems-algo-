
public class SystemSolver {

    private static SystemSolver instance;

    private SystemSolver() {
        system = new EquationSystem();
    }

   
    public static synchronized SystemSolver getInstance() {
        if (instance == null) {
            instance = new SystemSolver();
        }
        return instance;
    }
    
    private final EquationSystem system;
 
    public void clearSystem() { //Clear System Equations
        system.clearAllEquations();
    }

    
    public void addEquationToSystem(Equation equation) {
        system.addEquationToSystem(equation);
    }

    
    public void solveByGausian() throws Exception {
        system.solveByGausian();
    }

    
    public double[] collectResultsFromSystem() throws Exception {
        double[] vars = new double[system.getEquationCount()];
        for (int i = vars.length - 1; i >= 0; i--) {
            Equation equation;
            try {
                equation = system.getEquatinInIndex(i);
            } catch (Exception e) {
                throw new Exception("Can't Get Solution !");
            }
            double lastNumInEquation = equation.getColValInIndex(vars.length);
            int firstNonZeroIndex = equation.getFirstNonZeroIndex();
            if (firstNonZeroIndex >= equation.getVarsParametersAndConstant().length - 1) {
                throw new Exception("Can't Get Solution !");
            }
            for (int j = firstNonZeroIndex + 1; j < vars.length; j++) {
                lastNumInEquation -= equation.getColValInIndex(j) * vars[j];
            }
            vars[i] = lastNumInEquation;
        }
        return vars;
    }

    
    //Print The System
    
    public void printSystem() {
        //System.out.println("Rewrite the system in matrix form and solve it by Gaussian Elimination (Gauss-Jordan elimination)\n" +system);
        
    }

}