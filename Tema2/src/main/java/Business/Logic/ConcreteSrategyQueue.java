package Business.Logic;

import Data.Models.Client;
import Data.Models.Queues;

import java.util.List;

public class ConcreteSrategyQueue implements Strategy{

    @Override
    public void addClient(List<Queues> queues, Client c) {
        int minQueue=Integer.MAX_VALUE;
        int idQ=-1;
        for(Queues q: queues)
        {
            int rez=q.getSize();
            if(rez<minQueue)
            {
                minQueue=rez;
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
