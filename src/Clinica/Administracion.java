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

public class Administracion extends JFrame implements ActionListener {

    JPanel panelA = new JPanel();
    JPanel pnlSupA = new JPanel();
    JPanel pnlizqA = new JPanel();
    Detalles detA = new Detalles();

    int AÑO;
    //Modo oscuro/claro
    int modo;

    JMenuBar BarraModo = new JMenuBar();
    JMenu Mode = new JMenu("Modo");
    JMenuItem Claro = new JMenuItem("Claro");
    JMenuItem Oscuro = new JMenuItem("Oscuro");

    //Componentes de Inicio sesión
    JButton BtIniciarSA = new JButton("Iniciar Sesión");
    JButton BtRegresarA = new JButton("Regresar");
    JTextField TxtUserA = new JTextField();
    JPasswordField TxtContraA = new JPasswordField();
    JLabel LbUserA = new JLabel("Usuario");
    JLabel LbUserA2 = new JLabel("Usuario");
    JLabel LbContraA = new JLabel("Contraseña");
    JLabel LbInicioA = new JLabel("Inicio de Sesión");
    JButton CerrSesA = new JButton("Cerrar sesión");

    //Parametros de inicio de sesión
    final String UserAdmin = "youuhd";
    final String ContraAdmin = "youuhd";
    String nom, Cont; boolean P, J, C, S;
    JLabel SesIniA = new JLabel();
    JPanel pnlIniA = new JPanel();
    ImageIcon logo = new ImageIcon("Icons/LOGO.png");
    JLabel img = new JLabel(logo);

    JButton BtConsultarA = new JButton("Consultar");
    JButton BtInventario = new JButton("Conferencia");
    JButton BtGanancia = new JButton("Ganancias");

    int Bot = 0;


    JMenuItem NuevoR = new JMenuItem("Nuevo");
    JMenuItem GuardarR = new JMenuItem("Registrar");


    //Consultar
    JPanel pnlAConsulta = new JPanel();

    JLabel LbAConsulta = new JLabel("Consulta");

    JButton CAPerSist = new JButton("Personas en el sistema");
    JButton CAHistMed = new JButton("Citas");
    JButton CAPerInter = new JButton("Personas internadas");
    JButton CADispDoc = new JButton("Disponibilidad del Doctor");
    JButton CAEquipMed = new JButton("Equipamiento médico");
    JButton CAMedica = new JButton("Medicamento");
    JButton CACanc = new JButton("Cancelar");

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


    //Inventario
    JPanel pnlAInventario = new JPanel();

    JLabel LbAInv = new JLabel("Inventario");
    JLabel LbASelecciona = new JLabel("Selecciona un opción");

    String [] sInv = {"Selecciona","Equpamiento","Medicamento"};
    JComboBox inv = new JComboBox(sInv);



    JButton BtEquipMed = new JButton("Guardar");

    JButton BtCancelar = new JButton("Cancelar");

    //GANANCIA
    JPanel pnlGanancia = new JPanel();

    JLabel LbGanancia = new JLabel("Ganancias");

    JLabel LbVTotal = new JLabel("Total: $");
    JLabel LbVMXN = new JLabel("MXN");
    JLabel LbVDin = new JLabel("0");
    JLabel LbVCant = new JLabel("0");

    JButton BtVCancelar = new JButton("Regresar");

    DefaultTableModel dtmA = new DefaultTableModel();
    JTable VentTabla = new JTable(dtmA);

    JScrollPane scrollC = new JScrollPane(VentTabla);

