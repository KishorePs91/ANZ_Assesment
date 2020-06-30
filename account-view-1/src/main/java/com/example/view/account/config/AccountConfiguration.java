package com.example.view.account.config;

import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
public class AccountConfiguration {

  private final Logger logger = LoggerFactory.getLogger(AccountConfiguration.class);

  private JdbcTemplate jdbcTemplate;

  public AccountConfiguration(JdbcTemplate jdbcTemplate) {
    this.jdbcTemplate = jdbcTemplate;
  }

  public List<Map<String, Object>> retrieveAccountList(){
    
    logger.info("Inside retrieveAccountList..");
	return jdbcTemplate.queryForList( "SELECT * FROM ACCOUNTS");

  }

  public List<Map<String, Object>> retrieveAccountTransactions(String accountNumber){

    logger.info("Inside retrieveAccountTransactions..");
    return jdbcTemplate.queryForList( "SELECT * FROM TRANSACTIONS WHERE ACCOUNT_NUMBER = ?", accountNumber);

  }

}
