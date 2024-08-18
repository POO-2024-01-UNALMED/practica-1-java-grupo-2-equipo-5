package baseDatos;

import gestorAplicacion.administracionHospital.Enfermedad;
import gestorAplicacion.administracionHospital.Hospital;

import java.io.*;

public class Serializador {
    public static void serializar(Hospital hospital) {
        serializarDoctores(hospital,new File("src\\baseDatos\\temp\\registroDoctores.txt\\"));
        serializarPacientes(hospital, new File("src\\baseDatos\\temp\\registroPacientes.txt"));
        serializarMedicamentos(hospital, new File("sc\\baseDatos\\temp\\registroMedicamentos.txt"));
        serializarVacunas(hospital, new File("src\\baseDatos\\temp\\registroVacunas.txt"));
        serializarHabitaciones(hospital, new File("src\\baseDatos\\temp\\registroHabitaciones.txt"));
        serializarEnfermedades(hospital, new File("src\\baseDatos\\temp\\registroVacunas.txt"));
    }

    public static void serializarDoctores(Hospital hospital, File archivo) {
        try {
            PrintWriter pw = new PrintWriter(archivo);
            FileOutputStream file = new FileOutputStream(archivo);
            ObjectOutput out = new ObjectOutputStream(file);
            out.writeObject(hospital.getListaDoctores());
            out.close();
            file.close();
        }
        catch (IOException e) {
            System.out.println("Error al serializar" + e);
        }
    }

    public static void serializarPacientes(Hospital hospital, File archivo) {
        try {
            PrintWriter pw = new PrintWriter(archivo);
            FileOutputStream file = new FileOutputStream(archivo);
            ObjectOutput out = new ObjectOutputStream(file);
            out.writeObject(hospital.getListaPacientes());
            out.close();
            file.close();
        }
        catch (IOException e) {
            System.out.println("Error al serializar" + e);
        }
    }
    public static void serializarMedicamentos(Hospital hospital, File archivo) {
        try {
            PrintWriter pw = new PrintWriter(archivo);
            FileOutputStream file = new FileOutputStream(archivo);
            ObjectOutput out = new ObjectOutputStream(file);
            out.writeObject(hospital.getListaMedicamentos());
            out.close();
            file.close();
        }
        catch (IOException e) {
            System.out.println("Error al serializar" + e);
        }
    }
    public static void serializarVacunas(Hospital hospital, File archivo) {
        try {
            PrintWriter pw = new PrintWriter(archivo);
            FileOutputStream file = new FileOutputStream(archivo);
            ObjectOutput out = new ObjectOutputStream(file);
            out.writeObject(hospital.getListaVacunas());
            out.close();
            file.close();
        }
        catch (IOException e) {
            System.out.println("Error al serializar" + e);
        }
    }
    public static void serializarHabitaciones(Hospital hospital, File archivo) {
        try {
            PrintWriter pw = new PrintWriter(archivo);
            FileOutputStream file = new FileOutputStream(archivo);
            ObjectOutput out = new ObjectOutputStream(file);
            out.writeObject(hospital.getListaHabitaciones());
            out.close();
            file.close();
        }
        catch (IOException e) {
            System.out.println("Error al serializar" + e);
        }
    }
    public static void serializarEnfermedades(Hospital hospital, File archivo) {
        try {
            PrintWriter pw = new PrintWriter(archivo);
            FileOutputStream file = new FileOutputStream(archivo);
            ObjectOutput out = new ObjectOutputStream(file);
            out.writeObject(Enfermedad.getEnfermedadesRegistradas());
            out.close();
            file.close();
        }
        catch (IOException e) {
            System.out.println("Error al serializar" + e);
        }
    }

}
