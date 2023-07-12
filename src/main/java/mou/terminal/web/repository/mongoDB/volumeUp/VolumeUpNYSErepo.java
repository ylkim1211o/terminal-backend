package mou.terminal.web.repository.mongoDB.volumeUp;

import mou.terminal.web.domain.mongoDB.volumeUp.VolumeUp;
import mou.terminal.web.domain.mongoDB.volumeUp.VolumeUpNYSE;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Date;
import java.util.List;

public interface VolumeUpNYSErepo extends MongoRepository<VolumeUpNYSE,String> {
    List<VolumeUp> findByregDate(Date regDate);
}
