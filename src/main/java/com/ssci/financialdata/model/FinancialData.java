package com.ssci.financialdata.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection="financial-data")
public class FinancialData {

  @Id
  private String id;
  
  private int totalAssets;
  private int netLoans;
  private int grossLoans;
  private int date;
  private String userId;

  public FinancialData() {}

  public FinancialData(int totalAssets, int netLoans, int grossLoans, int date, String userId) {
    this.totalAssets = totalAssets;
    this.netLoans = netLoans;
    this.userId = userId;
    this.grossLoans = grossLoans;
    this.date = date;
  }

  @Override
  public String toString() {
    return String.format(
        "FinancialData[id='%s', user_id='%s']",
        id, userId);
  }

}