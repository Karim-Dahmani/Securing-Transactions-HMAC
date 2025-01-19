package com.example.moneytransfer.dto;

import lombok.Data;

@Data
public class TransferMoneyRequest {
    private String fromAccount;
    private String toAccount;
    private Double amount;
    private String digitalSignature; // The digital signature accompanying the transfer
}
