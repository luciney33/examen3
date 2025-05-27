package org.example.ui;

import org.example.common.Consonantes;
import org.example.domain.CentroOcio;
import org.example.domain.DatosInciales;
import org.example.domain.ParqueAtracciones;
import org.example.domain.Zoo;
import org.example.service.GestionCentroOcio;
import org.example.service.GestionCentroOcioImplementacion;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class entradasalida {
    private final Scanner sc= new Scanner(System.in);
    private final GestionCentroOcio gestionCentroOcio= new GestionCentroOcioImplementacion();

    public void iniciarAplicacion() {
        int opcion;

        do {
            mostrarMenu();
            try {
                opcion = Integer.parseInt(sc.nextLine());
                switch (opcion) {
                    case 1 -> listarCentros();
                    case 2 -> listarOrdenadosPorProvinciaYAnyo();
                    case 3 -> agregarCentro();
                    case 4 -> consultaPorProvincia();
                    case 5 -> añadirServicioZoo();
                    case 6 -> parquesOrdenadosPorEdadYDia();
                    case 7 -> eliminarAntiguos();
                    case 8 -> System.out.println("Saliendo...");
                    default -> System.out.println("Opción no válida.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Por favor, introduce un número válido.");
                opcion = -1; // para que no se salga
            }
        } while (opcion != 8);
    }

    private void mostrarMenu() {
        System.out.println(Consonantes.MENU);
    }

    private void listarCentros() {
        List<CentroOcio> centros = gestionCentroOcio.listarcentros();
        if (centros.isEmpty()) {
            System.out.println("No hay centros disponibles.");
        } else {
            centros.forEach(System.out::println);
        }
    }

    private void listarOrdenadosPorProvinciaYAnyo() {
        List<CentroOcio> ordenados = gestionCentroOcio.getOrdenadosPorProvinciaYFecha();
        ordenados.forEach(System.out::println);
    }

    private void agregarCentro() {
        System.out.println("¿Qué tipo de centro quieres agregar? (1=Parque, 2=Zoo)");
        int tipo = Integer.parseInt(sc.nextLine());
        System.out.print("ID: ");
        int id = Integer.parseInt(sc.nextLine());
        System.out.print("Nombre: ");
        String nombre = sc.nextLine();
        System.out.print("Precio entrada: ");
        double precio = Double.parseDouble(sc.nextLine());
        System.out.print("Provincia: ");
        String provincia = sc.nextLine();
        System.out.print("Año de construcción: ");
        int anyo = Integer.parseInt(sc.nextLine());
        System.out.print("Correo atención: ");
        String correo = sc.nextLine();

        boolean agregado;
        if (tipo == 1) {
            ParqueAtracciones parque = new ParqueAtracciones(id, nombre, precio, provincia, anyo, correo);
            agregado = gestionCentroOcio.addCentro(parque);
        } else {
            Zoo zoo = new Zoo(id, nombre, precio, provincia, anyo, correo);
            agregado = gestionCentroOcio.addCentro(zoo);
        }

        System.out.println(agregado ? "Centro agregado correctamente." : "No se pudo agregar (ID duplicado).");
    }

    private void consultaPorProvincia() {
        System.out.print("Introduce provincia: ");
        String provincia = sc.nextLine();
        Map<String, List<CentroOcio>> resultado = gestionCentroOcio.obtenerCentrosPorProvincia(provincia);
        resultado.forEach((prov, lista) -> {
            System.out.println("Provincia: " + prov);
            System.out.println("Número de centros: " + lista.size());
            double media = lista.stream().mapToDouble(CentroOcio::getPrecioEntrada).average().orElse(0);
            System.out.println("Precio medio: " + media);
        });
    }

    private void añadirServicioZoo() {
        System.out.print("ID del zoológico: ");
        int id = Integer.parseInt(sc.nextLine());
        System.out.print("Servicio a añadir: ");
        String servicio = sc.nextLine();
        boolean añadido = gestionCentroOcio.añadirServicioZoo(id, servicio);
        System.out.println(añadido ? "Servicio añadido correctamente." : "No se pudo añadir.");
    }

    private void parquesOrdenadosPorEdadYDia() {
        int edad = 20; // fija como pide el enunciado
        boolean esFestivo = false; // día laborable

        List<ParqueAtracciones> resultado = gestionCentroOcio.obtenerParquesOrdenados(edad, esFestivo);
        resultado.forEach(System.out::println);
    }

    private void eliminarAntiguos() {
        System.out.print("Introduce el año de corte: ");
        int anyo = Integer.parseInt(sc.nextLine());
        int eliminados = gestionCentroOcio.eliminarCentrosPorAnyo(anyo);
        System.out.println("Se han eliminado " + eliminados + " centros.");
    }
}
