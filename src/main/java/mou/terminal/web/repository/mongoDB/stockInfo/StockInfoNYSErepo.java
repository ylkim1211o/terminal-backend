package mou.terminal.web.repository.mongoDB.stockInfo;

import mou.terminal.web.domain.mongoDB.stockInfo.StockInfo;
import mou.terminal.web.domain.mongoDB.stockInfo.StockInfoNYSE;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface StockInfoNYSErepo extends MongoRepository<StockInfoNYSE,String> {
    @Query(value = "{'symbol' : ?0}", fields = "{'stockName' : 1 , 'dailyInfo' : { '$slice' : -300 }}")
    StockInfo findBysymbol(String symbol);
}
