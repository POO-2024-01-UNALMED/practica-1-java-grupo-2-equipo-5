package gestorAplicacion.personas;

import gestorAplicacion.administracionHospital.*;
import gestorAplicacion.servicios.*;

import java.util.ArrayList;
import java.util.Objects;

public class Paciente extends Persona implements Pago{

    //Atributos
    private final HistoriaClinica historiaClinica;
    private CategoriaHabitacion categoriaHabitacion;
    private Habitacion habitacionAsignada;

    //Constructor

    public Paciente(int cedula, String nombre, String tipoEps, CategoriaHabitacion categoriaHabitacion) {
        super(cedula, nombre, tipoEps);
        this.categoriaHabitacion = categoriaHabitacion;
        this.historiaClinica = new HistoriaClinica(this);

    }
    public Paciente(int cedula, String nombre, String tipoEps){
        this(cedula, nombre, tipoEps, null);
    }

    //Metodos


    //METODO ENCARGADO DE REALIZAR LA BUSQUEDA DE MEDICAMENTOS DISPONIBLES
    public ArrayList<Medicamento> medEnfermedad(Enfermedad enfermedad, Hospital hospital) {
        ArrayList<Medicamento> medicamentos = hospital.medicamentosDisponibles();
        ArrayList<Medicamento> medEnfermedades = new ArrayList<Medicamento>();
        for (Medicamento med : medicamentos){
            if (enfermedad.getNombre().equals(med.getEnfermedad().getNombre()) && enfermedad.getTipologia().equals(med.getEnfermedad().getTipologia())){
                medEnfermedades.add(med);
            }

        }
        return medEnfermedades;
    }
    //METODO ENCARGADO DE BUSCAR DOCTORES POR EXPECIALIDAD Y TIPO DE EPS
    public ArrayList<Doctor> buscarDoctorEps(String especialidad, Hospital hospital) {
        ArrayList<Doctor> doctoresPorEspecialidad = hospital.buscarTipoDoctor(especialidad);
        ArrayList<Doctor> doctoresDisponibles = new ArrayList<Doctor>();

        for (int i = 1; i <= doctoresPorEspecialidad.size(); i++) {
            if (Objects.equals(doctoresPorEspecialidad.get(i - 1).getTipoEps(), getTipoEps())) {
                doctoresDisponibles.add(doctoresPorEspecialidad.get(i - 1));
            }
        }
        return doctoresDisponibles;
    }

    //METODO ENCARGADO DE ACTUALIZAR LA HISTORIA CLINICA
    public void actualizarHistorialCitas(Cita citaAsignada) {
        historiaClinica.getHistorialCitas().add(citaAsignada);
    }


