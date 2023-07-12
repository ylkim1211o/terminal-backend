package mou.terminal.web.domain.mongoDB.stockInfo;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Getter
@Setter
@Document(collection = "krxInfo")
public class StockInfoKRX {

    private String stockName;
    private List<DailyInfoKRX> dailyInfo;
}
