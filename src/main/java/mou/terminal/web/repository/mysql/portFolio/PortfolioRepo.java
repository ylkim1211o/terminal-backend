package mou.terminal.web.repository.mysql.portFolio;

import mou.terminal.web.domain.mysql.portFolio.Portfolio;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PortfolioRepo extends JpaRepository<Portfolio,Integer> {

    Portfolio findById(int id);

}
