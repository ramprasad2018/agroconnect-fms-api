package com.agroconnect.fms_api.repository;

import com.agroconnect.fms_api.model.FarmExpense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FarmExpenseRepository extends JpaRepository<FarmExpense, Integer> {
}