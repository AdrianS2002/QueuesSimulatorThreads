package Business.Logic;

import Data.Models.Client;
import Data.Models.Queues;
import Graphical.User.Interface.SecondPanel;

import java.io.*;
import java.security.PrivateKey;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SimulationManager implements Runnable{
    public int timeLimit;
    public int maxProcessingTime;
    public int minProcessingTime;
    SecondPanel secondPanel;
    public int maxArrivalTime;
    public int minArrivalTime;
    public int numberOfQueues;
    public int numberOfClients;
    public SelectionPolicy selectionPolicy = SelectionPolicy.SHORTEST_TIME;
    private Scheduler scheduler;
    private List<Client> generatedClients;


    public SimulationManager(SecondPanel secondPanel) {
        this.secondPanel = secondPanel;
        this.timeLimit = 40;
        this.maxProcessingTime = 10;
        this.minProcessingTime = 1;
        this.maxArrivalTime = 10;
        this.minArrivalTime = 1;
        this.numberOfQueues = 3;
        this.numberOfClients = 5;
        this.scheduler = new Scheduler(numberOfQueues, 100);
        scheduler.changeStrategy(selectionPolicy);
        generateNRandomTasks();
        System.out.println(generatedClients);
    }

    public SimulationManager(SecondPanel secondPanel,int timeLimit, int maxProcessingTime, int minProcessingTime, int maxArrivalTime, int minArrivalTime, int numberOfQueues, int numberOfClients, SelectionPolicy selectionPolicy) {

        this.secondPanel = secondPanel;
        this.timeLimit = timeLimit;
        this.maxProcessingTime = maxProcessingTime;
        this.minProcessingTime = minProcessingTime;
        this.maxArrivalTime = maxArrivalTime;
        this.minArrivalTime = minArrivalTime;
        this.numberOfQueues = numberOfQueues;
        this.numberOfClients = numberOfClients;
        this.scheduler = new Scheduler(numberOfQueues, 100);
        scheduler.changeStrategy(selectionPolicy);
        generateNRandomTasks();
        System.out.println(generatedClients);
    }

    private void generateNRandomTasks(){
        generatedClients=new ArrayList<>(numberOfClients);
        for(int i=0;i<numberOfClients;i++)
        {
            int ProcessingTime=(int)(Math.random()*(maxProcessingTime-minProcessingTime+1)+minProcessingTime);
            int arrivalTime=(int)(Math.random()*(maxArrivalTime-minArrivalTime+1)+minArrivalTime);
            generatedClients.add(new Client(i,arrivalTime,ProcessingTime));
        }
        Collections.sort(generatedClients);
    }

    @Override
    public void run() {
        int currentTime=0;
        int cZero=0;
        int peakHourClients=0;
        int peakHourTime=0;
        while (currentTime<timeLimit)
        {
            cZero=0;
            for(Client c:generatedClients)
            {
                if(c.getServiceTime()==0)
                    cZero++;
            }
            if(cZero==numberOfClients) {
                break;
            }

            //System.out.println(scheduler.getMaxClientsPerQueue());
            for(Client c:generatedClients)
            {
                if(c.getArrivalTime()<=currentTime)
                {
                    if(c.getFlag()==0)
                    {
                        c.setFlag(1);
                        scheduler.dispatchClient(c);

                    }
                }
            }

            System.out.println("Current time: "+currentTime);
            secondPanel.setText(secondPanel.getText() +"Current time:"+currentTime+"\n");


            System.out.println(scheduler.toString());
            secondPanel.setText(secondPanel.getText() +scheduler.toString()+"\n");

            System.out.println(generatedClients);
            secondPanel.setText(secondPanel.getText() +generatedClients+"\n");
            if(scheduler.getMaxClientsPerQueue()>peakHourClients){
                peakHourTime=currentTime;
                peakHourClients= scheduler.getMaxClientsPerQueue();
            }
            currentTime++;
            try {
                Thread.sleep(1000L);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        List<Queues> q=scheduler.getQ();
        for(Queues q1:q)
        {
            System.out.println(q1.getIdQ());
            secondPanel.setText(secondPanel.getText() +q1.getIdQ()+"\n");

            System.out.println(q1.getAverageWaitingTime());
            secondPanel.setText(secondPanel.getText() +q1.getAverageWaitingTime()+"\n");

            System.out.println(q1.getAverageServiceTime());
            secondPanel.setText(secondPanel.getText() +q1.getAverageServiceTime()+"\n");
        }
        System.out.println("Peakhour: "+peakHourTime+" with "+peakHourClients+" clients");
        secondPanel.setText(secondPanel.getText() +"Peakhour: "+peakHourTime+" with "+peakHourClients+" clients"+"\n");
    }


    public static void main(String[] args)
    {
        SimulationManager gen =new SimulationManager(new SecondPanel());
        Thread t=new Thread(gen);
        t.start();
    }

}
