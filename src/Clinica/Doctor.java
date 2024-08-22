package Clinica;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Doctor extends JFrame implements ActionListener {

    JPanel panelD = new JPanel();
    JPanel pnlSupD = new JPanel();
    JPanel pnlizqD = new JPanel();
    Detalles detD = new Detalles();
    String sDOC;
    int val = 0;
    //Variables que guardan los valores en archivos

    String sRApPat, sRApMat, sRNom, sRAño, sRAler, sRDir, sRPes, sREst, sRTel, sRCurp, sRDia,
            sRMes, sREnf, sREnf1, sREnf2,sREnf3,sREnf4, sREnf5,sREnf6,sREnf7,sREnf8, sRInter;
    String sMedic, sRecom;
    //Modo oscuro/claro
    int modo;

    JMenuBar BarraModo = new JMenuBar();
    JMenu Mode = new JMenu("Modo");
    JMenuItem Claro = new JMenuItem("Claro");
    JMenuItem Oscuro = new JMenuItem("Oscuro");
    int AÑOD;

    String ID;
    String Medico;

    //Componentes de Inicio sesión
    JButton BtIniciarSD = new JButton("Iniciar Sesión");
    JButton BtRegresarD = new JButton("Regresar");
    JTextField TxtUserD = new JTextField();
    JPasswordField TxtContraD = new JPasswordField();
    JLabel LbUserD = new JLabel("Usuario");
    JLabel LbUserD2 = new JLabel("Usuario");
    JLabel LbContraD = new JLabel("Contraseña");
    JLabel LbInicioD = new JLabel("Inicio de Sesión");
    JButton CerrSesD = new JButton("Cerrar sesión");
    JLabel ImgPer;

    //Parametros de inicio de sesión
    final String User1D = "Levi"; final String User2D = "Hanjie"; final String User3D = "Mikasa"; final String User4D = "Eren", User5D = "Armin";
    final String ContraD1 = "Ackerman"; final String ContraD2 = "Titan"; final String ContraD3 = "Dependencia"; final String ContraD4 = "Genocida"; final String ContraD5 = "Mar";

    String nom, Cont; boolean L,H,M,Er,A;
    JLabel SesIniD = new JLabel();
    JPanel pnlIniD = new JPanel();
    ImageIcon logo = new ImageIcon("Icons/LOGO.png");
    JLabel imgD = new JLabel(logo);
    JButton BtDispo = new JButton("Disponibilidad");
    JButton BtConsultas = new JButton("Consultas");
    JButton BtVideoConf = new JButton("Video Conferencia");
    JButton BtPagoRec = new JButton("Receta y Ficha de Pago");
    int Bot = 0;
    JLabel Doctor = new JLabel();

    //Disponibilidad
    JPanel pnlDisp = new JPanel();

    JLabel LBRDisp = new JLabel("Disponibilidad");
    JLabel RtitIntro = new JLabel("Selecciona una Opción");

    JButton BtDisponible = new JButton("Disponible");
    JButton BtAusente = new JButton("Ausente");
    JButton BtenConsulta = new JButton("En Consulta");
    JButton BtenEmergencia = new JButton("En emergencia");
    JButton BtRegresar = new JButton("Regresar");

    //Consultas
    JPanel pnlDConsulta = new JPanel();

    JLabel LbDConsulta = new JLabel("Consultas");
    DefaultTableModel dtmCita = new DefaultTableModel();
    JTable TblaConsulta = new JTable(dtmCita);
    JScrollPane scrollC = new JScrollPane(TblaConsulta);

    JButton CDCanc = new JButton("Regresar");

    //VideoConferencia
    JPanel pnlDConf = new JPanel();

    JLabel LbDConf = new JLabel("Video Conferencia");
    JLabel LbDSelecciona = new JLabel("Selecciona al Receptor");
    JLabel LbDCRazon = new JLabel("Razón de la Conferencia");

    String [] VideoConf = {"Selecciona","Doctor General","Oftanmólogo","Nutriologo","Cardiologo","Pediatra"};
    JComboBox VC = new JComboBox(VideoConf);
    int cam, mic;

    JButton BtDoConf = new JButton("Iniciar Conferencia");
    JButton BtCamara = new JButton();
    JButton BtMicro = new JButton();
    JButton BtCRCancelar = new JButton("Regresar");

    JPanel pnlCamara = new JPanel();



    JTextField TxtWhy = new JTextField();

    String [] sRCDoc = {"Selecciona","Doctor General","Oftanmólogo","Nutriologo","Cardiologo","Pediatra"};
    JComboBox ComboRCita = new JComboBox(sRCDoc);

    JTable RTablaCita = new JTable();

    ImageIcon cama = new ImageIcon("Icons/Camara.png");
    ImageIcon microf = new ImageIcon("Icons/Microfono.png");

    JLabel esperando = new JLabel("Activando la Cámara...");
    JLabel micro = new JLabel(microf);

    //FICHA Y RECETA

    JPanel pnlFR = new JPanel();

    ImageIcon lineas = new ImageIcon("Icons/Lineas.png");


    JLabel LbFR = new JLabel("Ficha de Pago");
    JLabel LbIdPac = new JLabel("ID Paciente");
    JLabel lBrAZ = new JLabel("Añadir Servicio");
    JLabel lbFRCost = new JLabel("Costo Cita $100 MXN");
    JLabel LbFRTotal = new JLabel("Total: $ ");
    JLabel LbVMXN = new JLabel("MXN");
    JLabel LbFRDin = new JLabel("Costo");
    int Cita = 100;
    JLabel LbRFañadirP = new JLabel("Añadir Precio");
    JLabel LbVCant = new JLabel(lineas);
    JLabel LbfrIDPago = new JLabel("ID Pago:");
    JLabel LbSetPago = new JLabel("0");
    JLabel LbFRTot = new JLabel("100");
    JLabel LbReceta = new JLabel("RECETA");
    JLabel LbFrMed = new JLabel("Medicamento");
    JLabel LbReco = new JLabel("Recomendaciones");

    JTextArea TXTMed = new JTextArea();
    JTextArea TXTRec = new JTextArea();

    JTextField txtRazon = new JTextField();
    JTextField txtID = new JTextField();
    JTextField txtCosto = new JTextField();

    JButton BtCost = new JButton("Añadir al Costo");
    JButton BtReg = new JButton("Regresar");
    JButton BtFin = new JButton("Finalizar");




    JTable VentTabla = new JTable();

    public Doctor(){
        //Creación de la ventana
        super("Doctor");
        //Asignación de tamaño
        setSize(600,600);
        //Asignación de que se cierre el programa al presionar el botón de cerrar
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //Asignación de la localización de la ventana, que esté en el centro
        setLocationRelativeTo(null);
        //Hacer que la ventana no cambie de tamaño
        setResizable(false);

        //INICIO DE SESION
        BtIniciarSD.addActionListener(this);
        BtRegresarD.addActionListener(this);
        CerrSesD.addActionListener(this);

        //ACCIONES DE USUARIO
        BtDispo.addActionListener(this);
        BtConsultas.addActionListener(this);
        BtVideoConf.addActionListener(this);
        BtPagoRec.addActionListener(this);

        //Disponibilidad
        BtDisponible.addActionListener(this);
        BtAusente.addActionListener(this);
        BtenEmergencia.addActionListener(this);
        BtenConsulta.addActionListener(this);
        BtRegresar.addActionListener(this);

        //CONSULTAR
        CDCanc.addActionListener(this);

        //Conferencia
        BtDoConf.addActionListener(this);
        BtCamara.addActionListener(this);
        BtMicro.addActionListener(this);
        BtCRCancelar.addActionListener(this);

        //ficha y receta
        BtCost.addActionListener(this);
        BtReg.addActionListener(this);
        BtFin.addActionListener(this);

        //Modo
        Claro.addActionListener(this);
        Oscuro.addActionListener(this);

        addPanels();

        detD.setColorR(pnlDConsulta);


        //Titulo de columnas
        dtmCita.addColumn("ID");
        dtmCita.addColumn("Doctor");
        dtmCita.addColumn("Dia");
        dtmCita.addColumn("Mes");
        dtmCita.addColumn("Hora");
        dtmCita.addColumn("Razon");

        scrollC.setBounds(20,60,403,300);
        CDCanc.setBounds(340,380,100,30);

        pnlDConsulta.add(scrollC);

        pnlDConsulta.setVisible(false);
        scrollC.setVisible(false);

        BarraModo.setBounds(522,60,42,20);
        BarraModo.setBorderPainted(false);
        AÑOD = detD.Fecha(pnlSupD);

        Mode.add(Claro);
        Mode.addSeparator();
        Mode.add(Oscuro);
        BarraModo.add(Mode);
        pnlSupD.add(BarraModo);


        InicioSesR();

        detD.setColorR(pnlizqD);
        detD.setColorPane(panelD,pnlSupD);
        //detR.setMode(modo,pnlIniR);
        //detR.setMode(modo,pnlizq);

        setContentPane(panelD);
        setVisible(true);
    }



    public void FichaRec(){
        pnlFR.setLayout(null);
        imgD.setVisible(false);

        detD.setColorR(pnlFR);

        pnlFR.setBounds(220,120,443,421);
        LbFR.setBounds(200,20,150,30);


        LbIdPac.setBounds(20,75,150,20);
        LbfrIDPago.setBounds(300,75,150,20);
        LbSetPago.setBounds(300,100,150,20);
        LbFRTot.setBounds(350,125,150,20);
        lbFRCost.setBounds(20,100,150,20);
        LbVCant.setBounds(-28,128,500,100);
        txtID.setBounds(150,75,80,20);
        txtCosto.setBounds(150,150,80,20);
        LbFRDin.setBounds(20,150,120,20);
        lBrAZ.setBounds(20,125,120,20);
        txtRazon.setBounds(150,125,80,20);
        BtCost.setBounds(20,180,120,20);
        BtReg.setBounds(20,380,100,30);
        LbFRTotal.setBounds(300,125,100,20);
        LbVMXN.setBounds(400,125,100,20);
        BtFin.setBounds(327,380,100,30);
        LbReceta.setBounds(200,210,100,20);
        LbFrMed.setBounds(20,225,100,20);
        LbReco.setBounds(240,225,100,20);
        TXTMed.setBounds(20,250,200,100);
        TXTRec.setBounds(240,250,183,100);

        JScrollPane scMed = new JScrollPane(TXTMed);
        JScrollPane scRec = new JScrollPane(TXTMed);
        scMed.setBounds(20,250,200,100);
        scRec.setBounds(240,250,183,100);
        TXTMed.setLineWrap(true);
        TXTRec.setLineWrap(true);

        pnlFR.add(LbFR);
        pnlFR.add(LbIdPac);
        pnlFR.add(lbFRCost);
        pnlFR.add(LbVCant);
        pnlFR.add(txtID);
        pnlFR.add(txtRazon);
        pnlFR.add(BtCost);
        pnlFR.add(BtReg);
        pnlFR.add(LbFRTotal);
        pnlFR.add(LbVMXN);
        pnlFR.add(BtFin);
        pnlFR.add(LbFRTot);
        pnlFR.add(lBrAZ);
        pnlFR.add(LbfrIDPago);
        pnlFR.add(LbSetPago);
        pnlFR.add(LbFRDin);
        pnlFR.add(txtCosto);
        pnlFR.add(TXTMed);
        pnlFR.add(TXTRec);
        pnlFR.add(LbReceta);
        pnlFR.add(LbReco);
        pnlFR.add(LbFrMed);
        pnlFR.add(scMed);
        pnlFR.add(scRec);

        panelD.add(pnlFR);

    }

    public void MostComponentes(int Bot){
        if(Bot == 1) {
            for (Object o : pnlDisp.getComponents()) {
                if (o instanceof JTextField) {
                    ((JTextField) o).setVisible(true);
                }
                if (o instanceof JButton) {
                    ((JButton) o).setVisible(true);
                }
                if (o instanceof JLabel) {
                    ((JLabel) o).setVisible(true);
                }
                for(Object Opaque: pnlDisp.getComponents()){
                    if(Opaque instanceof JRadioButton){
                        ((JRadioButton) Opaque).setOpaque(false);
                    }
                    if(Opaque instanceof JCheckBox){
                        ((JCheckBox) Opaque).setOpaque(false);
                    }
                }
                //NuevoR.setVisible(false);
                if (o instanceof JMenu) {
                    ((JMenu) o).setVisible(true);
                }
                if (o instanceof JMenuItem) {
                    ((JMenuItem) o).setVisible(true);
                }
                if (o instanceof JComboBox) {
                    ((JComboBox) o).setVisible(true);
                }
            }
            pnlDisp.setVisible(true);
        }if(Bot == 2) {
            for (Object o : pnlDConsulta.getComponents()) {
                if (o instanceof JTextField) {
                    ((JTextField) o).setVisible(true);
                }
                if (o instanceof JButton) {
                    ((JButton) o).setVisible(true);
                }
                if (o instanceof JLabel) {
                    ((JLabel) o).setVisible(true);
                }
                if (o instanceof JMenuItem) {
                    ((JMenuItem) o).setVisible(true);
                }
                if (o instanceof JTable) {
                    ((JTable) o).setVisible(true);
                }if (o instanceof JScrollPane) {
                    ((JScrollPane) o).setVisible(true);
                }
            }
            pnlDConsulta.setVisible(true);
        }if(Bot == 3) {
            for (Object o : pnlDConf.getComponents()) {
                if (o instanceof JTextField) {
                    ((JTextField) o).setVisible(true);
                }
                if (o instanceof JButton) {
                    ((JButton) o).setVisible(true);
                }
                if (o instanceof JLabel) {
                    ((JLabel) o).setVisible(true);
                }
                if (o instanceof JTable) {
                    ((JTable) o).setVisible(true);
                }
            }
            pnlDConf.setVisible(true);
        }if(Bot == 4) {
            for (Object o : pnlFR.getComponents()) {
                if (o instanceof JTextField) {
                    ((JTextField) o).setVisible(true);
                }
                if (o instanceof JButton) {
                    ((JButton) o).setVisible(true);
                }
                if (o instanceof JLabel) {
                    ((JLabel) o).setVisible(true);
                }
                if (o instanceof JTable) {
                    ((JTable) o).setVisible(true);
                }
            }
            pnlFR.setVisible(true);
        }

        imgD.setVisible(false);

    }

    public void EliComponentes(int Bot){
        if(Bot == 1) {
            for (Object o : pnlDisp.getComponents()) {
                if (o instanceof JTextField) {
                    ((JTextField) o).setVisible(false);
                }
                if (o instanceof JButton) {
                    ((JButton) o).setVisible(false);
                }
                if (o instanceof JLabel) {
                    ((JLabel) o).setVisible(false);
                }

                //NuevoR.setVisible(false);
                if (o instanceof JMenu) {
                    ((JMenu) o).setVisible(false);
                }
                if (o instanceof JMenuItem) {
                    ((JMenuItem) o).setVisible(false);
                }
                if (o instanceof JComboBox) {
                    ((JComboBox) o).setVisible(false);
                }
            }
            pnlDisp.setVisible(false);
        }if(Bot == 2) {
            for (Object o : pnlDConsulta.getComponents()) {
                if (o instanceof JTextField) {
                    ((JTextField) o).setVisible(false);
                }
                if (o instanceof JButton) {
                    ((JButton) o).setVisible(false);
                }
                if (o instanceof JLabel) {
                    ((JLabel) o).setVisible(false);
                }
                if (o instanceof JMenuItem) {
                    ((JMenuItem) o).setVisible(false);
                }
                if (o instanceof JComboBox) {
                    ((JComboBox) o).setVisible(false);
                }
            }
            pnlDConsulta.setVisible(false);
        }if(Bot == 3) {
            for (Object o : pnlDConf.getComponents()) {
                if (o instanceof JTextField) {
                    ((JTextField) o).setVisible(false);
                }
                if (o instanceof JButton) {
                    ((JButton) o).setVisible(false);
                }
                if (o instanceof JLabel) {
                    ((JLabel) o).setVisible(false);
                }
                if (o instanceof JTable) {
                    ((JTable) o).setVisible(false);
                }if (o instanceof JScrollPane) {
                    ((JScrollPane) o).setVisible(false);
                }
            }
            pnlDConf.setVisible(false);
        }if(Bot == 4) {
            for (Object o : pnlFR.getComponents()) {
                if (o instanceof JTextField) {
                    ((JTextField) o).setVisible(false);
                }
                if (o instanceof JButton) {
                    ((JButton) o).setVisible(false);
                }
                if (o instanceof JLabel) {
                    ((JLabel) o).setVisible(false);
                }
                if (o instanceof JTable) {
                    ((JTable) o).setVisible(false);
                }
            }
            pnlFR.setVisible(false);
        }
        imgD.setVisible(true);

    }


    public void Disponibilidad(){

        pnlDisp.setLayout(null);
        detD.setColorPanePlane(pnlDisp,6);
        detD.setColorR(pnlDisp);

        pnlDisp.setBounds(220,120,443,421);
        LBRDisp.setBounds(200,20,150,30);


        BtDisponible.setBounds(30,100,150,40);
        BtAusente.setBounds(30,150,150,40);
        BtenConsulta.setBounds(30,200,150,40);
        BtenEmergencia.setBounds(30,250,150,40);
        BtRegresar.setBounds(30,330,150,40);

        pnlDisp.add(LBRDisp);
        pnlDisp.add(BtDisponible);
        pnlDisp.add(BtAusente);
        pnlDisp.add(BtenConsulta);
        pnlDisp.add(BtenEmergencia);
        pnlDisp.add(BtRegresar);

        panelD.add(pnlDisp);

        imgD.setVisible(false);

    }

    public void DConferencia() {
        cam = 1;
        mic = 1;

        pnlDConf.setLayout(null);

        detD.setColorR(pnlDConf);

        pnlDConf.setBounds(220,120,443,421);
        LbDConf.setBounds(200,20,150,30);
        LbDSelecciona.setBounds(20,100,150,20);
        LbDCRazon.setBounds(20,130,150,20);
        VC.setBounds(200,100,110,20);
        TxtWhy.setBounds(200,130,110,20);
        BtDoConf.setBounds(20,370,150,30);
        BtCRCancelar.setBounds(204,370,150,30);
        pnlCamara.setBounds(20,180,288,160);
        BtCamara.setBounds(324,220,30,30);
        BtMicro.setBounds(324,260,30,30);
        pnlCamara.setBackground(Color.cyan);

        pnlCamara.add(micro);
        pnlCamara.add(esperando);

        pnlDConf.add(LbDConf);
        pnlDConf.add(LbDSelecciona);
        pnlDConf.add(LbDCRazon);
        pnlDConf.add(VC);
        pnlDConf.add(BtDoConf);
        pnlDConf.add(BtCRCancelar);
        pnlDConf.add(TxtWhy);
        pnlDConf.add(ComboRCita);
        pnlDConf.add(pnlCamara);
        pnlDConf.add(BtCamara);
        pnlDConf.add(BtMicro);

        BtCamara.setBorderPainted(false);
        BtMicro.setBorderPainted(false);

        BtCamara.setIcon(cama);
        BtMicro.setIcon(microf);

        micro.setVisible(true);
        pnlCamara.setVisible(true);

        panelD.add(pnlDConf);

    }
    public void leerTexto(String direccion){
        String cadena, fila[];

        try {
            FileReader lector = new FileReader(direccion);
            BufferedReader lectura = new BufferedReader(lector);
            cadena = lectura.readLine();

            while (cadena != null){
                fila = cadena.split("/");
                dtmCita.addRow(fila);
                cadena = lectura.readLine();
            }
        }catch (FileNotFoundException ex){
            System.err.println("Error: "+ex);
        }catch (IOException ex){
            System.err.println("Error: "+ex);
        }
    }

    public void DConsultas(String Medico){

        pnlDConsulta.setVisible(true);
        pnlDConsulta.setLayout(null);



        leerTexto(Medico + "RegistrosCitas.txt");
        pnlDConsulta.setBounds(220,120,443,421);
        LbDConsulta.setBounds(200,20,150,30);
        TblaConsulta.setBounds(20,60,403,300);

        scrollC.setVisible(true);

        pnlDConsulta.add(LbDConsulta);
        //pnlDConsulta.add(scrollC);
        pnlDConsulta.add(CDCanc);

        panelD.add(pnlDConsulta);

    }

    public void InicioSesR(){

        detD.fondoLogAf(pnlizqD);
        pnlizqD.setLayout(null);

        LbInicioD.setBounds(50,20,150,20);
        LbUserD.setBounds(20,50,150,20);
        LbContraD.setBounds(20,100,150,20);
        TxtUserD.setBounds(20,70,160,20);
        TxtContraD.setBounds(20,120,160,20);
        BtIniciarSD.setBounds(20,165,160,30);
        BtRegresarD.setBounds(20,400,160,30);

        imgD.setBounds(220,100,350,350);
        panelD.add(imgD);

        pnlizqD.add(LbInicioD);
        pnlizqD.add(LbUserD);
        pnlizqD.add(LbContraD);
        pnlizqD.add(TxtUserD);
        pnlizqD.add(TxtContraD);
        pnlizqD.add(BtIniciarSD);
        pnlizqD.add(BtRegresarD);
        //CAMBIAR DE LADOO
        detD.setColorPanePlane(pnlDisp,6);
        detD.setColorPanePlane(pnlDConsulta,6);
        detD.setColorPanePlane(pnlDConf,6);
        detD.setColorPanePlane(pnlFR,6);
    }

    public void addPanels(){
        panelD.setLayout(null);

        pnlSupD.setLayout(null);
        pnlSupD.setBounds(0,0,900,100);


        pnlizqD.setBounds(0,100,200,500);

        panelD.add(pnlSupD);
        panelD.add(pnlizqD);

    }

    //METODO DE VALIDACIÓN DE USUARIO
    public void iniciar(String NombreUser, String Cont){
        //Validar que usuario exista
        if(NombreUser.equals(User1D) || NombreUser.equals(User2D) || NombreUser.equals(User3D) || NombreUser.equals(User4D) || NombreUser.equals(User5D) ) {         //Comparar el texto obtenido con el usuario
            //Condición para saber que usuario es
            if (NombreUser.equals(User1D)) {                                //Asignarle true al usuario que es para posteriormente usarlo
                L = true; H = false; M = false; Er = false; A = false;
            }else if (NombreUser.equals(User2D)) {
                L = false; H = true; M = false; Er = false; A = false;
            } else if (NombreUser.equals(User3D)) {
                L = false; H = false; M = true; Er = false; A = false;
            } else if (NombreUser.equals(User4D)) {
                L = false; H = false; M = false; Er = true; A = false;
            }else if (NombreUser.equals(User5D)) {
                L = false; H = false; M = false; Er = false; A = true;
            }



            //Validar que la contraseña exista
            if(Cont.equals(ContraD1) || Cont.equals(ContraD2) ||Cont.equals(ContraD3) ||Cont.equals(ContraD4) || Cont.equals(ContraD5) ) {
                //Comparar las contraseñas con las variables de tipo booleano para iniciar
                if (Cont.equals(ContraD1) && L == true && H == false && M == false && Er == false && A == false) {
                    JOptionPane.showMessageDialog(null, "Bienvenido " + NombreUser + "");
                    Doctor.setText("Doctor General");
                    sDOC = "Doctor General";
                    VideoConf = new String[]{"Selecciona", "Oftanmologo", "Nutriologo", "Cardiologo", "Pediatra", "Administrador"};
                    AfterLogD(NombreUser);          //Mandar a llamar al método cuando la sesión esté iniciada

                } else if (Cont.equals(ContraD2) && L == false && H == true && M == false && Er == false && A == false) {
                    JOptionPane.showMessageDialog(null, "Bienvenido " + NombreUser + "");
                    Doctor.setText("Doctor: Oftanmologo");
                    sDOC = "Oftanmologo";
                    VideoConf = new String[]{"Doctor General", "Nutriologo", "Cardiologo", "Pediatra", "Administrador"};
                    AfterLogD(NombreUser);

                } else if (Cont.equals(ContraD3) && L == false && H == false && M == true && Er == false && A == false) {
                    JOptionPane.showMessageDialog(null, "Bienvenido " + NombreUser + "");
                    Doctor.setText("Doctor: Nutriologo");
                    sDOC = "Nutriologo";
                    VideoConf = new String[]{"Doctor General", "Oftanmologo", "Cardiologo", "Pediatra", "Administrador"};
                    AfterLogD(NombreUser);

                } else if (Cont.equals(ContraD4) && L == false && H == false && M == false && Er == true && A == false) {
                    JOptionPane.showMessageDialog(null, "Bienvenido  " + NombreUser + "");
                    Doctor.setText("Doctor: Cardiologo");
                    sDOC = "Cardiologo";
                    VideoConf = new String[]{"Doctor General", "Oftanmologo", "Nutriologo", "Pediatra", "Administrador"};
                    AfterLogD(NombreUser);
                } else if (Cont.equals(ContraD5) && L == false && H == false && M == false && Er == false && A == true) {
                    JOptionPane.showMessageDialog(null, "Bienvenido  " + NombreUser + "");
                    Doctor.setText("Doctor: Pediatra");
                    sDOC = "Pediatra";
                    VideoConf = new String[]{"Doctor General","Oftanmologo", "Nutriologo", "Cardiologo","Administrador"};
                    AfterLogD(NombreUser);


                } else if(Cont.equals(ContraD1) && L == false && H == true && M == false && Er == false && A == false){
                    JOptionPane.showMessageDialog(null,"Contraseña incorrecta","ERROR",JOptionPane.YES_NO_OPTION);
                } else if(Cont.equals(ContraD1) && L == false && H == false && M == true && Er == false && A == false){
                    JOptionPane.showMessageDialog(null,"Contraseña incorrecta","ERROR",JOptionPane.YES_NO_OPTION);
                } else if(Cont.equals(ContraD1) && L == false && H == false && M == false && Er == true && A == false){
                    JOptionPane.showMessageDialog(null,"Contraseña incorrecta","ERROR",JOptionPane.YES_NO_OPTION);
                } else if(Cont.equals(ContraD1) && L == false && H == false && M == false && Er == false && A == true){
                    JOptionPane.showMessageDialog(null,"Contraseña incorrecta","ERROR",JOptionPane.YES_NO_OPTION);

                } else if(Cont.equals(ContraD2) && L == true && H == false && M == false && Er == false && A == false){
                    JOptionPane.showMessageDialog(null,"Contraseña incorrecta","ERROR",JOptionPane.YES_NO_OPTION);
                } else if(Cont.equals(ContraD2) && L == false && H == false && M == true && Er == false && A == false) {
                    JOptionPane.showMessageDialog(null, "Contraseña incorrecta", "ERROR", JOptionPane.YES_NO_OPTION);
                } else if(Cont.equals(ContraD2) && L == false && H == false && M == false && Er == true && A == false) {
                    JOptionPane.showMessageDialog(null, "Contraseña incorrecta", "ERROR", JOptionPane.YES_NO_OPTION);
                } else if(Cont.equals(ContraD2) && L == false && H == false && M == false && Er == false && A == true) {
                    JOptionPane.showMessageDialog(null, "Contraseña incorrecta", "ERROR", JOptionPane.YES_NO_OPTION);

                } else if(Cont.equals(ContraD3) && L == true && H == false && M == false && Er == false && A == false) {
                    JOptionPane.showMessageDialog(null, "Contraseña incorrecta", "ERROR", JOptionPane.YES_NO_OPTION);
                } else if(Cont.equals(ContraD3) && L == false && H == true && M == false && Er == false && A == false) {
                    JOptionPane.showMessageDialog(null, "Contraseña incorrecta", "ERROR", JOptionPane.YES_NO_OPTION);
                } else if(Cont.equals(ContraD3) && L == false && H == false && M == false && Er== true && A == false) {
                    JOptionPane.showMessageDialog(null, "Contraseña incorrecta", "ERROR", JOptionPane.YES_NO_OPTION);
                } else if(Cont.equals(ContraD3) && L == false && H == false && M == false && Er == false && A == true) {
                    JOptionPane.showMessageDialog(null, "Contraseña incorrecta", "ERROR", JOptionPane.YES_NO_OPTION);

                } else if(Cont.equals(ContraD4) && L == true && H == false && M == false && Er == false && A == false) {
                    JOptionPane.showMessageDialog(null, "Contraseña incorrecta", "ERROR", JOptionPane.YES_NO_OPTION);
                } else if(Cont.equals(ContraD4) && L == false && H == true && M == false && Er == false && A == false) {
                    JOptionPane.showMessageDialog(null, "Contraseña incorrecta", "ERROR", JOptionPane.YES_NO_OPTION);
                } else if(Cont.equals(ContraD4) && L == false && H == false && M == true && Er == false && A == false) {
                    JOptionPane.showMessageDialog(null, "Contraseña incorrecta", "ERROR", JOptionPane.YES_NO_OPTION);
                 }else if(Cont.equals(ContraD4) && L == false && H == false && M == false && Er == true && A == false) {
                    JOptionPane.showMessageDialog(null, "Contraseña incorrecta", "ERROR", JOptionPane.YES_NO_OPTION);
                }
            }else {
                System.out.println("efe");
                JOptionPane.showMessageDialog(null,"Contraseña incorrecta","ERROR",JOptionPane.YES_NO_OPTION);
            }

        }else {
            JOptionPane.showMessageDialog(null,"El usuario "+NombreUser+" no existe");
        }
    }

    public void AfterLogD(String UserR){


        pnlIniD.setLayout(null);
        BarraModo.setBounds(620,60,42,20);

        detD.setColorR(pnlIniD);
        detD.fondoLogAf2(pnlIniD);
        detD.fondoLogAf(pnlIniD);

        detD.setPerfilPicture(pnlIniD, ImgPer,false,false,false,false,L,H,M,Er,A,false);


        pnlIniD.setBounds(0,100,200,500);

        setSize(700,600);
        setLocationRelativeTo(null);

        JLabel LbInicioRAct = new JLabel("Sesión activa");
        JLabel Acc = new JLabel("Acciones");

        SesIniD.setText(UserR);

        Acc.setBounds(20, 130,160,20);
        BtDispo.setBounds(20, 160,160,30);
        BtConsultas.setBounds(20,200,160,30);
        BtVideoConf.setBounds(20,240,160,30);
        BtPagoRec.setBounds(20,280,160,30);

        LbUserD2.setBounds(20,50,160,20);
        LbInicioRAct.setBounds(50,20,160,20);
        SesIniD.setBounds(20,80,160,20);
        CerrSesD.setBounds(20,400,160,30);
        Doctor.setBounds(20, 115,160,20);

        CerrSesD.setVisible(true);

        //imgD.setText("ImagenINICIO");

        pnlizqD.setVisible(false);

        pnlIniD.add(Acc);
        pnlIniD.add(BtDispo);
        pnlIniD.add(BtConsultas);
        pnlIniD.add(BtVideoConf);
        pnlIniD.add(LbUserD2);
        pnlIniD.add(LbInicioRAct);
        pnlIniD.add(SesIniD);
        pnlIniD.add(CerrSesD);
        pnlIniD.add(BtPagoRec);

        Acc.setVisible(true);
        BtDispo.setVisible(true);
        BtConsultas.setVisible(true);
        BtVideoConf.setVisible(true);
        LbUserD.setVisible(true);
        CerrSesD.setVisible(true);
        BtPagoRec.setVisible(true);


        pnlIniD.add(Doctor);

        panelD.add(pnlIniD);
    }

    public void DesBots(int Bot){
        if(Bot == 0){
            CerrSesD.setVisible(false);                     //El botón deja de ser visile
            BtDispo.setVisible(false);
            BtConsultas.setVisible(false);
            BtVideoConf.setVisible(false);
            BtPagoRec.setVisible(false);
        } else if(Bot == 1){
            BtConsultas.setEnabled(false);
            BtVideoConf.setEnabled(false);
            CerrSesD.setEnabled(false);
            BtPagoRec.setEnabled(false);
        } else if(Bot == 2){
            BtDispo.setEnabled(false);
            BtVideoConf.setEnabled(false);
            CerrSesD.setEnabled(false);
            BtPagoRec.setEnabled(false);
        } else if(Bot == 3){
            BtDispo.setEnabled(false);
            BtConsultas.setEnabled(false);
            //BtVideoConf.setEnabled(false);
            CerrSesD.setEnabled(false);
            BtPagoRec.setEnabled(false);
        } else if(Bot == 4){
            BtDispo.setEnabled(false);
            BtConsultas.setEnabled(false);
            BtVideoConf.setEnabled(false);
            CerrSesD.setEnabled(false);

        }
    }

    public void ActBots(){
        BtDispo.setEnabled(true);
        BtConsultas.setEnabled(true);
        BtVideoConf.setEnabled(true);
        CerrSesD.setEnabled(true);
        BtPagoRec.setEnabled(true);
    }
    public void Limpiar(){
        int filas = dtmCita.getRowCount();
        for(int i = 0; i< filas;i++){
            dtmCita.removeRow(0);
        }
    }




    public static void main(String[] args) {
        Doctor Doc = new Doctor();
    }

    //METODO DE EVENTOS
    @Override
    public void actionPerformed(ActionEvent E) {
        //Objeto boton que escucha las acciones de los botones al presionarlos
        Object BotonDG = E.getSource();
        Object RadioBtD = E.getSource();
        Object MenBtD = E.getSource();
        Object ModoD = E.getSource();
        Object BotonDOpci = E.getSource();
        Object BotonDisponibilidad = E.getSource();
        Object BotonConsultas = E.getSource();
        Object BotonVideoC = E.getSource();
        Object BotonPagoF = E.getSource();
        int indiDoc = VC.getSelectedIndex();

        if(ModoD instanceof JMenuItem) {
            if (ModoD == Claro) {
                modo = 1;

                detD.setMode(modo,panelD);
                detD.setMode(modo, pnlIniD);
                detD.setMode(modo, pnlizqD);
                BarraModo.setBackground(Color.WHITE);
            }
            if (ModoD == Oscuro) {
                modo = 2;

                detD.setMode(modo,panelD);
                detD.setMode(modo, pnlIniD);
                detD.setMode(modo, pnlizqD);

                BarraModo.setBackground(Color.GRAY);
            }
        }

        //Si estamos presionando un botón
        if(BotonDG instanceof JButton){
            //Entra a un if anidado, si el boton pulsado es el de iniciar sesión
            if(BotonDG == BtIniciarSD){
                //Entra a unas validaciones
                try{
                    if(TxtUserD.getText().length() != 0){   //Si la caja de texto no está vacía
                        nom = TxtUserD.getText();           //Se obtiene el texto de la caja de texto

                        //Condición para saber si la caja de text o passwordfield no esté vacío
                        if(TxtContraD.getText().length() != 0){
                            Cont = TxtContraD.getText();        //Obtenemos la contraseña y la guardamo en la variable
                            iniciar(nom,Cont);          //Después mandamos a llamar al método para validar el usuario o contraseña
                            detD.setColorR(pnlIniD);
                            detD.setMode(modo, pnlIniD);

                        }else {     //Si está vacío, mandará un mensaje donde pide introducir la contraseña
                            JOptionPane.showMessageDialog(null,"Introduce la contraseña");
                        }
                    }else {         //Si está vacío, mandará un mensaje donde pide introducir el usuario
                        JOptionPane.showMessageDialog(null,"Introduce el nombre de usuario");
                    }
                }catch (Exception ex){      //El try catch ayuda a que nos envíe un mensaje diciendo que llenemos los campos para poder iniciar sesión
                    JOptionPane.showMessageDialog(null,"Por favor llena los campos");
                }
                //Si el botón seleccionado es el de regresar
            }else if(BotonDG == BtRegresarD){
                StartClinic RegIni = new StartClinic();         //Se crea un objeto de la clase StartClinic para mostrar la ventana principal
                RegIni.show();                                  //Se hace visible la ventana
                dispose();                                      //Se oculta la ventana actual para que la siguiente ventana no se empalme
                //Si el botón presionado es CerrarSes
            }else if(BotonDG == CerrSesD){                       //Este botón solo se verá cuando se haya iniciado sesión
                Limpiar();
                setSize(600,600);                 //La ventana regresa a su tamaño original
                setLocationRelativeTo(null);
                pnlizqD.setVisible(true);                        //Se hace visible el panel anterior
                Bot = 0;
                DesBots(Bot);
                imgD.setText("Imagen");
                detD.vaciar(pnlizqD);
                detD.fondoLogAf(pnlizqD);

                BarraModo.setBounds(522,60,42,20);


                repaint();


            } else if(BotonDOpci == BtDispo){
                Bot = 1;
                DesBots(Bot);
                Disponibilidad();
                MostComponentes(Bot);
                detD.setColorR(pnlDisp);


            } else if(BotonDOpci == BtConsultas){

                Bot = 2;
                DesBots(Bot);
                DConsultas(sDOC);
                MostComponentes(Bot);
                detD.setColorR(pnlDConsulta);

            } else if(BotonDOpci == BtVideoConf){
                Bot = 3;
                DesBots(Bot);
                DConferencia();
                MostComponentes(Bot);
                detD.setColorR(pnlDConf);

            } else if(BotonDOpci == BtPagoRec){
                Bot = 4;
                DesBots(Bot);
                FichaRec();
                MostComponentes(Bot);
                detD.setColorR(pnlFR);
                REGISTROS rg = new REGISTROS();

                ID = String.valueOf(rg.ID());

                LbSetPago.setText(ID);

            }

            Disponibilidad dips = new Disponibilidad();
            int dis;
            if(BotonDisponibilidad == BtDisponible){
                dis = 1;
                dips.Disp(dis,L,H,M,Er,A);

            } else if (BotonDisponibilidad == BtAusente) {
                dis = 2;
                dips.Disp(dis,L,H,M,Er,A);

            } else if (BotonDisponibilidad == BtenConsulta) {
                dis = 3;
                dips.Disp(dis,L,H,M,Er,A);
            } else if (BotonDisponibilidad == BtenEmergencia) {
                dis = 4;
                dips.Disp(dis,L,H,M,Er,A);
            } else if(BotonDisponibilidad == BtRegresar){
                ActBots();
                EliComponentes(Bot);
            }


            } if (BotonConsultas == CDCanc){
                ActBots();
                EliComponentes(Bot);
                Limpiar();

            }



            if(BotonVideoC == BtCamara){

                if(cam == 1) {
                    pnlCamara.setBackground(Color.DARK_GRAY);
                    esperando.setVisible(false);
                    cam = 0;
                }else {
                    pnlCamara.setBackground(Color.cyan);

                    esperando.setVisible(true);
                    cam = 1;
                }
            }else if(BotonVideoC == BtMicro){
                if(mic == 1) {

                    micro.setVisible(false);
                    mic = 0;
                }else {

                    micro.setVisible(true);
                    mic = 1;
                }

            }else if(BotonVideoC == BtDoConf){
                if(TxtWhy.getText().length() != 0) {
                    if(indiDoc != 0) {
                        JOptionPane.showMessageDialog(null, "Esperando al Receptor...");
                    }else {
                        JOptionPane.showMessageDialog(null, "Selecciona un receptor");
                    }
                }else {
                    JOptionPane.showMessageDialog(null, "Introduce un motivo para la conferencia");
                }
            }else if(BotonVideoC == BtCRCancelar){
                ActBots();
                EliComponentes(Bot);
            }

            if(BotonPagoF == BtCost){
                try {
                    if(txtCosto.getText().length() != 0) {
                        String sCostoE = txtCosto.getText();
                        int CostE, Final;
                        CostE = Integer.parseInt(sCostoE);
                        Final = Cita + CostE;
                        sCostoE = String.valueOf(Final);
                        LbFRTot.setText(sCostoE);
                        Cita = Final;
                    }else {
                        JOptionPane.showMessageDialog(null,"Introduce el precio");
                    }
                }catch (Exception e){
                    JOptionPane.showMessageDialog(null,"Introduce un valor numerico en el costo");
                }
            }else if(BotonPagoF == BtReg){
                ActBots();
                EliComponentes(Bot);
                detD.vaciar(pnlFR);
            }else if(BotonPagoF == BtFin){
                if(txtID.getText().length() != 0 && txtCosto.getText().length() != 0 && txtRazon.getText().length() != 0) {
                    String idP = txtID.getText();
                    String sCostoF = txtCosto.getText();
                    String sServ = txtRazon.getText();
                    sMedic = TXTMed.getText();
                    sRecom = TXTRec.getText();
                    sCostoF = LbFRTot.getText();

                    Ticket ticket = new Ticket();

                    ticket.AddLbls(ID, sCostoF, idP, sMedic, sRecom);
                    ticket.show();
                }else {
                    JOptionPane.showMessageDialog(null,"Por favor, llena los campos");
                }
            }


            repaint();
        }

    }


