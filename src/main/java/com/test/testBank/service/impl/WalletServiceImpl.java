package com.test.testBank.service.impl;

import com.test.testBank.model.repository.WalletRepository;
import org.springframework.stereotype.Service;

@Service
public class WalletServiceImpl {
    private final WalletRepository walletRepository;

    public WalletServiceImpl(WalletRepository walletRepository) {
        this.walletRepository = walletRepository;
    }
}
