package Clinica;

import javax.swing.*;
import java.awt.*;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Detalles {

    ImageIcon fondoLb1 = new ImageIcon("Icons/Login.png");
    JLabel fondo = new JLabel(fondoLb1);
    ImageIcon fondoLb2 = new ImageIcon("Icons/Img.png");
    JLabel fondo2 = new JLabel(fondoLb2);
    ImageIcon perfil;
    Date fecha = new Date();

    ImageIcon Pam = new ImageIcon("Icons/RecPam.png");
    ImageIcon Jean = new ImageIcon("Icons/RecJean.png");
    ImageIcon Connie = new ImageIcon("Icons/RecConnie.png");
    ImageIcon Sasha = new ImageIcon("Icons/RecSasha.png");
    ImageIcon Levi = new ImageIcon("Icons/DocLevi.png");
    ImageIcon Hanjie = new ImageIcon("Icons/DocHanjie.png");
    ImageIcon Mikasa = new ImageIcon("Icons/DocMikasa.png");
    ImageIcon Eren = new ImageIcon("Icons/DocErencio.png");
    ImageIcon Armin = new ImageIcon("Icons/DocArmando.png");

    JLabel lbPam = new JLabel(Pam);
    JLabel lbJean = new JLabel(Jean);
    JLabel lbConnie = new JLabel(Connie);
    JLabel lbSasha = new JLabel(Sasha);
    JLabel lbLevi = new JLabel(Levi);
    JLabel lbHan = new JLabel(Hanjie);
    JLabel lbMik = new JLabel(Mikasa);
    JLabel lbEren = new JLabel(Eren);
    JLabel lbArmin = new JLabel(Armin);


    public void setColorR(JPanel panelC){
        for(Object Colors: panelC.getComponents()){
            if(Colors instanceof JButton){
                ((JButton) Colors).setBackground(new Color(192,0,0));
                ((JButton) Colors).setForeground(Color.WHITE);
                ((JButton) Colors).setBorderPainted(false);
            }
            if(Colors instanceof JComboBox){
                ((JComboBox) Colors).setBackground(new Color(192,0,0));
                ((JComboBox) Colors).setForeground(Color.WHITE);
            }

        }
    }

    public void setMode(int modo, JPanel pnlmo){
        if(modo == 1){
            pnlmo.setBackground(Color.WHITE);
            for(Object mod: pnlmo.getComponents()){
                if(mod instanceof JLabel){
                    ((JLabel) mod).setForeground(null);
                }
            }
        }
        else if(modo == 2){
            pnlmo.setBackground(new Color(43,43,43));
            for(Object mod: pnlmo.getComponents()){
                if(mod instanceof JLabel){
                    ((JLabel) mod).setForeground(Color.WHITE);
                }
            }
        }
    }
    public void setColorPane(JPanel panelPrin, JPanel pnlSec){
        for(Object ColorP: panelPrin.getComponents()) {
            if (ColorP instanceof JPanel) {
                pnlSec.setBackground(new Color(192, 0, 0));
            }
        }
    }

    public void setColorPanePlane(JPanel pnlUni, int color){
        if (color == 1){
            pnlUni.setBackground(Color.WHITE);
        }
        if (color == 2){
            pnlUni.setBackground(Color.RED);
        }
        if (color == 3){
            pnlUni.setBackground(Color.BLUE);
        }
        if (color == 4){
            pnlUni.setBackground(Color.ORANGE);
        }
        if (color == 5){
            pnlUni.setBackground(Color.GREEN);
        }
        if (color == 6){
            pnlUni.setBackground(Color.lightGray);
            for(Object mod: pnlUni.getComponents()){
                if(mod instanceof JLabel){
                    ((JLabel) mod).setForeground(null);
                }
            }
        }
        if (color == 7){
            pnlUni.setBackground(Color.CYAN);
        }
        if (color == 8){
            pnlUni.setBackground(Color.BLACK);
        }
        if (color == 9){
            pnlUni.setBackground(Color.MAGENTA);
        }
        if (color == 10){
            pnlUni.setBackground(Color.DARK_GRAY);
            for(Object mod: pnlUni.getComponents()){
                if(mod instanceof JLabel){
                    ((JLabel) mod).setForeground(Color.WHITE);
                }
            }
        }

    }

    public void setFont(JPanel panelF, int tam) {
        for (Object Letra : panelF.getComponents()) {
            if (Letra instanceof JButton) {
                ((JButton) Letra).setFont(new Font("Arial", Font.PLAIN, tam));
            }
        }
    }
    //Metodo para reiniciar los componentes
    public void vaciar(JPanel pnl){
        //Este ciclo for ayuda a que se vacien los campos y volver a iniciar sesión
        for(Object o: pnl.getComponents()){
            if(o instanceof  JTextField  ){
                ((JTextField) o).setText("");
            }
            if(o instanceof JRadioButton){
                ((JRadioButton) o).setSelected(false);
            }
            if(o instanceof JComboBox){
                ((JComboBox) o).setSelectedIndex(0);
            }
            if(o instanceof JCheckBox){
                ((JCheckBox) o).setSelected(false);
            }
            if(o instanceof JPasswordField){
                ((JPasswordField) o).setText("");
            }
        }
    }

    public void fondoLogAf(JPanel pnlad){
        fondo.setBounds(0,-19,200,500);
        pnlad.add(fondo);

    }
    public void fondoLogAf2(JPanel pnlad){
        fondo2.setBounds(115,45,70,70);
        pnlad.add(fondo2);

    }
    //public void setPerfilPicture(JPanel PNL, JLabel lbPerfil, ImageIcon foto,boolean P, boolean J, boolean C, boolean S,boolean E, boolean M, boolean A, boolean L, boolean H, boolean D){

        public void setPerfilPicture(JPanel PNL, JLabel lbPerfil,boolean P, boolean J, boolean C, boolean S,boolean L, boolean H, boolean M, boolean E, boolean A, boolean D){
        lbPam.setVisible(false);
        lbJean.setVisible(false);
        lbConnie.setVisible(false);
        lbSasha.setVisible(false);
        lbLevi.setVisible(false);
        lbHan.setVisible(false);
        lbMik.setVisible(false);
        lbEren.setVisible(false);
        lbArmin.setVisible(false);

        if(P == true){

            lbPam.setBounds(120,50,60,60);

            PNL.add(lbPam);
            lbPam.setVisible(true);
        }else if(J == true){

            lbJean.setBounds(120,50,60,60);

            PNL.add(lbJean);
            lbJean.setVisible(true);
        }else if(C == true){

            lbConnie.setBounds(120,50,60,60);

            PNL.add(lbConnie);
            lbConnie.setVisible(true);
        }else if(S == true){

            lbSasha.setBounds(120,50,60,60);

            PNL.add(lbSasha);
            lbSasha.setVisible(true);
        }else if(L == true){
            lbLevi.setBounds(120,50,60,60);

            PNL.add(lbLevi);
            lbLevi.setVisible(true);
        }else if(H == true){
            lbHan.setBounds(120,50,60,60);

            PNL.add(lbHan);
            lbHan.setVisible(true);
        }else if(M == true){
            lbMik.setBounds(120,50,60,60);

            PNL.add(lbMik);
            lbMik.setVisible(true);
        }else if(E == true){
            lbEren.setBounds(120,50,60,60);

            PNL.add(lbEren);
            lbEren.setVisible(true);
        }else if(A == true){
            lbArmin.setBounds(120,50,60,60);

            PNL.add(lbArmin);
            lbArmin.setVisible(true);

        }else if(D == true){
            lbSasha.setBounds(120,50,60,60);

            PNL.add(lbSasha);
            lbSasha.setVisible(true);
        }

        //P = false; J = false; C = false; S = false; E = false; M = false; A = false; L = false; H = false; D = false;

    }

    public int Fecha(JPanel hra){

        Calendar cal = Calendar.getInstance();

        JLabel LbDia = new JLabel();

        String sDia, sMes, sAño;
        int dia = cal.get(Calendar.DAY_OF_MONTH);
        int mes = cal.get(Calendar.MONTH);
        int año = cal.get(Calendar.YEAR);

        mes = mes + 1;

        sDia = Integer.toString(dia);
        sMes = Integer.toString(mes);
        sAño = Integer.toString(año);

        LbDia.setText("Fecha: "+sDia+" / "+sMes+" / "+sAño);

        LbDia.setBounds(400,10,200,40);

        LbDia.setForeground(Color.WHITE);
        LbDia.setFont(new Font("Arial",Font.BOLD,18));

        hra.add(LbDia);

        return año;
    }
}
