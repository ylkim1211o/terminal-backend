package mou.terminal.web.controller.mysql;

import mou.terminal.util.response.AdapterResponseEntity;
import mou.terminal.web.service.mongoDB.PortfolioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ports")
public class PortPageMainController {

    private final PortfolioService portfolioService;

    PortPageMainController(PortfolioService portfolioService){
        this.portfolioService = portfolioService;
    }

    @RequestMapping(value = "/get")
    public ResponseEntity getPortfolioList(){
         return AdapterResponseEntity.success(portfolioService.findAllPortList());
    }

    @RequestMapping(value = "/delete")
    public ResponseEntity deletePortfolio(@RequestParam int id){
        return AdapterResponseEntity.success(portfolioService.deleteByPortId(id));
    }
}
