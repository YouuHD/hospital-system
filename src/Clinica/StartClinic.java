/**
 *  Proyecto Unidad 1: Clinica
 *  Autor/Estudiante: Luis Daniel Payan Rivera
    Numero de control: 19041235
    Clase: Tópicos Avanzados de Programación
    Maestro: Anibal

 */
package Clinica;            //Paquete Clinica que contiene todas las clases del sistema
//Importaciones de librerias
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//Clase principal
public class StartClinic extends JFrame implements ActionListener {

    JPanel pnl = new JPanel();

    ImageIcon Logo = new ImageIcon("Icons/Start.png");
    ImageIcon Imgs = new ImageIcon();

    /*JLabel LbLogo = new JLabel(Logo);
    JLabel LbImg = new JLabel(Imgs);*/

    JLabel LbLogo = new JLabel(Logo);
    //JLabel LbImg = new JLabel("Imgs");

    JButton BtRececion = new JButton("Recepción");
    JButton BtDoctor = new JButton("Doctor");
    JButton BtAdministración = new JButton("Administración");
    JButton BtCerrarApp = new JButton("Cerrar");

    int tam;

    Detalles detalles = new Detalles();

    //Constructor
    public StartClinic(){

        //Creación de la ventana
        super("Clinica Liberty ");
        //Asignación de tamaño
        setSize(326,350);
        //Asignación de que se cierre el programa al presionar el botón de cerrar
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //Asignación de la localización de la ventana, que esté en el centro
        setLocationRelativeTo(null);
        //Hacer que la ventana no cambie de tamaño
        setResizable(false);

        //Hacer que los botones se escuchen al presionarlos
        BtRececion.addActionListener(this);
        BtDoctor.addActionListener(this);
        BtAdministración.addActionListener(this);
        BtCerrarApp.addActionListener(this);


        //Mandar a llamar al metodo de añadir componentes
        addComponents();

        detalles.setColorR(pnl);
        tam = 18;
        detalles.setFont(pnl,tam);

        setContentPane(pnl);
        setVisible(true);
    }
    //METODO PARA AÑADIR LOS COMPONENTES Y DARLES SUS COORDENADAS
    public void addComponents(){
        //Quitarle el diseño al panel para poder utilizar el setBounds y darle coordenadas a los componentes
        pnl.setLayout(null);

        //ASIGNACIÓN DE COORDENADAS PARA LOS COMPONENTES

        LbLogo.setBounds(-10,-20,326, 350);      //Coordenadas del Label del logo
        //LbImg.setBounds(0,250,100,50);      //Coordenadas del Label de la imagen

        BtRececion.setBounds(130,80,180,40);            //Coordenadas del botón recepción
        BtDoctor.setBounds(130,140,180,40);             //Coordenadas del botón doctor
        BtAdministración.setBounds(130,200,180,40);     //Coordenadas del botón administración
        BtCerrarApp.setBounds(130,260,180,40);          //Coordenadas del boton Cerrar

        //AÑADIR COMPONENTES AL PANEL
        pnl.add(LbLogo);        //Añadiendo Label logo al panel
        //pnl.add(LbImg);         //Añadiendo Label imagen al panel

        pnl.add(BtRececion);            //Añadiendo el botón recepción al panel
        pnl.add(BtDoctor);              //Añadiendo el botón doctor al panel
        pnl.add(BtAdministración);      //Añadiendo el botón administración al panel
        pnl.add(BtCerrarApp);
    }




    //METODO DE EVENTOS
    @Override
    public void actionPerformed(ActionEvent actionEvent) {

        Object Boton = actionEvent.getSource();

        if(Boton instanceof JButton){
            if(Boton == BtRececion){
                Recepcion InstRecp = new Recepcion();
                InstRecp.show();
                dispose();
            }
            else if(Boton == BtDoctor){
                Doctor InstDoc = new Doctor();
                InstDoc.show();
                dispose();
            }
            else if(Boton == BtAdministración){
                Administracion InstAdmin = new Administracion();
                InstAdmin.show();
                dispose();
            }
            else if(Boton == BtCerrarApp){
                int Resp = JOptionPane.showConfirmDialog(null,"¿Estás seguro de querer salir?","ADVERTENCIA",JOptionPane.YES_NO_OPTION);
                if(Resp == 0){
                    System.exit(0);
                }
            }
        }

    }

    public static void main(String[] args) {
        StartClinic Inicio = new StartClinic();
    }
}
