package org.example.polymorphism1;

public class InterfaceTest {

    public static void main(String[] args) {

        PhonePay payment =  new PhonePay();


        Payment pay = payment.transfer("9701061489","7995179127",3000.0);
        System.out.println(pay.getTransactionId()+" status "+pay.getStatus()+" uter "+pay.getUter()+" Date "+pay.getTransactionDate());
        System.out.println("Balance of from account"+PhonePay.accountBalanceMap.get("9701061489"));
        System.out.println("Balance of to account"+PhonePay.accountBalanceMap.get("7995179127"));
    }
}
