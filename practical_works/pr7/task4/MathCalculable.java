package pr7.task4;

public interface MathCalculable {
    double PI = Math.PI;

    ComplexNumber pow(ComplexNumber base, int exponent);
    double absComplex(ComplexNumber number);
    double pow(double base, int exponent);
}
