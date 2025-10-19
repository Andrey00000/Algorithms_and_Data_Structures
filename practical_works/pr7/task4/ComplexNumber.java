package pr7.task4;

public class ComplexNumber {
    private double real;
    private double imaginary;

    public ComplexNumber(double real, double imaginary){
        this.imaginary = imaginary;
        this.real = real;
    }

    public double getReal() { return real; }
    public double getImaginary() { return imaginary; }

    @Override
    public String toString(){
        if (imaginary >= 0) {
            return real + " + " + imaginary + "i";
        } else {
            return real + " - " + Math.abs(imaginary) + "i";
        }
    }
}
