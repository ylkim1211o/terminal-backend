package mou.terminal.web.repository.mongoDB.breakLow;

import mou.terminal.web.domain.mongoDB.breakLow.BreakLow;
import mou.terminal.web.domain.mongoDB.breakLow.BreakLowNYSE;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Date;
import java.util.List;

public interface BreakLowNYSErepo extends MongoRepository<BreakLowNYSE,String> {

    List<BreakLow> findBystatusDate(Date statusDate);
}
