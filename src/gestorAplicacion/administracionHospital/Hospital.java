package gestorAplicacion.administracionHospital;

import baseDatos.Deserializador;
import gestorAplicacion.personas.Doctor;
import gestorAplicacion.personas.Paciente;
import gestorAplicacion.servicios.Habitacion;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;

//EN ESTA CLASE VA LA ESTRUCTURA PRINCIPAL DEL HOSPITAL

public class Hospital implements Serializable {

    //Atributos
    private ArrayList<Doctor> listaDoctores = new ArrayList<>();
    private ArrayList<Paciente> listaPacientes = new ArrayList<>();
    private ArrayList<Medicamento> listaMedicamentos = new ArrayList<Medicamento>();
    private ArrayList<Vacuna> listaVacunas = new ArrayList<>();
    public static ArrayList<Habitacion> habitaciones= new ArrayList<>();

    //Constructor

    public Hospital(){
        Deserializador.deserializar(this);

    }

    //Métodos
    public ArrayList<Doctor> buscarTipoDoctor(String especialidad) {
        ArrayList<Doctor> doctoresDisponibles = new ArrayList<Doctor>();
        for (int i = 1; i <= listaDoctores.size(); i++) {
            if (Objects.equals(listaDoctores.get(i - 1).getEspecialidad(), especialidad)) {
                doctoresDisponibles.add(listaDoctores.get(i - 1));
            }
        }
        return doctoresDisponibles;
    }
        //Buscar un paciente en la base de datos usando su numero de cédula

        public Paciente buscarPaciente (int cedula){
            for (Paciente paciente : listaPacientes) {
                if (paciente.getCedula() == cedula) {
                    return paciente;
                }
            }
            return null;
        }

        //Sobrecarga de métodos buscarDoctor: Uno con la cédula y otro con la especialidad

        public Doctor buscarDoctor ( int cedula){
            for (Doctor doctor : listaDoctores) {
                if (doctor.getCedula() == cedula) {
                    return doctor;
                }
            }
            return null;
        }


        public Vacuna buscarVacuna(String nombre){
            for (Vacuna vacuna : listaVacunas) {
                if (Objects.equals(vacuna.getNombre(), nombre)) {
                    return vacuna;
                }
            }
            return null;
        }


        public ArrayList<Medicamento> medicamentosDisponibles(){
            ArrayList<Medicamento> medicamentos = new ArrayList<>();
            for (int i = 0; i <= listaMedicamentos.size(); i++) {
                if (listaMedicamentos.get(i).getCantidad()>0){
                    medicamentos.add(listaMedicamentos.get(i));
                }
            }
            return medicamentos;
        }
        public ArrayList<Vacuna> buscarTipoVacuna(String tipo){
            ArrayList<Vacuna> vacunas = new ArrayList<>();
            for (int i = 1; i < listaVacunas.size(); i++) {
                if (Objects.equals(listaVacunas.get(i-1).getTipo(), tipo)){
                    vacunas.add(listaVacunas.get(i-1));
                }
            }
            return vacunas;
        }

        //Faltan métodos para vacunas

        //Getters y setters
        public ArrayList<Doctor> getListaDoctores() {return listaDoctores;}

        public void setListaDoctores (ArrayList<Doctor> listaDoctores) {this.listaDoctores = listaDoctores;}

        public ArrayList<Paciente> getListaPacientes() {return listaPacientes;}

        public void setListaPacientes (ArrayList<Paciente> listaPacientes) {this.listaPacientes = listaPacientes;}

        public ArrayList<Medicamento> getListaMedicamentos() {return listaMedicamentos;}

        public void setListaMedicamentos (ArrayList<Medicamento> listaMedicamentos) {this.listaMedicamentos = listaMedicamentos;}

        public ArrayList<Vacuna> getListaVacunas () {return listaVacunas;}

        public void setListaVacunas (ArrayList < Vacuna > listaVacunas) {this.listaVacunas = listaVacunas;}

        public static ArrayList<Habitacion> getListaHabitaciones(){return habitaciones;}

        public static void setHabitaciones(ArrayList<Habitacion> habitaciones){Hospital.habitaciones = habitaciones;}


}
