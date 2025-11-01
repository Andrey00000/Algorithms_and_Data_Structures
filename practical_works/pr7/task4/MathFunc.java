package pr7.task4;

public class MathFunc implements MathCalculable{

    @Override
    public double pow(double base, int exponent) {
        return Math.pow(base, exponent);
    }

    @Override
    public ComplexNumber pow(ComplexNumber base, int exponent) {
        if (exponent == 0) {
            return new ComplexNumber(1, 0);
        }

        double modulus = absComplex(base);
        double argument = Math.atan2(base.getImaginary(), base.getReal());

        double newModulus = Math.pow(modulus, exponent);
        double newReal = newModulus * Math.cos(argument * exponent);
        double newImaginary = newModulus * Math.sin(argument * exponent);

        return new ComplexNumber(newReal, newImaginary);
    }

    @Override
    public double absComplex(ComplexNumber number) {
        return Math.sqrt(pow(number.getReal(), 2) + pow(number.getImaginary(), 2));
    }

    public double circleLength(double radius) {
        return 2 * PI * radius;
    }

}
