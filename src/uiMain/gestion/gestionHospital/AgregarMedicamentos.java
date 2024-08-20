package uiMain.gestion.gestionHospital;

import gestorAplicacion.administracionHospital.Enfermedad;
import gestorAplicacion.administracionHospital.Hospital;
import gestorAplicacion.administracionHospital.Medicamento;

import java.util.ArrayList;
import java.util.Scanner;

//Clase de Gestion encargada de agregar los medicamentos al paciente
public class AgregarMedicamentos {
    public static void agregarMedicamentos(Hospital hospital) {
        Scanner sc = new Scanner(System.in);
            boolean anadirOtro;
            do {
                System.out.println("Bienvenido! Deseas aumentar el stock de un medicamento existente (1) o añadoir uno nuevo (2)?");
                System.out.println("1. Aumentar el stock de un medicamento existente.");
                System.out.println("2. Ingresar un nuevo medicamento.");
                ArrayList<Medicamento> listaMedicamentos = hospital.getListaMedicamentos();
                int opcion = sc.nextInt();
                sc.nextLine();
                switch (opcion) {
                    case 1:
                        while (true) {
                            VerMedicamentos.verMedicamentos(hospital);
                            byte opcionMed = sc.nextByte();
                            if (opcionMed <= 0 || opcionMed > listaMedicamentos.size()) {
                                System.out.println("Opción no válida. Intente de nuevo.");
                            } else {
                                Medicamento escogido = listaMedicamentos.get(opcionMed - 1);
                                System.out.println("Ingrese la nueva cantidad del medicamento:");
                                int cantidad = sc.nextInt();
                                escogido.setCantidad(cantidad);
                                System.out.println("Se ha actualizado el medicamento:");
                                System.out.println(escogido);
                                break;
                            }
                        }
                        break;
                    case 2:
                        System.out.println("Por favor, ingrese el nombre del nuevo medicamento:");
                        String nombre = sc.nextLine();
                        Enfermedad enfermedad;
                        ArrayList<Enfermedad> enfermedades = Enfermedad.getEnfermedadesRegistradas();
                        while (true) {
                            System.out.println("¿Qué enfermedad trata este medicamento?");
                            System.out.println("0. Registrar una nueva enfermedad");
                            for (int i = 0; i < enfermedades.size(); i++) {
                                System.out.println(i + 1 + ". " + enfermedades.get(i));
                            }
                            byte opcionEnf = sc.nextByte();
                            sc.nextLine();
                            if (opcionEnf == 0) {
                                System.out.println("Por favor, ingrese el nombre de la nueva enfermedad:");
                                String nEnfermedad = sc.nextLine();
                                System.out.println("Por favor, ingrese la tipología de la enfermedad:");
                                String tEnfermedad = sc.next();
                                System.out.println("Por favor, ingrese la especialidad que trata dicha enfermedad:");
                                String eEnfermedad = sc.next();
                                Enfermedad nuevaEnfermedad = new Enfermedad(eEnfermedad, nEnfermedad, tEnfermedad);
                                System.out.println("Se ha registrado la nueva enfermedad en el sistema!");
                            } else if (opcionEnf <= 0 || opcionEnf > enfermedades.size()) {
                                System.out.println("Opción no válida. Por favor intente de nuevo.");
                            } else {
                                enfermedad = enfermedades.get(opcionEnf - 1);
                                break;
                            }
                        }
                        System.out.println("Por favor, ingrese una descripción para el medicamento:");
                        String dMedicamento = sc.nextLine();
                        System.out.println("Por favor, ingrese la cantidad de unidades del medicamento:");
                        int cMedicamento = sc.nextInt();
                        System.out.println("Por favor, ingrese el precio del medicamento:");
                        float pMedicamento = sc.nextFloat();
                        Medicamento nuevoMedicamento = new Medicamento(nombre, enfermedad, dMedicamento, cMedicamento, pMedicamento);
                        hospital.getListaMedicamentos().add(nuevoMedicamento);
                        break;
                    default:
                        System.out.println("Opción no válida. Por favor intente de nuevo.");
                }
                while (true) {
                    System.out.println("¿Desea añadir un nuevo medicamento? (s/n)");
                    char confirmar = sc.next().charAt(0);
                    if (confirmar == 's' || confirmar == 'n') {
                        anadirOtro = confirmar == 's';
                        break;
                    } else {
                        System.out.println("Opción no válida. Por favor intente de nuevo");
                    }
                }

        }while (anadirOtro);
        System.out.println("Se han actualizado los medicamentos!");
    }
}
