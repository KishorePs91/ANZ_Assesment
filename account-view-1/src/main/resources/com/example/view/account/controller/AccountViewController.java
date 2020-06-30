package com.example.view.account.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.view.account.service.AccountViewService;
import com.fasterxml.jackson.databind.JsonNode;

@RestController
public class AccountViewController {

  private static final Logger logger = LoggerFactory.getLogger(AccountViewController.class);

  @Autowired
  AccountViewService accountViewService;

  @RequestMapping(path = "${get-account-list}", method = RequestMethod.GET, produces = "application/json")
  @ResponseBody
  public ResponseEntity<JsonNode> getAccountList(){

    logger.info("Start of getAccountList Controller..");
    return accountViewService.getAccountList();

  }

  @RequestMapping(path = "${get-account-transaction}", method = RequestMethod.GET, produces = "application/json")
  @ResponseBody
  public ResponseEntity<JsonNode> getAccountTransaction(@RequestParam(name = "accountNumber") String accountNumber){

    logger.info("Start of getAccountList Controller..");
    return accountViewService.getAccountTransaction(accountNumber);

  }
}
