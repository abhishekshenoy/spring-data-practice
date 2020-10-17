package com.example.polymorphism;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SalesTransactionRepository extends JpaRepository<SaleTransaction,Long> {

}
