package mou.terminal.web.repository.mongoDB.volumeUp;

import mou.terminal.web.domain.mongoDB.volumeUp.VolumeUp;
import mou.terminal.web.domain.mongoDB.volumeUp.VolumeUpNASDAQ;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Date;
import java.util.List;

public interface VolumeUpNASDAQrepo extends MongoRepository<VolumeUpNASDAQ,String> {
    List<VolumeUp> findByregDate(Date regDate);
}