    public Administracion(){
        //Creación de la ventana
        super("Administración");
        //Asignación de tamaño
        setSize(600,600);
        //Asignación de que se cierre el programa al presionar el botón de cerrar
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //Asignación de la localización de la ventana, que esté en el centro
        setLocationRelativeTo(null);
        //Hacer que la ventana no cambie de tamaño
        setResizable(false);

        //INICIO DE SESION
        BtIniciarSA.addActionListener(this);
        BtRegresarA.addActionListener(this);
        CerrSesA.addActionListener(this);

        //ACCIONES DE USUARIO
        BtConsultarA.addActionListener(this);
        BtInventario.addActionListener(this);
        BtGanancia.addActionListener(this);

        NuevoR.addActionListener(this);
        GuardarR.addActionListener(this);

        //CONSULTAR
        CAPerSist.addActionListener(this);
        CAHistMed.addActionListener(this);
        CAPerInter.addActionListener(this);
        CADispDoc.addActionListener(this);
        CAEquipMed.addActionListener(this);
        CAMedica.addActionListener(this);
        CACanc.addActionListener(this);

        //INVENTARIO
        BtEquipMed.addActionListener(this);
        BtCRCancelar.addActionListener(this);

        //Conferencia
        BtDoConf.addActionListener(this);
        BtCamara.addActionListener(this);
        BtMicro.addActionListener(this);
        BtCancelar.addActionListener(this);

        //GANANCIA
        BtVCancelar.addActionListener(this);

        //Modo
        Claro.addActionListener(this);
        Oscuro.addActionListener(this);

        Mode.add(Claro);
        Mode.addSeparator();
        Mode.add(Oscuro);
        BarraModo.add(Mode);
        pnlSupA.add(BarraModo);

        addPanels();
        InicioSesA();

        //Titulo de columnas
        dtmA.addColumn("ID");
        dtmA.addColumn("Servicio");
        dtmA.addColumn("Costo");

        scrollC.setBounds(20,60,403,250);

        pnlGanancia.add(scrollC);

        pnlGanancia.setVisible(false);
        scrollC.setVisible(false);

        BarraModo.setBounds(522,60,42,20);
        BarraModo.setBorderPainted(false);
        AÑO = detA.Fecha(pnlSupA);


        detA.setColorR(pnlizqA);
        detA.setColorPane(panelA,pnlSupA);

        setContentPane(panelA);
        setVisible(true);
    }



    public void Ganancia(){

        pnlGanancia.setVisible(true);

        pnlGanancia.setLayout(null);
        img.setVisible(false);

        detA.setColorR(pnlGanancia);

        leerTexto("RegistrosPagosG.txt");


        Sumar();

        pnlGanancia.setBounds(220,120,443,421);
        LbGanancia.setBounds(200,20,150,30);

        LbVCant.setBounds(180,390,150,20);

        VentTabla.setBounds(20,60,403,250);
        BtVCancelar.setBounds(20,380,100,30);
        LbVTotal.setBounds(127,390,100,20);
        LbVMXN.setBounds(227,390,100,20);

        scrollC.setVisible(true);

        pnlGanancia.add(LbGanancia);
        pnlGanancia.add(LbVCant);
        //pnlGanancia.add(VentTabla);
        pnlGanancia.add(LbVTotal);
        pnlGanancia.add(LbVMXN);
        pnlGanancia.add(BtVCancelar);



        panelA.add(pnlGanancia);

    }

