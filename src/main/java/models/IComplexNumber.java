package models;


/**
 * An interface representing a complex number
 *
 * A complex number consists of two parts: real and imaginary
 * Example of an imaginary number would be 4 + 3i,
 *  where 4 is the real part,  3 is the imaginary part, and i representing
 *  sqrt(-1)
 *
 * @author Terence Lee
 * */
public interface IComplexNumber {

    /**
     * Returns the real part of the complex number
     * */
    double getRealPart();



    /**
     * Sets the real part of the number
     *
     * @param realPart the real part
     * */
    void setRealPart(double realPart);


    /**
     * Returns the imaginary part of the complex number
     * */
    double getImaginaryPart();


    /**
     * Sets the imaginary part of the number
     *
     * @param imaginaryPart the imaginary part
     * */
    void setImaginaryPart(double imaginaryPart);
}
