package org.example.polymorphism1;

import java.util.*;
import java.util.function.BiPredicate;

public class PhonePay implements UPIPayment{

    static Map<String,Double> accountBalanceMap=new HashMap<>();

    static {

        accountBalanceMap.put("9701061489",10000.0);
        accountBalanceMap.put("7995179127",1000.0);


    }

    private Double accountBalance;
    BiPredicate<String,Double> balanceCheck=(amountNumber, amt)->{
        Double balance=accountBalanceMap.get(amountNumber);
        if (accountBalance > amt){
            return true;
        }else{
            return false;
        }
    };

    BiPredicate<String,Double> dailyBalanceCheck=(accountNumber,amt)->{

        Double dailyLimit=10000.0;
        ArrayList<Payment> paymentHistoryList=accountHistoryMap.get(acoountNumber);
        if (paymentHistoryList !=null){
            Double totalTransactionAmount =0.0;
            for (int i=0; i< paymentHistoryList.size(); i++){

                Payment payment=paymentHistoryList.get(i);
                totalTransactionAmount += payment.getAmount();
            }

            if (totalTransactionAmount > dailyLimit){
                return true;
                {

                }else{
                    return false;
                }else{
                    return true;
                }
            }
        }
    }

    @Override
    public Payment transfer(String fromMobileNumber , String toMobileNumber , Double amount){

        Payment p = new Payment();
        if (balanceCheck.test(fromMobileNumber,amount)){


            Double accountBalance = accountBalanceMap.get(fromMobileNumber);
            Double toAccountBalance = accountBalanceMap.get(toMobileNumber);
            Double fromTotalBalance = accountBalance-amount;
            Double toTotalBalance = toAccountBalance+amount;
            accountBalanceMap.put(fromMobileNumber,fromTotalBalance);
            accountBalanceMap.put(toMobileNumber,toTotalBalance);
            p.setStatus(PaymentStatusEnum.SUCCESS.getLabel());
            p.setTransactionId(UUID.randomUUID().toString());
            p.setUter(UUID.randomUUID().toString());
            p.setTransactionDate(new Date());

        }else{

            p.setStatus(PaymentStatusEnum.FAILED.getLabel());
            p.setTransactionId(UUID.randomUUID().toString());
            p.setUter(UUID.randomUUID().toString());
            p.setTransactionDate(new Date());
        }

        return p;
    }
}
