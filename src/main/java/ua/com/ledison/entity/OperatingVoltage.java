package ua.com.ledison.entity;

public enum OperatingVoltage {
    V_175_250("175-250"),
    V_198_242("198-242"),
    V_200_240("200-240"),
    V_220("220"),
    V_220_240("220-240");

    private String name;

    OperatingVoltage(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}