public class MainFramePresenter {

    private static MainFramePresenter instance;

    private MainFramePresenter() {
        solver = SystemSolver.getInstance();
    }

 
    public static synchronized MainFramePresenter getInstance() {
        if (instance == null) {
            instance = new MainFramePresenter();
        }
        return instance;
    }

    private MainFrame frame;
    private final SystemSolver solver;
 
    public void clearSystem() {
        solver.clearSystem();
    }

    
    public void addEquationToSystem(Equation equation) {
        solver.addEquationToSystem(equation);
    }

    private void getFinalResultFromSystem() throws Exception {
        Equation equation = new Equation(solver.collectResultsFromSystem());
        equation.roundDoubles();
        frame.addResultsToTable(equation.getVarsParametersAndConstant());
    }

    public void solveByGausian() throws Exception {
        solver.solveByGausian();
        getFinalResultFromSystem();
    }

    public void printSystem() {
        solver.printSystem();
    }

   
    public void setFrame(MainFrame frame) {
        this.frame = frame;
        frame.setPresenter(instance);
    }

}