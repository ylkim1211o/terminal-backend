package mou.terminal.web.repository.mysql.portFolio;


import mou.terminal.web.domain.mysql.portFolio.PortfolioContent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PortfolioContentRepo extends JpaRepository<PortfolioContent,String> {


    @Query("select p from PortfolioContent p join fetch p.portfolio")
    List<PortfolioContent> findAllContent();

    PortfolioContent findByPortfolio_Id(int id);

//    @Query(value = "select * from portfolioContent where portFolioId = ?1",nativeQuery = true)
//    PortfolioContent findByPortFolioId(int id);

}