    public void MostComponentes(int Bot){
        if(Bot == 1) {

        }if(Bot == 2) {
            for (Object o : pnlAConsulta.getComponents()) {
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
                }if (o instanceof JScrollPane) {
                    ((JScrollPane) o).setVisible(true);
                }if (o instanceof JTable) {
                    ((JTable) o).setVisible(true);
                }
            }
            pnlAConsulta.setVisible(true);
        }if(Bot == 3) {
            for (Object o : pnlAInventario.getComponents()) {
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
            pnlAInventario.setVisible(true);
        }if(Bot == 4) {
            for (Object o : pnlGanancia.getComponents()) {
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
            pnlGanancia.setVisible(true);
        }

        img.setVisible(false);

    }

    public void EliComponentes(int Bot){
        if(Bot == 1) {

        }if(Bot == 2) {
            for (Object o : pnlAConsulta.getComponents()) {
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
                }if (o instanceof JScrollPane) {
                    ((JScrollPane) o).setVisible(false);
                }if (o instanceof JTable) {
                    ((JTable) o).setVisible(false);
                }

            }
            pnlAConsulta.setVisible(false);
        }if(Bot == 3) {
            for (Object o : pnlAInventario.getComponents()) {
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
            pnlAInventario.setVisible(false);
        }if(Bot == 4) {
            for (Object o : pnlGanancia.getComponents()) {
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
                }/*if (o instanceof JScrollPane) {
                    ((JScrollPane) o).setVisible(false);
                }*/
            }
            pnlGanancia.setVisible(false);
        }
        img.setVisible(true);

    }
    public void leerTexto(String direccion){
        String cadena, fila[];

        try {
            FileReader lector = new FileReader(direccion);
            BufferedReader lectura = new BufferedReader(lector);
            cadena = lectura.readLine();

            while (cadena != null){
                fila = cadena.split("/");
                dtmA.addRow(fila);
                cadena = lectura.readLine();
            }
        }catch (FileNotFoundException ex){
            System.err.println("Error: "+ex);
        }catch (IOException ex){
            System.err.println("Error: "+ex);
        }
    }


    public void AInventario() {
        cam = 1;
        mic = 1;

        pnlAInventario.setLayout(null);

        detA.setColorR(pnlAInventario);

        pnlAInventario.setBounds(220,120,443,421);
        LbDConf.setBounds(200,20,150,30);
        LbDSelecciona.setBounds(20,100,150,20);
        LbDCRazon.setBounds(20,130,150,20);
        VC.setBounds(200,100,110,20);
        TxtWhy.setBounds(200,130,110,20);
        BtDoConf.setBounds(20,370,150,30);
        BtCancelar.setBounds(204,370,150,30);
        pnlCamara.setBounds(20,180,288,160);
        BtCamara.setBounds(324,220,30,30);
        BtMicro.setBounds(324,260,30,30);
        pnlCamara.setBackground(Color.cyan);

        pnlCamara.add(micro);
        pnlCamara.add(esperando);

        pnlAInventario.add(LbDConf);
        pnlAInventario.add(LbDSelecciona);
        pnlAInventario.add(LbDCRazon);
        pnlAInventario.add(VC);
        pnlAInventario.add(BtDoConf);
        pnlAInventario.add(BtCancelar);
        pnlAInventario.add(TxtWhy);
        pnlAInventario.add(ComboRCita);
        pnlAInventario.add(pnlCamara);
        pnlAInventario.add(BtCamara);
        pnlAInventario.add(BtMicro);

        BtCamara.setBorderPainted(false);
        BtMicro.setBorderPainted(false);

        BtCamara.setIcon(cama);
        BtMicro.setIcon(microf);

        micro.setVisible(true);
        pnlCamara.setVisible(true);

        panelA.add(pnlAInventario);

    }
    public void AConsultar(){

        //pnlAConsulta.setVisible(true);
        pnlAConsulta.setLayout(null);

        detA.setColorR(pnlAConsulta);



        LbAConsulta.setBounds(200,20,150,30);
        pnlAConsulta.setBounds(220,120,443,421);
        CAPerSist.setBounds(120,80,200,40);
        CAPerInter.setBounds(120,130,200,40);
        CAHistMed.setBounds(120,180,200,40);
        CADispDoc.setBounds(120,230,200,40);
        CACanc.setBounds(340,380,100,30);

       // scrollC.setVisible(true);

        pnlAConsulta.add(CAPerSist);
        pnlAConsulta.add(CAPerInter);
        pnlAConsulta.add(CAHistMed);
        pnlAConsulta.add(CADispDoc);
        pnlAConsulta.add(CACanc);
        pnlAConsulta.add(LbAConsulta);
        panelA.add(pnlAConsulta);

    }

