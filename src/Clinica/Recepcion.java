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

public class Recepcion extends JFrame implements ActionListener {

    JPanel panel = new JPanel();
    JPanel pnlSup = new JPanel();
    JPanel pnlizq = new JPanel();
    Detalles detR = new Detalles();

    //Variables que guardan los valores en archivos

    String sRApPat, sRApMat, sRNom, sRAño, sRAler, sRDir, sRPes, sREst, sRTel, sRCurp, sRDia,
            sRMes, sREnf, sREnf1, sREnf2,sREnf3,sREnf4, sREnf5,sREnf6,sREnf7,sREnf8, sRInter, sRRazon;

    String Razon, sDOC, Dia,  Mes,Hora;
    float fRTel, fRPes, fREsta;
    int iRaño;
    //Modo oscuro/claro
    int modo;

    JMenuBar BarraModo = new JMenuBar();
    JMenu Mode = new JMenu("Modo");
    JMenuItem Claro = new JMenuItem("Claro");
    JMenuItem Oscuro = new JMenuItem("Oscuro");

    //Componentes de Inicio sesión
    JButton BtIniciarSR = new JButton("Iniciar Sesión");
    JButton BtRegresarR = new JButton("Regresar");
    JTextField TxtUserR = new JTextField();
    JPasswordField TxtContraR = new JPasswordField();
    JLabel LbUserR = new JLabel("Usuario");
    JLabel LbUserR2 = new JLabel("Usuario");
    JLabel LbContraR = new JLabel("Contraseña");
    JLabel LbInicioR = new JLabel("Inicio de Sesión");
    JButton CerrSesR = new JButton("Cerrar sesión");
    JLabel ImgPer;

    //Parametros de inicio de sesión
    final String User1 = "Pam"; final String User2 = "Jean"; final String User3 = "Connie"; final String User4 = "Sasha";
    final String ContraR1 = "Panecito"; final String ContraR2 = "Caballo"; final String ContraR3 = "krilin"; final String ContraR4 = "Comida";
    String nom, Cont; boolean P, J, C, S;
    JLabel SesIniR = new JLabel();
    JPanel pnlIniR = new JPanel();
    JLabel Recept = new JLabel();
    ImageIcon logo = new ImageIcon("Icons/LOGO.png");
    JLabel img = new JLabel(logo);

    JButton BtRegisPac = new JButton("Registrar");
    JButton BtConsultar = new JButton("Consultar");
    JButton BtCita = new JButton("Citas");
    JButton BtVentMed = new JButton("Vender Medicamento");
    JButton BtPagar = new JButton("Pagar servicio");


    int Bot = 0;
    int AÑO;

    //Registro
    JPanel pnlRegistro = new JPanel();

    JLabel LBRRegistro = new JLabel("Registro");
    JLabel LbRnom = new JLabel("Nombre");
    JLabel LbRApPat = new JLabel("Apellido Paterno");
    JLabel LbRAppMat = new JLabel("Apellido Materno");
    JLabel LbRFechaNac = new JLabel("Fecha de nacimiento");
    JLabel LbRDia= new JLabel("Día");
    JLabel LbRMes = new JLabel("Mes");
    JLabel LbRAño = new JLabel("Año");
    JLabel LbRCurp = new JLabel("CURP");
    JLabel LbRDirección = new JLabel("Dirección");
    JLabel LbRLugNaci = new JLabel("Lugar de nacimiento");
    JLabel LbRPaís = new JLabel("País de origen");
    JLabel LbEnferCro = new JLabel("Enfermedades Crónicas");
    JLabel LbAlergías = new JLabel("Alergías");
    JLabel LbPeso = new JLabel("Peso");
    JLabel LbEst = new JLabel("Estatura");
    JLabel LbTel = new JLabel("Telefono");
    JLabel Interno = new JLabel("Interno");

    JTextField TxtRNomb = new JTextField();
    JTextField TxtRApPat = new JTextField();
    JTextField TxtRAppMat = new JTextField();
    JTextField TxtRDirección = new JTextField();
    JTextField TxtRCurp  = new JTextField();
    JTextField TxtRAZIN = new JTextField();
    JTextField TxtRAño = new JTextField();
    JTextField TxtRPaís  = new JTextField();
    JTextField TxtRAlegia  = new JTextField();
    JTextField TxtRPeso  = new JTextField();
    JTextField TxtREsta  = new JTextField();
    JTextField TxtRTel  = new JTextField();

    JButton BtRHacerRegis = new JButton("Confirmar");
    JButton BtRNOHAYDATOS = new JButton("No hay datos(EMERGENCIA)");
    JButton BtRCancelar = new JButton("Cancelar");

