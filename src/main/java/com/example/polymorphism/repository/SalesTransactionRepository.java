package com.example.polymorphism.repository;

import com.example.polymorphism.model.SaleTransaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SalesTransactionRepository extends JpaRepository<SaleTransaction,Long> {

}
