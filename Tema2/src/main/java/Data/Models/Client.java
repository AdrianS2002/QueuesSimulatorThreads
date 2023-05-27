package Data.Models;

public class Client implements Comparable<Client> {
    private Integer id;
    private Integer flag=0;
    private Integer arrivalTime;
    private Integer serviceTime;

    private Integer finishTime;

    public Client(Integer id, Integer arrivalTime, Integer serviceTime)
    {
        this.id=id;
        this.arrivalTime=arrivalTime;
        this.serviceTime=serviceTime;
        this.flag=0;
    }

    public Integer getId() {
        return id;
    }

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }

    public Integer getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(Integer arrivalTime) {
        this.arrivalTime = arrivalTime;  }

    public Integer getServiceTime() {
        return serviceTime;
    }

    @Override
    public int compareTo(Client o) {
        return this.getArrivalTime().compareTo(o.getArrivalTime());
    }

     public void setServiceTime(Integer serviceTime) {
        this.serviceTime = serviceTime;
    }


    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", arrivalTime=" + arrivalTime +
                ", serviceTime=" + serviceTime +
                '}';
    }
}