    String [] Rdía = {"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};
    String [] RMes = {"Enero","Febrero","Marzo","Abril","Mayo","Junio","Julio","Agosto","Septiembre","Octubre","Noviembre","Diciembre"};
    JComboBox RComboDay = new JComboBox(Rdía);
    JComboBox RComboMes = new JComboBox(RMes);

    JMenuBar BarraR = new JMenuBar();
    JMenu MenuR = new JMenu("Registro");
    JMenuItem NuevoR = new JMenuItem("Nuevo");
    JMenuItem GuardarR = new JMenuItem("Registrar");

    JCheckBox RBDiab = new JCheckBox("Diabetes");
    JCheckBox RBAsma = new JCheckBox("Asma");
    JCheckBox RBArtritis = new JCheckBox("Artritis");
    JCheckBox RBCancer = new JCheckBox("Cáncer");
    JCheckBox RBEPOC = new JCheckBox("EPOC");
    JCheckBox RBCrohn = new JCheckBox("Crohn");
    JCheckBox RBFibQuis = new JCheckBox("Fibrosis Quística");
    JCheckBox RBAlzh = new JCheckBox("Alzheimer");
    JCheckBox RBNinguna = new JCheckBox("Ninguna");

    JRadioButton RBNin = new JRadioButton("Ninguna",false);

    ButtonGroup opci = new ButtonGroup();
    JRadioButton RBInterY = new JRadioButton("Si",false);
    JRadioButton RBInterN = new JRadioButton("No",false);


    //Consulta
    JPanel pnlRConsulta = new JPanel();

    JLabel LbRConsulta = new JLabel("Consulta");

    JButton CRPerSist = new JButton("Personas en el sistema");
    JButton CRHistMed = new JButton();
    JButton CRPerInter = new JButton("Personas internadas");
    JButton CRDispDoc = new JButton("Disponibilidad del Doctor");
    JButton CREquipMed = new JButton("Equipamiento médico");
    JButton CRMedica = new JButton("Medicamento");
    JButton CRCanc = new JButton("Cancelar");

    //Cita
    JPanel pnlRCita = new JPanel();

    JLabel LbRCita = new JLabel("Cita");
    JLabel LbRCNum = new JLabel("ID");
    JLabel LbRCRazon = new JLabel("Razón de la cita");
    JLabel LbRCDoctor = new JLabel("Doctor");
    JLabel LbRDate = new JLabel("Día               Mes               Hora");

    JButton BtBusc = new JButton("Buscar");
    JButton BtFechCit = new JButton("Calcular la fecha");
    JButton BtDoCit = new JButton("Finalizar");
    JButton BtPrintCit = new JButton("Imprimir");
    JButton BtCRCancelar = new JButton("Cancelar");

    DefaultTableModel dtmCita = new DefaultTableModel();

    JTable RTablaCita = new JTable(dtmCita);
    JScrollPane scrollCR = new JScrollPane(RTablaCita);




    JTextField TxtRCNum = new JTextField();
    JTextField TxtWhy = new JTextField();
    JTextField TxtRCDia = new JTextField();
    JTextField TxtRCMes = new JTextField();
    JTextField TxtRCAño = new JTextField();

    String [] sRCDoc = {"Selecciona","Doctor General","Oftanmólogo","Nutriologo","Cardiologo","Pediatra"};
    JComboBox ComboRCita = new JComboBox(sRCDoc);



    //VENTA
    JPanel pnlVenta = new JPanel();

    JLabel LbVenta = new JLabel("Venta de medicamento");
    JLabel LbVMed = new JLabel("Medicamento");
    JLabel lbVCant = new JLabel("Cantidad");
    JLabel LbVTotal = new JLabel("Total: $");
    JLabel LbVMXN = new JLabel("MXN");
    JLabel LbVDin = new JLabel("0");
    JLabel LbVCant = new JLabel("0");
    int Cantidad = 0;

    JButton BtVplus = new JButton();
    JButton BtVres = new JButton();
    JButton BtVEliCom = new JButton("Eliminar Compra");
    JButton BtVEliEl = new JButton("Eliminar Elemento");
    JButton BtVCancelar = new JButton("Cancelar");
    JButton BtVCompra = new JButton("Finalizar Compra");
    JButton BtVAddCar = new JButton("Añadir al Carro");

    ImageIcon Plus = new ImageIcon("Icons/BtPlus.png");
    ImageIcon Res = new ImageIcon("Icons/BtRes.png");

    JTextField TxtVMed = new JTextField();
    JTextField TxtPrecio = new JTextField();


    DefaultTableModel dtmVenta = new DefaultTableModel();

    JTable VentTabla = new JTable(dtmVenta);
    JScrollPane scrollVenta = new JScrollPane(VentTabla);

    //Pago
    JPanel pnlRPago = new JPanel();
    JLabel Pag = new JLabel("Pago ");
    JLabel IdPag = new JLabel("Id Pago ");
    JLabel lbServ = new JLabel("Servicio");
    JLabel lbPrecio = new JLabel("Precio");

    JTextField txtidpg = new JTextField(20);
    JTextField txtserv = new JTextField(20);
    JTextField txtprecio = new JTextField(20);

    JButton BtPreg = new JButton("Regresar");
    JButton BtPag = new JButton("Pagar");



    public Recepcion(){
        //Creación de la ventana
        super("Recepción");
        //Asignación de tamaño
        setSize(600,600);
        //Asignación de que se cierre el programa al presionar el botón de cerrar
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //Asignación de la localización de la ventana, que esté en el centro
        setLocationRelativeTo(null);
        //Hacer que la ventana no cambie de tamaño
        setResizable(false);

        //INICIO DE SESION
        BtIniciarSR.addActionListener(this);
        BtRegresarR.addActionListener(this);
        CerrSesR.addActionListener(this);

        //ACCIONES DE USUARIO
        BtRegisPac.addActionListener(this);
        BtConsultar.addActionListener(this);
        BtCita.addActionListener(this);
        BtVentMed.addActionListener(this);
        BtPagar.addActionListener(this);

        //REGISTRO
        BtRHacerRegis.addActionListener(this);
        BtRNOHAYDATOS.addActionListener(this);
        BtRCancelar.addActionListener(this);

        RComboDay.addActionListener(this);
        RComboMes.addActionListener(this);
        RBNin.addActionListener(this);

        NuevoR.addActionListener(this);
        GuardarR.addActionListener(this);
        RBInterY.addActionListener(this);
        RBInterN.addActionListener(this);

        //CONSULTA
        CRPerSist.addActionListener(this);
        CRHistMed.addActionListener(this);
        CRPerInter.addActionListener(this);
        CRDispDoc.addActionListener(this);
        CREquipMed.addActionListener(this);
        CRMedica.addActionListener(this);
        CRCanc.addActionListener(this);

        //CITA
        BtBusc.addActionListener(this);
        BtFechCit.addActionListener(this);
        BtDoCit.addActionListener(this);
        BtCRCancelar.addActionListener(this);

        //VENTA
        BtVentMed.addActionListener(this);
        BtVplus.addActionListener(this);
        BtVres.addActionListener(this);
        BtVEliCom.addActionListener(this);
        BtVEliEl.addActionListener(this);
        BtVCompra.addActionListener(this);
        BtVAddCar.addActionListener(this);
        BtVCancelar.addActionListener(this);

        //PAGO
        BtPreg.addActionListener(this);
        BtPag.addActionListener(this);

        //Modo
        Claro.addActionListener(this);
        Oscuro.addActionListener(this);

        addPanels();

        //Titulo de columnas
        dtmCita.addColumn("ID");
        dtmCita.addColumn("Doctor");
        dtmCita.addColumn("Dia");
        dtmCita.addColumn("Mes");
        dtmCita.addColumn("Hora");
        dtmCita.addColumn("Razon");

        RTablaCita.setBounds(160,250,266,150);
        scrollCR.setBounds(160,250,266,150);

        pnlRCita.add(scrollCR);

        pnlRCita.setVisible(false);
        scrollCR.setVisible(false);

        //Titulo de columnas
        dtmVenta.addColumn("Producto");
        dtmVenta.addColumn("Cantidad");
        dtmVenta.addColumn("Precio");

        VentTabla.setBounds(127,200,300,170);
        scrollVenta.setBounds(127,200,300,170);

        pnlVenta.add(scrollVenta);

        pnlVenta.setVisible(false);
        scrollVenta.setVisible(false);

        BarraModo.setBounds(522,60,42,20);
        BarraModo.setBorderPainted(false);
        AÑO = detR.Fecha(pnlSup);

        Mode.add(Claro);
        Mode.addSeparator();
        Mode.add(Oscuro);
        BarraModo.add(Mode);
        pnlSup.add(BarraModo);


        InicioSesR();

        detR.setColorR(pnlizq);
        detR.setColorPane(panel,pnlSup);
        //detR.setMode(modo,pnlIniR);
        //detR.setMode(modo,pnlizq);

        setContentPane(panel);
        setVisible(true);
    }



    public void Venta(){
        pnlVenta.setVisible(true);

        pnlVenta.setLayout(null);
        img.setVisible(false);

        detR.setColorR(pnlVenta);

        leerTexto("RegistrosVenta.txt");

        JLabel lbPrec = new JLabel("Precio");

        pnlVenta.setBounds(220,120,443,421);
        LbVenta.setBounds(200,20,150,30);
        LbVMed.setBounds(20,75,150,20);
        lbVCant.setBounds(20,100,150,20);
        LbVCant.setBounds(100,100,100,20);
        LbVDin.setBounds(180,390,150,20);
        TxtVMed.setBounds(150,75,140,20);
        lbPrec.setBounds(20,120,100,20);
        TxtPrecio.setBounds(20,140,50,20);
        BtVAddCar.setBounds(297,75,130,20);
        BtVplus.setBounds(150,100,30,30);
        BtVres.setBounds(200,100,30,30);
        BtVEliEl.setBounds(150,155,140,30);
        BtVEliCom.setBounds(297,155,130,30);
        //VentTabla.setBounds(127,200,300,170);
        BtVCancelar.setBounds(20,380,100,30);
        LbVTotal.setBounds(127,390,100,20);
        LbVMXN.setBounds(227,390,100,20);
        BtVCompra.setBounds(327,380,100,30);

        scrollVenta.setVisible(true);

        BtVplus.setIcon(Plus);
        BtVres.setIcon(Res);

        pnlVenta.add(lbPrec);
        pnlVenta.add(TxtPrecio);
        pnlVenta.add(LbVenta);
        pnlVenta.add(LbVMed);
        pnlVenta.add(lbVCant);
        pnlVenta.add(LbVCant);
        pnlVenta.add(BtVAddCar);
        pnlVenta.add(BtVplus);
        pnlVenta.add(BtVres);
        pnlVenta.add(BtVEliCom);
        pnlVenta.add(BtVEliEl);
        //pnlVenta.add(VentTabla);
        pnlVenta.add(LbVTotal);
        pnlVenta.add(LbVMXN);
        pnlVenta.add(BtVCancelar);
        pnlVenta.add(BtVCompra);
        pnlVenta.add(TxtVMed);
        pnlVenta.add(LbVDin);

        panel.add(pnlVenta);

    }

    public void MostComponentes(int Bot){
        if(Bot == 1) {
            for (Object o : pnlRegistro.getComponents()) {
                if (o instanceof JTextField) {
                    ((JTextField) o).setVisible(true);
                }
                if (o instanceof JButton) {
                    ((JButton) o).setVisible(true);
                }
                if (o instanceof JLabel) {
                    ((JLabel) o).setVisible(true);
                }
                BarraR.setVisible(true);
                MenuR.setVisible(true);

                for(Object Opaque: pnlRegistro.getComponents()){
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
            pnlRegistro.setVisible(true);
        }if(Bot == 2) {
            for (Object o : pnlRConsulta.getComponents()) {
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
                if (o instanceof JComboBox) {
                    ((JComboBox) o).setVisible(true);
                }
            }
            pnlRConsulta.setVisible(true);
        }if(Bot == 3) {
        for (Object o : pnlRCita.getComponents()) {
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
        pnlRCita.setVisible(true);
    }if(Bot == 4) {
        for (Object o : pnlVenta.getComponents()) {
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
            }if (o instanceof JScrollPane) {
                ((JScrollPane) o).setVisible(true);
            }
        }
        pnlVenta.setVisible(true);
    }if(Bot == 5) {
            for (Object o : pnlRPago.getComponents()) {
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
                }if (o instanceof JScrollPane) {
                    ((JScrollPane) o).setVisible(true);
                }
            }
            pnlRPago.setVisible(true);
        }

        img.setVisible(false);

    }

    public void EliComponentes(int Bot){
        if(Bot == 1) {
            for (Object o : pnlRegistro.getComponents()) {
                if (o instanceof JTextField) {
                    ((JTextField) o).setVisible(false);
                }
                if (o instanceof JButton) {
                    ((JButton) o).setVisible(false);
                }
                if (o instanceof JLabel) {
                    ((JLabel) o).setVisible(false);
                }
                BarraR.setVisible(false);
                MenuR.setVisible(false);
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
            pnlRegistro.setVisible(false);
        }if(Bot == 2) {
            for (Object o : pnlRConsulta.getComponents()) {
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
            pnlRConsulta.setVisible(false);
        }if(Bot == 3) {
            for (Object o : pnlRCita.getComponents()) {
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
            pnlRCita.setVisible(false);
        }if(Bot == 4) {
            for (Object o : pnlVenta.getComponents()) {
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
            pnlVenta.setVisible(false);
        }
        img.setVisible(true);
        if(Bot == 5) {
            for (Object o : pnlRPago.getComponents()) {
                if (o instanceof JTextField) {
                    ((JTextField) o).setVisible(false);
                }
                if (o instanceof JButton) {
                    ((JButton) o).setVisible(false);
                }
                if (o instanceof JLabel) {
                    ((JLabel) o).setVisible(false);
                }

            }
            pnlRPago.setVisible(false);
        }
        img.setVisible(true);

    }


    public void Registro(){

        pnlRegistro.setLayout(null);
        detR.setColorPanePlane(pnlRegistro,6);
        detR.setColorR(pnlRegistro);

        opci.add(RBInterY);
        opci.add(RBInterN);

        pnlRegistro.setBounds(220,120,443,421);
        LBRRegistro.setBounds(200,20,150,30);
        BarraR.setBounds(220,120,443,20);
        LbRApPat.setBounds(20,50,150,20);
        LbRAppMat.setBounds(20,80,150,20);
        LbRnom.setBounds(20,110,150,20);
        TxtRApPat.setBounds(130,50,95,20);
        TxtRAppMat.setBounds(130,80,95,20);
        TxtRNomb.setBounds(130,110,95,20);
        LbRFechaNac.setBounds(250,50,150,20);
        LbRDia.setBounds(250,80,20,20);
        LbRMes.setBounds(300,80,50,20);
        LbRAño.setBounds(410,80,30,20);
        TxtRAño.setBounds(410,100,30,20);
        RComboDay.setBounds(250,100,40,20);
        RComboMes.setBounds(300,100,100,20);
        LbRCurp.setBounds(250,130,100,20);
        TxtRCurp.setBounds(250,150,150,20);
        LbRDirección.setBounds(20,130,100,20);
        TxtRDirección.setBounds(20,150,206,20);
        LbPeso.setBounds(20,180,100,20);
        LbEst.setBounds(124,180,100,20);
        LbTel.setBounds(250,180,100,20);
        TxtRPeso.setBounds(54,180,50,20);
        TxtREsta.setBounds(176,180,50,20);
        TxtRTel.setBounds(310,180,90,20);
        Interno.setBounds(20,200,100,20);
        RBInterY.setBounds(20,230,50,20);
        RBInterN.setBounds(80,230,50,20);
        TxtRAZIN.setBounds(140,230,50,20);

        BtRHacerRegis.setBounds(30,370,120,40);
        BtRNOHAYDATOS.setBounds(160,370,120,40);
        BtRCancelar.setBounds(290,370,120,40);

        LbEnferCro.setBounds(20,250,150,20);
        LbAlergías.setBounds(290,250,120,20);
        TxtRAlegia.setBounds(290,280,120,20);

        RBDiab.setBounds(20,280,80,20);
        RBAlzh.setBounds(100,280,90,20);
        RBArtritis.setBounds(20,300,80,20);
        RBAsma.setBounds(100,300,70,20);
        RBCancer.setBounds(170,300,80,20);
        RBCrohn.setBounds(20,320,70,20);
        RBEPOC.setBounds(100,320,70,20);
        RBFibQuis.setBounds(170,320,90,20);
        RBNinguna.setBounds(20,340,90,20);
        RBNin.setBounds(290,310,150,20);

        MenuR.add(NuevoR);
        MenuR.addSeparator();
        MenuR.add(GuardarR);
        BarraR.add(MenuR);

        RBInterY.setOpaque(false);
        RBInterN.setOpaque(false);

        pnlRegistro.add(LBRRegistro);
        pnlRegistro.add(LbRApPat);
        pnlRegistro.add(LbRAppMat);
        pnlRegistro.add(LbRnom);
        pnlRegistro.add(TxtRApPat);
        pnlRegistro.add(TxtRAppMat);
        pnlRegistro.add(TxtRNomb);
        pnlRegistro.add(LbRFechaNac);
        pnlRegistro.add(LbRDia);
        pnlRegistro.add(LbRMes);
        pnlRegistro.add(RComboDay);
        pnlRegistro.add(RComboMes);
        pnlRegistro.add(LbRCurp);
        pnlRegistro.add(TxtRCurp);
        pnlRegistro.add(LbRDirección);
        pnlRegistro.add(TxtRDirección);
        pnlRegistro.add(BtRHacerRegis);
        pnlRegistro.add(BtRNOHAYDATOS);
        pnlRegistro.add(BtRCancelar);
        pnlRegistro.add(LbEnferCro);
        pnlRegistro.add(LbAlergías);
        pnlRegistro.add(TxtRAlegia);
        pnlRegistro.add(RBDiab);
        pnlRegistro.add(RBAlzh);
        pnlRegistro.add(RBArtritis);
        pnlRegistro.add(RBAsma);
        pnlRegistro.add(RBCancer);
        pnlRegistro.add(RBCrohn);
        pnlRegistro.add(RBEPOC);
        pnlRegistro.add(RBFibQuis);
        pnlRegistro.add(RBNinguna);
        pnlRegistro.add(RBNin);
        pnlRegistro.add(LbRAño);
        pnlRegistro.add(TxtRAño);
        pnlRegistro.add(LbRAño);
        pnlRegistro.add(LbTel);
        pnlRegistro.add(TxtRTel);
        pnlRegistro.add(LbPeso);
        pnlRegistro.add(LbEst);
        pnlRegistro.add(TxtRPeso);
        pnlRegistro.add(TxtREsta);
        pnlRegistro.add(RBInterY);
        pnlRegistro.add(RBInterN);
        pnlRegistro.add(Interno);
        pnlRegistro.add(TxtRAZIN);


        panel.add(BarraR);
        panel.add(pnlRegistro);

        img.setVisible(false);

    }

    public void RCita() {

        pnlRCita.setVisible(true);

        pnlRCita.setLayout(null);

        detR.setColorR(pnlRCita);

        pnlRCita.setBounds(220,120,443,421);
        LbRCita.setBounds(200,20,150,30);
        LbRCNum.setBounds(20,100,80,20);
        LbRCRazon.setBounds(20,130,100,20);
        LbRCDoctor.setBounds(20,160,50,20);
        LbRDate.setBounds(20,200,200,20);
        //BtBusc.setBounds(250,100,100,20);
        //BtFechCit.setBounds(20, 255,100,30);
        TxtRCNum.setBounds(120,100,110,20);
        TxtWhy.setBounds(120,130,110,20);
        ComboRCita.setBounds(120,160,110,20);
        TxtRCDia.setBounds(20,220,45,20);
        TxtRCMes.setBounds(75,220,80,20);
        TxtRCAño.setBounds(165,220,50,20);
        BtDoCit.setBounds(20,330,85,30);
        //BtPrintCit.setBounds(20,380,85,30);
        BtCRCancelar.setBounds(20,380,85,30);

        leerTexto("RegistrosCitas.txt");

        pnlRCita.add(LbRCita);
        pnlRCita.add(LbRCNum);
        pnlRCita.add(LbRCRazon);
        pnlRCita.add(LbRCDoctor);
        pnlRCita.add(LbRDate);
        //pnlRCita.add(BtBusc);
        //pnlRCita.add(BtFechCit);
        pnlRCita.add(TxtRCNum);
        pnlRCita.add(TxtRCDia);
        pnlRCita.add(TxtRCMes);
        pnlRCita.add(TxtRCAño);
        pnlRCita.add(BtDoCit);
        //pnlRCita.add(BtPrintCit);
        pnlRCita.add(BtCRCancelar);
        pnlRCita.add(TxtWhy);
        pnlRCita.add(ComboRCita);
        //pnlRCita.add(RTablaCita);
        pnlRCita.add(scrollCR);

        scrollCR.setVisible(true);

        panel.add(pnlRCita);

    }
    public void RConsultar(){

        pnlRConsulta.setLayout(null);

        detR.setColorR(pnlRConsulta);

        pnlRConsulta.setBounds(220,120,443,421);
        LbRConsulta.setBounds(200,20,150,30);
        CRPerSist.setBounds(120,80,200,40);
        CRPerInter.setBounds(120,130,200,40);
        CRHistMed.setBounds(120,180,200,40);
        CRDispDoc.setBounds(120,230,200,40);
        CREquipMed.setBounds(120,280,200,40);
        CRMedica.setBounds(120,330,200,40);
        CRCanc.setBounds(340,380,100,30);

        pnlRConsulta.add(CRPerSist);
        pnlRConsulta.add(CRPerInter);
        pnlRConsulta.add(CRHistMed);
        pnlRConsulta.add(CRDispDoc);
        pnlRConsulta.add(CREquipMed);
        pnlRConsulta.add(CRMedica);
        pnlRConsulta.add(CRCanc);
        pnlRConsulta.add(LbRConsulta);
        panel.add(pnlRConsulta);


    }
    public void RPago(){

        pnlRPago.setLayout(null);

        detR.setColorR(pnlRPago);

        pnlRPago.setBounds(220,120,443,421);
        Pag.setBounds(200,20,150,20);
        IdPag.setBounds(20,80,100,20);
        txtidpg.setBounds(100,80,150,20);
        lbServ.setBounds(20,110,100,20);
        txtserv.setBounds(100,110,150,20);
        lbPrecio.setBounds(20,140,100,20);
        txtprecio.setBounds(100,140,150,20);
        BtPreg.setBounds(20,380,100,30);
        BtPag.setBounds(150,380,100,30);

        pnlRPago.add(Pag);
        pnlRPago.add(IdPag);
        pnlRPago.add(txtidpg);
        pnlRPago.add(lbServ);
        pnlRPago.add(txtserv);
        pnlRPago.add(lbPrecio);
        pnlRPago.add(txtprecio);
        pnlRPago.add(BtPreg);
        pnlRPago.add(BtPag);


        panel.add(pnlRPago);



    }

    public void InicioSesR(){

        detR.fondoLogAf(pnlizq);
        pnlizq.setLayout(null);

        LbInicioR.setBounds(50,20,150,20);
        LbUserR.setBounds(20,50,150,20);
        LbContraR.setBounds(20,100,150,20);
        TxtUserR.setBounds(20,70,160,20);
        TxtContraR.setBounds(20,120,160,20);
        BtIniciarSR.setBounds(20,165,160,30);
        BtRegresarR.setBounds(20,400,160,30);

        img.setBounds(220,100,350,350);
        panel.add(img);

        pnlizq.add(LbInicioR);
        pnlizq.add(LbUserR);
        pnlizq.add(LbContraR);
        pnlizq.add(TxtUserR);
        pnlizq.add(TxtContraR);
        pnlizq.add(BtIniciarSR);
        pnlizq.add(BtRegresarR);
    //CAMBIAR DE LADOO
        detR.setColorPanePlane(pnlRegistro,6);
        detR.setColorPanePlane(pnlRConsulta,6);
        detR.setColorPanePlane(pnlRCita,6);
        detR.setColorPanePlane(pnlVenta,6);
        detR.setColorPanePlane(pnlRPago,6);
    }

    public void addPanels(){
        panel.setLayout(null);

        pnlSup.setLayout(null);

        pnlSup.setBounds(0,0,900,100);


        pnlizq.setBounds(0,100,200,500);

        panel.add(pnlSup);
        panel.add(pnlizq);

    }

    //METODO DE VALIDACIÓN DE USUARIO
    public void iniciar(String NombreUser, String Cont){
        //Validar que usuario exista
        if(NombreUser.equals(User1) || NombreUser.equals(User2) || NombreUser.equals(User3) || NombreUser.equals(User4) ) {         //Comparar el texto obtenido con el usuario
            //Condición para saber que usuario es
            if (NombreUser.equals(User1)) {                                //Asignarle true al usuario que es para posteriormente usarlo
                P = true; J = false; C = false; S = false;
            }else if (NombreUser.equals(User2)) {
                P = false; J = true; C = false; S = false;
            } else if (NombreUser.equals(User3)) {
                P = false; J = false; C = true; S = false;
            } else if (NombreUser.equals(User4)) {
                P = false; J = false; C = false; S = true;
            }

                //Validar que la contraseña exista
                if(Cont.equals(ContraR1) || Cont.equals(ContraR2) ||Cont.equals(ContraR3) ||Cont.equals(ContraR4) ) {
                    //Comparar las contraseñas con las variables de tipo booleano para iniciar
                    if (Cont.equals(ContraR1) && P == true && J == false && C == false && S == false) {

                        JOptionPane.showMessageDialog(null, "Bienvenida " + NombreUser + "");
                        AfterLogR(NombreUser);          //Mandar a llamar al método cuando la sesión esté iniciada
                        Recept.setText("Recepcionista");
                        CRHistMed.setText("Registros de "+NombreUser);

                        //lbperfil = new JLabel(Pam);

                    } else if (Cont.equals(ContraR2) && P == false && J == true && C == false && S == false) {
                        JOptionPane.showMessageDialog(null, "Bienvenido " + NombreUser + "");
                        AfterLogR(NombreUser);
                        Recept.setText("Recepcionista");
                        CRHistMed.setText("Registros de "+NombreUser);


                    } else if (Cont.equals(ContraR3) && P == false && J == false && C == true && S == false) {
                        JOptionPane.showMessageDialog(null, "Bienvenido " + NombreUser + "");
                        AfterLogR(NombreUser);
                        Recept.setText("Recepcionista");
                        CRHistMed.setText("Registros de "+NombreUser);


                    } else if (Cont.equals(ContraR4) && P == false && J == false && C == false && S == true) {
                        JOptionPane.showMessageDialog(null, "Bienvenida  " + NombreUser + "");
                        AfterLogR(NombreUser);
                        Recept.setText("Recepcionista");
                        CRHistMed.setText("Registros de "+NombreUser);


                    } else if(Cont.equals(ContraR1) && P == false && J == true && C == false && S == false){
                        JOptionPane.showMessageDialog(null,"Contraseña incorrecta","ERROR",JOptionPane.YES_NO_OPTION);
                    } else if(Cont.equals(ContraR1) && P == false && J == false && C == true && S == false){
                        JOptionPane.showMessageDialog(null,"Contraseña incorrecta","ERROR",JOptionPane.YES_NO_OPTION);
                    } else if(Cont.equals(ContraR1) && P == false && J == false && C == false && S == true){
                        JOptionPane.showMessageDialog(null,"Contraseña incorrecta","ERROR",JOptionPane.YES_NO_OPTION);

                    } else if(Cont.equals(ContraR2) && P == true && J == false && C == false && S == false){
                        JOptionPane.showMessageDialog(null,"Contraseña incorrecta","ERROR",JOptionPane.YES_NO_OPTION);
                    } else if(Cont.equals(ContraR2) && P == false && J == false && C == true && S == false) {
                        JOptionPane.showMessageDialog(null, "Contraseña incorrecta", "ERROR", JOptionPane.YES_NO_OPTION);
                    } else if(Cont.equals(ContraR2) && P == false && J == false && C == false && S == true) {
                        JOptionPane.showMessageDialog(null, "Contraseña incorrecta", "ERROR", JOptionPane.YES_NO_OPTION);

                    } else if(Cont.equals(ContraR3) && P == true && J == false && C == false && S == false) {
                        JOptionPane.showMessageDialog(null, "Contraseña incorrecta", "ERROR", JOptionPane.YES_NO_OPTION);
                    } else if(Cont.equals(ContraR3) && P == false && J == true && C == false && S == false) {
                        JOptionPane.showMessageDialog(null, "Contraseña incorrecta", "ERROR", JOptionPane.YES_NO_OPTION);
                    } else if(Cont.equals(ContraR3) && P == false && J == false && C == false && S == true) {
                        JOptionPane.showMessageDialog(null, "Contraseña incorrecta", "ERROR", JOptionPane.YES_NO_OPTION);

                    } else if(Cont.equals(ContraR4) && P == true && J == false && C == false && S == false) {
                        JOptionPane.showMessageDialog(null, "Contraseña incorrecta", "ERROR", JOptionPane.YES_NO_OPTION);
                    } else if(Cont.equals(ContraR4) && P == false && J == true && C == false && S == false) {
                        JOptionPane.showMessageDialog(null, "Contraseña incorrecta", "ERROR", JOptionPane.YES_NO_OPTION);
                    } else if(Cont.equals(ContraR4) && P == false && J == false && C == true && S == false) {
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

    public void AfterLogR(String UserR){


        pnlIniR.setLayout(null);
        BarraModo.setBounds(620,60,42,20);


        detR.setColorR(pnlIniR);
        detR.fondoLogAf2(pnlIniR);
        detR.fondoLogAf(pnlIniR);

        detR.setPerfilPicture(pnlIniR, ImgPer,P,J,C,S,false,false,false,false,false,false);
        pnlIniR.setBounds(0,100,200,500);

        setSize(700,600);
        setLocationRelativeTo(null);

        JLabel LbInicioRAct = new JLabel("Sesión activa");
        JLabel Acc = new JLabel("Acciones");

        SesIniR.setText(UserR);

        Acc.setBounds(20, 130,160,20);
        BtRegisPac.setBounds(20, 160,160,30);
        BtConsultar.setBounds(20,200,160,30);
        BtCita.setBounds(20,240,160,30);
        BtVentMed.setBounds(20,320,160,30);
        //BtPagar.setBounds(20,320,160,30);
        BtPagar.setBounds(20,280,160,30);
        //lbperfil.setBounds(120,50,60,60);

        LbUserR2.setBounds(20,50,160,20);
        LbInicioRAct.setBounds(50,20,160,20);
        SesIniR.setBounds(20,80,160,20);
        CerrSesR.setBounds(20,400,160,30);
        Recept.setBounds(20, 100,160,20);
        //ImgPer.setBounds(120,50,60,60);

        CerrSesR.setVisible(true);

        //img.setText("ImagenINICIO");

        pnlizq.setVisible(false);

        pnlIniR.add(Acc);
        pnlIniR.add(BtRegisPac);
        pnlIniR.add(BtConsultar);
        pnlIniR.add(BtCita);
        pnlIniR.add(LbUserR2);
        pnlIniR.add(LbInicioRAct);
        pnlIniR.add(SesIniR);
        pnlIniR.add(CerrSesR);
        pnlIniR.add(BtVentMed);
        pnlIniR.add(BtPagar);




        //Acc.setVisible(true);
        BtRegisPac.setVisible(true);
        BtConsultar.setVisible(true);
        BtCita.setVisible(true);
        BtVentMed.setVisible(true);
        CerrSesR.setVisible(true);
        BtPagar.setVisible(true);

        pnlIniR.add(Recept);
        //pnlIniR.add(lbperfil);

        //lbperfil.setVisible(true);

        panel.add(pnlIniR);

    }

    public void DesBots(int Bot){
        if(Bot == 0){
            CerrSesR.setVisible(false);                     //El botón deja de ser visile
            BtRegisPac.setVisible(false);
            BtConsultar.setVisible(false);
            BtCita.setVisible(false);
            BtVentMed.setVisible(false);
            BtPagar.setVisible(false);
        } else if(Bot == 1){
            BtConsultar.setEnabled(false);
            BtCita.setEnabled(false);
            BtVentMed.setEnabled(false);
            CerrSesR.setEnabled(false);
            BtPagar.setEnabled(false);
        } else if(Bot == 2){
            BtRegisPac.setEnabled(false);
            BtCita.setEnabled(false);
            BtVentMed.setEnabled(false);
            CerrSesR.setEnabled(false);
            BtPagar.setEnabled(false);
        } else if(Bot == 3){
            BtRegisPac.setEnabled(false);
            BtConsultar.setEnabled(false);
            BtVentMed.setEnabled(false);
            CerrSesR.setEnabled(false);
            BtPagar.setEnabled(false);
        } else if(Bot == 4){
            BtRegisPac.setEnabled(false);
            BtConsultar.setEnabled(false);
            BtCita.setEnabled(false);
            CerrSesR.setEnabled(false);
            BtPagar.setEnabled(false);
        } else if(Bot == 5){
            BtRegisPac.setEnabled(false);
            BtConsultar.setEnabled(false);
            BtCita.setEnabled(false);
            BtVentMed.setEnabled(false);
            CerrSesR.setEnabled(false);
        }
    }

    public void ActBots(){
        BtRegisPac.setEnabled(true);
        BtConsultar.setEnabled(true);
        BtCita.setEnabled(true);
        BtVentMed.setEnabled(true);
        CerrSesR.setEnabled(true);
        BtPagar.setEnabled(true);
    }
    public void GuardarTablaR(String sRApPat, String sRApMat, String sRNom, String sRAño, String sRAler,
                             String  sRDir, String sRPes, String sREst, String sRTel, String sRCurp,
                             String sRDia, String sRMes, String sREnf, String sREnf1, String sREnf2,
                             String sREnf3, String sREnf4, String sREnf5, String sREnf6, String sREnf7,
                             String sREnf8, String sRInter){

        dtmCita.addRow(new Object[]{
                sRApPat, sRApMat, sRNom, sRAño, sRAler, sRDir, sRPes, sREst, sRTel, sRCurp, sRDia,
                sRMes, sREnf, sREnf1, sREnf2,sREnf3,sREnf4, sREnf5,sREnf6,sREnf7,sREnf8, sRInter
        });
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

    public void LimpCamp(JPanel panell) {
        for(Object o: panell.getComponents()){
            if(o instanceof  JTextField  ){
                ((JTextField) o).setText("");
            }
        }
    }
    public void eliminar(){
        int fila = VentTabla.getSelectedRow();
        dtmVenta.removeRow(fila);
    }

    public void LimpiarCeldas(){
        int filas = dtmVenta.getRowCount();
        for(int i = 0; i< filas;i++){
            dtmVenta.removeRow(0);
        }
    }
    public void GuardarTabla(String Med,String Cant, String Pre){

        dtmVenta.addRow(new Object[]{
              Med,Cant,Pre  });
    }



    public static void main(String[] args) {
        Recepcion Rec = new Recepcion();
    }

    public void Limpiar(){
        int filas = dtmCita.getRowCount();
        for(int i = 0; i< filas;i++){
            dtmCita.removeRow(0);
        }
    }

    //METODO DE EVENTOS
    @Override
    public void actionPerformed(ActionEvent E) {
        //Objeto boton que escucha las acciones de los botones al presionarlos
        Object BotonRG = E.getSource();
        Object RadioBtR = E.getSource();
        Object MenBt = E.getSource();
        Object Modo = E.getSource();
        Object BotonROpci = E.getSource();
        Object BotonRegistrar = E.getSource();
        Object BotonConsultar = E.getSource();
        Object BotonCita = E.getSource();
        Object BotonVenta = E.getSource();
        Object BotonPago = E.getSource();

        if (MenBt instanceof JMenuItem){
            if (MenBt == NuevoR){
                int res = JOptionPane.showConfirmDialog(null,"¿Seguro que quiere crear un nuevo Registro?\nSe borrarán todos los campos introducidos","ADVERTENCIA",JOptionPane.YES_NO_OPTION);
                if(res == 0){
                    detR.vaciar(pnlRegistro);
                    TxtRAlegia.setEnabled(true);
                }

            }else if (MenBt == GuardarR){

            }
        }

        if(Modo instanceof JMenuItem) {
            if (Modo == Claro) {
                modo = 1;

                detR.setMode(modo,panel);
                detR.setMode(modo, pnlIniR);
                detR.setMode(modo, pnlizq);
                BarraModo.setBackground(Color.WHITE);
            }
            if (Modo == Oscuro) {
                modo = 2;

                detR.setMode(modo,panel);
                detR.setMode(modo, pnlIniR);
                detR.setMode(modo, pnlizq);

                BarraModo.setBackground(Color.GRAY);
            }
        }
        int IndicediaR = RComboDay.getSelectedIndex();


            if (IndicediaR == 0) {
                sRDia = "1";
            } else if (IndicediaR == 1) {
                sRDia = "2";
            } else if (IndicediaR == 2) {
                sRDia = "3";
            } else if (IndicediaR == 3) {
                sRDia = "4";
            } else if (IndicediaR == 4) {
                sRDia = "5";
            } else if (IndicediaR == 5) {
                sRDia = "6";
            } else if (IndicediaR == 6) {
                sRDia = "7";
            } else if (IndicediaR == 7) {
                sRDia = "8";
            } else if (IndicediaR == 8) {
                sRDia = "9";
            } else if (IndicediaR == 9) {
                sRDia = "10";
            } else if (IndicediaR == 10) {
                sRDia = "11";
            } else if (IndicediaR == 11) {
                sRDia = "12";
            } else if (IndicediaR == 12) {
                sRDia = "13";
            } else if (IndicediaR == 13) {
                sRDia = "14";
            } else if (IndicediaR == 14) {
                sRDia = "15";
            } else if (IndicediaR == 15) {
                sRDia = "16";
            } else if (IndicediaR == 16) {
                sRDia = "17";
            } else if (IndicediaR == 17) {
                sRDia = "18";
            } else if (IndicediaR == 18) {
                sRDia = "19";
            } else if (IndicediaR == 19) {
                sRDia = "20";
            } else if (IndicediaR == 20) {
                sRDia = "21";
            } else if (IndicediaR == 21) {
                sRDia = "22";
            } else if (IndicediaR == 22) {
                sRDia = "23";
            } else if (IndicediaR == 23) {
                sRDia = "24";
            } else if (IndicediaR == 24) {
                sRDia = "25";
            } else if (IndicediaR == 25) {
                sRDia = "26";
            } else if (IndicediaR == 26) {
                sRDia = "27";
            } else if (IndicediaR == 27) {
                sRDia = "28";
            } else if (IndicediaR == 28) {
                sRDia = "29";
            } else if (IndicediaR == 29) {
                sRDia = "30";
            } else if (IndicediaR == 30) {
                sRDia = "31";
            }


        int IndicemesR = RComboMes.getSelectedIndex();

        if(IndicemesR == 0){
            sRMes = "Enero";
        }else if(IndicemesR == 1){
            sRMes = "Febrero";
        }else if(IndicemesR == 2){
            sRMes = "Marzo";
        }else if(IndicemesR == 3){
            sRMes = "Abril";
        }else if(IndicemesR == 4){
            sRMes = "Mayo";
        }else if(IndicemesR == 5){
            sRMes = "Junio";
        }else if(IndicemesR == 6){
            sRMes = "Julio";
        }else if(IndicemesR == 7){
            sRMes = "Agosto";
        }else if(IndicemesR == 8){
            sRMes = "Septiembre";
        }else if(IndicemesR == 9){
            sRMes = "Octubre";
        }else if(IndicemesR == 10){
            sRMes = "Noviembre";
        }else if(IndicemesR == 11){
            sRMes = "Diciembre";
        }

        if(RadioBtR instanceof  JRadioButton) {
            if (RadioBtR == RBNin) {
                TxtRAlegia.setEnabled(false);
            }
        }
            if (RadioBtR == RBInterY){
                TxtRAZIN.setEnabled(true);
            } else if(RadioBtR == RBInterN){
                TxtRAZIN.setEnabled(false);
            }

            //Si estamos presionando un botón
        if(BotonRG instanceof JButton){
            //Entra a un if anidado, si el boton pulsado es el de iniciar sesión
            if(BotonRG == BtIniciarSR){
                //Entra a unas validaciones
                try{
                    if(TxtUserR.getText().length() != 0){   //Si la caja de texto no está vacía
                        nom = TxtUserR.getText();           //Se obtiene el texto de la caja de texto

                        //Condición para saber si la caja de text o passwordfield no esté vacío
                        if(TxtContraR.getText().length() != 0){
                            Cont = TxtContraR.getText();        //Obtenemos la contraseña y la guardamo en la variable
                            iniciar(nom,Cont);          //Después mandamos a llamar al método para validar el usuario o contraseña
                            detR.setColorR(pnlIniR);
                            detR.setMode(modo, pnlIniR);


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
            }else if(BotonRG == BtRegresarR){
                StartClinic RegIni = new StartClinic();         //Se crea un objeto de la clase StartClinic para mostrar la ventana principal
                RegIni.show();                                  //Se hace visible la ventana
                dispose();                                      //Se oculta la ventana actual para que la siguiente ventana no se empalme
            //Si el botón presionado es CerrarSes
            }else if(BotonRG == CerrSesR){                       //Este botón solo se verá cuando se haya iniciado sesión

                setSize(600,600);                 //La ventana regresa a su tamaño original
                setLocationRelativeTo(null);
                pnlizq.setVisible(true);                        //Se hace visible el panel anterior
                Bot = 0;
                DesBots(Bot);
                //img.setText("Imagen");
                detR.vaciar(pnlizq);
                detR.fondoLogAf(pnlizq);
                BarraModo.setBounds(522,60,42,20);


                P = false; J = false; S = false; C = false;

            } else if(BotonROpci == BtRegisPac){
                Bot = 1;
                DesBots(Bot);
                Registro();
                MostComponentes(Bot);
                detR.setColorR(pnlRegistro);


            } else if(BotonROpci == BtConsultar){

                Bot = 2;
                DesBots(Bot);
                RConsultar();
                MostComponentes(Bot);
                detR.setColorR(pnlRConsulta);

            } else if(BotonROpci == BtCita){
                Bot = 3;
                DesBots(Bot);
                RCita();
                MostComponentes(Bot);
                detR.setColorR(pnlRCita);



            } else if(BotonROpci == BtVentMed){
                Bot = 4;
                DesBots(Bot);
                Venta();
                MostComponentes(Bot);
                detR.setColorR(pnlVenta);

            } else if(BotonROpci == BtPagar){
                Bot = 5;
                DesBots(Bot);
                RPago();
                MostComponentes(Bot);
                detR.setColorR(pnlRPago);
            }


            if(BotonRegistrar == BtRHacerRegis){

                if(TxtRApPat.getText().length() != 0 && TxtRAppMat.getText().length() != 0 && TxtRNomb.getText().length() != 0 && TxtRAño.getText().length() != 0 && TxtRTel.getText().length() != 0 && TxtRPeso.getText().length() != 0 && TxtREsta.getText().length() != 0 && TxtRDirección.getText().length() != 0 && TxtRCurp.getText().length() != 0) {
                    if(TxtRAlegia.getText().length() != 0 || RBNin.isSelected()){
                        if(RBNinguna.isSelected() || RBFibQuis.isSelected() || RBEPOC.isSelected() || RBCrohn.isSelected() || RBCancer.isSelected() || RBAsma.isSelected() || RBArtritis.isSelected() || RBAlzh.isSelected() || RBDiab.isSelected()){
                            if(RBInterY.isSelected() || RBInterN.isSelected()) {
                                try {
                                    sRApMat = TxtRAppMat.getText();
                                    sRApPat = TxtRApPat.getText();
                                    sRNom = TxtRNomb.getText();
                                    sRAño = TxtRAño.getText();
                                    sRAler = TxtRAlegia.getText();
                                    sRPes = TxtRPeso.getText();
                                    sREst = TxtREsta.getText();
                                    sRTel = TxtRTel.getText();
                                    sRCurp = TxtRCurp.getText();
                                    sRDir = TxtRDirección.getText();
                                    sRRazon = TxtRAZIN.getText();

                                    System.out.println("Si");
                                    System.out.println(sRDia);
                                    System.out.println(sRMes);

                                    if (RBInterY.isSelected()) {
                                        sRInter = "Si";
                                    }else if(RBInterN.isSelected()){
                                        sRInter = "No";
                                    }

                                    if (RBNin.isSelected()) {
                                        sRAler = "Ninguna";
                                    }
                                    if (RBNinguna.isSelected()) {

                                        sREnf = "Ninguna";
                                    } else {
                                        sREnf = "|";
                                    }
                                    if (RBFibQuis.isSelected()) {
                                        sREnf1 = "Fibrosis Quistica";
                                    } else {
                                        sREnf1 = "|";
                                    }
                                    if (RBEPOC.isSelected()) {
                                        sREnf2 = "EPOC";
                                    } else {
                                        sREnf2 = "|";
                                    }
                                    if (RBCrohn.isSelected()) {
                                        sREnf3 = "Crohn";
                                    } else {
                                        sREnf3 = "|";
                                    }
                                    if (RBCancer.isSelected()) {
                                        sREnf4 = "Cancer";
                                    } else {
                                        sREnf4 = "|";
                                    }
                                    if (RBAsma.isSelected()) {
                                        sREnf5 = "Asma";
                                    } else {
                                        sREnf5 = "|";
                                    }
                                    if (RBArtritis.isSelected()) {
                                        sREnf6 = "Atritis";
                                    } else {
                                        sREnf6 = "|";
                                    }
                                    if (RBAlzh.isSelected()) {
                                        sREnf7 = "Alzhaimer";
                                    } else {
                                        sREnf7 = "|";
                                    }
                                    if (RBDiab.isSelected()) {
                                        sREnf8 = "Diabetes";
                                    } else {
                                        sREnf8 = "|";
                                    }

                                    iRaño = Integer.parseInt(sRAño);
                                    fRPes = Float.parseFloat(sRPes);
                                    fREsta = Float.parseFloat(sREst);
                                    fRTel = Float.parseFloat(sRTel);

                                    //CALCULAR FECHA DE NACIMIENTO
                                    int fechaNac = AÑO - iRaño;

                                    String edad = String.valueOf(fechaNac);

                                    int res = JOptionPane.showConfirmDialog(null, "¿Desea Registrar en el Sistema?\n", "ADVERTENCIA", JOptionPane.YES_NO_OPTION);
                                    if (res == 0) {

                                        JOptionPane.showMessageDialog(null, "Gracias por Registrarse\nBienvenido a Liberty ");
                                        REGISTROS Inst = new REGISTROS();
                                        //Crear ID
                                        int id = Inst.ID();
                                        Inst.ArchivoSistema(nom, sRApPat, sRApMat, sRNom, sRDia, sRMes, sRAño, edad, sRDir, sRPes, sREst, sRAler, sRTel, sRCurp, sREnf, sREnf1,
                                                sREnf2, sREnf3, sREnf4, sREnf5, sREnf6, sREnf7, sREnf8, sRInter, id);
                                        System.out.println("Dos");

                                        Inst.ArchivoSistemaGENERAL(nom, sRApPat, sRApMat, sRNom, sRDia, sRMes, sRAño, edad, sRDir, sRPes, sREst, sRAler, sRTel, sRCurp, sREnf, sREnf1,
                                                sREnf2, sREnf3, sREnf4, sREnf5, sREnf6, sREnf7, sREnf8, sRInter, id);

                                        Inst.GuardarTabla(sRApPat, sRApMat, sRNom, sRDia, sRMes, sRAño, edad, sRDir, sRPes, sREst, sRAler, sRTel, sRCurp, sREnf, sREnf1,
                                                sREnf2, sREnf3, sREnf4, sREnf5, sREnf6, sREnf7, sREnf8, sRInter, id);
                                        if(sRInter == "Si"){
                                            Inst.ArchivoInternos(nom,sRApPat,sRApMat,sRNom,sRAler, sREnf, sREnf1,
                                                    sREnf2, sREnf3, sREnf4, sREnf5, sREnf6, sREnf7, sREnf8,sRRazon,id);

                                        }
                                        detR.vaciar(pnlRegistro);
                                        TxtRAlegia.setEnabled(true);
                                    }

                                } catch (Exception e) {
                                    JOptionPane.showMessageDialog(null, "Introduce valores correctos");
                                }
                            }else {
                                JOptionPane.showMessageDialog(null, "Introduce si está internado o no");
                            }
                        }else {
                            JOptionPane.showMessageDialog(null, "Introduce si hay Enfermedades Cronicas");
                        }
                    }else {
                        JOptionPane.showMessageDialog(null, "Introduce si hay Alergias");
                    }

                }else {
                    JOptionPane.showMessageDialog(null, "Por favor llena los campos");
                }

            }else if(BotonRegistrar == BtRNOHAYDATOS){

                TxtRApPat.setText("Desconocido");
                TxtRAppMat.setText("Desconocido");
                TxtRNomb.setText("Desconocido");
                TxtRAño.setText("0");
                TxtRAlegia.setText("Desconocido");
                TxtRDirección.setText("Desconocido");
                TxtRPeso.setText("0");
                TxtREsta.setText("0");
                TxtRTel.setText("0");
                TxtRCurp.setText("Desconocido");
                RBNinguna.setSelected(true);
                RBInterY.setSelected(true);
                sRInter = "Si";

            }else if(BotonRegistrar == BtRCancelar){
                ActBots();
                EliComponentes(Bot);
                detR.vaciar(pnlRegistro);
            }


            if(BotonConsultar == CRPerSist){
                REGISTROS Inst = new REGISTROS();
                Inst.AddTabla(1,1,1,nom);

                Inst.show();

            } else if(BotonConsultar == CRHistMed){
                REGISTROS Inst = new REGISTROS();
                Inst.AddTabla(1,1,2,nom);
                Inst.show();

            } else if(BotonConsultar == CRPerInter){
                REGISTROS Inst = new REGISTROS();
                Inst.AddTabla(2,1,1,nom);
                Inst.show();

            } else if(BotonConsultar == CRDispDoc){
                Disponibilidad InsD = new Disponibilidad();
                InsD.MostDisp();

            } else if(BotonConsultar == CREquipMed){
                REGISTROS Inst = new REGISTROS();
                Inst.AddTabla(3,1,1,nom);
                Inst.show();

            } else if(BotonConsultar == CRMedica){
                REGISTROS Inst = new REGISTROS();
                Inst.AddTabla(4,1,1,nom);
                Inst.show();
            } else if (BotonConsultar == CRCanc){
                ActBots();
                EliComponentes(Bot);
                //pnlRConsulta.setVisible(false);

            }



             if(BotonCita == BtDoCit){

                 REGISTROS InstanciaR = new REGISTROS();
                 //Crear ID
                 int id = Integer.parseInt(TxtRCNum.getText());
                 Razon = TxtWhy.getText();
                 int IndiceDoc = ComboRCita.getSelectedIndex();
                 if(IndiceDoc == 0){

                 }else if(IndiceDoc == 1){
                     sDOC = "Doctor General";
                 }else if(IndiceDoc == 2){
                     sDOC = "Oftanmologo";
                 }else if(IndiceDoc == 3){
                     sDOC = "Nutriologo";
                 }else if(IndiceDoc == 4){
                     sDOC = "Cardiologo";
                 }else if(IndiceDoc == 5){
                     sDOC = "Pediatra";
                 }

                 Dia = TxtRCDia.getText();
                 Mes = TxtRCMes.getText();
                 Hora = TxtRCAño.getText();

                     InstanciaR.ArchivoCitas(Razon,id,sDOC,Dia,Mes,Hora,AÑO);
                     InstanciaR.ArchivoCitasGENERAL(Razon,id,sDOC,Dia,Mes,Hora,AÑO);


            }else if(BotonCita == BtCRCancelar){
                ActBots();
                EliComponentes(Bot);

                detR.vaciar(pnlRCita);
                pnlRCita.setVisible(false);
                scrollCR.setVisible(false);

                Limpiar();
            }

            String Med;  String Precios, Pc2;
            String sCant, sCantADD;
            int Prec, finalPrec;
            if(BotonVenta == BtVAddCar){

                if(TxtVMed.getText().length() != 0 && TxtPrecio.getText().length() != 0) {
                    try {
                    Med = TxtVMed.getText();
                    sCantADD = LbVCant.getText();
                    Precios = TxtPrecio.getText();
                    Prec = Integer.parseInt(Precios);
                    if (Cantidad != 0) {
                        finalPrec = Prec * Cantidad;

                        Pc2 = String.valueOf(finalPrec);
                        LbVDin.setText(Pc2);

                        GuardarTabla(Med, sCantADD, String.valueOf(finalPrec));

                        detR.vaciar(pnlRPago);
                        TxtVMed.setText("");
                        LbVCant.setText("0");
                        TxtPrecio.setText("");
                        LbVDin.setText("0");
                    } else {
                        JOptionPane.showMessageDialog(null, "Introduce la cantidad");
                    }
                    }catch (Exception f){
                        JOptionPane.showMessageDialog(null,"Introduce un valor correcto en Precio");
                    }
                }else {
                    JOptionPane.showMessageDialog(null, "Por favor Llena los campos");
                }


            }else if (BotonVenta == BtVplus){
                Cantidad = Cantidad + 1;
                sCant = String.valueOf(Cantidad);
                LbVCant.setText(sCant);

            }else if (BotonVenta == BtVres){
                Cantidad = Cantidad - 1;
                sCant = String.valueOf(Cantidad);
                LbVCant.setText(sCant);

            }else if (BotonVenta == BtVEliCom){
                Cantidad = 0;
                LimpiarCeldas();
                LimpiarCeldas();
                detR.vaciar(pnlRPago);
                TxtVMed.setText("");
                LbVCant.setText("0");
                TxtPrecio.setText("");
                LbVDin.setText("0");

            }else if (BotonVenta == BtVEliEl){
                eliminar();
                Cantidad = 0;
                TxtVMed.setText("");
                LbVCant.setText("0");
                TxtPrecio.setText("");
                LbVDin.setText("0");

            }else if (BotonVenta == BtVCancelar){
                ActBots();
                EliComponentes(Bot);
                detR.vaciar(pnlVenta);
                LimpiarCeldas();

            }else if (BotonVenta == BtVCompra){

                    if(TxtVMed.getText().length() != 0 && TxtPrecio.getText().length() != 0) {
                        try {
                        Med = TxtVMed.getText();
                        sCantADD = LbVCant.getText();
                        Precios = TxtPrecio.getText();
                        Prec = Integer.parseInt(Precios);
                        if (Cantidad != 0) {
                            finalPrec = Prec * Cantidad;
                            REGISTROS instR = new REGISTROS();
                            instR.ArchivoVenta(Med, sCantADD, String.valueOf(finalPrec));
                            instR.ArchivoGeneralPagos(Med, sCantADD, String.valueOf(finalPrec));
                            LimpiarCeldas();
                            detR.vaciar(pnlRPago);
                            Cantidad= 0;
                        } else {
                            JOptionPane.showMessageDialog(null, "Introduce la cantidad");
                        }
                        }catch (Exception f){
                            JOptionPane.showMessageDialog(null,"Introduce un valor correcto en Precio");
                        }
                    }else {
                        JOptionPane.showMessageDialog(null, "Por favor Llena los campos");
                    }
            }

            if(BotonPago == BtPag){
                if(txtidpg.getText().length() != 0 && txtserv.getText().length() != 0 && txtprecio.getText().length() != 0) {
                    try {
                        String sId = txtidpg.getText();
                        String sSer = txtserv.getText();
                        String sPago = txtprecio.getText();
                        float pag = Float.parseFloat(sPago);

                        REGISTROS InsP = new REGISTROS();
                        InsP.ArchivoGeneralPagos(sId, sSer, sPago);
                        detR.vaciar(pnlRPago);
                    }catch (Exception ef){
                        JOptionPane.showMessageDialog(null,"Por favor Introduce un valor númerico en el Pago");
                    }

                }else {
                    JOptionPane.showMessageDialog(null,"Por favor llena los campos");
                }
            }else if(BotonPago == BtPreg){
                Limpiar();
                ActBots();
                EliComponentes(Bot);
                detR.vaciar(pnlRPago);
            }


        }
        repaint();
    }
}
