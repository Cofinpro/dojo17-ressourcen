package de.cofinpro.dojo.ressourcen.model;

public enum CustomerRole {
    SOFTWARE_ENGINEER("software-engineer");
    private final String value;

    private CustomerRole(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