    public void InicioSesA(){
        pnlizqA.setLayout(null);
        detA.fondoLogAf(pnlizqA);

        LbInicioA.setBounds(50,20,150,20);
        LbUserA.setBounds(20,50,150,20);
        LbContraA.setBounds(20,100,150,20);
        TxtUserA.setBounds(20,70,160,20);
        TxtContraA.setBounds(20,120,160,20);
        BtIniciarSA.setBounds(20,165,160,30);
        BtRegresarA.setBounds(20,400,160,30);

        img.setBounds(220,100,350,350);
        panelA.add(img);

        pnlizqA.add(LbInicioA);
        pnlizqA.add(LbUserA);
        pnlizqA.add(LbContraA);
        pnlizqA.add(TxtUserA);
        pnlizqA.add(TxtContraA);
        pnlizqA.add(BtIniciarSA);
        pnlizqA.add(BtRegresarA);

        //CAMBIAR DE LADOO
        detA.setColorPanePlane(pnlAConsulta,6);
        detA.setColorPanePlane(pnlAInventario,6);
        detA.setColorPanePlane(pnlGanancia,6);
    }

    public void addPanels(){
        panelA.setLayout(null);

        pnlSupA.setLayout(null);

        pnlSupA.setBounds(0,0,900,100);
        pnlSupA.setBackground(Color.cyan);

        pnlizqA.setBounds(0,100,200,500);

        panelA.add(pnlSupA);
        panelA.add(pnlizqA);

    }

    //METODO DE VALIDACIÓN DE USUARIO
    public void iniciar(String NombreUser, String Cont) {
        //Validar que usuario exista
        if (NombreUser.equals(UserAdmin)) {         //Comparar el texto obtenido con el usuario
            //Condición para saber que usuario es
                //Validar que la contraseña exista
                if (Cont.equals(ContraAdmin)) {
                    JOptionPane.showMessageDialog(null, "Bienvenido Administrador "+NombreUser );
                    AfterLogR(NombreUser);
                } else {
                    JOptionPane.showMessageDialog(null, "Contraseña incorrecta ");
                }
        }else {
            JOptionPane.showMessageDialog(null, "El usuario " + NombreUser + " no existe");
        }
    }

    public void AfterLogR(String UserR){

        pnlIniA.setLayout(null);
        BarraModo.setBounds(620,60,42,20);

        detA.setColorR(pnlIniA);
        detA.fondoLogAf(pnlIniA);

        JLabel Recept = new JLabel("Administrador");


        pnlIniA.setBounds(0,100,200,500);

        setSize(700,600);
        setLocationRelativeTo(null);

        JLabel LbInicioRAct = new JLabel("Sesión activa");
        JLabel Acc = new JLabel("Acciones");


        SesIniA.setText(UserR);

        Acc.setBounds(20, 130,160,20);
        //BtRegisPac.setBounds(20, 160,160,30);
        BtConsultarA.setBounds(20,200,160,30);
        BtInventario.setBounds(20,240,160,30);
        BtGanancia.setBounds(20,280,160,30);
        //BtPagarEm.setBounds(20,320,160,30);

        LbUserA2.setBounds(20,50,160,20);
        LbInicioRAct.setBounds(50,20,160,20);
        SesIniA.setBounds(20,80,160,20);
        CerrSesA.setBounds(20,400,160,30);
        Recept.setBounds(20, 100,160,20);

        CerrSesA.setVisible(true);

        //img.setText("ImagenINICIO");

        pnlizqA.setVisible(false);

        pnlIniA.add(BtConsultarA);
        pnlIniA.add(BtInventario);
        pnlIniA.add(LbUserA2);
        pnlIniA.add(LbInicioRAct);
        pnlIniA.add(SesIniA);
        pnlIniA.add(CerrSesA);
        pnlIniA.add(BtGanancia);

        BtConsultarA.setVisible(true);
        BtInventario.setVisible(true);
        BtGanancia.setVisible(true);
        CerrSesA.setVisible(true);

        pnlIniA.add(Recept);

        panelA.add(pnlIniA);
    }

