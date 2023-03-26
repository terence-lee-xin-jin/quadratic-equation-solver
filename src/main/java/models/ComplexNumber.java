package models;


/**
 * An implementation of the IComplexNumber interface
 * It represents a complex number
 *
 * A complex number consists of two parts: real and imaginary
 * Example of an imaginary number would be 4 + 3i,
 *  where 4 is the real part,  3 is the imaginary part, and i representing
 *  sqrt(-1)
 *
 * @author Terence Lee
 * */
public class ComplexNumber implements IComplexNumber {

    private double realPart;
    private double imaginaryPart;

    public ComplexNumber(){

    }



    /**
     * Returns the real part of the complex number
     * */
    @Override
    public double getRealPart() {
        return this.realPart;
    }


    /**
     * Sets the real part of the number
     *
     * @param realPart the real part
     * */
    @Override
    public void setRealPart(double realPart) {
        this.realPart = realPart;
    }


    /**
     * Returns the imaginary part of the complex number
     * */
    @Override
    public double getImaginaryPart() {
        return this.imaginaryPart;
    }


    /**
     * Sets the imaginary part of the number
     *
     * @param imaginaryPart the imaginary part
     * */
    @Override
    public void setImaginaryPart(double imaginaryPart) {
        this.imaginaryPart = imaginaryPart;
    }
}
