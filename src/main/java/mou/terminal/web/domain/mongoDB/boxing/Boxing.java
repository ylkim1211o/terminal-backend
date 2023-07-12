package mou.terminal.web.domain.mongoDB.boxing;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mou.terminal.web.domain.mongoDB.SuperCondition;
import org.springframework.format.annotation.DateTimeFormat;

import java.text.SimpleDateFormat;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class Boxing extends SuperCondition {

    private String symbol;
    private int status;
    private int boxing;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private Date statusDate;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
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
