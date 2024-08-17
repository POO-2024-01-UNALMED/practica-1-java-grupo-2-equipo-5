package uiMain.Funcionalidades;

import java.util.ArrayList;
import java.util.Scanner;

import gestorAplicacion.administracionHospital.Enfermedad;
import gestorAplicacion.administracionHospital.Hospital;
import gestorAplicacion.administracionHospital.Medicamento;
import gestorAplicacion.personas.Doctor;
import gestorAplicacion.personas.Paciente;
import gestorAplicacion.servicios.Formula;

public class FormulaMedica {

    static Scanner sc = new Scanner(System.in);

    // Buscar paciente
    public static void formulaMedica(Hospital hospital){
        System.out.println("Ingrese la cedula del paciente:");
        int cedula = sc.nextInt();
        Paciente paciente = hospital.buscarPaciente(cedula);

        if (paciente == null) {

            while (true) {
                System.out.println("Paciente no encontrado. \n¿Desea registrarlo?");
                System.out.println("1. Si\n2. No \nSeleccione una opción");
                byte opcion = sc.nextByte();
                switch (opcion) {
                    case 1:
                        RegistrarPaciente.RegistrarPaciente(hospital);
                        return;

                    case 2:
                        System.out.println("Adíos");
                        return;
                
                    default:
                        System.out.println("Opción no válida");
                }                
            }
    }

    // Crear la formula pal enfermo
    Formula formulaPaciente = new Formula(paciente);

    ArrayList<Medicamento> listMedicamento = new ArrayList<~>();
    System.out.println("¿Cuál enfermdad desea tratar?:");
    Enfermedad enfermedadTratar = null;
    if (paciente.getHistoriaClinica().getEnfermedades().size()==0){
        System.out.println("El paciente no tiene enfermedades. Por favor diríjase a registar enfermedades.");
        return;
    }
    
    while (true) {
        for( int i = 0; i < paciente.getHistoriaClinica().getEnfermedades().size(); i++){
            System.out.println((i+1)+". "+paciente.getHistoriaClinica().getEnfermedades().get(i));
        }

        byte opcEnf = sc.nextByte();
        // Buscamos la enfermedad que eligio el paciente
        if (opcEnf <= paciente.getHistoriaClinica().getEnfermedades().size() && opcEnf > 0){
            enfermedadTratar = paciente.getHistoriaClinica().getEnfermedades().get(opcEnf - 1);
            break;
        } 

        else{
            System.out.println("Opción no válida");
        }

    }
    //Se busca en la historia clinica el doctor que trata la enfermedad verificando que haya tenido cita con el paciente
    ArrayList<Doctor> doctoresCita = paciente.getHistoriaClinica().buscarCitaDoc(enfermedadTratar.getEspecialidad(), hospital)

    if (doctoresCita.size()==0){
        System.out.println("No hay doctores que traten la enfermedad en el hospital.");
        return;
    }
    Doctor doctorEscogido = null;
    while (true) {//Bucle para el caso en el que elija opciones fuera de rango
        System.out.println("Los doctores que lo han atendido y estan disponibles para formular "+ enfermedadTratar.getNombre() + " "+enfermedadTratar.getTipologia()+ "son: ");

        for(int i = 0; i<doctorCita.size(); i++){
            System.out.println((i+1)+". "+doctorCita.get(i).getNombre());
        }
        byte opcDoc = sc.nextByte();
        if (opcDoc > 0 & opcDoc <= doctoresCita.size(); i++) {
            doctorEscogido = doctoresCita.get(opcDoc - 1);
            break;
            
        }

        else{
            System.out.println("Opción no válida");
        }
    }
    //Agregar medicamnetos 
    boolean agregarOtro = false;

    formulaPaciente.setDoctor(doctorEscogido);

    do{
        System.out.println(paciente.mensajeDoctor(doctorEscogido));

        ArrayList<Medicamento> disponibleEnf = paciente.medEnfermedades(enfermedadTratar, hospital);

        if (disponibleEnf.size()==0) {
            System.out.println("No hay medicamentos disponibles para la enfermedad");
            break;
            
        }

        while (true) {
            for(int i = 0; i < disponibleEnf.size(); i++){
                
            }
            
        }
    }
}
