package ua.com.ledison.entity;

public enum Authority {
    ROLE_USER("User"),
    ROLE_ADMIN("Admin");

    private String name;

    Authority(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
