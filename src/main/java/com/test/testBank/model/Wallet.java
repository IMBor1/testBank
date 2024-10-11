package com.test.testBank.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "wallet")
public class Wallet {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "wallet_id")
    private UUID walletId;
    @Column(name = "amount")
    private Double amount;

    public enum OperationType {
        DEPOSIT,
        WITHDRAW;
    }
@Enumerated(EnumType.STRING)
@Column(name = "operationType")
    private OperationType operationType;

}
