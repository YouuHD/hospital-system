package Clinica;

import javax.swing.*;
import java.awt.*;
import java.util.Calendar;

public class Ticket extends JFrame {

    final JLabel TituloT = new JLabel("Clinica 'Liberty'");
    final JLabel SubTitT = new JLabel("Ticket de Pago");
    final JLabel SuelBaseT = new JLabel("Precio base de consulta: 100 MXN");
    final JLabel DATOST = new JLabel("Datos ");
    JLabel raya = new JLabel("------------------------------------------------------------------------");
    JLabel rayas = new JLabel("_______________________________________________________________________");
    JLabel raya2 = new JLabel("------------------------------------------------------------------------");
    JLabel rayas2 = new JLabel("_______________________________________________________________________");
    JLabel Nomb = new JLabel("ID Compra: ");
    JLabel Horas = new JLabel("Precio total: ");
    ImageIcon tuer = new ImageIcon("Icons/Tick.png");
    JLabel LbT = new JLabel(tuer);
    JLabel LbID = new JLabel();
    JLabel LbPre = new JLabel();
    JLabel LbIDU = new JLabel();
    JLabel LbUser = new JLabel("ID Paciente");
    JLabel Salls = new JLabel("Medicamento");
    JLabel LbMed = new JLabel();
    JLabel LbRecom = new JLabel("Recomendaciones");
    JLabel LbRec = new JLabel();
    Calendar O = Calendar.getInstance();
    JPanel panel = new JPanel();


    public Ticket(){

        super("Ticket");
        setSize(300,500);
        //setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        System.out.printf("\nFecha: %te %tB %tY",O,O,O);

        panel.setLayout(null);

        TituloT.setFont(new Font("Arial",Font.BOLD,25));
        TituloT.setBounds(30,20,200,25);
        raya.setBounds(0,40,300,20);
        rayas.setBounds(0,50,300,20);
        SubTitT.setBounds(100,70,150,20);
        DATOST.setBounds(90,90,150,20);
        Nomb.setBounds(10,130,150,20);
        Horas.setBounds(10,160,150,20);
        raya2.setBounds(0,330,300,20);
        rayas2.setBounds(0,340,300,20);
        LbT.setBounds(95,350,100,100);
        LbID.setBounds(100,130,150,20);
        LbPre.setBounds(100,160,150,20);
        LbIDU.setBounds(100,190,150,20);
        LbUser.setBounds(10,190,150,20);
        //LbUser.setFont(new Font("Arial",Font.BOLD,8));
        Salls.setBounds(10,220,150,20);
        //Salls.setFont(new Font("Arial",Font.BOLD,8));
        LbMed.setBounds(10,250,300,20);
        //LbSalarioF.setFont(new Font("Arial",Font.BOLD,8));
        LbRecom.setBounds(10,280,150,20);
        LbRec.setBounds(10,300,300,20);

        panel.add(TituloT);
        panel.add(raya);
        panel.add(rayas);
        panel.add(raya2);
        panel.add(rayas2);
        panel.add(SubTitT);
        panel.add(SuelBaseT);
        panel.add(DATOST);
        panel.add(Nomb);
        panel.add(Horas);

        panel.add(LbT);
        panel.add(LbID);
        panel.add(LbPre);
        panel.add(LbIDU);
        panel.add(LbUser);
        panel.add(Salls);
        panel.add(LbMed);
        panel.add(LbRecom);
        panel.add(LbRec);

        setContentPane(panel);


        setVisible(true);
    }

    public void AddLbls(String ID, String Precio, String IDUser,String med, String recom){

        LbID.setText(ID);
        LbIDU.setText(IDUser);
        LbPre.setText(Precio);
        LbMed.setText(med);
        LbRec.setText(recom);


    }


    public static void main(String[] args) {
        Ticket objeto = new Ticket();
    }
}
