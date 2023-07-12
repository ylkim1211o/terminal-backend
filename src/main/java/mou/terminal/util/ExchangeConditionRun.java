package mou.terminal.util;

import java.util.concurrent.Callable;

public class ExchangeConditionRun {

    public static Object exchangeCondition(String type, Callable krx, Callable nasdaq, Callable nyse) {

        try {
            if(type.equals("krx")) return krx.call();
            else if(type.equals("nasdaq")) return nasdaq.call();
            else if(type.equals("nyse")) return  nyse.call();

        }catch(Exception e){
            e.printStackTrace();
        }

        return null;

    }

}
