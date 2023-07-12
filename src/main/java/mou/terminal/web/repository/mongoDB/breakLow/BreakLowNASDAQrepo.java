package mou.terminal.web.repository.mongoDB.breakLow;

import mou.terminal.web.domain.mongoDB.breakLow.BreakLow;
import mou.terminal.web.domain.mongoDB.breakLow.BreakLowNASDAQ;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Date;
import java.util.List;

public interface BreakLowNASDAQrepo extends MongoRepository<BreakLowNASDAQ,String> {

    List<BreakLow> findBystatusDate(Date statusDate);
}
