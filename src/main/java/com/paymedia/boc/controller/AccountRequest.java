package com.paymedia.boc.controller;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class AccountRequest {

    private AccountDetail fromAcctDetails;
    private AccountDetail toAcctDetails;

    private BigDecimal amount;

}
