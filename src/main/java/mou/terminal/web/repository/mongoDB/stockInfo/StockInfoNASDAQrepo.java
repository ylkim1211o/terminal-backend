package mou.terminal.web.repository.mongoDB.stockInfo;

import mou.terminal.web.domain.mongoDB.stockInfo.StockInfo;
import mou.terminal.web.domain.mongoDB.stockInfo.StockInfoNASDAQ;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface StockInfoNASDAQrepo extends MongoRepository<StockInfoNASDAQ,String> {
    @Query(value = "{'symbol' : ?0}", fields = "{'symboml' : 1 , 'dailyInfo' : { '$slice' : -300 }}")
    StockInfo findBysymbol(String symbol);
}
