package ua.com.ledison.entity;

public enum CapType {
    E27("E27"),
    E14("E14"),
    E40("E40"),
    G4("G4"),
    G9("G9"),
    GU53("GU5.3"),
    T8("T8");

    private String name;

    CapType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}