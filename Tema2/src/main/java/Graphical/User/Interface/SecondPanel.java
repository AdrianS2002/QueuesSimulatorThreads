package Graphical.User.Interface;
import javax.swing.*;
import java.awt.*;

public class SecondPanel extends JFrame {
    private JLabel lblResult = new JLabel("Result");
    private JTextArea txtResult = new JTextArea();
    private JScrollPane scrollPane = new JScrollPane(txtResult);

    public SecondPanel() throws HeadlessException
    {
        super();
        this.setTitle("Queue Simulator - Result");
        JPanel panel = new JPanel();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1200, 800);
        panel.setBackground(Color.decode("#FF5858"));

        lblResult.setForeground(Color.decode("#2e0c60"));
        lblResult.setFont(new Font("Arial", Font.BOLD, 30));
        lblResult.setBounds(580, 15, 500, 50);
        panel.setLayout(null);
        panel.add(lblResult);

        scrollPane.setBounds(20, 65, 1140, 665);
        txtResult.setForeground(Color.decode("#2e0c60"));
        txtResult.setBackground(Color.decode("#f5e6fb"));
        txtResult.setFont(new Font("Arial", Font.PLAIN, 15));
        panel.add(scrollPane);

        this.setContentPane(panel);
    }
    public void setText(String text){
        txtResult.setText(text);
    }
    public String getText(){
        return txtResult.getText();
    }

    public static void main(String[] args) {
        SecondPanel frame = new SecondPanel();
        frame.setResizable(false);
        frame.setVisible(true);
    }
}
