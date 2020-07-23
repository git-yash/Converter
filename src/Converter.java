public class Converter {
    public double milesToInches(double miles) {
        int inchesInAMile = 63360;
        return miles * inchesInAMile;
    }

    public double areaOfCircle(double radius) {
        return (radius * radius) * Math.PI;
    }
}
