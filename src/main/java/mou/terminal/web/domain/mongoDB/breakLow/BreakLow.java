package mou.terminal.web.domain.mongoDB.breakLow;

import lombok.Getter;
import lombok.Setter;
import mou.terminal.web.domain.mongoDB.SuperCondition;

import java.text.SimpleDateFormat;
import java.util.Date;

@Getter
@Setter
public class BreakLow extends SuperCondition {

    private String symbol;
    private Date statusDate;
    private Date regDate;

    public String getStatusDate() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return simpleDateFormat.format(statusDate);
    }

    public String getRegDate(){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return simpleDateFormat.format(regDate);
    }

}
