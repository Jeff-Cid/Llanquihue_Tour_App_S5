package cl.LlanquihueTour.ui;

import cl.LlanquihueTour.data.GestorDatos;
import cl.LlanquihueTour.model.Cliente;

public class Main {

    public static void main(String[] args) {

        GestorDatos gestor = new GestorDatos();

        System.out.println();
        System.out.println("=== CLIENTES DE LLANQUIHUE TOUR ===");
        System.out.println();

        gestor.cargarClientes("src/main/resources/clientes.txt");

        System.out.println();
        System.out.println("Clientes cargados: " + gestor.getClientes().size());
        System.out.println("----------------------------------------------");
        gestor.mostrarClientes();

        System.out.println();
        System.out.println("=== BUSCAR POR RUT: 25123321-K ===");
        Cliente encontrado = gestor.buscarPorRut("25123321-K");
        if (encontrado != null) {
            System.out.println(encontrado);
        } else {
            System.out.println("Cliente no encontrado.");
        }

        System.out.println();
        System.out.println("=== BUSCAR POR RUT: 99999999-9 ===");
        Cliente noExiste = gestor.buscarPorRut("99999999-9");
        if (noExiste != null) {
            System.out.println(noExiste);
        } else {
            System.out.println("Cliente no encontrado.");
        }

        System.out.println();
        System.out.println("=== CLIENTES EN VALPARAISO ===");
        gestor.buscarPorCiudad("Valparaíso");
    }
}