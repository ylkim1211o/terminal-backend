package mou.terminal.web.controller.mysql;

import mou.terminal.util.response.AdapterResponseEntity;
import mou.terminal.web.domain.mysql.portFolio.Portfolio;
import mou.terminal.web.domain.mysql.portFolio.PortfolioContent;
import mou.terminal.web.service.mongoDB.PortfolioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/port")
public class PortPageContentController {

    private final PortfolioService portfolioService;

    PortPageContentController(PortfolioService portfolioService){
        this.portfolioService = portfolioService;
    }

    @RequestMapping(value = "/get")
    public ResponseEntity getPortfolio(int id){
        return AdapterResponseEntity.success(portfolioService.findPort(id));
    }

    @RequestMapping(value = "/update")
    public ResponseEntity updatePortfolio(@RequestBody PortfolioContent portfolioContent){
        return AdapterResponseEntity.success(portfolioService.updatePort(portfolioContent));
    }

    @RequestMapping(value = "/add")
    public ResponseEntity addPortfolio(@RequestParam Portfolio portfolio,@RequestParam String content,@RequestParam String ref){
        return AdapterResponseEntity.success(portfolioService.addPort(portfolio,content,ref));
    }


}
