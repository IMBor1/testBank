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
@Table(name = "Wallet")
public class Wallet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "wallet_id")
    private UUID walletId;
    @Column(name = "amount")
    private long amount;

    public enum OperationType {
        Deposit,
        Withdraw;
    }
@Enumerated(EnumType.STRING)
@Column(name = "operationType")
    private OperationType operationType;

}
