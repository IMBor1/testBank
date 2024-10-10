package com.test.testBank.service.impl;

import com.test.testBank.exception.NotFoundWithdraw;
import com.test.testBank.model.Wallet;
import com.test.testBank.model.dto.WalletDto;
import com.test.testBank.repository.WalletRepository;
import com.test.testBank.service.WalletService;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class WalletServiceImpl implements WalletService {
    private final WalletRepository walletRepository;

    public WalletServiceImpl(WalletRepository walletRepository) {
        this.walletRepository = walletRepository;
    }

    @Override
    public Wallet createWallet(Wallet wallet) {
        return walletRepository.save(wallet);
    }

    @Override
    public Wallet updateWallet(WalletDto walletDto, UUID walletId) {
        Wallet wallet = walletRepository.findById(walletId).orElseThrow(NotFoundWithdraw::new);
        if(walletDto.getOperationType()== Wallet.OperationType.Withdraw &&
        walletDto.getAmount() < walletRepository.findById(walletId).orElseThrow().getAmount());
        wallet.setAmount(walletDto.getAmount());
        wallet.setOperationType(walletDto.getOperationType());
        return walletRepository.save(wallet);
    }

    @Override
    public Wallet findWallet(UUID walletId) {
        return walletRepository.findById(walletId).orElseThrow(NotFoundWithdraw::new);
    }
}
