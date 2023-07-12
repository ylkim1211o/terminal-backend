package mou.terminal.web.repository.mongoDB.breakTop;

import mou.terminal.web.domain.mongoDB.breakTop.BreakTop;
import mou.terminal.web.domain.mongoDB.breakTop.BreakTopNYSE;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Date;
import java.util.List;

public interface BreakTopNYSErepo extends MongoRepository<BreakTopNYSE,String> {
    List<BreakTop> findBytypeAndStatusDate(int type, Date statusDate);
}
