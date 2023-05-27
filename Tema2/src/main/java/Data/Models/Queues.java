package Data.Models;

import java.util.Collections;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class Queues implements Runnable {
    private BlockingQueue<Client> clients;
    private AtomicInteger waitingPeriod;
    private int idQ;
    private boolean permission=true;

    private AtomicInteger totalWaitingTime;
    private AtomicInteger totalServiceTime;

    private AtomicInteger waitingClients;
    private AtomicInteger processedClients;
    private int maxQueueSize=2000;
    public Queues(int idQ, int maxQueueSize)
    {
        this.idQ=idQ;
        this.maxQueueSize=maxQueueSize;
        this.clients=new ArrayBlockingQueue<Client>(maxQueueSize);
        this.waitingPeriod=new AtomicInteger(0);
        this.totalWaitingTime=new AtomicInteger(0);
        this.totalServiceTime=new AtomicInteger(0);
        this.waitingClients=new AtomicInteger(0);
        this.processedClients=new AtomicInteger(0);
    }

    public BlockingQueue<Client> getClients() {
        return clients;
    }
    public AtomicInteger getWaitingClients() {
        return waitingClients;
    }
    public AtomicInteger getProcessedClients() {
        return processedClients;
    }
    public AtomicInteger getTotalWaitingTime() {
        return totalWaitingTime;
    }
    public AtomicInteger getWaitingPeriod() {
        return waitingPeriod;
    }
    public int getIdQ() {
        return idQ;
    }

    public int getSize()
    {
        return clients.size();
    }

    public void addClient(Client c)
    {
        if(clients.size()!=maxQueueSize) {
            clients.add(c);
            waitingPeriod.getAndAdd(c.getServiceTime());

            processedClients.getAndIncrement();
            totalServiceTime.getAndAdd(c.getServiceTime());
            totalWaitingTime.getAndAdd(waitingPeriod.get());

        }
    }
    public Double getAverageWaitingTime()
    {
        return (double)totalWaitingTime.get()/processedClients.get();
    }
    public Double getAverageServiceTime()
    {
        return (double)totalServiceTime.get()/processedClients.get();
    }

    public void setPermission(boolean permission) {
        this.permission = permission;
    }
    @Override
    public void run() {
        while(permission==true)
        {
            while(true)
            {
              Client c=clients.peek();
              if(c!=null)
              {
                  if(c.getServiceTime()!=1){
                      c.setServiceTime(c.getServiceTime()-1);
                      waitingPeriod.getAndDecrement();
                  }
                  else
                  {
                      try {
                            clients.take();
                      } catch (InterruptedException e) {
                          throw new RuntimeException(e);
                      }

                  }
              }
                try {
                    Thread.sleep(1000L);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }

        }
    }

    @Override
    public String toString() {
        return "Queues{" +
                "idQ=" + idQ +
                " ,clients=" + clients +

                '}';
    }
}
