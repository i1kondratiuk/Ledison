package ua.com.ledison.entity;

public enum DiffuserType {
    FROSTED("Frosted"),
    CLEAR("Clear");

    private String name;

    DiffuserType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}