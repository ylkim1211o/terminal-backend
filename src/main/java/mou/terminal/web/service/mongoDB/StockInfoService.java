package mou.terminal.web.service.mongoDB;

import mou.terminal.web.domain.mongoDB.stockInfo.StockInfo;
import mou.terminal.web.domain.mongoDB.stockInfo.StockInfoKRX;
import mou.terminal.web.repository.mongoDB.stockInfo.StockInfoKRXrepo;
import mou.terminal.web.repository.mongoDB.stockInfo.StockInfoNASDAQrepo;
import mou.terminal.web.repository.mongoDB.stockInfo.StockInfoNYSErepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StockInfoService {

    @Autowired
    StockInfoKRXrepo stockInfoRepository;
    @Autowired
    StockInfoNASDAQrepo stockInfoNASDAQrepo;
    @Autowired
    StockInfoNYSErepo stockInfoNYSErepo;

    public StockInfoKRX getDailyInfoKRX(String stockName){
        return stockInfoRepository.findBystockName(stockName);
    }

    public StockInfo getDailyInfo(String type, String symbol){

        if(type.equals("nasdaq")){
            return stockInfoNASDAQrepo.findBysymbol(symbol);
        }
        else if(type.equals("nyse")){
            return stockInfoNYSErepo.findBysymbol(symbol);
        }

        return null;

    }
}
