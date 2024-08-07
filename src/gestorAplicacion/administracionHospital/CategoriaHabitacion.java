package gestorAplicacion.administracionHospital;

public enum CategoriaHabitacion {
    //Enum para clasificar los tipos de habitaciones disponibles.
    CAMILLA(50000),
    INDIVIDUAL(150000),
    DOBLE(320000),
    OBSERVACION(500000),
    UCI(1300000),
    UCC(1500000);

    private final int valor;

    private CategoriaHabitacion(int valor) {
        this.valor = valor;
    }
}
