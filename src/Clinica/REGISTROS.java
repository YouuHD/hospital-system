package Clinica;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.ListModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import java.util.logging.Logger;

public class REGISTROS extends JFrame implements ActionListener {

    DefaultTableModel dtm = new DefaultTableModel();
    final JTable Mitabla = new JTable(dtm);
    JPanel panelREG = new JPanel();
    Detalles detREG = new Detalles();

    FileReader fr = null;
    File archivo = null;
    BufferedReader br = null;

    String [] Nombres;



    public REGISTROS(){

        detREG.setMode(2,panelREG);
        setContentPane(panelREG);


    }

    public void leerTexto(String direccion){
        String cadena, fila[];

        try {
            FileReader lector = new FileReader(direccion);
            BufferedReader lectura = new BufferedReader(lector);
            cadena = lectura.readLine();

            while (cadena != null){
                fila = cadena.split("/");
                dtm.addRow(fila);
                cadena = lectura.readLine();
            }
        }catch (FileNotFoundException ex){
            System.err.println("Error: "+ex);
        }catch (IOException ex){
            System.err.println("Error: "+ex);
        }
    }

    public void mostrarInfo(){
        ListSelectionListener evento = new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if(e.getValueIsAdjusting()){
                    int filaSeleccionada = Mitabla.getSelectedRow();
                    String puesto = (String) dtm.getValueAt(filaSeleccionada, 0);
                    String nombre = (String) dtm.getValueAt(filaSeleccionada, 1);
                    String horasT = (String) dtm.getValueAt(filaSeleccionada, 2);
                    String sueldo = (String) dtm.getValueAt(filaSeleccionada, 3);
                    String bono = (String) dtm.getValueAt(filaSeleccionada, 4);

                    /*
                    txtFPuesto.setText(puesto);
                    txtFNom.setText(nombre);
                    txtFHorasT.setText(horasT);
                    txtFSueldo.setText("/" + sueldo);
                    txtFBono.setText("/" + bono);*/
                }
            }
        };
        Mitabla.getSelectionModel().addListSelectionListener(evento);
    }

    public static void main(String[] args) {
        REGISTROS rg = new REGISTROS();
    }

    public void ArchivoSistema(String NombreUser, String sRApPat, String sRApMat, String sRNom,
                               String sRDia, String sRMes, String sRAño, String sEdad,
                               String  sRDir, String sRPes, String sREst,String sRAler ,String sRTel, String sRCurp, String sREnf, String sREnf1, String sREnf2,
                               String sREnf3, String sREnf4, String sREnf5, String sREnf6, String sREnf7,
                               String sREnf8, String sRInte, int id){
        //crear  fichero
        try{
            FileWriter fw;
            PrintWriter pw;


            //crear ubicacion de archivo
            fw = new FileWriter(""+NombreUser+"RegistrosEnSistema.txt",true);
            //Ingresar datos
            pw = new PrintWriter(fw);
            //ingresar datos
            pw.print(id+" / "+sRApPat+" / "+sRApMat+" / "+sRNom+" / "+sRDia+" / "+sRMes+" / "+sRAño+" / "+sEdad+" / "+sRDir+" / "+sRPes+" / "+sREst+" / "+sRAler+" / "+sRTel+" / "+sRCurp+
                    " / "+sREnf+ sREnf1 + sREnf2 + sREnf3 + sREnf3 + sREnf4 + sREnf5 + sREnf6 + sREnf7 + sREnf8+" / "+sRInte+"\n");


            //liberar memoria
            pw.close();
            //mensaje de exito
            //JOptionPane.showMessageDialog(null, "Datos guardados");


        }catch(Exception ex){
            //mensaje de error
            JOptionPane.showMessageDialog(null,"Datos no guardados");

        }

    }
    public void ArchivoEquipMed(String Producto, String Cant, String Precio){
        //crear  fichero
        try{
            FileWriter fw;
            PrintWriter pw;

            //crear ubicacion de archivo
            fw = new FileWriter("RegistrosEquipMed.txt",true);
            //Ingresar datos
            pw = new PrintWriter(fw);
            //ingresar datos
            pw.print(Producto+" | "+Cant+" | "+Precio+"\n");
            //liberar memoria
            pw.close();
            //mensaje de exito
            //JOptionPane.showMessageDialog(null, "Datos guardados");
        }catch(Exception ex){
            //mensaje de error
            JOptionPane.showMessageDialog(null,"Datos no guardados");
        }
    }

    public void ArchivoMed(String Producto, String Cant, String Precio){
        //crear  fichero
        try{
            FileWriter fw;
            PrintWriter pw;

            //crear ubicacion de archivo
            fw = new FileWriter("RegistrosMedicamento.txt",true);
            //Ingresar datos
            pw = new PrintWriter(fw);
            //ingresar datos
            pw.print(Producto+" | "+Cant+" | "+Precio+"\n");
            //liberar memoria
            pw.close();
            //mensaje de exito
            //JOptionPane.showMessageDialog(null, "Datos guardados");
        }catch(Exception ex){
            //mensaje de error
            JOptionPane.showMessageDialog(null,"Datos no guardados");
        }
    }

    public void ArchivoSistemaGENERAL(String NombreUser, String sRApPat, String sRApMat, String sRNom,
                                      String sRDia, String sRMes, String sRAño, String sEdad,
                                      String  sRDir, String sRPes, String sREst,String sRAler ,String sRTel, String sRCurp, String sREnf, String sREnf1, String sREnf2,
                                      String sREnf3, String sREnf4, String sREnf5, String sREnf6, String sREnf7,
                                      String sREnf8, String sRInte, int id){
        //crear  fichero
        try{
            FileWriter fw;
            PrintWriter pw;

            //crear ubicacion de archivo
            fw = new FileWriter("RegistrosGENERALEnSistema.txt",true);
            //Ingresar datos
            pw = new PrintWriter(fw);
            //ingresar datos
            pw.print(id+" / "+sRApPat+" / "+sRApMat+" / "+sRNom+" / "+sRDia+" / "+sRMes+" / "+sRAño+" / "+sEdad+" / "+sRDir+" / "+sRPes+" / "+sREst+" / "+sRAler+" / "+sRTel+" / "+sRCurp+
                    " / "+sREnf+ sREnf1 + sREnf2 + sREnf3 + sREnf3 + sREnf4 + sREnf5 + sREnf6 + sREnf7 + sREnf8+" / "+sRInte+"\n");

            //liberar memoria
            pw.close();
            //mensaje de exito
            //JOptionPane.showMessageDialog(null, "Datos guardados");
        }catch(Exception ex){
            //mensaje de error
            JOptionPane.showMessageDialog(null,"Datos no guardados");

        }
    }
    public void ArchivoInternos(String NombreUser, String sRApPat, String sRApMat, String sRNom,
                                     String sRAler , String sREnf, String sREnf1, String sREnf2,
                                      String sREnf3, String sREnf4, String sREnf5, String sREnf6, String sREnf7,
                                      String sREnf8, String sRRazon, int id){

        //crear  fichero
        try{
            FileWriter fw;
            PrintWriter pw;

            //crear ubicacion de archivo
            fw = new FileWriter("RegistrosInternos.txt",true);
            //Ingresar datos
            pw = new PrintWriter(fw);
            //ingresar datos
            pw.print(id+" / "+sRApPat+" / "+sRApMat+" / "+sRNom+" / "+sRAler+" / "+sREnf+ sREnf1 + sREnf2 + sREnf3 + sREnf3 + sREnf4 + sREnf5 + sREnf6 + sREnf7 + sREnf8+" / "+sRRazon+"\n");

            //liberar memoria
            pw.close();
            //mensaje de exito
            //JOptionPane.showMessageDialog(null, "Datos guardados");
        }catch(Exception ex){
            //mensaje de error
            JOptionPane.showMessageDialog(null,"Datos no guardados");

        }
    }

    public void ArchivoCitas( String sRRazon, int id, String sDOC, String Dia, String Mes, String Hora, int año){
//Titulo de columnas

        //crear  fichero
        try{
            FileWriter fw;
            PrintWriter pw;

            //crear ubicacion de archivo
            fw = new FileWriter(sDOC+"RegistrosCitas.txt",true);
            //Ingresar datos
            pw = new PrintWriter(fw);
            //ingresar datos
            pw.print(id+" / "+sDOC+" / "+Dia+" / "+Mes+" / "+Hora+" / "+sRRazon+"\n");

            //liberar memoria
            pw.close();
            //mensaje de exito
            //JOptionPane.showMessageDialog(null, "Datos guardados");
        }catch(Exception ex){
            //mensaje de error
            JOptionPane.showMessageDialog(null,"Datos no guardados");

        }
    }
    public void ArchivoCitasGENERAL( String sRRazon, int id, String sDOC, String Dia, String Mes, String Hora, int año){
//Titulo de columnas

        //crear  fichero
        try{
            FileWriter fw;
            PrintWriter pw;

            //crear ubicacion de archivo
            fw = new FileWriter("RegistrosCitas.txt",true);
            //Ingresar datos
            pw = new PrintWriter(fw);
            //ingresar datos
            pw.print(id+" / "+sDOC+" / "+Dia+" / "+Mes+" / "+Hora+" / "+año+" / "+sRRazon+"\n");

            //liberar memoria
            pw.close();
            //mensaje de exito
            //JOptionPane.showMessageDialog(null, "Datos guardados");
        }catch(Exception ex){
            //mensaje de error
            JOptionPane.showMessageDialog(null,"Datos no guardados");

        }
    }
    public void ArchivoGeneralPagos( String sID, String Servicio, String Costo){
//Titulo de columnas

        //crear  fichero
        try{
            FileWriter fw;
            PrintWriter pw;

            //crear ubicacion de archivo
            fw = new FileWriter("RegistrosPagosG.txt",true);
            //Ingresar datos
            pw = new PrintWriter(fw);
            //ingresar datos
            pw.print(sID+" / "+Servicio+" / "+Costo+"\n");

            //liberar memoria
            pw.close();
            //mensaje de exito
            //JOptionPane.showMessageDialog(null, "Datos guardados");
        }catch(Exception ex){
            //mensaje de error
            JOptionPane.showMessageDialog(null,"Datos no guardados");

        }
    }
    public void ArchivoVenta( String sID, String Servicio, String Costo){
//Titulo de columnas

        //crear  fichero
        try{
            FileWriter fw;
            PrintWriter pw;

            //crear ubicacion de archivo
            fw = new FileWriter("RegistrosVenta.txt",true);
            //Ingresar datos
            pw = new PrintWriter(fw);
            //ingresar datos
            pw.print(sID+" / "+Servicio+" / "+Costo+"\n");

            //liberar memoria
            pw.close();
            //mensaje de exito
            //JOptionPane.showMessageDialog(null, "Datos guardados");
        }catch(Exception ex){
            //mensaje de error
            JOptionPane.showMessageDialog(null,"Datos no guardados");

        }
    }
    public void AddTabla(int Tabla, int User, int Archivo, String NombreUser){
        if(Tabla == 1) {
            setSize(1000,600);



            setLocationRelativeTo(null);
            //TABLA DE PERSONAS EN SISTEMA
            //Arreglo de objetos con el contenido de las columnas
            Object[] datos = new Object[5];
            //Tabla con el modelo DefaultTableModel

            JScrollPane scrollPane = new JScrollPane(Mitabla);


            Mitabla.setOpaque(true);
            Mitabla.setBackground(null);
            Mitabla.setBackground(Color.lightGray);

            scrollPane.setOpaque(true);
            scrollPane.setBackground(null);
            scrollPane.setBackground(new Color(192,0,0));
            scrollPane.setForeground(Color.WHITE);

            //Titulo de columnas
            dtm.addColumn("ID");
            dtm.addColumn("Apellido Pat.");
            dtm.addColumn("Apellido Mat.");
            dtm.addColumn("Nombre");
            dtm.addColumn("Dia");
            dtm.addColumn("Mes");
            dtm.addColumn("Año");
            dtm.addColumn("Edad");
            dtm.addColumn("Dirección");
            dtm.addColumn("Peso");
            dtm.addColumn("Estatura");
            dtm.addColumn("Alergia");
            dtm.addColumn("Telefono");
            dtm.addColumn("Curp");
            dtm.addColumn("Enfermedades Crónicas");
            dtm.addColumn("Interno");
            //Tamaño de la tabla
            Mitabla.setBounds(10, 10, 964, 540);
            //Scroll que se agrega a la tabla
            //Agregamos el JScrollPane al contenedor
            scrollPane.setBounds(10, 10, 964, 540);

            if(User == 1){
                Mitabla.setEnabled(false);
                scrollPane.setEnabled(false);
            }else if(User == 2){
                Mitabla.setEnabled(true);
                scrollPane.setEnabled(true);
            }

            if(Archivo == 1) {
                setTitle("Tabla GENERAL de Registros");
                leerTexto("RegistrosGENERALEnSistema.txt");
            }else if (Archivo == 2){
                setTitle("Tabla de Registros de "+NombreUser);
                leerTexto(NombreUser+"RegistrosEnSistema.txt");
            }


            add(scrollPane);
            setLayout(null);

            //pnl.add(Prueba);
        }else if(Tabla == 2){
            setSize(500,500);
            setTitle("Tabla de Internos");
            setLocationRelativeTo(null);
            //Arreglo de objetos con el contenido de las columnas
            Object[] datos = new Object[5];
            //Tabla con el modelo DefaultTableModel

            JScrollPane scrollPane = new JScrollPane(Mitabla);
            //Titulo de columnas
            dtm.addColumn("ID");
            dtm.addColumn("Apellido Pat.");
            dtm.addColumn("Apellido Mat.");
            dtm.addColumn("Nombre");
            dtm.addColumn("Alergias");
            dtm.addColumn("Enfermedades Crónicas");
            dtm.addColumn("Razon");

            //Tamaño de la tabla

            Mitabla.setBounds(10, 10, 465, 441);
            //Scroll que se agrega a la tabla
            //Agregamos el JScrollPane al contenedor
            scrollPane.setBounds(10, 10, 465, 441);

            if(User == 1){
                Mitabla.setEnabled(false);
                scrollPane.setEnabled(false);
            }else if(User == 2){
                Mitabla.setEnabled(true);
                scrollPane.setEnabled(true);
            }


                leerTexto("RegistrosInternos.txt");



            add(scrollPane);
            setLayout(null);

        }else if(Tabla == 3){
            setSize(436,459);
            setTitle("Tabla de Equipamiento medico");
            setLocationRelativeTo(null);
            //Arreglo de objetos con el contenido de las columnas
            Object[] datos = new Object[5];
            //Tabla con el modelo DefaultTableModel

            JScrollPane scrollPane = new JScrollPane(Mitabla);
            //Titulo de columnas
            dtm.addColumn("Producto");
            dtm.addColumn("Cantidad");
            dtm.addColumn("Precio");

            //Tamaño de la tabla

            Mitabla.setBounds(10, 10, 400, 400);
            //Scroll que se agrega a la tabla
            //Agregamos el JScrollPane al contenedor
            scrollPane.setBounds(10, 10, 400, 400);

            leerTexto("RegistrosEquipMed.txt");
            add(scrollPane);
            setLayout(null);

        }else if(Tabla == 4){
            setSize(436,459);
            setTitle("Tabla de Medicamento");
            setLocationRelativeTo(null);
            //Arreglo de objetos con el contenido de las columnas
            Object[] datos = new Object[5];
            //Tabla con el modelo DefaultTableModel

            JScrollPane scrollPane = new JScrollPane(Mitabla);
            //Titulo de columnas
            dtm.addColumn("Producto");
            dtm.addColumn("Cantidad");
            dtm.addColumn("Precio");

            //Tamaño de la tabla

            Mitabla.setBounds(10, 10, 400, 400);
            //Scroll que se agrega a la tabla
            //Agregamos el JScrollPane al contenedor
            scrollPane.setBounds(10, 10, 400, 400);

            leerTexto("RegistrosMedicamento.txt");
            add(scrollPane);
            setLayout(null);

        }else if(Tabla == 5){
            setSize(436,459);
            setLocationRelativeTo(null);
            //Arreglo de objetos con el contenido de las columnas
            Object[] datos = new Object[5];
            //Tabla con el modelo DefaultTableModel

            JScrollPane scrollPane = new JScrollPane(Mitabla);
            //Titulo de columnas
            //Titulo de columnas
            dtm.addColumn("ID");
            dtm.addColumn("Doctor");
            dtm.addColumn("Dia");
            dtm.addColumn("Mes");
            dtm.addColumn("Hora");
            dtm.addColumn("Razon");

            //Tamaño de la tabla

            Mitabla.setBounds(10, 10, 400, 400);
            //Scroll que se agrega a la tabla
            //Agregamos el JScrollPane al contenedor
            scrollPane.setBounds(10, 10, 400, 400);

            leerTexto("RegistrosCitas.txt");

            add(scrollPane);
            setLayout(null);
        }
    }

    public void GuardarTabla(String sRApPat, String sRApMat, String sRNom,
                             String sRDia, String sRMes, String sRAño, String Edad,String sRAler,
                        String  sRDir, String sRPes, String sREst, String sRTel, String sRCurp, String sREnf, String sREnf1, String sREnf2,
                        String sREnf3, String sREnf4, String sREnf5, String sREnf6, String sREnf7,
                        String sREnf8, String sRInter, int ID){

        dtm.addRow(new Object[]{
                ID, sRApPat, sRApMat, sRNom, sRDia,sRMes,sRAño,Edad, sRDir, sRPes, sREst, sRAler ,sRTel, sRCurp,
                 sREnf + sREnf1 + sREnf2 + sREnf3 + sREnf4 + sREnf5 + sREnf6 + sREnf7 + sREnf8, sRInter
        });
    }

    public int ID(){
        try{
            int id = (int)(Math.random()*100000);        //Valores generados

            return id; //Retornamos el arreglo generado

        }catch(Exception e) {       //Impresión por si no se generan los números
            JOptionPane.showMessageDialog(null, "No se Generó el ID\n Reinicie el sistema");
            return 0;
        }
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {

    }
}
