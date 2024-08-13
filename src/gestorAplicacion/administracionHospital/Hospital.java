package gestorAplicacion.administracionHospital;

import java.util.ArrayList;

import gestorAplicacion.personas.Doctor;
import gestorAplicacion.personas.Paciente;
import gestorAplicacion.servicios.Habitacion;
import javax.print.Doc;


//Importar el serializable y lo que falte.

//En esta clase va todo lo más general relacionado con el hospital
public class Hospital { //implementar de serializable

    //Atributos
    private ArrayList<Doctor> listaDoctores = new ArrayList<>();
    private ArrayList<Paciente> listaPacientes = new ArrayList<>();
    private ArrayList<Medicamento> listaMedicamentos = new ArrayList<Medicamento>();
    private ArrayList<Vacuna> listaVacunas = new ArrayList<>();
    //Atributo estático que cumple con el requerimiento del proyecto:
    private static ArrayList<Habitacion> listaHabitaciones = new ArrayList<Habitacion>();

    //Implementar constructor aqui...
    //public Hospital() {
        //Deserializador.deserializar(this);
    //}

    //Métodos

    //Buscar un paciente en la base de datos usando su numero de cédula
    public Paciente buscarPaciente(int cedula) {
        for (Paciente paciente : listaPacientes) {
            //if (paciente.getCedula() == cedula) {
            //    return paciente;
            //} --> Implementar método getCedula Paciente!
        }
        return null;
    }

    //Sobrecarga de métodos buscarDoctor: Uno con la cédula y otro con la especialidad

    public Doctor buscarDoctor(int cedula) {
        for (Doctor doctor : listaDoctores) {
            if (doctor.getCedula() == cedula) {
                return doctor;
            }
        }
        return null;
    }

    public ArrayList<Doctor> buscarDoctor(String especialidad) {
        ArrayList<Doctor> doctores = new ArrayList<>();
        for (Doctor doctor : listaDoctores) {
            if (doctor.getEspecialidad().equals(especialidad)) {
                doctores.add(doctor);
            }
        }
        return doctores;
    }

    //Faltan métodos para vacunas

    //Getters y setters
    public ArrayList<Doctor> getListaDoctores() {
        return listaDoctores;
    }

    public void setListaDoctores(ArrayList<Doctor> listaDoctores) {
        this.listaDoctores = listaDoctores;
    }

    public ArrayList<Paciente> getListaPacientes() {
        return listaPacientes;
    }

    public void setListaPacientes(ArrayList<Paciente> listaPacientes) {
        this.listaPacientes = listaPacientes;
    }

    public ArrayList<Medicamento> getListaMedicamentos() {
        return listaMedicamentos;
    }

    public void setListaMedicamentos(ArrayList<Medicamento> listaMedicamentos) {
        this.listaMedicamentos = listaMedicamentos;
    }

    public ArrayList<Vacuna> getListaVacunas() {
        return listaVacunas;
    }

    public void setListaVacunas(ArrayList<Vacuna> listaVacunas) {
        this.listaVacunas = listaVacunas;
    }

    public static ArrayList<Habitacion> getListaHabitaciones() {
        return listaHabitaciones;
    }

    public static void setListaHabitaciones(ArrayList<Habitacion> listaHabitaciones) {
        Hospital.listaHabitaciones = listaHabitaciones;
    }
}
