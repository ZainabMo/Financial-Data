package com.ssci.financialdata.repository;

import java.util.List;

import com.ssci.financialdata.model.FinancialData;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface FinancialDataRepository extends MongoRepository<FinancialData, String> {
  public List<FinancialData> findByUserId(String userId);
  public List<FinancialData> findByDate(int date);
  public long count();

}
