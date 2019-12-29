package com.ssci.financialdata.service;

import java.util.List;

import com.ssci.financialdata.model.FinancialData;
import com.ssci.financialdata.model.FinancialDataVO;
import com.ssci.financialdata.repository.FinancialDataRepository;

import org.springframework.stereotype.Service;

@Service
public class FinancialDataService{

    private FinancialDataRepository repository;
    public FinancialDataService (FinancialDataRepository repository){
        this.repository = repository;
    }
    public long getCount(){
        return repository.count();
    }
    public List<FinancialData> findAll(){
        return repository.findAll();
    }
    public List<FinancialData> findByDate(int date){
        return repository.findByDate(date);
    }
    public List<FinancialData> findByUserId(String uId){
        return repository.findByUserId(uId);
    }
    public FinancialData findById(String id){
        return repository.findById(id).get();
    }
    public FinancialData addFinancialData(FinancialDataVO financialDataVO){
        FinancialData financialData = new FinancialData();
        convertFinancialData(financialDataVO, financialData);
        return repository.save(financialData);
    }
    public FinancialData updateFinancialData(String id, FinancialDataVO financialDataVO){  
        FinancialData financialData = findById(id);
        convertFinancialData(financialDataVO, financialData);
        return repository.save(financialData);
    }
    public void deleteFinancialData(String id){
        FinancialData financialData = findById(id);
        repository.delete(financialData);
    }
    private void convertFinancialData(FinancialDataVO financialDataVO, FinancialData financialData){
        if(financialDataVO.getDate() != null){
            financialData.setDate(Integer.parseInt(financialDataVO.getDate()));
        }
        if(financialDataVO.getNetLoans() != null){
            financialData.setNetLoans(Integer.parseInt(financialDataVO.getNetLoans()));
        }
        if(financialDataVO.getGrossLoans() != null){
            financialData.setGrossLoans(Integer.parseInt(financialDataVO.getGrossLoans()));
        }
        if(financialDataVO.getTotalAssets() != null){
            financialData.setTotalAssets(Integer.parseInt(financialDataVO.getTotalAssets()));
        }
        if(financialDataVO.getUserId() != null){
            financialData.setUserId(financialDataVO.getUserId());
        }
    }
}