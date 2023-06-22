package model;

public enum Muenze {
    Cent10(10), Cent20(20), Cent50(50), Euro(100), Euro2(200),
    ;
    private int value;

    Muenze(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

}
