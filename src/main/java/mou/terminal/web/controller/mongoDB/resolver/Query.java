package mou.terminal.web.controller.mongoDB.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import mou.terminal.web.domain.mongoDB.boxing.Boxing;
import mou.terminal.web.domain.mongoDB.breakLow.BreakLow;
import mou.terminal.web.domain.mongoDB.breakTop.BreakTop;
import mou.terminal.web.domain.mongoDB.stockInfo.StockInfo;
import mou.terminal.web.domain.mongoDB.stockInfo.StockInfoKRX;
import mou.terminal.web.domain.mongoDB.volumeUp.VolumeUp;
import mou.terminal.util.StringToUTCDate;
import mou.terminal.web.service.mongoDB.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Query implements GraphQLQueryResolver {

    @Autowired
    BoxingService boxingService;
    @Autowired
    BreakLowService breakLowService;
    @Autowired
    BreakTopService breakTopService;
    @Autowired
    VolumeUpService volumeUpService;
    @Autowired
    StockInfoService stockInfoService;

    public List<VolumeUp> getVolumeUp(String type, String regDate) {

        return volumeUpService.volumeUpFindAll(type, StringToUTCDate.get(regDate));
    }

    public List<Boxing> getBoxingStatus(String type, int status, String statusDate, String regDate) {

        return boxingService.boxingStatusFindAllbyDate(type, status, StringToUTCDate.get(statusDate), StringToUTCDate.get(regDate));
    }

    public List<Boxing> getBoxingBoxStatus(String type, int boxing, int status, String regDate) {

        return boxingService.boxingBoxStatusFindAllbyDate(type, boxing, status, StringToUTCDate.get(regDate));

    }

    public List<BreakTop> getBreakBoxingTop(String type, int status, String statusDate) {

        return breakTopService.breakTopBoxing(type, status, StringToUTCDate.get(statusDate));
    }

    public List<BreakLow> getBreakBoxingLow(String type, String statusDate) {

        return breakLowService.breakLowBoxing(type,StringToUTCDate.get(statusDate));
    }

    public StockInfo getDailyInfo(String type, String symbol) {
        return stockInfoService.getDailyInfo(type,symbol);
    }

    public StockInfoKRX getDailyInfoKRX(String stockName) {
        return stockInfoService.getDailyInfoKRX(stockName);
    }

}

