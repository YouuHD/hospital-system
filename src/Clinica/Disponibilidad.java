package Clinica;

import javax.swing.*;

public class Disponibilidad {
    String DisponibilidadL = "No ha iniciado";
    String DisponibilidadH = "No ha iniciado";
    String DisponibilidadM = "No ha iniciado";
    String DisponibilidadE = "No ha iniciado";
    String DisponibilidadA = "No ha iniciado";

    public void Disp(int dis,boolean L, boolean H,boolean M,boolean E, boolean A){

        if(L == true){
            if(dis == 1){
                DisponibilidadL = "Disponible";
            }else if(dis == 2){
                DisponibilidadL = "en Ausente";
            }else if(dis == 3){
                DisponibilidadL = "en Consulta";
            }else if(dis == 4){
                DisponibilidadL = "en Emergencia";
            }
            JOptionPane.showMessageDialog(null,"Disponibilidad cambiada con Exito\nEstado: "+DisponibilidadL);
        }else if(H == true){
            if(dis == 1){
                DisponibilidadH = "Disponible";
            }else if(dis == 2){
                DisponibilidadH = "en Ausente";
            }else if(dis == 3){
                DisponibilidadH = "en Consulta";
            }else if(dis == 4){
                DisponibilidadH = "en Emergencia";
            }
            JOptionPane.showMessageDialog(null,"Disponibilidad cambiada con Exito\nEstado: "+DisponibilidadH);
        }else if(M == true){
            if(dis == 1){
                DisponibilidadM = "Disponible";
            }else if(dis == 2){
                DisponibilidadM = "en Ausente";
            }else if(dis == 3){
                DisponibilidadM = "en Consulta";
            }else if(dis == 4){
                DisponibilidadM = "en Emergencia";
            }

            JOptionPane.showMessageDialog(null,"Disponibilidad cambiada con Exito\nEstado: "+DisponibilidadM);
        }else if (E == true){
            if(dis == 1){
                DisponibilidadE = "Disponible";
            }else if(dis == 2){
                DisponibilidadE = "en Ausente";
            }else if(dis == 3){
                DisponibilidadE = "en Consulta";
            }else if(dis == 4){
                DisponibilidadE = "en Emergencia";
            }
            JOptionPane.showMessageDialog(null,"Disponibilidad cambiada con Exito\nEstado: "+DisponibilidadE);
        }else if(A == true ){
            if(dis == 1){
                DisponibilidadA = "Disponible";
            }else if(dis == 2){
                DisponibilidadA = "en Ausente";
            }else if(dis == 3){
                DisponibilidadA = "en Consulta";
            }else if(dis == 4){
                DisponibilidadA = "en Emergencia";
            }
            JOptionPane.showMessageDialog(null,"Disponibilidad cambiada con Exito\nEstado: "+DisponibilidadA);
        }
    }

    public void MostDisp(){

                JOptionPane.showMessageDialog(null,"-*-*-*-*-* Disponibilidad *-*-*-*-*-\n\n" +
                        "Doctor General Levi "+DisponibilidadL+"\nOftanmologo Hanjie "+DisponibilidadH+
                        "\nNutriologa Mikasa "+DisponibilidadM+"\nCardiologo Eren "+DisponibilidadE+"\nPediatra Armin "+DisponibilidadA);

    }
}


