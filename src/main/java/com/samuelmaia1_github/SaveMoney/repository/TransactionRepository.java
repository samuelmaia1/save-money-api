package com.samuelmaia1_github.SaveMoney.repository;

import com.samuelmaia1_github.SaveMoney.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction, String> {

}
