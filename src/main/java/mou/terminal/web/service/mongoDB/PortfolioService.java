package mou.terminal.web.service.mongoDB;

import lombok.extern.slf4j.Slf4j;
import mou.terminal.web.domain.mysql.portFolio.Portfolio;
import mou.terminal.web.domain.mysql.portFolio.PortfolioChangeRecord;
import mou.terminal.web.domain.mysql.portFolio.PortfolioContent;
import mou.terminal.web.repository.mysql.portFolio.PortfolioChangeRecordRepo;
import mou.terminal.web.repository.mysql.portFolio.PortfolioContentRepo;
import mou.terminal.web.repository.mysql.portFolio.PortfolioRepo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Slf4j
@Service
@Transactional
public class PortfolioService {

    private final PortfolioRepo portfolioRepo;
    private final PortfolioContentRepo portfolioContentRepo;
    private final PortfolioChangeRecordRepo portfolioChangeRecordRepo;

    PortfolioService(PortfolioRepo portfolioRepo, PortfolioContentRepo portfolioContentRepo, PortfolioChangeRecordRepo portfolioChangeRecordRepo){
        this.portfolioRepo = portfolioRepo;
        this.portfolioContentRepo = portfolioContentRepo;
        this.portfolioChangeRecordRepo = portfolioChangeRecordRepo;
    }

    public List<Portfolio> findAllPortList(){

        log.debug("FindAllPortList Running...");

        return this.portfolioRepo.findAll();
    }

    public int deleteByPortId(int id){

        PortfolioContent portfolioContent = this.portfolioContentRepo.findByPortfolio_Id(id);

        this.backupRecord(portfolioContent);

        this.portfolioRepo.deleteById(id);

        return 1;
    }

    public PortfolioContent findPort(int id){
        return this.portfolioContentRepo.findByPortfolio_Id(id);
    }

    public int addPort(Portfolio portfolio,String content, String ref) {

        this.portfolioRepo.save(portfolio);

        PortfolioContent portfolioContent = PortfolioContent.builder()
                .content(content)
                .portfolio(portfolio)
                .ref(ref).build();

        this.portfolioContentRepo.save(portfolioContent);

        return 1;
    }

    public int updatePort(PortfolioContent response) {

       this.backupRecord(response);

        this.portfolioContentRepo.save(response);

        return 1;
    }

    public void backupRecord(PortfolioContent portfolioContent) {

        this.portfolioChangeRecordRepo.save(PortfolioChangeRecord.builder()
                .title(portfolioContent.getPortfolio().getTitle())
                .type(portfolioContent.getPortfolio().getType())
                .content(portfolioContent.getContent())
                .ref(portfolioContent.getRef())
                .regDate(LocalDate.now()).build());

    }
}
