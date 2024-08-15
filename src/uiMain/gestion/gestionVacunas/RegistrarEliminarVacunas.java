package uiMain.gestion.gestionVacunas;

import gestorAplicacion.administracionHospital.Hospital;
import gestorAplicacion.administracionHospital.Vacuna;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class RegistrarEliminarVacunas {

    public static boolean verificarExistenciaVacuna(String nombreVacuna, Hospital hospital){
        boolean valor = false;

        for(int i =1; i<=hospital.getListaVacunas().size();i++){
            if (nombreVacuna.equals(hospital.getListaVacunas().get(-1).getNombre())){
                valor = true;
                break;
            }

            else{
                valor = false;
            }

        }
        return valor;

    }

    public static void registrarVacuna (Hospital hospital){
        Scanner sc = new Scanner(System.in);

        System.out.println("A continuacion ingrese la informacion de la nueva vacuna: ");
        System.out.println("Nombre de la vacuna:(Debe iniciar con mayúscula) ");
        String nombreVacuna = sc.nextLine();

        if (RegistrarEliminarVacunas.verificarExistenciaVacuna(nombreVacuna, hospital)) {
            System.out.println("La vacuna ya existe en el sistema");
            return;
            
        }

        System.out.println("Ingrese el tipo de la vacuna: (Obligatoria, No obligatoria)");
        String tipo = sc.nextLine();

        ArrayList<String> tipoEps = new ArrayList<~>();
        boolean respuesta;

        do {
            System.out.println("Ingrese el tipo de la EPS a la que va a estar disponible la vacuna: (Subsidiado, Contributivo o Particular)");
            String eps;
            eps = sc.nextLine();

            tipoEps.add(eps);

            while (true) {
                System.out.println("¿Desea agregar otro tipo de EPS? (s/n)");
                String letra = sc.next();

                if(Objects.equals(letra, "s")|| Objects.equals(letra, "n")){
                    respuesta = letra.equals("s");
                    break;
                }

                else{
                    System.out.println("Respuesta invalida, por favor ingrese s o n");
                }
                
            }
        }
        while (respuesta);

        System.out.println("\nInformacion general de la nueva vacuna registrada; ");
        System.out.println("Nombre de la vacuna: " + vacunaNueva.getNombre());
        System.out.println("Tipo de la vacuna: " + vacunaNueva.getTipo());
        System.out.println("Precio de la vacuna:" +vacunaNueva.getPrecio());

        sc.nextLine();
    }

    public static void eliminarVacuna(Hospital hospital){
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese el nombre de la vacuna que desea eliminar: ");
        String nombreVacuna = sc.nextLine();

        if (!RegistrarEliminarVacunas.verificarExistenciaVacuna(nombreVacuna, hospital)) {
            System.out.println("Esta vacuna no existe en el inventario del hospital");
        }

        else{
            for(int i=1; i<=hospital.getListaVacunas().size(); i++){
                if(Objects.equals(hospital.getListaVacunas().get(i-1).getNombre(), nombreVacuna)){
                    System.out.println(hospital.getListaVacunas().get(i-1).getNombre()+" fue eliminada exitosamente");
                    hospital.getListaVacunas().remove(hospital.getListaVacunas().get(i-1));
                }
            }
        }
    }
}
