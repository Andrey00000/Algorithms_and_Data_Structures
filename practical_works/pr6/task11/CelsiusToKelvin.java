package pr6.task11;

public class CelsiusToKelvin implements Convertable {
    private double celsius;

    public CelsiusToKelvin(double celsius){
        this.celsius = celsius;
    }

    @Override
    public double convert() {
        return celsius + 273.15;
    }

    @Override
    public String toString() {
        return celsius + " °C = " + convert() + " K";
    }
}
