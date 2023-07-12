package mou.terminal.web.domain.mongoDB.stockInfo;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document(collection = "nyseInfo")
public class StockInfoNYSE extends StockInfo{

}