    public void DesBots(int Bot){
        if(Bot == 0){
            CerrSesA.setVisible(false);                     //El botón deja de ser visile
            BtConsultarA.setVisible(false);
            BtInventario.setVisible(false);
            BtGanancia.setVisible(false);
        } else if(Bot == 1){
            BtConsultarA.setEnabled(false);
            BtConsultarA.setEnabled(false);
            BtGanancia.setEnabled(false);
            CerrSesA.setEnabled(false);
        } else if(Bot == 2){

            BtGanancia.setEnabled(false);
            BtInventario.setEnabled(false);
            CerrSesA.setEnabled(false);
        } else if(Bot == 3){
            BtConsultarA.setEnabled(false);
            BtGanancia.setEnabled(false);
            CerrSesA.setEnabled(false);
        } else if(Bot == 4){
            BtConsultarA.setEnabled(false);
            BtInventario.setEnabled(false);
            CerrSesA.setEnabled(false);
        }
    }

    public void ActBots(){

        BtConsultarA.setEnabled(true);
        BtInventario.setEnabled(true);
        BtGanancia.setEnabled(true);
        CerrSesA.setEnabled(true);
    }
    public void Limpiar(){
        int filas = dtmA.getRowCount();
        for(int i = 0; i< filas;i++){
            dtmA.removeRow(0);
        }
    }

    public void Sumar(){
        int fila = 0, total = 0;
        float IntVal = 0;
        fila = dtmA.getRowCount();
        String Valores;
        for(int i = 0; i< fila; i++){
            String val = (String) dtmA.getValueAt(i,2);
            //total += fila;
            IntVal += Float.parseFloat(val);
            Valores = String.valueOf(IntVal);
            LbVCant.setText(Valores);
        }

    }


    public static void main(String[] args) {
        Administracion admin = new Administracion();
    }

