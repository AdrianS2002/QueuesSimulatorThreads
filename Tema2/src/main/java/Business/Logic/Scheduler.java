package Business.Logic;

import Data.Models.Client;
import Data.Models.Queues;

import java.util.ArrayList;
import java.util.List;

public class Scheduler {

    private List<Queues> q;
    private ArrayList<Thread> threads;
    private int maxNoQueues=0;
    private int maxClientsPerQueue=0;
    private Strategy strategy;

    public Scheduler(int maxNoQueues, int maxClientsPerQueue)
    {
        this.maxNoQueues = maxNoQueues;
        this.maxClientsPerQueue = maxClientsPerQueue;
        this.q=new ArrayList<Queues>(maxNoQueues);
        this.threads=new ArrayList<Thread>(maxNoQueues);
        for(int i=0;i<maxNoQueues;i++)
        {
            q.add(new Queues(i,maxNoQueues));
            threads.add(new Thread(q.get(i)));
            threads.get(i).start();
        }
    }

    public int getMaxClientsPerQueue() {
        int maxC=0;
      for(Queues q: this.q)
      {
          maxC+=q.getSize();
      }
        return maxC;
    }


    public void changeStrategy(SelectionPolicy p)
    {
        if(p==SelectionPolicy.SHORTEST_QUEUE)
        {
            strategy=new ConcreteSrategyQueue();
        }
        if(p==SelectionPolicy.SHORTEST_TIME)
        {
            strategy=new ConcreteStrategyTime();
        }
    }
    public void dispatchClient(Client c)
    {

        strategy.addClient(q,c);
    }

    public List<Queues> getQ()
    {
        return q;
    }

    @Override
    public String toString() {
        String s="";
        for(Queues q: this.q)
        {
            s+=q.toString();
            s+="\n";
        }
        return s;
    }
}
