package mou.terminal.web.service.mongoDB;

import mou.terminal.web.domain.mongoDB.volumeUp.VolumeUp;
import mou.terminal.web.repository.mongoDB.volumeUp.VolumeUpKRXrepo;
import mou.terminal.web.repository.mongoDB.volumeUp.VolumeUpNASDAQrepo;
import mou.terminal.web.repository.mongoDB.volumeUp.VolumeUpNYSErepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class VolumeUpService {

    @Autowired
    VolumeUpKRXrepo volumeUpKRXrepo;
    @Autowired
    VolumeUpNASDAQrepo volumeUpNASDAQrepo;
    @Autowired
    VolumeUpNYSErepo volumeUpNYSErepo;

    public List<VolumeUp> volumeUpFindAll(String type, Date regDate) {

        if(type.equals("krx")){
            return volumeUpKRXrepo.findByregDate(regDate);
        }
        else if(type.equals("nasdaq")){
            return volumeUpNASDAQrepo.findByregDate(regDate);
        }
        else if(type.equals("nyse")){
            return volumeUpNYSErepo.findByregDate(regDate);
        }

        return null;
    }

}
