package Graphical.User.Interface;
import Business.Logic.SelectionPolicy;
import Business.Logic.SimulationManager;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static Business.Logic.SelectionPolicy.SHORTEST_QUEUE;
import static Business.Logic.SelectionPolicy.SHORTEST_TIME;

public class FirstPanel extends JFrame {
    private JTextField txtNumberOfClients = new JTextField();
    private JTextField txtNumberOfQueues = new JTextField();
    private JTextField txtSimulationTime = new JTextField();
    private JTextField txtMinArrivalTime = new JTextField();
    private JTextField txtMaxArrivalTime = new JTextField();
    private JTextField txtMinServiceTime = new JTextField();
    private JTextField txtMaxServiceTime = new JTextField();

    private JComboBox cmbSelectionPolicy = new JComboBox(new String[]{"Shortest queue", "Shortest time"});
    private JButton btnProcess = new JButton("Process");
    private JLabel lblNume = new JLabel("Queue Initializer");
    private JLabel lblNumberOfClients = new JLabel("Number of clients:");
    private JLabel lblNumberOfQueues = new JLabel("Number of queues:");
    private JLabel lblSimulationTime = new JLabel("Simulation time:");
    private JLabel lblMinArrivalTime = new JLabel("Minimum arrival time:");
    private JLabel lblMaxArrivalTime = new JLabel("Maximum arrival time:");
    private JLabel lblMinServiceTime = new JLabel("Minimum service time:");
    private JLabel lblMaxServiceTime = new JLabel("Maximum service time:");
    private JLabel lblSelectionPolicy = new JLabel("Selection policy:");


