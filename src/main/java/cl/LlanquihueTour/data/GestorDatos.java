package cl.LlanquihueTour.data;

import cl.LlanquihueTour.model.Cliente;
import cl.LlanquihueTour.model.Direccion;
import cl.LlanquihueTour.model.Rut;
import cl.LlanquihueTour.util.Validador;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;


public class GestorDatos {

    private ArrayList<Cliente> clientes = new ArrayList<>();

    public ArrayList<Cliente> getClientes() {
        return clientes;
    }

    public void cargarClientes(String ruta) {
        clientes.clear();
        int numeroLinea = 0;

        try (BufferedReader lector = Files.newBufferedReader(Paths.get(ruta))) {
            String linea;
            while ((linea = lector.readLine()) != null) {
                numeroLinea++;
                if (linea.trim().isEmpty()) {
                    continue;
                }
                try {
                    clientes.add(crearCliente(linea));
                } catch (IllegalArgumentException e) {
                    System.out.println("Línea " + numeroLinea + " ignorada: " + e.getMessage());
                }
            }
        } catch (IOException e) {
            System.out.println("No se pudo leer el archivo: " + e.getMessage());
        }
    }

    private Cliente crearCliente(String linea) {
        String[] p = linea.split(";");

        if (p.length != 11) {
            throw new IllegalArgumentException("faltan datos... Hay " + p.length + " de 11 completados.");
        }

        Validador.validarTextoNoVacio(p[0], "nombre");
        Validador.validarTextoNoVacio(p[1], "apellido");
        Validador.validarTextoNoVacio(p[5], "calle");
        Validador.validarTextoNoVacio(p[7], "ciudad");
        Validador.validarTextoNoVacio(p[8], "región");
        Validador.validarCorreo(p[4].trim());

        Rut rut = new Rut(p[2].trim());
        int telefono = Validador.convertirAEntero(p[3], "teléfono");
        int numeroCalle = Validador.convertirAEntero(p[6], "número de calle");

        Direccion direccion = new Direccion(p[5].trim(), numeroCalle, p[7].trim(), p[8].trim());

        return new Cliente(p[0].trim(), p[1].trim(), rut, telefono,
                p[4].trim(), direccion, p[9].trim(), p[10].trim());
    }

    public void mostrarClientes() {
        for (Cliente c : clientes) {
            System.out.println(c);
            System.out.println("----------------------------------------------");
        }
    }

    public Cliente buscarPorRut(String numeroRut) {
        for (Cliente c : clientes) {
            if (c.getRut().getNumero().equalsIgnoreCase(numeroRut)) {
                return c;
            }
        }
        return null;
    }

    public void buscarPorCiudad(String ciudad) {
        boolean encontrado = false;
        for (Cliente c : clientes) {
            if (c.getDireccion().getCiudad().equalsIgnoreCase(ciudad)) {
                System.out.println(c);
                System.out.println("----------------------------------------------");
                encontrado = true;
            }
        }
        if (!encontrado) {
            System.out.println("No hay clientes en " + ciudad);
        }
    }
}