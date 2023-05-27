package Business.Logic;

import Data.Models.Client;
import Data.Models.Queues;

import java.util.List;
import java.util.Queue;

public interface Strategy {
    public void addClient(List<Queues>queues, Client c);
}

