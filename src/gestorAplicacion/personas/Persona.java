package gestorAplicacion.personas;


public class Persona {

    //Atributos

    private int cedula;
    private String nombre;
    private String tipoEps;

    //Constructor

    public Persona(int cedula, String nombre, String tipoEps){
        this.cedula = cedula;
        this.nombre = nombre;
        this.tipoEps = tipoEps;

    }

        //GETS Y SETS


    public int getCedula(){
        return cedula;
    }
    public void setCedula(int cedula){
        this.cedula = cedula;

    }
    public String getNombre(){
        return nombre;
    }
    public void setNombre(String nombre){
        this.nombre = nombre;

    }
    public String getTipoEps(){
        return tipoEps;
    }
    public void setTipoEps(String tipoEps){
        this.tipoEps = tipoEps;

    }
    public String Bienvenida(){
        return "bienvenido usuario"+nombre;
    }


}