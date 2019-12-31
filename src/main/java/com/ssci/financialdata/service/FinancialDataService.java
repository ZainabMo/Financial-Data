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
    //change all so id is not printed
    public List<FinancialData> findAll(){
        List<FinancialData> all = repository.findAll();
        return FinancialData.hideId(all);
    }
    public List<FinancialData> findByDate(int date){
        List<FinancialData> all = repository.findByDate(date);
        return FinancialData.hideId(all);
    }
    public List<FinancialData> findByUserId(String uId){
        List<FinancialData> all = repository.findByUserId(uId);
        return FinancialData.hideId(all);
    }
    public FinancialData findById(String id){
        FinancialData result = repository.findById(id).get();
        return FinancialData.hideId(result);
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