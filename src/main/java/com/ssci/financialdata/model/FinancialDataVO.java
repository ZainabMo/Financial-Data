package com.ssci.financialdata.model;

import org.springframework.data.annotation.Id;

import lombok.Data;

@Data
public class FinancialDataVO {

  @Id
  private String id;
  
  private String totalAssets;
  private String netLoans;
  private String grossLoans;
  private String date;
  private String userId;

  public FinancialDataVO() {}

  public FinancialDataVO(String totalAssets, String netLoans, String grossLoans, String date, String userId) {
    this.totalAssets = totalAssets;
    this.netLoans = netLoans;
    this.userId = userId;
    this.grossLoans = grossLoans;
    this.date = date;
  }

  @Override
  public String toString() {
    return String.format(
        "FinancialDataVO[id=%s, totalAssets='%s', netLoans='%s', user_id='%s', grossLoans='%s', date='%s']",
        id, totalAssets, netLoans, userId, grossLoans, date);
  }
//amke private
}