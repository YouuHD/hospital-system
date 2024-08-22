package Clinica;

import javax.swing.*;

public class InicioSesion {
    final String User1 = "Pam"; final String User2 = "Jean"; final String User3 = "Connie"; final String User4 = "Sasha";
    final String ContraR1 = "Panecito"; final String ContraR2 = "Caballo"; final String ContraR3 = "krilin"; final String ContraR4 = "Comida";
    String nom, Cont; boolean P, J, C, S;

    //METODO DE VALIDACIÓN DE USUARIO RECEPCION
    public int iniciarR(String NombreUser, String Cont){
        int obvio = 0;
        //Validar que usuario exista
        if(NombreUser.equals(User1) || NombreUser.equals(User2) || NombreUser.equals(User3) || NombreUser.equals(User4) ) {         //Comparar el texto obtenido con el usuario
            //Condición para saber que usuario es
            if (NombreUser.equals(User1)) {                                //Asignarle true al usuario que es para posteriormente usarlo
                P = true; J = false; C = false; S = false;
            }else if (nom.equals(User2)) {
                P = false; J = true; C = false; S = false;
            } else if (nom.equals(User3)) {
                P = false; J = false; C = true; S = false;
            } else if (nom.equals(User4)) {
                P = false; J = false; C = false; S = true;
            }
            //Validar que la contraseña exista
            if(Cont.equals(ContraR1) || Cont.equals(ContraR2) ||Cont.equals(ContraR3) ||Cont.equals(ContraR4) ) {
                //Comparar las contraseñas con las variables de tipo booleano para iniciar
                if (Cont.equals(ContraR1) && P == true && J == false && C == false && S == false) {
                    JOptionPane.showMessageDialog(null, "Bienvenido " + NombreUser + "");
                    obvio = 1;
                    //AfterLogR(NombreUser);          //Mandar a llamar al método cuando la sesión esté iniciada
                } else if (Cont.equals(ContraR2) && P == false && J == true && C == false && S == false) {
                    JOptionPane.showMessageDialog(null, "Bienvenido " + NombreUser + "");
                    obvio = 1;
                    //AfterLogR(NombreUser);
                } else if (Cont.equals(ContraR3) && P == false && J == false && C == true && S == false) {
                    JOptionPane.showMessageDialog(null, "Bienvenido " + NombreUser + "");
                    obvio = 1;
                    //AfterLogR(NombreUser);
                } else if (Cont.equals(ContraR4) && P == false && J == false && C == false && S == true) {
                    JOptionPane.showMessageDialog(null, "Bienvenido  " + NombreUser + "");
                    obvio = 1;
                    //AfterLogR(NombreUser);

                } else if(Cont.equals(ContraR1) && P == false && J == true && C == false && S == false){
                    JOptionPane.showMessageDialog(null,"Contraseña incorrecta","ERROR",JOptionPane.YES_NO_OPTION);
                    obvio = 2;
                } else if(Cont.equals(ContraR1) && P == false && J == false && C == true && S == false){
                    JOptionPane.showMessageDialog(null,"Contraseña incorrecta","ERROR",JOptionPane.YES_NO_OPTION);
                    obvio = 2;
                } else if(Cont.equals(ContraR1) && P == false && J == false && C == false && S == true){
                    JOptionPane.showMessageDialog(null,"Contraseña incorrecta","ERROR",JOptionPane.YES_NO_OPTION);
                    obvio = 2;

                } else if(Cont.equals(ContraR2) && P == true && J == false && C == false && S == false){
                    JOptionPane.showMessageDialog(null,"Contraseña incorrecta","ERROR",JOptionPane.YES_NO_OPTION);
                    obvio = 2;
                } else if(Cont.equals(ContraR2) && P == false && J == false && C == true && S == false) {
                    JOptionPane.showMessageDialog(null, "Contraseña incorrecta", "ERROR", JOptionPane.YES_NO_OPTION);
                    obvio = 2;
                } else if(Cont.equals(ContraR2) && P == false && J == false && C == false && S == true) {
                    JOptionPane.showMessageDialog(null, "Contraseña incorrecta", "ERROR", JOptionPane.YES_NO_OPTION);
                    obvio = 2;

                } else if(Cont.equals(ContraR3) && P == true && J == false && C == false && S == false) {
                    JOptionPane.showMessageDialog(null, "Contraseña incorrecta", "ERROR", JOptionPane.YES_NO_OPTION);
                    obvio = 2;
                } else if(Cont.equals(ContraR3) && P == false && J == true && C == false && S == false) {
                    JOptionPane.showMessageDialog(null, "Contraseña incorrecta", "ERROR", JOptionPane.YES_NO_OPTION);
                    obvio = 2;
                } else if(Cont.equals(ContraR3) && P == false && J == false && C == false && S == true) {
                    JOptionPane.showMessageDialog(null, "Contraseña incorrecta", "ERROR", JOptionPane.YES_NO_OPTION);
                    obvio = 2;
                } else if(Cont.equals(ContraR4) && P == true && J == false && C == false && S == false) {
                    JOptionPane.showMessageDialog(null, "Contraseña incorrecta", "ERROR", JOptionPane.YES_NO_OPTION);
                    obvio = 2;
                } else if(Cont.equals(ContraR4) && P == false && J == true && C == false && S == false) {
                    JOptionPane.showMessageDialog(null, "Contraseña incorrecta", "ERROR", JOptionPane.YES_NO_OPTION);
                    obvio = 2;
                } else if(Cont.equals(ContraR4) && P == false && J == false && C == true && S == false) {
                    JOptionPane.showMessageDialog(null, "Contraseña incorrecta", "ERROR", JOptionPane.YES_NO_OPTION);
                    obvio = 2;
                }
            }else {
                System.out.println("efe");
                JOptionPane.showMessageDialog(null,"Contraseña incorrecta","ERROR",JOptionPane.YES_NO_OPTION);
            }
            //}
        }else {
            JOptionPane.showMessageDialog(null,"El usuario "+NombreUser+" no existe");
        }
        return obvio;
    }
}
