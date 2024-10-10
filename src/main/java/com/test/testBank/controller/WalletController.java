package com.test.testBank.controller;

import com.test.testBank.model.Wallet;
import com.test.testBank.model.dto.WalletDto;
import com.test.testBank.service.WalletService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RequestMapping("/api/v1")
@RestController
public class WalletController {
    private final WalletService walletService;

    public WalletController(WalletService walletService) {
        this.walletService = walletService;
    }

@PostMapping("/wallet")
    public ResponseEntity<Wallet> createWallet(@RequestBody Wallet wallet) {
        return ResponseEntity.ok(walletService.createWallet(wallet));
    }

    @PutMapping("/wallet/{walletId}")
    public ResponseEntity<Wallet> updateWallet(@RequestBody WalletDto walletDto,
                                               @PathVariable UUID walletId) {
        return ResponseEntity.ok(walletService.updateWallet(walletDto, walletId));
    }

    @GetMapping("/wallets/{walletId}")
    public ResponseEntity<Wallet> findWallet(@PathVariable UUID walletId) {
        return ResponseEntity.ok(walletService.findWallet(walletId));
    }
}
