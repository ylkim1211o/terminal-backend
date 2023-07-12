package mou.terminal.web.repository.mongoDB.stockInfo;

import mou.terminal.web.domain.mongoDB.stockInfo.StockInfoKRX;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface StockInfoKRXrepo extends MongoRepository<StockInfoKRX,String> {

    @Query(value = "{'stockName' : ?0}", fields = "{'stockName' : 1 , 'dailyInfo' : { '$slice' : -300 }}")
    StockInfoKRX findBystockName(String stockName);

}
