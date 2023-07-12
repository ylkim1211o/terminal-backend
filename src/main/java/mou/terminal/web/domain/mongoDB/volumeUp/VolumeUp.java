package mou.terminal.web.domain.mongoDB.volumeUp;

import lombok.Getter;
import lombok.Setter;
import mou.terminal.web.domain.mongoDB.SuperCondition;

import java.text.SimpleDateFormat;
import java.util.Date;

@Getter
@Setter
public class VolumeUp extends SuperCondition {

    private String symbol;
    private int times;
    private Date regDate;

    public String getRegDate(){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return simpleDateFormat.format(regDate);
    }

}
