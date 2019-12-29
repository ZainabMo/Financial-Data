package com.ssci.financialdata.controller;

import java.util.List;

import com.ssci.financialdata.model.FinancialData;
import com.ssci.financialdata.model.FinancialDataVO;
import com.ssci.financialdata.service.FinancialDataService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FinancialDataController {
  
  private FinancialDataService financialDataService;

  public FinancialDataController(FinancialDataService financialDataService){
    this.financialDataService = financialDataService;
  }

  @RequestMapping("/financial-data/count")
  public long getUserSettingCount() {
    return financialDataService.getCount();
  }
  //find all
  @RequestMapping("/financial-data")
  public List<FinancialData> getFinancialData() {
    return financialDataService.findAll();
  }

  //find by date
  @RequestMapping(value = "/financial-data", params = "date")
  public List<FinancialData> getFinancialDataDate(@RequestParam(value="date") int date) {
    return financialDataService.findByDate(date);
  }
  
  //find by user id
  @RequestMapping(value = "/financial-data", params ="userId")
  public List<FinancialData> getFinancialDataUserId(@RequestParam(value="userId") String userId) {
    return financialDataService.findByUserId(userId);
  }

  //find by id
  @RequestMapping(value = "/financial-data/{id}", method = RequestMethod.GET)
  public FinancialData getFinancialDataId(@PathVariable String id) {
    return financialDataService.findById(id);
  }

  @PostMapping(value="/financial-data")
  public FinancialData addFinancialData(@RequestBody FinancialDataVO financialDataVO){
    return financialDataService.addFinancialData(financialDataVO);
  }
  
  @PutMapping(value="/financial-data/{id}")
  public FinancialData updateFinancialData(@PathVariable String id, @RequestBody FinancialDataVO financialDataVO){
    return financialDataService.updateFinancialData(id, financialDataVO);
  }
  
  @PatchMapping(value="/financial-data/{id}")
  public FinancialData updateSomeFinancialData(@PathVariable String id, @RequestBody FinancialDataVO financialDataVO){
    return financialDataService.updateFinancialData(id, financialDataVO);
  }

  //delete w id
  @DeleteMapping(value="/financial-data/{id}")
  public void deleteFinancialData(@PathVariable String id){
    financialDataService.deleteFinancialData(id);
  }
  
}