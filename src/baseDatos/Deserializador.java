package baseDatos;

import gestorAplicacion.administracionHospital.*;
import gestorAplicacion.personas.*;
import gestorAplicacion.servicios.*;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class Deserializador {
    public static void deserializar(Hospital hospital){
        deserializarDoctores(hospital,new File("src\\baseDatos\\temp\\registroDoctores.txt"));
        deserializarPacientes(hospital,new File("src\\baseDatos\\temp\\registroPacientes.txt"));
        deserializarMedicamentos(hospital,new File("src\\baseDatos\\temp\\registroMedicamentos.txt"));
        deserializarVacunas(hospital,new File("src\\baseDatos\\temp\\registroVacunas.txt"));
        deserializarHabitaciones(hospital,new File("src\\baseDatos\\temp\\registroHabitaciones.txt"));
        deserializarEnfermedades(hospital,new File("src\\baseDatos\\temp\\registroEnfermedades.txt"));
    }
    public static void deserializarDoctores(Hospital hospital, File ruta) {
        try {
            FileInputStream file = new FileInputStream(ruta);
            ObjectInputStream in = new ObjectInputStream(file);
            hospital.setListaDoctores((ArrayList<Doctor>) in.readObject());

        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error en la serializacion" + e);
        }
    }

    public static void deserializarPacientes(Hospital hospital, File ruta) {
        try {
            FileInputStream file = new FileInputStream(ruta);
            ObjectInputStream in = new ObjectInputStream(file);
            hospital.setListaPacientes((ArrayList<Paciente>) in.readObject());

        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error en la serializacion" + e);
        }
    }

    public static void deserializarMedicamentos(Hospital hospital, File ruta) {
        try {
            FileInputStream file = new FileInputStream(ruta);
            ObjectInputStream in = new ObjectInputStream(file);
            hospital.setListaMedicamentos((ArrayList<Medicamento>) in.readObject());

        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error en la serializacion" + e);
        }
    }

    public static void deserializarVacunas(Hospital hospital, File ruta) {
        try {
            FileInputStream file = new FileInputStream(ruta);
            ObjectInputStream in = new ObjectInputStream(file);
            hospital.setListaVacunas((ArrayList<Vacuna>) in.readObject());

        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error en la serializacion" + e);
        }
    }

    public static void deserializarHabitaciones(Hospital hospital, File ruta) {
        try {
            FileInputStream file = new FileInputStream(ruta);
            ObjectInputStream in = new ObjectInputStream(file);
            Hospital.setHabitaciones((ArrayList<Habitacion>) in.readObject());

        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error en la serializacion" + e);
        }
    }

    public static void deserializarEnfermedades(Hospital hospital, File ruta) {
        try {
            FileInputStream file = new FileInputStream(ruta);
            ObjectInputStream in = new ObjectInputStream(file);
            Enfermedad.setEnfermedadesRegistradas((ArrayList<Enfermedad>) in.readObject());

        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error en la serializacion" + e);
        }
    }
}



