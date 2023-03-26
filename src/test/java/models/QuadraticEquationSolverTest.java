package models;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import  org.junit.jupiter.api.Assertions;


/**
 * @author Terence Lee
 *
 * Contains the unit tests for the various public methods of the QuadraticEquationSolver
 * class
 * */
public class QuadraticEquationSolverTest {


    private static double DELTA = 0.000001;


    @ParameterizedTest
    @CsvSource({"1,2,3", "6,11,-35", "2,4,0"})
    public void testGetCoefficientA(double coefficientA, double coefficientB,
                                    double constantC) {

        QuadraticEquationSolver solver = new QuadraticEquationSolver(coefficientA,
                                            coefficientB, constantC);

        Assertions.assertEquals(coefficientA, solver.getCoefficientA(), DELTA);
    }


    @ParameterizedTest
    @CsvSource({"1,2,3", "6,11,-35", "2,4,0"})
    public void testGetCoefficientB(double coefficientA, double coefficientB,
                                    double constantC) {

        QuadraticEquationSolver solver = new QuadraticEquationSolver(coefficientA,
                coefficientB, constantC);

        Assertions.assertEquals(coefficientB, solver.getCoefficientB(), DELTA);
    }


    @ParameterizedTest
    @CsvSource({"1,2,3", "6,11,-35", "2,4,0"})
    public void testGetConstantC(double coefficientA, double coefficientB,
                                 double constantC) {

        QuadraticEquationSolver solver = new QuadraticEquationSolver(coefficientA,
                coefficientB, constantC);

        Assertions.assertEquals(constantC, solver.getConstantC(), DELTA);
    }


    @ParameterizedTest
    @CsvSource({"1,5,-14,81", "6,11,6,-23", "2,4,33,-248"})
    public void testGetDiscriminant(double coefficientA, double coefficientB,
                                    double constantC, double discriminant) {

        QuadraticEquationSolver solver = new QuadraticEquationSolver(coefficientA,
                coefficientB, constantC);

        Assertions.assertEquals(discriminant, solver.getDiscriminant(), DELTA);
    }


    @ParameterizedTest
    @CsvSource({"1,5,-14,REAL_AND_DISTINCT", "2,4,2,REAL_AND_EQUAL",
                "2,8,33,COMPLEX"})
    public void testGetRootType(double coefficientA, double coefficientB,
                                double constantC, String rootTypeString) {

        QuadraticEquationSolver solver = new QuadraticEquationSolver(coefficientA,
                coefficientB, constantC);

        Assertions.assertEquals(rootTypeString, solver.getRootType().toString());
    }


    @ParameterizedTest
    @CsvSource({"1,5,-14,REAL_AND_DISTINCT,-7,,", "6,12,6,REAL_AND_EQUAL,-1,,",
                "2,8,33,COMPLEX,,-2,-3.535533905"})
    public void testGetFirstRoot(double coefficientA, double coefficientB,
                                 double constantC, String rootType,
                                 Double firstRootReal,
                                 Double firstRootComplexRealPart,
                                 Double firstRootComplexImaginaryPart) {

        QuadraticEquationSolver solver = new QuadraticEquationSolver(coefficientA,
                coefficientB, constantC);

        if (rootType.equals("REAL_AND_EQUAL") || rootType.equals("REAL_AND_DISTINCT")){

            Assertions.assertEquals(firstRootReal, (Double) solver.getFirstRoot(), DELTA);
        }
        else{
            IComplexNumber firstRootComplexNumber = (IComplexNumber) solver.getFirstRoot();

            Assertions.assertEquals(firstRootComplexRealPart,
                    firstRootComplexNumber.getRealPart(), DELTA);

            Assertions.assertEquals(firstRootComplexImaginaryPart,
                    firstRootComplexNumber.getImaginaryPart(), DELTA);

        }

    }


    @ParameterizedTest
    @CsvSource({"1,5,-14,REAL_AND_DISTINCT,2,,", "6,12,6,REAL_AND_EQUAL,-1,,",
            "2,8,33,COMPLEX,,-2,3.535533905"})
    public void testGetSecondRoot(double coefficientA, double coefficientB,
                                  double constantC, String rootType,
                                  Double secondRootReal,
                                  Double secondRootComplexRealPart,
                                  Double secondRootComplexImaginaryPart) {

        QuadraticEquationSolver solver = new QuadraticEquationSolver(coefficientA,
                coefficientB, constantC);

        if (rootType.equals("REAL_AND_EQUAL") || rootType.equals("REAL_AND_DISTINCT")){

            Assertions.assertEquals(secondRootReal, (Double) solver.getSecondRoot(), DELTA);
        }
        else{
            IComplexNumber secondRootComplexNumber = (IComplexNumber) solver.getSecondRoot();

            Assertions.assertEquals(secondRootComplexRealPart,
                    secondRootComplexNumber.getRealPart(), DELTA);

            Assertions.assertEquals(secondRootComplexImaginaryPart,
                    secondRootComplexNumber.getImaginaryPart(), DELTA);

        }
    }


    @ParameterizedTest
    @CsvSource({"1,5,-14,-2.5,-20.25", "6,12,6,-1,0", "2,8,33,-2,25"})
    public void testGetVertex(double coefficientA, double coefficientB,
                              double constantC, double vertexXCoordinate,
                              double vertexYCoordinate) {

        QuadraticEquationSolver solver = new QuadraticEquationSolver(coefficientA,
                coefficientB, constantC);

        Assertions.assertEquals(vertexXCoordinate, solver.getVertex().getXCoordinate(), DELTA);
        Assertions.assertEquals(vertexYCoordinate, solver.getVertex().getYCoordinate(), DELTA);
    }


    @ParameterizedTest
    @CsvSource({"1,5,-14,-5", "6,12,6,-2", "2,8,33,-4"})
    public void testGetSumOfRoots(double coefficientA, double coefficientB,
                                  double constantC, double sumOfRoots) {

        QuadraticEquationSolver solver = new QuadraticEquationSolver(coefficientA,
                coefficientB, constantC);

        Assertions.assertEquals(sumOfRoots, solver.getSumOfRoots(), DELTA);
    }


    @ParameterizedTest
    @CsvSource({"1,5,-14,-14", "6,12,6,1", "2,4,33,16.5"})
    public void testGetProductOfRoots(double coefficientA, double coefficientB,
                                      double constantC, double productOfRoots) {

        QuadraticEquationSolver solver = new QuadraticEquationSolver(coefficientA,
                coefficientB, constantC);

        Assertions.assertEquals(productOfRoots, solver.getProductOfRoots(), DELTA);
    }
}