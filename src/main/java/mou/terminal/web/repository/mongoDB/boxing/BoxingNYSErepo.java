package mou.terminal.web.repository.mongoDB.boxing;

import mou.terminal.web.domain.mongoDB.boxing.Boxing;
import mou.terminal.web.domain.mongoDB.boxing.BoxingNYSE;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Date;
import java.util.List;

public interface BoxingNYSErepo extends MongoRepository<BoxingNYSE,String> {

    List<Boxing> findByStatusAndStatusDateAndRegDateGreaterThanEqual(int status, Date statusDate , Date regDate);
    List<Boxing> findByBoxingLessThanEqualAndStatusAndRegDateGreaterThanEqual(int boxing, int status, Date regDate);
    List<Boxing> findByBoxingAndRegDateGreaterThanEqual(int boxing, Date regDate);

}