    //METODO DE EVENTOS
    @Override
    public void actionPerformed(ActionEvent E) {
        //Objeto boton que escucha las acciones de los botones al presionarlos
        Object BotonAd = E.getSource();
        Object RadioBtR = E.getSource();
        Object MenBt = E.getSource();
        Object ModoA = E.getSource();
        Object BotonROpci = E.getSource();
        Object BotonRegistrar = E.getSource();
        Object BotonConsultar = E.getSource();
        Object BotonInv = E.getSource();
        Object BotonGan = E.getSource();
        int indiDoc = VC.getSelectedIndex();

        if(ModoA instanceof JMenuItem) {
            if (ModoA == Claro) {
                modo = 1;

                detA.setMode(modo,panelA);
                detA.setMode(modo, pnlIniA);
                detA.setMode(modo, pnlizqA);
                BarraModo.setBackground(Color.WHITE);
            }
            if (ModoA == Oscuro) {
                modo = 2;

                detA.setMode(modo,panelA);
                detA.setMode(modo, pnlIniA);
                detA.setMode(modo, pnlizqA);

                BarraModo.setBackground(Color.GRAY);
            }
        }


        //Si estamos presionando un botón
        if(BotonAd instanceof JButton){
            //Entra a un if anidado, si el boton pulsado es el de iniciar sesión
            if(BotonAd == BtIniciarSA){
                //Entra a unas validaciones
                try{
                    if(TxtUserA.getText().length() != 0){   //Si la caja de texto no está vacía
                        nom = TxtUserA.getText();           //Se obtiene el texto de la caja de texto

                        //Condición para saber si la caja de text o passwordfield no esté vacío
                        if(TxtContraA.getText().length() != 0){
                            Cont = TxtContraA.getText();        //Obtenemos la contraseña y la guardamo en la variable
                            iniciar(nom,Cont);          //Después mandamos a llamar al método para validar el usuario o contraseña

                            detA.setColorR(pnlIniA);
                            detA.setMode(modo, pnlIniA);

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
            }else if(BotonAd == BtRegresarA){
                StartClinic RegIni = new StartClinic();         //Se crea un objeto de la clase StartClinic para mostrar la ventana principal
                RegIni.show();                                  //Se hace visible la ventana
                dispose();                                      //Se oculta la ventana actual para que la siguiente ventana no se empalme
                //Si el botón presionado es CerrarSes
            }else if(BotonAd == CerrSesA){                       //Este botón solo se verá cuando se haya iniciado sesión

                setSize(600,600);                 //La ventana regresa a su tamaño original
                setLocationRelativeTo(null);
                pnlizqA.setVisible(true);                        //Se hace visible el panel anterior
                detA.fondoLogAf(pnlizqA);
                Bot = 0;
                DesBots(Bot);

                img.setText("Imagen");

                //Este ciclo for ayuda a que se vacien los campos y volver a iniciar sesión
                for(Object o: pnlizqA.getComponents()){
                    if(o instanceof  JTextField  ){
                        ((JTextField) o).setText("");
                        TxtContraA.setText("");
                        TxtUserA.setText("");
                    }
                }

            }
            if(BotonROpci == BtConsultarA){

                Bot = 2;
                DesBots(Bot);
                AConsultar();
                MostComponentes(Bot);
                detA.setColorR(pnlAConsulta);
            } else if(BotonROpci == BtInventario){
                Bot = 3;
                DesBots(Bot);
                AInventario();
                MostComponentes(Bot);
                detA.setColorR(pnlAInventario);
            } else if(BotonROpci == BtGanancia){
                Bot = 4;
                DesBots(Bot);
                Ganancia();
                MostComponentes(Bot);
                detA.setColorR(pnlGanancia);

                System.out.println("hola");
            }

            if(BotonConsultar == CAPerSist){
                REGISTROS Insta = new REGISTROS();
                Insta.AddTabla(1,2,1,nom);
                Insta.show();
            } else if(BotonConsultar == CAHistMed){
                REGISTROS Insta = new REGISTROS();
                Insta.AddTabla(5,2,1,nom);
                Insta.show();
            } else if(BotonConsultar == CAPerInter){
                REGISTROS Insta = new REGISTROS();
                Insta.AddTabla(2,2,1,nom);
                Insta.show();
            } else if(BotonConsultar == CADispDoc){
                Disponibilidad dispo = new Disponibilidad();
                dispo.MostDisp();

            } else if(BotonConsultar == CAEquipMed){
                REGISTROS Insta = new REGISTROS();
                Insta.AddTabla(3,2,1,nom);
                Insta.show();
            } else if(BotonConsultar == CAMedica){
                REGISTROS Insta = new REGISTROS();
                Insta.AddTabla(4,2,1,nom);
                Insta.show();
            } else if (BotonConsultar == CACanc){
                ActBots();
                EliComponentes(Bot);
            }


            if(BotonInv == BtCamara){

                if(cam == 1) {
                    pnlCamara.setBackground(Color.DARK_GRAY);
                    esperando.setVisible(false);
                    cam = 0;
                }else {
                    pnlCamara.setBackground(Color.cyan);

                    esperando.setVisible(true);
                    cam = 1;
                }
            }else if(BotonInv == BtMicro){
                if(mic == 1) {

                    micro.setVisible(false);
                    mic = 0;
                }else {

                    micro.setVisible(true);
                    mic = 1;
                }

            }else if(BotonInv == BtDoConf){
                if(TxtWhy.getText().length() != 0) {
                    if(indiDoc != 0) {
                        JOptionPane.showMessageDialog(null, "Esperando al Receptor...");
                    }else {
                        JOptionPane.showMessageDialog(null, "Selecciona un receptor");
                    }
                }else {
                    JOptionPane.showMessageDialog(null, "Introduce un motivo para la conferencia");
                }
            }else if(BotonInv == BtCancelar){
                ActBots();
                EliComponentes(Bot);
            }

            if(BotonInv == BtEquipMed){

            }else if(BotonInv == BtCRCancelar){
                ActBots();
                EliComponentes(Bot);
            }

            }if (BotonGan == BtVCancelar){
            ActBots();
            EliComponentes(Bot);
            Limpiar();

        }
        repaint();
    }
}
