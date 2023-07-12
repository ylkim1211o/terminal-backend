package mou.terminal.web.domain.mongoDB.breakTop;

import lombok.Getter;
import lombok.Setter;
import mou.terminal.web.domain.mongoDB.SuperCondition;

import java.text.SimpleDateFormat;
import java.util.Date;

@Getter
@Setter
public class BreakTop extends SuperCondition {

    private String symbol;
    private int type;
    private Date statusDate;
    private Date regDate;

    public String getType(){
        return type == 0 ? "종가" : "고가";
    }

    public String getStatusDate() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return simpleDateFormat.format(statusDate);
    }

    public String getRegDate(){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return simpleDateFormat.format(regDate);
    }

}
