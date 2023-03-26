package models;


/**
 * A simple quadratic equation solver
 *
 *  @author Terence Lee
 *
 * Example usage:
 * <pre>
 *     //quadratic equation is 6x^2 + 11x - 35 = 0
 *
 *     QuadraticEquationSolver solver = new QuadraticEquationSolver(6,11,-35);
 *
 *     double discriminant = solver.getDiscriminant();
 *     double sumOfRoots = solver.getSumOfRoots();
 *     double productOfRoots = solver.getProductOfRoots();
 *     IVertex vertex = solver.getVertex();
 *
 *     QuadraticEquationSolver.RootType rootType = solver.getRootType();
 *
 *     Object firstRoot =  solver.getFirstRoot();
 *     Object secondRoot = solver.getSecondRoot();
 *
 *     if (rootType == REAL_AND_EQUAL || rootType == REAL_AND_DISTINCT){
 *
 *         Double firstRootDouble = (Double) firstRoot;
 *         Double secondRootDouble = (Double) secondRoot;
 *     }
 *     else{
 *         //complex roots
 *         IComplexNumber firstRootComplexNumber = (IComplexNumber) firstRoot;
 *         IComplexNumber secondRootComplexNumber = (IComplexNumber) secondRoot;
 *     }
 *
 * </pre>
 *
 * */
public class QuadraticEquationSolver {

    private final double coefficientA;
    private final double coefficientB;
    private final double constantC;

    private double discriminant;

    private RootType rootType;
    private Object firstRoot;
    private Object secondRoot;

    private IVertex vertex;
    private double sumOfRoots;
    private double productOfRoots;


    /**
     * Represents the possible values of the type of roots
     * a quadratic equation has
     * */

    public enum RootType
    {
        REAL_AND_EQUAL,
        REAL_AND_DISTINCT,
        COMPLEX
    }


    /**
     * The constructor which takes in three parameters (a,b,c)
     * which refers to the quadratic equation
     * ax^2 + bx + c = 0
     *
     * @param coefficientA the coefficient a of the quadratic equation
     * @param coefficientB the coefficient b of the quadratic equation
     * @param constantC the constant c of the quadratic equation
     * */
    public QuadraticEquationSolver(double coefficientA, double coefficientB, double constantC) {

        this.coefficientA = coefficientA;
        this.coefficientB = coefficientB;
        this.constantC = constantC;

        solveQuadraticEquation();
    }


    /**
     * Solve the quadratic equation
     * */
    private void solveQuadraticEquation(){

        calculateAndSetDiscriminant();

        calculateAndSetRootType();
        calculateAndSetFirstRoot();
        calculateAndSetSecondRoot();

        calculateAndSetVertex();
        calculateAndSetSumOfRoots();
        calculateAndSetProductOfRoots();

    }


    /**
     * Calculate and set the value of the discriminant of the quadratic equation,
     * using the formula discriminant = (b^2 - 4ac)
     * */
    private void calculateAndSetDiscriminant(){

        this.discriminant = (coefficientB * coefficientB) - (4* coefficientA * constantC);
    }


    /**
     * Determine and set the root type of the quadratic equation solutions based on the
     * calculated discriminant
     *
     * @pre this.discriminant must first be calculated and set
     * */
    private void calculateAndSetRootType()
    {
        if (this.discriminant == 0) {

            this.rootType = RootType.REAL_AND_EQUAL;
        }
        else if (this.discriminant > 0) {

            this.rootType = RootType.REAL_AND_DISTINCT;
        }
        else{
            this.rootType = RootType.COMPLEX;
        }
    }


    /**
     * Calculate and set the first root of the quadratic equation
     * where firstRoot = (-b - sqrt(b^2 - 4ac))/(2a)
     *
     * Depending on the value of getRootType(), sets two possible types of values for firstRoot:
     *
     *      (a) getRootType() == REAL_AND_EQUAL -->
     *                      sets a Double object wrapper representing the first root
     *      (b) getRootType() == REAL_AND_DISTINCT -->
     *                      sets a Double object wrapper representing the first root
     *      (c) getRootType() == COMPLEX -->
     *                      sets a IComplex object representing the first root
     *
     *  @pre the this.discriminant value must already be calculated and set
     * */
    private void calculateAndSetFirstRoot(){

        if (this.discriminant < 0){

            double realPartOfComplexRoot = -coefficientB /(2* coefficientA);
            double imaginaryPartOfComplexRoot =
                    -Math.sqrt(Math.abs(this.discriminant))/(2*coefficientA);

            IComplexNumber complexFirstRoot = new ComplexNumber();
            complexFirstRoot.setRealPart(realPartOfComplexRoot);
            complexFirstRoot.setImaginaryPart(imaginaryPartOfComplexRoot);

            this.firstRoot = complexFirstRoot;
        }
        else{
            Double firstRootDoubleObject =
                    (-coefficientB - Math.sqrt(this.discriminant))/(2* coefficientA);

            this.firstRoot = firstRootDoubleObject;
        }
    }


