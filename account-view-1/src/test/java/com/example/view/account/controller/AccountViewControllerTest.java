package com.example.view.account.controller;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.util.ReflectionTestUtils;
import com.example.view.account.AccountViewApplication;
import com.example.view.account.config.AccountConfiguration;
import com.example.view.account.util.AccountViewTestUtils;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest(classes = AccountViewApplication.class,
    webEnvironment = WebEnvironment.RANDOM_PORT)
public class AccountViewControllerTest {

  public static final Logger logger = LoggerFactory.getLogger(AccountViewControllerTest.class);

  @Mock
  JdbcTemplate jdbcTemplate;
  
  @Test
  public void getAccountListTest() throws Exception{
    logger.info("Inside getAccountListTest..");
    AccountConfiguration accountConfiguration = new AccountConfiguration(jdbcTemplate);
    ReflectionTestUtils.setField(accountConfiguration, "jdbcTemplate", jdbcTemplate);
    Mockito.when(jdbcTemplate.queryForList("SELECT * FROM ACCOUNTS"))
    .thenReturn(AccountViewTestUtils.getAccountconfigurationList());
    assertEquals(AccountViewTestUtils.getAccountconfigurationList(),accountConfiguration.retrieveAccountList());
  }

  @Test
  public void getAccountTransactionTest() throws Exception{
    logger.info("Inside getAccountTransactionTest..");
    String accountNumber = "";
    AccountConfiguration accountConfiguration = new AccountConfiguration(jdbcTemplate);
    ReflectionTestUtils.setField(accountConfiguration, "jdbcTemplate", jdbcTemplate);
    Mockito.when(jdbcTemplate.queryForList("SELECT * FROM TRANSACTIONS WHERE ACCOUNT_NUMBER = ?", accountNumber))
    .thenReturn(AccountViewTestUtils.getTransactionsconfigurationList());
    assertEquals(AccountViewTestUtils.getTransactionsconfigurationList(),accountConfiguration.retrieveAccountTransactions(accountNumber));
  }

}
