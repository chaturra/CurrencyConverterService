package com.zooplus.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "cryptoRates")
@Table(name = "CRYPTO_RATE")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CryptoRatesEntity {

    @Id
    @Column(name = "CRYPTO_CURRENCY_NAME")
    private String cryptoCurrencyName;

    @Column(name = "PRICE")
    private String price;

}
