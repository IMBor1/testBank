package com.test.testBank.service;

import com.test.testBank.model.Wallet;
import com.test.testBank.model.dto.WalletDto;

import java.util.UUID;

public interface WalletService {
    Wallet createWallet(Wallet wallet);

    Wallet updateWallet(WalletDto walletDto, UUID walletId);

    Wallet findWallet(UUID walletId);
}
