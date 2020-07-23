public class Converter {
    public double milesToInches(double miles) {
        int inchesInAMile = 63360;
        return Math.round((miles * inchesInAMile) * 100.0) / 100.0;
    }

    public double areaOfCircle(double radius) {
        return Math.round(((radius * radius) * Math.PI) * 100.0) / 100.0;
    }
}
