package mou.terminal.web.repository.mongoDB.breakLow;

import mou.terminal.web.domain.mongoDB.breakLow.BreakLow;
import mou.terminal.web.domain.mongoDB.breakLow.BreakLowKRX;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Date;
import java.util.List;

public interface BreakLowKRXrepo extends MongoRepository<BreakLowKRX,String> {

    List<BreakLow> findBystatusDate(Date statusDate);
}
