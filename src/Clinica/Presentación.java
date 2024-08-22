package Clinica;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Presentación extends JFrame implements ActionListener {


    ImageIcon img = new ImageIcon("Icons/Presentación.png");
    JLabel label = new JLabel(img);
    JButton Cont = new JButton("Iniciar");
    JPanel PNL = new JPanel();

    public Presentación(){
        super("Clinica Liberty");
        setSize(845,510);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        PNL.setLayout(null);

        Cont.addActionListener(this);

        label.setBounds(-5,-17,845,510);
        Cont.setBounds(558,358,240,94);
        Cont.setBackground(new Color(192, 0, 0));
        Cont.setForeground(Color.WHITE);
        Cont.setBorderPainted(false);

        PNL.add(label);
        PNL.add(Cont);

        setContentPane(PNL);



        setVisible(true);
    }

    public static void main(String[] args) {
        Presentación ob = new Presentación();

    }
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        Object o = actionEvent.getSource();
        if(o instanceof JButton){
            if(o == Cont){
                StartClinic insST = new StartClinic();
                insST.show();
                dispose();
            }
        }
    }
}