    public double calcularPrecio(Formula formula) {
        double precio = 0;
        for (Medicamento med : formula.getListaMedicamentos()) {
            if (formula.getPaciente().getTipoEps().equals("Contributivo")) {
                precio += med.getPrecio() * 0.8;
            }
            if (formula.getPaciente().getTipoEps().equals("Subsidiado")) {
                precio += med.getPrecio() * 0.7;
            }
            if (formula.getPaciente().getTipoEps().equals("Particular")) {
                precio += med.getPrecio();
            }
        }
        return precio * (1 + IVA);
    }
    public double calcularPrecio(Cita citaAsignada) {

        double precioTotal = 0;

        if (Objects.equals(citaAsignada.getDoctor().getEspecialidad(),"General")) {
            precioTotal += 5000;
        }

        if (Objects.equals(citaAsignada.getDoctor().getEspecialidad(),"Oftalmologia")) {
            precioTotal += 7000;
        }

        if (Objects.equals(citaAsignada.getDoctor().getEspecialidad(),"Odontologia")) {
            precioTotal += 10000;
        }

        if (Objects.equals(citaAsignada.getPaciente().getTipoEps(),"Contributivo")) {
            precioTotal += 2000;
        }

        if (Objects.equals(citaAsignada.getPaciente().getTipoEps(),"Subsidiado")) {
            precioTotal += 500;
        }

        if (Objects.equals(citaAsignada.getPaciente().getTipoEps(),"Particular")) {
            precioTotal += 10000;
        }

        precioTotal = precioTotal*(1+IVA);
        return precioTotal;
    }
    public double calcularPrecio(CitaVacuna citaAsignada) {
        double precioTotal = citaAsignada.getVacuna().getPrecio();

        if (Objects.equals(citaAsignada.getVacuna().getTipo(), "Obligatoria")) {
            precioTotal += 1000;
        }
        if (Objects.equals(citaAsignada.getVacuna().getTipo(), "No obligatoria")) {
            precioTotal += 3000;
        }
        if (Objects.equals(citaAsignada.getPaciente().getTipoEps(), "Contributivo")) {
            precioTotal += 2000;
        }
        if (Objects.equals(citaAsignada.getPaciente().getTipoEps(), "Subsidiado")) {
            precioTotal += 500;
        }
        if (Objects.equals(citaAsignada.getPaciente().getTipoEps(), "Particular")) {
            precioTotal += 10000;
        }
        precioTotal = precioTotal * (1 + IVA);
        return precioTotal;
    }
    public  double calcularPrecio(Habitacion habitacionAsignada)
    {
        double precio=0;
        if (Objects.equals(getTipoEps(), "Subsidiado"))
        {
            precio=habitacionAsignada.getCategoria().getValor()*0;
            return precio*(1+IVA);
        }
        else if (Objects.equals(getTipoEps(), "Contributivo"))
        {
            precio=(habitacionAsignada.getCategoria().getValor()/2)*habitacionAsignada.getDias();
            return precio*(1+IVA);
        }
        else
        {
            precio=habitacionAsignada.getCategoria().getValor()*habitacionAsignada.getDias();
            return precio*(1+IVA);
        }
    }

    public ArrayList<Vacuna> buscarVacunaPorEps(String tipo, Hospital hospital){
        ArrayList<Vacuna> vacunasPorTipo= hospital.buscarTipoVacuna(tipo);
        ArrayList<Vacuna> vacunasDisponibles= new ArrayList<Vacuna>();

        for (int i=1; i<=vacunasPorTipo.size();i++){
            ArrayList<String> tipoEpsVacuna = vacunasPorTipo.get(i-1).getTipoEps();
            for (int j=1;j<=tipoEpsVacuna.size();j++){
                if (Objects.equals(tipoEpsVacuna.get(j - 1), getTipoEps())){
                    vacunasDisponibles.add(vacunasPorTipo.get(i-1));
                }
            }
        }
        return vacunasDisponibles;
    }
    public String mensajeDoctor(Persona doctor){
        //Hay ligadura dinámica
        return doctor.bienvenida()+ "\nPor favor selecciona los medicamentos que vas a formularle a: "+getNombre();
    }
    public void actualizarHistorialVacunas(CitaVacuna citaAsignada){
        historiaClinica.getHistorialVacunas().add(citaAsignada);
    }

    //Getter y setter



    public HistoriaClinica getHistoriaClinica() {
        return historiaClinica;
    }

    public CategoriaHabitacion getCategoriaHabitacion()
    {
        return categoriaHabitacion;
    }

    public void setCategoriaHabitacion(CategoriaHabitacion categoriaHabitacion) {
        this.categoriaHabitacion = categoriaHabitacion;
    }
    public Habitacion getHabitacionAsignada() {
        return habitacionAsignada;
    }

    public void setHabitacionAsignada(Habitacion habitacionAsignada) {
        this.habitacionAsignada = habitacionAsignada;
    }



    @Override

    public String toString(){
        return "---------------------------\nNombre: "+ getNombre() + "\nCédula: " + getCedula() + "\nTipo de EPS: " + getTipoEps() + "\n---------------------------";
    }

    public String despedida(Cita citaAsignada ){

        /*EXISTE UNA LIGADURA DINAMICA EN ESTE CAMPO YA QUE LA REFERENCIA DE
        citaAsignada PUEDE APUNTAR A UNA CITA O CITA VACUNA Y DEPENDIENDO DE
        ESTO, SE EJECUTA EL METODO MAS ESPECIFICO DEL MENSAJE*/


        return "¡Adiós "+getNombre()+" "+citaAsignada.mensaje();
    }
}
