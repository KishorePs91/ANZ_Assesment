package com.example.view.account.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AccountViewTestUtils {

  public static List<Map<String, Object>> getAccountconfigurationList(){
		
    List<Map<String, Object>> accountsList = new ArrayList<Map<String, Object>>();

    Map<String, Object> account = new HashMap<String, Object>();

    account.put("ACCOUNT_NAME", "AUSavings726");
    account.put("ACCOUNT_NUMBER","5600098342");
    account.put("ACCOUNT_TYPE","Savings");
    account.put("AVAILABLE_BALANCE","54,098.95");
    account.put("BALANCE_DATE","08/04/2020");
    account.put("CURRENCY","AUD");

    accountsList.add(account);
    
    return accountsList;
    
  }
		
  public static List<Map<String, Object>> getTransactionsconfigurationList(){
		
    List<Map<String, Object>> transactionsList = new ArrayList<Map<String, Object>>();

    Map<String, Object> transaction = new HashMap<String, Object>();

    transaction.put("ACCOUNT_NUMBER", "5600098342");
    transaction.put("ACCOUNT_TYPE","Savings Account");
    transaction.put("VALUE_DATE","08/04/2020");
    transaction.put("CURRENCY","AUD");
    transaction.put("DEBIT_AMOUNT","");
    transaction.put("CREDIT_AMOUNT","101.00");
    transaction.put("TRANSACTION","Credit");
    transaction.put("TRANSACTION_NARATIVE","");

    transactionsList.add(transaction);
    
    return transactionsList;
    
  }
}
