package com.test.testBank;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.test.testBank.controller.WalletController;
import com.test.testBank.exception.NotFoundWithdraw;
import com.test.testBank.model.Wallet;
import com.test.testBank.model.dto.WalletDto;
import com.test.testBank.service.WalletService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.UUID;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;
import static org.springframework.mock.http.server.reactive.MockServerHttpRequest.post;
import static org.springframework.mock.http.server.reactive.MockServerHttpRequest.put;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class WalletControllerTest {
    @InjectMocks
    private WalletController walletController;

    @Mock
    private WalletService walletService;
@Autowired
    private MockMvc mockMvc;


    private ObjectMapper objectMapper = new ObjectMapper();

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(walletController).build();
    }

    @Test
    public void testCreateWallet() throws Exception {
        Wallet wallet = new Wallet();
        wallet.setWalletId(UUID.randomUUID());
        wallet.setAmount(1000.0);

        when(walletService.createWallet(any(Wallet.class))).thenReturn(wallet);

        mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/wallet")
                .content(objectMapper.writeValueAsString(wallet))
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(MockMvcResultMatchers.status().isOk());

        verify(walletService, times(1)).createWallet(any(Wallet.class));
    }

    @Test
    public void testUpdateWallet() throws Exception {
        UUID walletId = UUID.randomUUID();
        WalletDto walletDto = new WalletDto();
        walletDto.setOperationType(Wallet.OperationType.Withdraw);
        walletDto.setAmount(500.0);

        Wallet updatedWallet = new Wallet();
        updatedWallet.setWalletId(walletId);
        updatedWallet.setAmount(500.0);

        when(walletService.updateWallet(any(WalletDto.class), eq(walletId))).thenReturn(updatedWallet);

        mockMvc.perform(MockMvcRequestBuilders.put("/api/v1/wallet/{walletId}", walletId)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(walletDto)))
                .andExpect(status().isOk());

        verify(walletService, times(1)).updateWallet(any(WalletDto.class), eq(walletId));
    }

    @Test
    public void testFindWallet() throws Exception {
        UUID walletId = UUID.randomUUID();
        Wallet wallet = new Wallet();
        wallet.setWalletId(walletId);
        wallet.setAmount(1000.0);

        when(walletService.findWallet(eq(walletId))).thenReturn(wallet);

        mockMvc.perform(get("/api/v1/wallets/{walletId}", walletId))
                .andExpect(status().isOk());

        verify(walletService, times(1)).findWallet(eq(walletId));
    }

    @Test
    public void testFindNonExistentWallet() throws Exception {
        UUID walletId = UUID.randomUUID();

        when(walletService.findWallet(eq(walletId))).thenThrow(new NotFoundWithdraw());

        mockMvc.perform(get("/api/v1/wallets/{walletId}", walletId))
                .andExpect(status().isNotFound());

        verify(walletService, times(1)).findWallet(eq(walletId));
    }
}
