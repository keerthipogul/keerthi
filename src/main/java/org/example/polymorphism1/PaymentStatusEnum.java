package org.example.polymorphism1;

public enum PaymentStatusEnum {

    SUCCESS ( "Transaction is success"),

    FAILED (" Transaction is failed"),

    PENDING (" Transaction is in-progress");

    private String label;

    PaymentStatusEnum(String label) {

        this.label = label;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
}
