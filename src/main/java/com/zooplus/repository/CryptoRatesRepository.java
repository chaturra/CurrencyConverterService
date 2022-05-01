package com.zooplus.repository;

import com.zooplus.entity.CryptoRatesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CryptoRatesRepository extends JpaRepository<CryptoRatesEntity, String> {


}
