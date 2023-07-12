package mou.terminal.web.repository.mongoDB.volumeUp;

import mou.terminal.web.domain.mongoDB.volumeUp.VolumeUp;
import mou.terminal.web.domain.mongoDB.volumeUp.VolumeUpKRX;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Date;
import java.util.List;

public interface VolumeUpKRXrepo extends MongoRepository<VolumeUpKRX,String> {
    List<VolumeUp> findByregDate(Date regDate);
}
