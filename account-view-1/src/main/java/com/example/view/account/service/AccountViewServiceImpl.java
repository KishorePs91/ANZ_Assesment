package com.example.view.account.service;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.view.account.config.AccountConfiguration;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class AccountViewServiceImpl implements AccountViewService{

  private static final Logger logger = LoggerFactory.getLogger(AccountViewServiceImpl.class);

  @Autowired
  AccountConfiguration accountConfiguration;

  @Override
  public ResponseEntity<JsonNode> getAccountList() {

    logger.info("Inside getAccountList");
    List<Map<String, Object>> accountsList = accountConfiguration.retrieveAccountList();
    ObjectMapper mapper = new ObjectMapper();
    JsonNode accountsArray = mapper.valueToTree(accountsList);
    JsonNode result = mapper.createObjectNode().set("Accounts",accountsArray);
    return new ResponseEntity<JsonNode>(result, HttpStatus.OK);

  }



  @Override
  public ResponseEntity<JsonNode> getAccountTransaction(String accountNumber) {

    logger.info("Inside getAccountTransaction ");
    List<Map<String, Object>> transactionsList = accountConfiguration.retrieveAccountTransactions(accountNumber);
    
    if ( transactionsList.size() == 0 ) {
    	
      return new ResponseEntity<JsonNode>(HttpStatus.BAD_REQUEST);
      
    } else {
    	
      ObjectMapper mapper = new ObjectMapper();
      JsonNode transactionsArray = mapper.valueToTree(transactionsList);
      JsonNode result = mapper.createObjectNode().set("Transactions",transactionsArray);
      return new ResponseEntity<JsonNode>(result, HttpStatus.OK);
      
    }

  }

}
