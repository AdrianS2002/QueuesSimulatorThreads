package Business.Logic;

import Data.Models.Client;
import Data.Models.Queues;

import java.util.List;

public class ConcreteStrategyTime implements Strategy {
    @Override
    public void addClient(List<Queues> queues, Client c) {
        int minTime=Integer.MAX_VALUE;
        int idQ=-1;
        for(Queues q: queues)
        {
            int rez=q.getWaitingPeriod().get();
            if(rez<minTime)
            {
                minTime=rez;
                idQ=q.getIdQ();
            }
        }
        for(Queues q: queues)
        {
            if(q.getIdQ()==idQ)
            {
                q.addClient(c);
                q.setPermission(true);
            }
        }

    }
}