    public FirstPanel() throws HeadlessException {
        this.setTitle("Queue Simulator - Initializer");
        JPanel panel = new JPanel();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(800, 800);
        panel.setBackground(Color.decode("#FF5858"));

        btnProcess.setBackground(Color.decode("#AE81BD"));
        btnProcess.setForeground(Color.decode("#2e0c60"));
        btnProcess.setFont(new Font("Arial", Font.BOLD, 18));
        btnProcess.setBounds(300, 640, 130, 50);
        panel.setLayout(null);
        panel.add(btnProcess);

        btnProcess.addActionListener(new ActionListener() {
            @Override

            public void actionPerformed(ActionEvent e) {
                SecondPanel frame = new SecondPanel();
                SimulationManager gen =new SimulationManager(frame,Integer.parseInt(txtSimulationTime.getText()),Integer.parseInt(txtMaxServiceTime.getText()),Integer.parseInt(txtMinServiceTime.getText()),Integer.parseInt(txtMaxArrivalTime.getText()),Integer.parseInt(txtMinArrivalTime.getText()),Integer.parseInt(txtNumberOfQueues.getText()),Integer.parseInt(txtNumberOfClients.getText()),getSelectionPolicy());
                Thread t=new Thread(gen);
                t.start();

                frame.setResizable(false);
                frame.setVisible(true);
            }
        });

        lblNume.setForeground(Color.decode("#2e0c60"));
        lblNume.setFont(new Font("Arial", Font.BOLD, 30));
        lblNume.setBounds(250, 15, 500, 50);
        panel.setLayout(null);
        panel.add(lblNume);

        lblNumberOfClients.setForeground(Color.decode("#2e0c60"));
        lblNumberOfClients.setFont(new Font("Arial", Font.BOLD, 18));
        lblNumberOfClients.setBounds(240, 80, 170, 50);
        panel.setLayout(null);
        panel.add(lblNumberOfClients);


        lblNumberOfQueues.setForeground(Color.decode("#2e0c60"));
        lblNumberOfQueues.setFont(new Font("Arial", Font.BOLD, 18));
        lblNumberOfQueues.setBounds(240, 150, 170, 50);
        panel.setLayout(null);
        panel.add(lblNumberOfQueues);

        lblSimulationTime.setForeground(Color.decode("#2e0c60"));
        lblSimulationTime.setFont(new Font("Arial", Font.BOLD, 18));
        lblSimulationTime.setBounds(240, 220, 170, 50);
        panel.setLayout(null);
        panel.add(lblSimulationTime);

        lblMinArrivalTime.setForeground(Color.decode("#2e0c60"));
        lblMinArrivalTime.setFont(new Font("Arial", Font.BOLD, 18));
        lblMinArrivalTime.setBounds(240, 290, 210, 50);
        panel.setLayout(null);
        panel.add(lblMinArrivalTime);

        lblMaxArrivalTime.setForeground(Color.decode("#2e0c60"));
        lblMaxArrivalTime.setFont(new Font("Arial", Font.BOLD, 18));
        lblMaxArrivalTime.setBounds(240, 360, 210, 50);
        panel.setLayout(null);
        panel.add(lblMaxArrivalTime);

        lblMinServiceTime.setForeground(Color.decode("#2e0c60"));
        lblMinServiceTime.setFont(new Font("Arial", Font.BOLD, 18));
        lblMinServiceTime.setBounds(240, 430, 210, 50);
        panel.setLayout(null);
        panel.add(lblMinServiceTime);

        lblMaxServiceTime.setForeground(Color.decode("#2e0c60"));
        lblMaxServiceTime.setFont(new Font("Arial", Font.BOLD, 18));
        lblMaxServiceTime.setBounds(240, 500, 210, 50);
        panel.setLayout(null);
        panel.add(lblMaxServiceTime);

        lblSelectionPolicy.setForeground(Color.decode("#2e0c60"));
        lblSelectionPolicy.setFont(new Font("Arial", Font.BOLD, 18));
        lblSelectionPolicy.setBounds(240, 570, 170, 50);
        panel.setLayout(null);
        panel.add(lblSelectionPolicy);

        txtNumberOfClients.setForeground(Color.decode("#2e0c60"));
        txtNumberOfClients.setBackground(Color.decode("#f5e6fb"));
        txtNumberOfClients.setFont(new Font("Arial", Font.BOLD, 18));
        txtNumberOfClients.setBounds(470, 80, 50, 35);
        panel.setLayout(null);
        panel.add(txtNumberOfClients);

        txtNumberOfQueues.setForeground(Color.decode("#2e0c60"));
        txtNumberOfQueues.setBackground(Color.decode("#f5e6fb"));
        txtNumberOfQueues.setFont(new Font("Arial", Font.BOLD, 18));
        txtNumberOfQueues.setBounds(470, 150, 50, 35);
        panel.setLayout(null);
        panel.add(txtNumberOfQueues);

        txtSimulationTime.setForeground(Color.decode("#2e0c60"));
        txtSimulationTime.setBackground(Color.decode("#f5e6fb"));
        txtSimulationTime.setFont(new Font("Arial", Font.BOLD, 18));
        txtSimulationTime.setBounds(470, 220, 50, 35);
        panel.add(txtSimulationTime);

        txtMinArrivalTime.setForeground(Color.decode("#2e0c60"));
        txtMinArrivalTime.setBackground(Color.decode("#f5e6fb"));
        txtMinArrivalTime.setFont(new Font("Arial", Font.BOLD, 18));
        txtMinArrivalTime.setBounds(470, 290, 50, 35);
        panel.add(txtMinArrivalTime);

        txtMaxArrivalTime.setForeground(Color.decode("#2e0c60"));
        txtMaxArrivalTime.setBackground(Color.decode("#f5e6fb"));
        txtMaxArrivalTime.setFont(new Font("Arial", Font.BOLD, 18));
        txtMaxArrivalTime.setBounds(470, 360, 50, 35);
        panel.add(txtMaxArrivalTime);

        txtMinServiceTime.setForeground(Color.decode("#2e0c60"));
        txtMinServiceTime.setBackground(Color.decode("#f5e6fb"));
        txtMinServiceTime.setFont(new Font("Arial", Font.BOLD, 18));
        txtMinServiceTime.setBounds(470, 430, 50, 35);
        panel.add(txtMinServiceTime);

        txtMaxServiceTime.setForeground(Color.decode("#2e0c60"));
        txtMaxServiceTime.setBackground(Color.decode("#f5e6fb"));
        txtMaxServiceTime.setFont(new Font("Arial", Font.BOLD, 18));
        txtMaxServiceTime.setBounds(470, 500, 50, 35);
        panel.add(txtMaxServiceTime);

        cmbSelectionPolicy.setForeground(Color.decode("#2e0c60"));
        cmbSelectionPolicy.setBackground(Color.decode("#f5e6fb"));
        cmbSelectionPolicy.setFont(new Font("Arial", Font.BOLD, 18));
        cmbSelectionPolicy.setBounds(470, 570, 170, 35);
        panel.add(cmbSelectionPolicy);

        this.setContentPane(panel);
    }

    public String getNumberOfClients()
    {
        return txtNumberOfClients.getText();
    }

    public String getNumberOfQueues()
    {
        return txtNumberOfQueues.getText();
    }

    public String getSimulationTime()
    {
        return txtSimulationTime.getText();
    }

    public String getMinArrivalTime()
    {
        return txtMinArrivalTime.getText();
    }

    public String getMaxArrivalTime()
    {
        return txtMaxArrivalTime.getText();
    }

    public String getMinServiceTime()
    {
        return txtMinServiceTime.getText();
    }

    public String getMaxServiceTime()
    {
        return txtMaxServiceTime.getText();
    }

    public SelectionPolicy getSelectionPolicy()
    {
        if(cmbSelectionPolicy.getSelectedIndex()==0)
            return SHORTEST_QUEUE;
        return SHORTEST_TIME;
    }

    public  static void main(String[] args)
    {

       FirstPanel frame = new FirstPanel();
        frame.setResizable(false);
        frame.setVisible(true);
    }

}