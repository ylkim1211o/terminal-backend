package mou.terminal.web.domain.mongoDB.stockInfo;

import lombok.Getter;
import lombok.Setter;
import mou.terminal.web.domain.mongoDB.SuperCondition;

import java.util.List;

@Getter
@Setter
public class StockInfo extends SuperCondition {

    private String symbol;
    private List<DailyInfo> dailyInfo;

}
