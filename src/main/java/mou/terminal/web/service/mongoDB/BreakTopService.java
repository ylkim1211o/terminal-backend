package mou.terminal.web.service.mongoDB;

import mou.terminal.web.domain.mongoDB.breakTop.BreakTop;
import mou.terminal.web.repository.mongoDB.breakTop.BreakTopKRXrepo;
import mou.terminal.web.repository.mongoDB.breakTop.BreakTopNASDAQrepo;
import mou.terminal.web.repository.mongoDB.breakTop.BreakTopNYSErepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class BreakTopService {

    @Autowired
    BreakTopKRXrepo breakTopKRXrepo;
    @Autowired
    BreakTopNASDAQrepo breakTopNASDAQrepo;
    @Autowired
    BreakTopNYSErepo breakTopNYSErepo;

    public List<BreakTop> breakTopBoxing(String type, int status, Date statusDate){

        if(type.equals("krx")){
            return breakTopKRXrepo.findBytypeAndStatusDate(status,statusDate);
        }
        else if(type.equals("nasdaq")){
            return breakTopNASDAQrepo.findBytypeAndStatusDate(status,statusDate);
        }
        else if(type.equals("nyse")){
            return breakTopNYSErepo.findBytypeAndStatusDate(status,statusDate);
        }

        return null;
    }

}
