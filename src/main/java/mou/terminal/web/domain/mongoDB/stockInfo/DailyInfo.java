package mou.terminal.web.domain.mongoDB.stockInfo;

import lombok.Getter;
import lombok.Setter;

import java.text.SimpleDateFormat;
import java.util.Date;

@Getter
@Setter
public class DailyInfo {

    private int open;
    private int close;
    private int high;
    private int low;
    private double vol;
    private Date stockDate;

    public String getStock_date() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return simpleDateFormat.format(stockDate);
    }
}


