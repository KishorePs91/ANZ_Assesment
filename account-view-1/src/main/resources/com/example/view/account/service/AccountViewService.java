package com.example.view.account.service;

import org.springframework.http.ResponseEntity;

import com.fasterxml.jackson.databind.JsonNode;

public interface AccountViewService {

  ResponseEntity<JsonNode> getAccountList();

  ResponseEntity<JsonNode> getAccountTransaction(String accountNumber);

}
