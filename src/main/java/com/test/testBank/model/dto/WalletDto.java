package com.test.testBank.model.dto;

import com.test.testBank.model.Wallet;
import lombok.Data;

import java.math.BigDecimal;
import java.util.UUID;
@Data
public class WalletDto {
    private UUID walletId;
    private Double amount;
    private Wallet.OperationType operationType;
}
