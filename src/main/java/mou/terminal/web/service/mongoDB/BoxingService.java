package mou.terminal.web.service.mongoDB;

import mou.terminal.web.domain.mongoDB.boxing.Boxing;
import mou.terminal.web.repository.mongoDB.boxing.BoxingKRXrepo;
import mou.terminal.web.repository.mongoDB.boxing.BoxingNASDAQrepo;
import mou.terminal.web.repository.mongoDB.boxing.BoxingNYSErepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class BoxingService {

    @Autowired
    BoxingKRXrepo boxingKRXrepo;
    @Autowired
    BoxingNASDAQrepo boxingNASDAQrepo;
    @Autowired
    BoxingNYSErepo boxingNYSErepo;

    public List<Boxing> boxingStatusFindAllbyDate(String type, int status, Date statusDate, Date regDate){

        if(type.equals("krx")){
            return boxingKRXrepo.findByStatusAndStatusDateAndRegDateGreaterThanEqual(status, statusDate, regDate);
        }
        else if(type.equals("nasdaq")){
            return boxingNASDAQrepo.findByStatusAndStatusDateAndRegDateGreaterThanEqual(status, statusDate, regDate);
        }
        else if(type.equals("nyse")){
            return boxingNYSErepo.findByStatusAndStatusDateAndRegDateGreaterThanEqual(status, statusDate, regDate);
        }

        return null;
    }

    public List<Boxing> boxingBoxStatusFindAllbyDate(String type,int boxing, int status, Date regDate){

        if(type.equals("krx")){
            return boxingKRXrepo.findByBoxingLessThanEqualAndStatusAndRegDateGreaterThanEqual(boxing, status, regDate);
        }
        else if(type.equals("nasdaq")){
            return boxingNASDAQrepo.findByBoxingLessThanEqualAndStatusAndRegDateGreaterThanEqual(boxing, status,  regDate);
        }
        else if(type.equals("nyse")){
            return boxingNYSErepo.findByBoxingLessThanEqualAndStatusAndRegDateGreaterThanEqual(boxing, status,regDate);
        }

        return null;
    }

    public List<Boxing> boxingBoxFindAllbyDate(String type, int boxing, Date regDate) {

        if (type.equals("krx")) {
            return boxingKRXrepo.findByBoxingAndRegDateGreaterThanEqual(boxing, regDate);
        }
        else if (type.equals("nasdaq")) {
            return boxingNASDAQrepo.findByBoxingAndRegDateGreaterThanEqual(boxing, regDate);
        }
        else if (type.equals("nyse")) {
            return boxingNYSErepo.findByBoxingAndRegDateGreaterThanEqual(boxing, regDate);
        }

        return null;
    }
}