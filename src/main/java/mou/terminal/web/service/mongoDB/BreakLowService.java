package mou.terminal.web.service.mongoDB;

import mou.terminal.web.domain.mongoDB.breakLow.BreakLow;
import mou.terminal.web.repository.mongoDB.breakLow.BreakLowKRXrepo;
import mou.terminal.web.repository.mongoDB.breakLow.BreakLowNASDAQrepo;
import mou.terminal.web.repository.mongoDB.breakLow.BreakLowNYSErepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class BreakLowService {

    @Autowired
    BreakLowKRXrepo breakLowKRXrepo;
    @Autowired
    BreakLowNASDAQrepo breakLowNASDAQrepo;
    @Autowired
    BreakLowNYSErepo breakLowNYSErepo;

    public List<BreakLow> breakLowBoxing(String type, Date regDate){

        if(type.equals("krx")){
            return breakLowKRXrepo.findBystatusDate(regDate);
        }
        else if(type.equals("nasdaq")){
            return breakLowNASDAQrepo.findBystatusDate(regDate);
        }
        else if(type.equals("nyse")){
            return breakLowNYSErepo.findBystatusDate(regDate);
        }

        return null;
    }

}

