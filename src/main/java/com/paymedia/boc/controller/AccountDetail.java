package com.paymedia.boc.controller;

import lombok.Data;

@Data
public class AccountDetail {

    private String acctId;
    private String costCenter;
    private AccountType acctType;
}