    /**
     * Calculate and set the second root of the quadratic equation
     * where secondRoot = (-b + sqrt(b^2 - 4ac))/(2a)
     *
     * Depending on the value of getRootType(), sets two possible types of values for firstRoot:
     *
     *      (a) getRootType() == REAL_AND_EQUAL -->
     *                      sets a Double object wrapper representing the second root
     *      (b) getRootType() == REAL_AND_DISTINCT -->
     *                      sets a Double object wrapper representing the second root
     *      (c) getRootType() == COMPLEX -->
     *                      sets a IComplex object representing the second root
     *
     * @pre the this.discriminant value must already be calculated and set
     * */
    private void calculateAndSetSecondRoot(){

        if (this.discriminant < 0){

            double realPartOfComplexRoot = -coefficientB /(2* coefficientA);
            double imaginaryPartOfComplexRoot =
                    Math.sqrt(Math.abs(this.discriminant))/(2* coefficientA);

            IComplexNumber complexFirstRoot = new ComplexNumber();
            complexFirstRoot.setRealPart(realPartOfComplexRoot);
            complexFirstRoot.setImaginaryPart(imaginaryPartOfComplexRoot);

            this.secondRoot = complexFirstRoot;
        }
        else{
            Double secondRootDoubleObject =
                    (-coefficientB + Math.sqrt(this.discriminant))/(2* coefficientA);

            this.secondRoot = secondRootDoubleObject;
        }
    }



    /**
     * Calculate and set the vertex of the quadratic equation.
     *
     * The vertex refers to the highest/lowest point on the plotted
     * graph of a quadratic equation, and is represented by a pair of
     * x-y coordinates
     *
     * A quadratic equation only has one vertex, and it is either the
     * highest or lowest point on a plotted graph
     *
     * */
    private void calculateAndSetVertex(){

        double xCoordinate = -coefficientB /(2* coefficientA);
        double yCoordinate =
                (coefficientA * xCoordinate * xCoordinate) + (coefficientB *xCoordinate) + constantC;

        IVertex vertex = new Vertex();
        vertex.setXCoordinate(xCoordinate);
        vertex.setYCoordinate(yCoordinate);

        this.vertex = vertex;

    }


    /**
     * Calculate and set the this.sumOfRoots of the quadratic equation
     * using the formula sumOfRoots = -b/a
     *
     * where a and b are coefficients of the quadratic equation
     * ax^2 + bx + c = 0
     * */
    private void calculateAndSetSumOfRoots(){

        this.sumOfRoots = (-coefficientB)/ coefficientA;
    }


    /**
     * Calculate and set the this.productOfRoots of the quadratic equation
     * using the formula productOfRoots = c/a
     *
     * where a and c are coefficients of the quadratic equation
     * ax^2 + bx + c = 0
     * */
    private void calculateAndSetProductOfRoots(){
        this.productOfRoots = constantC / coefficientA;
    }


    /**
     * Getter for the coefficient a of the quadratic equation,
     * where ax^2 + bx + c = 0
     * */
    public double getCoefficientA() {
        return this.coefficientA;
    }


    /**
     * Getter for the coefficient b of the quadratic equation,
     * where ax^2 + bx + c = 0
     * */
    public double getCoefficientB() {
        return coefficientB;
    }


    /**
     * Getter for the constant c of the quadratic equation,
     * where ax^2 + bx + c = 0
     * */
    public double getConstantC() {
        return constantC;
    }


    /**
     * Getter for the discriminant of the quadratic equation,
     * where discriminant = (b^2 - 4ac)
     * */
    public double getDiscriminant(){
        return this.discriminant;
    }


    /**
     * Getter for the root type of the quadratic equation
     *
     * Possible Values are:
     *      (a) REAL_AND_EQUAL --> real and equal roots if discriminant == 0
     *      (b) REAL_AND_DISTINCT  --> real and distinct roots if discriminant > 0
     *      (c) COMPLEX --> complexr roots if discriminant < 0
     * */
    public RootType getRootType(){
        return this.rootType;
    }


    /**
     * Getter for the first root of the quadratic equation
     * where firstRoot = (-b - sqrt(b^2 - 4ac))/(2a)
     *
     * Depending on the value of getRootType(), returns two possible types of values:
     *
     *      (a) getRootType() == REAL_AND_EQUAL -->
     *                      returns a Double object wrapper representing the first root
     *      (b) getRootType() == REAL_AND_DISTINCT -->
     *                      returns a Double object wrapper representing the first root
     *      (c) getRootType() == COMPLEX -->
     *                      returns a IComplex object representing the first root
     * */
    public Object getFirstRoot(){
        return this.firstRoot;
    }


    /**
     * Getter for the second root of the quadratic equation
     * where secondRoot = (-b + sqrt(b^2 - 4ac))/(2a)
     *
     * Depending on the value of getRootType(), returns two possible types of values:
     *
     *      (a) getRootType() == REAL_AND_EQUAL -->
     *                      returns a Double object wrapper representing the first root
     *      (b) getRootType() == REAL_AND_DISTINCT -->
     *                      returns a Double object wrapper representing the first root
     *      (c) getRootType() == COMPLEX -->
     *                      returns a IComplex object representing the first root
     * */
    public Object getSecondRoot(){
        return this.secondRoot;
    }


    /**
     * Getter for the vertex of the quadratic equation
     *
     * Returns a deep-copy of the vertex of the quadratic equation
     * */
    public IVertex getVertex(){

        IVertex vertexCopy = new Vertex();
        vertexCopy.setXCoordinate(this.vertex.getXCoordinate());
        vertexCopy.setYCoordinate(this.vertex.getYCoordinate());

        return vertexCopy;
    }




    /**
     * Returns the sum of roots of the quadratic equation
     * using the formula sumOfRoots = -b/a
     *
     * where a and b are coefficients of the quadratic equation
     * ax^2 + bx + c = 0
     * */
    public double getSumOfRoots(){
        return this.sumOfRoots;
    }





    /**
     * Returns the product of roots of the quadratic equation
     * using the formula productOfRoots = c/a
     *
     * where a and c are coefficients of the quadratic equation
     * ax^2 + bx + c = 0
     * */
    public double getProductOfRoots(){
        return this.productOfRoots;
    }

}
