public enum Options {
    MILES_TO_INCHES(0),
    AREA_OF_CIRCLE(1);

    private final int option;

    Options(int option) {
        this.option = option;
    }

    public int getLevelCode() {
        return this.option;
    }


}
