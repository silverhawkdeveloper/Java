package principal;

import estructuraDatos.*;
import estructuraDatos.Enumerado.*;
import java.io.File;
import java.util.*;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.*;
import utilidades.*;

/**
 *
 * @author Daniel Díaz González
 * @version 1.0
 */
public class CPrincipal {

    private static final ArrayList<Cliente> MISCLIENTES = new ArrayList<Cliente>();
    private static final ArrayList<Producto> MISPRODUCTOS = new ArrayList<Producto>();

    /**
     * @param args Menu principal donde se inicia la ejecución del programa
     */
    public static void main(String[] args) {
        boolean correcto = false;
        int opciones;

        IO_ES.crearDirectorios();
        leerDatos(Constante.RutaDatos());

        IO_ES.escribirLN(Color.azul() + "BIENVENIDOS A LA APLICACIÓN DE FARMACIA");
        do {
            IO_ES.escribirLN(Color.azul() + "---------------------------------------");
            IO_ES.escribirLN(Color.azul() + "               LA BOTÍCA               ");
            IO_ES.escribirLN(Color.azul() + "---------------------------------------" + Color.reset());
            IO_ES.escribirLN("1.  Añadir cliente");
            IO_ES.escribirLN("2.  Dar de baja cliente");
            IO_ES.escribirLN("3.  Modificar cliente");
            IO_ES.escribirLN("4.  Mostrar clientes");
            IO_ES.escribirLN("5.  Ordenar clientes\n");
            IO_ES.escribirLN("6.  Añadir producto");
            IO_ES.escribirLN("7.  Eliminar producto");
            IO_ES.escribirLN("8.  Modificar producto");
            IO_ES.escribirLN("9.  Añadir unidades");
            IO_ES.escribirLN("10. Quitar unidades");
            IO_ES.escribirLN("11. Mostrar productos");
            IO_ES.escribirLN("12. Ordenar productos\n");
            IO_ES.escribirLN("13. Exportar XML");
            IO_ES.escribirLN("14. Importar XML\n");
            IO_ES.escribirLN("15. Guardar datos");
            IO_ES.escribirLN("16. Guardar copia de seguridad");
            IO_ES.escribirLN("17. Leer copia de seguridad");
            IO_ES.escribirLN("0.  Salir");
            opciones = IO_ES.leerInteger("Introduzca una opción: ", 0, 17);

            switch (opciones) {
                case 1:
                    aniadirClientes();
                    break;
                case 2:
                    bajaCliente();
                    break;
                case 3:
                    modificarCliente();
                    break;
                case 4:
                    mostrarClientes();
                    break;
                case 5:
                    ordenarClientes();
                    break;
                case 6:
                    aniadirProducto();
                    break;
                case 7:
                    eliminarProducto();
                    break;
                case 8:
                    modificarProducto();
                    break;
                case 9:
                    aniadirUnidades();
                    break;
                case 10:
                    eliminarUnidades();
                    break;
                case 11:
                    mostrarProductos();
                    break;
                case 12:
                    ordenarProductos();
                    break;
                case 13:
                    escribirXML();
                    break;
                case 14:
                    leerXML();
                    break;
                case 15:
                    guardarDatos(Constante.RutaDatos());
                    break;
                case 16:
                    copiaSeguridad();
                    break;
                case 17:
                    leerCopiaSeguridad();
                    break;
                case 0:
                    salir();
                    correcto = true;
                    break;
            }
        } while (correcto == false);

    }

    public static void salir() {
        boolean guardar = IO_ES.leerBoleano("¿Deseas guardar los datos? ");

        if (guardar) {
            guardarDatos(Constante.RutaDatos());
        }
    }

    /**
     * Método para guardar una copia de seguridad
     */
    public static void copiaSeguridad() {
        String rutaSeguridad = IO_ES.fechasDirectorio();
        guardarDatos(rutaSeguridad);
    }

    /**
     * Método para leer una copia de seguridad
     */
    public static void leerCopiaSeguridad() {
        IO_ES.escribirLN("\n---------------------------------------");
        IO_ES.escribirLN("COPIA DE SEGURIDAD");
        IO_ES.escribirLN("Tienes que saber la fecha de la copia de seguridad");
        String anio = IO_ES.leerCadena("Indica el año: ");
        String mes = IO_ES.leerCadena("Indica el mes: ");
        String dia = IO_ES.leerCadena("Indica el día: ");
        String hora = IO_ES.leerCadena("Indica la hora: ");

        String rutaseguridad = "COPIA DE SEGURIDAD/" + anio + mes + dia + " " + hora;
        leerDatos(rutaseguridad);
    }

    /**
     * Método para guardar los datos del programa
     *
     * @param rutaDatos la ruta donde guardamos los datos
     */
    public static void guardarDatos(String rutaDatos) {
        /*for (int i = 0; i < MISCLIENTES.size(); i++) {
            if (i == 0) {
                IO_ES.escribirArchivo(rutaDatos + "/" + "DatosCliente.dat", MISCLIENTES.get(i).datosCliente(), false);
            } else {
                IO_ES.escribirArchivo(rutaDatos + "/" + "DatosCliente.dat", MISCLIENTES.get(i).datosCliente(), true);
            }
        }
        for (int i = 0; i < MISPRODUCTOS.size(); i++) {
            if (i == 0) {
                IO_ES.escribirArchivo(rutaDatos + "/" + "DatosProducto.dat", MISPRODUCTOS.get(i).datosProducto(), false);
            } else {
                IO_ES.escribirArchivo(rutaDatos + "/" + "DatosProducto.dat", MISPRODUCTOS.get(i).datosProducto(), true);
            }
        }
        
        File ficheroCliente = new File(Constante.RutaDatos() + "/" + "DatosCliente.dat");
        ficheroCliente.delete();
        File ficheroProductos = new File(Constante.RutaDatos() + "/" + "DatosProducto.dat");
        ficheroProductos.delete();
        for (Cliente x : MISCLIENTES) {
            IO_ES.escribirArchivo(rutaDatos + "/" + "DatosCliente.dat", x.datosCliente(), true);
        }
        for (Producto y : MISPRODUCTOS) {
            IO_ES.escribirArchivo(rutaDatos + "/" + "DatosProducto.dat", y.datosProducto(), true);
        }
         */

        for (int i = 0; i < MISCLIENTES.size(); i++) {
            if (i == 0) {
                IO_ES.escribirArchivo(rutaDatos + "\\" + "datosApliacionClientes",
                        MISCLIENTES.get(i).datosCliente(), false);
            } else {
                IO_ES.escribirArchivo(rutaDatos + "\\" + "datosApliacionClientes",
                        MISCLIENTES.get(i).datosCliente(), true);
            }
        }

        for (int i = 0; i < MISPRODUCTOS.size(); i++) {
            if (i == 0) {
                IO_ES.escribirArchivo(rutaDatos + "\\" + "datosAplicacionProductos",
                        MISPRODUCTOS.get(i).datosProducto(), false);
            } else {
                IO_ES.escribirArchivo(rutaDatos + "\\" + "datosAplicacionProductos",
                        MISPRODUCTOS.get(i).datosProducto(), true);
            }
        }

        IO_ES.escribirLN(Color.verde() + "Los datos se han guardado correctamente" + Color.reset());
    }

    /**
     * Método para leer los datos del programa
     *
     * @param rutaDatos la ruta donde leemos los datos
     */
    public static void leerDatos(String rutaDatos) {
        /*String contenidoCliente = IO_ES.leerArchivo(rutaDatos + "/" + "DatosCliente.dat");
        String contenidoProducto = IO_ES.leerArchivo(rutaDatos + "/" + "DatosProducto.dat");
        //Todas las lineas del archivo cliente
        String[] lineasC = contenidoCliente.split("\n");
        String[] lineasP = contenidoProducto.split("\n");
        for (int i = 0; i < lineasC.length; i++) {
            String[] argumentos = lineasC[i].split("&");
            //Son los atributos de la clase Clientes
            if (argumentos.length == 5 && buscarClientes(argumentos[0]) == null) {
                if (ValidarDatos.validarNIF(argumentos[0])) {
                    if (ValidarDatos.validarTelefono(argumentos[3])) {
                        MISCLIENTES.add(new Cliente(argumentos[0], argumentos[1], argumentos[2], argumentos[3],
                                Boolean.valueOf(argumentos[4])));
                    } else {
                        IO_ES.escribirLN(Color.rojo() + "El teléfono no es válido" + Color.reset());
                    }
                } else {
                    IO_ES.escribirLN(Color.rojo() + "El NIF no es válido" + Color.reset());
                }
            }
        }
        for (int i = 0; i < lineasP.length; i++) {
            String[] argumentos = lineasP[i].split("&");
            if (argumentos.length == 9 && argumentos[0].equalsIgnoreCase("medicamento")) {
                MISPRODUCTOS.add(new Medicamento(argumentos[1], argumentos[2], argumentos[3], Double.parseDouble(argumentos[4]),
                        Integer.parseInt(argumentos[5]), TipoMedicamento.valueOf(argumentos[6]), argumentos[7], argumentos[8]));
            }
            if (argumentos.length == 9 && argumentos[0].equalsIgnoreCase("parafarmacia")) {
                MISPRODUCTOS.add(new Parafarmacia(argumentos[1], argumentos[2], argumentos[3], Double.parseDouble(argumentos[4]),
                        Integer.parseInt(argumentos[5]), Categoria.valueOf(argumentos[6]), Integer.parseInt(argumentos[7]),
                        Double.parseDouble(argumentos[8])));
            }
        }*/

        String contenidoArchivoClientes = IO_ES.leerArchivo(rutaDatos + "\\" + "DatosCliente.dat");
        String contenidoArchivoProductos = IO_ES.leerArchivo(rutaDatos + "\\" + "DatosProducto.dat");

        String[] arrayContenidoClientes = contenidoArchivoClientes.split("\n");
        String[] arrayContenidoProductos = contenidoArchivoProductos.split("\n");

        for (int i = 0; i < arrayContenidoClientes.length; i++) {
            String[] argumentos = arrayContenidoClientes[i].split("&");
            MISCLIENTES.add(new Cliente(argumentos[0], argumentos[1], argumentos[2],
                    argumentos[3], Boolean.valueOf(argumentos[4])));
        }

        for (int i = 0; i < arrayContenidoProductos.length; i++) {
            String[] argumentos = arrayContenidoProductos[i].split("&");
            if (argumentos[0].equalsIgnoreCase("medicamento")) {
                MISPRODUCTOS.add(new Medicamento(argumentos[1], argumentos[2], argumentos[3], Double.parseDouble(argumentos[4]),
                        Integer.parseInt(argumentos[5]), TipoMedicamento.valueOf(argumentos[6]), argumentos[7], argumentos[8]));
            }
            if (argumentos[0].equalsIgnoreCase("parafarmacia")) {
                MISPRODUCTOS.add(new Parafarmacia(argumentos[1], argumentos[2], argumentos[3], Double.parseDouble(argumentos[4]),
                        Integer.parseInt(argumentos[5]), Categoria.valueOf(argumentos[6]), Integer.parseInt(argumentos[7]),
                        Double.parseDouble(argumentos[8])));
            }
        }
    }

    /**
     * Método para buscar un cliente
     *
     * @param id DNI o NIF del cliente que deseamos buscar
     * @return Devuelve el cliente si ha sido encontrado
     */
    public static Cliente buscarClientes(String id) {
        boolean encontrado = false;
        Cliente cliente = null;
        for (Cliente x : MISCLIENTES) {
            if (x.getId().equalsIgnoreCase(id)) {
                encontrado = true;
                cliente = x;
            }
            if (encontrado) {
                break;
            }
        }
        return cliente;
    }

    /**
     * Método para buscar un producto
     *
     * @param codigo Código del producto que deseamos buscar
     * @return Devuelve el producto si ha sido encontrado
     */
    public static Producto buscarProductos(String codigo) {
        boolean encontrado = false;
        Producto producto = null;
        for (Producto y : MISPRODUCTOS) {
            if (y.getCodigo().equalsIgnoreCase(codigo)) {
                encontrado = true;
                producto = y;
            }
            if (encontrado) {
                break;
            }
        }
        return producto;
    }

    /**
     * Método para añadir un cliente
     */
    public static void aniadirClientes() {
        String id, nombre, direccion, telefono;

        IO_ES.escribirLN("\n---------------------------------------");
        IO_ES.escribirLN("AÑADIR CLIENTE");
        id = IO_ES.leerCadena("Introduzca el NIF/DNI del cliente: ", 9);
        if (buscarClientes(id) != null) {
            IO_ES.escribirLN(Color.rojo() + "Ya hay un cliente dado de alta con ese DNI/NIF" + Color.reset());
        } else if (ValidarDatos.validarNIF(id)) {
            nombre = IO_ES.leerCadena("Introduzca el nombre: ");
            direccion = IO_ES.leerCadena("Introduzca la dirección: ");
            telefono = IO_ES.leerCadena("Introduzca el teléfono: ");
            if (ValidarDatos.validarTelefono(telefono)) {
                MISCLIENTES.add(new Cliente(id, nombre, direccion, telefono));
                IO_ES.escribirLN(Color.verde() + "Cliente añadido" + Color.reset());
            } else {
                IO_ES.escribirLN(Color.rojo() + "El numero de teléfono no es correcto" + Color.reset());
            }
        } else {
            IO_ES.escribirLN(Color.rojo() + "El DNI/NIF es incorrecto" + Color.reset());
        }
    }

    /**
     * Método para dar de baja a un cliente
     */
    public static void bajaCliente() {
        String cliente;
        boolean encontrado = false;
        boolean baja;

        IO_ES.escribirLN("\n---------------------------------------");
        IO_ES.escribirLN("DAR DE BAJA CLIENTE");
        cliente = IO_ES.leerCadena("Introduzca el DNI/NIF: ", 9);
        if (buscarClientes(cliente) != null) {
            encontrado = true;
            IO_ES.escribirLN("---------------------------------------");
            System.out.println(buscarClientes(cliente));
        }
        if (buscarClientes(cliente).getBaja() && buscarClientes(cliente).getId().equalsIgnoreCase(cliente)) {
            IO_ES.escribirLN(Color.rojo() + "El cliente ya estaba dado de baja" + Color.reset());
        }
        if (!buscarClientes(cliente).getBaja() && buscarClientes(cliente).getId().equalsIgnoreCase(cliente)) {
            baja = IO_ES.leerBoleano("¿Quieres dar de baja al cliente?: ");
            if (baja) {
                buscarClientes(cliente).setBaja(baja);
                IO_ES.escribirLN(Color.verde() + "El cliente se ha dado de baja" + Color.reset());
            } else {
                IO_ES.escribirLN(Color.verde() + "El cliente no se ha dado de baja" + Color.reset());
            }
        }
        if (!encontrado) {
            IO_ES.escribirLN(Color.rojo() + "El cliente no se encuentra en la base de datos" + Color.reset());
        }
    }

    /**
     * Método para modificar los datos de un cliente
     */
    public static void modificarCliente() {
        int opciones;
        String cliente;
        boolean encontrado = false;

        IO_ES.escribirLN("\n---------------------------------------");
        IO_ES.escribirLN("MODIFICAR CLIENTE");
        IO_ES.escribirLN("1. Nombre");
        IO_ES.escribirLN("2. Dirección");
        IO_ES.escribirLN("3. Teléfono");
        IO_ES.escribirLN("4. Alta");
        IO_ES.escribirLN("0. Salir");
        opciones = IO_ES.leerInteger("Elige una opción para modificar del cliente: ", 0, 4);
        cliente = IO_ES.leerCadena("Introduzca el DNI/NIF: ", 9);

        if (buscarClientes(cliente) != null) {
            encontrado = true;
            IO_ES.escribirLN("---------------------------------------");
            System.out.println(buscarClientes(cliente));
        }
        if (!encontrado) {
            IO_ES.escribirLN(Color.rojo() + "El cliente no se encuentra en la base de datos" + Color.reset());
        }
        if (encontrado) {
            IO_ES.escribirLN("---------------------------------------");

            switch (opciones) {
                case 1:
                    String nombreNuevo = IO_ES.leerCadena("Escribe el nuevo nombre: ");
                    buscarClientes(cliente).setNombre(nombreNuevo);
                    IO_ES.escribirLN(Color.verde() + "El nombre se ha modificado" + Color.reset());
                    break;
                case 2:
                    String dirreccionNuevo = IO_ES.leerCadena("Escribe la nueva dirección: ");
                    buscarClientes(cliente).setDireccion(dirreccionNuevo);
                    IO_ES.escribirLN(Color.verde() + "La dirección se ha modificado" + Color.reset());
                    break;
                case 3:
                    String telefonoNuevo = IO_ES.leerCadena("Escribe el nuevo teléfono: ");
                    if (ValidarDatos.validarTelefono(telefonoNuevo)) {
                        buscarClientes(cliente).setTelefono(telefonoNuevo);
                        IO_ES.escribirLN(Color.verde() + "El número de teléfono se ha modificado" + Color.reset());
                    } else {
                        IO_ES.escribirLN(Color.rojo() + "El numero de teléfono no es correcto" + Color.reset());
                    }
                    break;
                case 4:
                    boolean alta = IO_ES.leerBoleano("¿Quieres dar de alta al cliente?: ");

                    if (alta) {
                        if (buscarClientes(cliente).getBaja() == false) {
                            IO_ES.escribirLN(Color.rojo() + "El cliente ya estaba dado de alta" + Color.reset());
                        } else {
                            buscarClientes(cliente).setBaja(false);
                            IO_ES.escribirLN(Color.verde() + "El cliente se ha dado de alta" + Color.reset());
                        }
                    }
                    break;
                case 0:
                    break;
            }
        }
    }

    /**
     * Método para mostrar clientes
     */
    public static void mostrarClientes() {
        int opciones;
        String cliente;
        boolean encontrado = false;

        IO_ES.escribirLN("\n---------------------------------------");
        IO_ES.escribirLN("MOSTRAR CLIENTES");
        IO_ES.escribirLN("1. Mostrar todos los clientes");
        IO_ES.escribirLN("2. Buscar un cliente");
        IO_ES.escribirLN("3. Mostrar los clientes dado de baja");
        IO_ES.escribirLN("0. Salir");
        opciones = IO_ES.leerInteger("Elige una opción: ", 0, 3);
        switch (opciones) {
            case 1:
                for (Cliente x : MISCLIENTES) {
                    encontrado = true;
                    IO_ES.escribirLN("---------------------------------------");
                    IO_ES.escribirLN(x.toString());
                }
                if (!encontrado) {
                    IO_ES.escribirLN(Color.rojo() + "La base de datos de clientes esta vacia" + Color.reset());
                }
                break;
            case 2:
                cliente = IO_ES.leerCadena("Introduzca el DNI/NIF: ", 9);
                if (buscarClientes(cliente).getId().equalsIgnoreCase(cliente)) {
                    IO_ES.escribirLN("---------------------------------------");
                    IO_ES.escribirLN(buscarClientes(cliente).toString());
                } else {
                    IO_ES.escribirLN(Color.rojo() + "El cliente no se ha encontrado" + Color.reset());
                }
                break;
            case 3:
                for (Cliente x : MISCLIENTES) {
                    if (x.getBaja() == true) {
                        encontrado = true;
                        IO_ES.escribirLN("---------------------------------------");
                        IO_ES.escribirLN(x.toString());
                    }
                }
                if (!encontrado) {
                    IO_ES.escribirLN(Color.rojo() + "No hay clientes dados de baja" + Color.reset());
                }
                break;
            case 0:
                break;
        }
    }

    /**
     * Método para ordenar los clientes
     */
    public static void ordenarClientes() {
        int opciones;

        IO_ES.escribirLN("\n---------------------------------------");
        IO_ES.escribirLN("ORDENAR CLIENTES");
        IO_ES.escribirLN("1. Ordenar por DNI");
        IO_ES.escribirLN("2. Ordenar por nombre");
        IO_ES.escribirLN("0. Salir");
        opciones = IO_ES.leerInteger("Introduce una opción: ");
        switch (opciones) {
            case 1:
                Collections.sort(MISCLIENTES);
                IO_ES.escribirLN(Color.verde() + "Los clientes se han ordenado por su DNI" + Color.reset());
                for (Cliente x : MISCLIENTES) {
                    IO_ES.escribirLN("---------------------------------------");
                    IO_ES.escribirLN(x.toString());
                }
                break;
            case 2:
                Collections.sort(MISCLIENTES, new ComparatorClienteNombre());
                IO_ES.escribirLN(Color.verde() + "Los clientes se han ordenado por su nombre" + Color.reset());
                for (Cliente x : MISCLIENTES) {
                    IO_ES.escribirLN("---------------------------------------");
                    IO_ES.escribirLN(x.toString());
                }
                break;
            case 0:
                break;
        }
    }

    /**
     * Método para añadir un producto
     */
    public static void aniadirProducto() {
        String codigo, nombre, descripcion, comoTomar, efectosAdversos;
        TipoMedicamento tipoMedicamento;
        int dosisUnidades;
        double descuento;
        double precio;
        int unidades;
        boolean encontrado = false;
        boolean correcto = false;
        int tipoProducto;
        Categoria categoria;

        IO_ES.escribirLN("\n---------------------------------------");
        IO_ES.escribirLN("AÑADIR PRODUCTO");
        do {
            tipoProducto = IO_ES.leerInteger("\n1. Medicamento \n2. Parafarmacia \n0. Salir \nQue tipo de producto vas añadir: ", 0, 2);
            switch (tipoProducto) {
                case 1:
                    codigo = IO_ES.leerCadena("Introduzca el código del medicamento: ");
                    if (!Producto.comprobarCodigo(codigo)) {
                        codigo = "X";
                    }
                    if (buscarProductos(codigo) != null && codigo != "X") {
                        encontrado = true;
                        IO_ES.escribirLN("El código del medicamento ya esta asignado");
                    } else if (!encontrado) {
                        nombre = IO_ES.leerCadena("Introduzca el nombre del medicamento: ");
                        descripcion = IO_ES.leerCadena("Introduzca la descripción del medicamento: ");
                        precio = IO_ES.leerReallargo("Introduzca el precio del medicamento: ");
                        unidades = IO_ES.leerInteger("Introduzca las unidades del medicamento: ", 0);
                        tipoMedicamento = modificarTipoMedicamento();
                        comoTomar = IO_ES.leerCadena("Introduzca el método para consumir el medicamento: ");
                        efectosAdversos = IO_ES.leerCadena("Introduzca los efectos adversos del medicamentos: ");
                        MISPRODUCTOS.add(new Medicamento(codigo, nombre, descripcion, precio, unidades, tipoMedicamento,
                                comoTomar, efectosAdversos));
                        IO_ES.escribirLN(Color.verde() + "Se ha añadido un medicamento" + Color.reset());
                    }
                    break;
                case 2:
                    codigo = IO_ES.leerCadena("Introduzca el código del producto de Parafarmacia: ");
                    if (!Producto.comprobarCodigo(codigo)) {
                        codigo = "X";
                    }
                    if (buscarProductos(codigo) != null && codigo != "X") {
                        encontrado = true;
                        IO_ES.escribirLN(Color.rojo() + "El código del producto ya esta asignado" + Color.reset());
                    } else if (encontrado == false) {
                        nombre = IO_ES.leerCadena("Introduzca el nombre del producto de Parafarmacia: ");
                        descripcion = IO_ES.leerCadena("Introduzca la descripción del producto de Parafarmacia: ");
                        precio = IO_ES.leerReallargo("Introduzca el precio del producto de Parafarmacia: ");
                        unidades = IO_ES.leerInteger("Introduzca las unidades del producto de Parafarmacia: ", 0);
                        dosisUnidades = IO_ES.leerInteger("Introduzca las unidades de las dosis: ", 0);
                        descuento = IO_ES.leerReallargo("Introduzca el descuento (en porcentaje): ");
                        categoria = modificarCategoria();
                        MISPRODUCTOS.add(new Parafarmacia(codigo, nombre, descripcion, precio, unidades, categoria,
                                dosisUnidades, descuento));
                        IO_ES.escribirLN(Color.verde() + "Se ha añadido un producto de Parafarmacia" + Color.reset());
                    }
                    break;
                case 0:
                    correcto = true;
                    break;
            }
        } while (correcto == false);
    }

    /**
     * Método para mostrar los productos
     */
    public static void mostrarProductos() {
        int opciones;
        boolean encontrado = false;

        IO_ES.escribirLN("\n---------------------------------------");
        IO_ES.escribirLN("1. Mostrar todos los productos");
        IO_ES.escribirLN("2. Buscar un producto");
        IO_ES.escribirLN("0. Salir");
        opciones = IO_ES.leerInteger("Escoge una opción: ", 0, 2);
        switch (opciones) {
            case 1:
                for (Producto y : MISPRODUCTOS) {
                    encontrado = true;
                    IO_ES.escribirLN("---------------------------------------");
                    IO_ES.escribirLN(y.toString());
                }
                if (!encontrado) {
                    IO_ES.escribirLN(Color.rojo() + "La base de datos de productos esta vacia" + Color.reset());
                }
                break;
            case 2:
                String codigo = IO_ES.leerCadena("Indica el código del producto: ");
                if (buscarProductos(codigo).getCodigo().equalsIgnoreCase(codigo)) {
                    IO_ES.escribirLN("---------------------------------------");
                    IO_ES.escribirLN(buscarProductos(codigo).toString());
                } else {
                    IO_ES.escribirLN(Color.rojo() + "El producto no se encuentra en la base de datos" + Color.reset());
                }
                break;
            case 0:
                break;
        }
    }

    /**
     * Método para eliminar un producto
     */
    public static void eliminarProducto() {
        String buscar;
        boolean encontrado = false;

        IO_ES.escribirLN("\n---------------------------------------");
        IO_ES.escribirLN("ELIMINAR PRODUCTO");
        buscar = IO_ES.leerCadena("Indique el código del producto: ");
        Medicamento medicamento = (Medicamento) buscarProductos(buscar);
        System.out.println(medicamento.toString());
        /*for (Producto y : MISPRODUCTOS) {
            if (y.getCodigo().equalsIgnoreCase(buscar)) {
                encontrado = true;
                MISPRODUCTOS.remove(y);
                IO_ES.escribirLN(Color.verde() + "El producto se ha eliminado correctamente" + Color.reset());
            }
        }
        if (!encontrado) {
            IO_ES.escribirLN(Color.rojo() + "El producto no se encuentra en la base de datos" + Color.reset());
        }*/
    }

    /**
     * Método para modificar modificar un producto
     */
    public static void modificarProducto() {
        int opciones;
        String producto;
        boolean encontrado = false;

        IO_ES.escribirLN("\n---------------------------------------");
        IO_ES.escribirLN("MODIFICAR PRODUCTO");
        IO_ES.escribirLN("1. Nombre");
        IO_ES.escribirLN("2. Descripción");
        IO_ES.escribirLN("3. Precio");
        IO_ES.escribirLN("Medicamento");
        IO_ES.escribirLN("4. Toma del medicamento");
        IO_ES.escribirLN("5. Efectos adversos");
        IO_ES.escribirLN("6. Tipo de medicamento");
        IO_ES.escribirLN("Parafarmacia");
        IO_ES.escribirLN("7. Categoria");
        IO_ES.escribirLN("8. Dosis de unidades");
        IO_ES.escribirLN("9. Descuento");
        IO_ES.escribirLN("0. Salir");
        opciones = IO_ES.leerInteger("Elige una opción para modificar del producto: ", 0, 9);
        producto = IO_ES.leerCadena("Introduzca el código del producto: ");

        if (buscarProductos(producto) != null) {
            encontrado = true;
            IO_ES.escribirLN("---------------------------------------");
            System.out.println(buscarProductos(producto));
        }

        if (!encontrado) {
            IO_ES.escribirLN(Color.rojo() + "El producto no se encuentra en la base de datos" + Color.reset());
        }
        if (encontrado) {

            switch (opciones) {
                case 1:
                    String nuevoNombre = IO_ES.leerCadena("Escribe el nuevo nombre: ");
                    buscarProductos(producto).setNombre(nuevoNombre);
                    IO_ES.escribirLN(Color.verde() + "El nombre se ha modificado" + Color.reset());
                    break;
                case 2:
                    String nuevaDescripcion = IO_ES.leerCadena("Escribe la nueva descripcion: ");
                    buscarProductos(producto).setDescripcion(nuevaDescripcion);
                    IO_ES.escribirLN(Color.verde() + "La descripción se ha modificado" + Color.reset());
                    break;
                case 3:
                    double nuevoPrecio = IO_ES.leerReallargo("Escribe el nuevo precio: ");
                    buscarProductos(producto).setPrecio(nuevoPrecio);
                    IO_ES.escribirLN(Color.verde() + "El precio se ha modificado" + Color.reset());
                    break;
                case 4:
                    if (buscarProductos(producto).getClass() == Medicamento.class) {
                        String nuevaToma = IO_ES.leerCadena("Escribe la nueva toma del medicamento: ");
                        Medicamento referencia1 = (Medicamento) buscarProductos(producto);
                        referencia1.setComoTomar(nuevaToma);
                        IO_ES.escribirLN(Color.verde() + "La toma se ha modificado" + Color.reset());
                    } else {
                        IO_ES.escribirLN("Solo es válido para los medicamentos");
                    }
                    break;
                case 5:
                    if (buscarProductos(producto).getClass() == Medicamento.class) {
                        String nuevoEfectos = IO_ES.leerCadena("Escribe los nuevos efectos adversos del medicamento: ");
                        Medicamento referencia2 = (Medicamento) buscarProductos(producto);
                        referencia2.setEfectosAdversos(nuevoEfectos);
                        IO_ES.escribirLN(Color.verde() + "Los efectos adversos se ha modificado" + Color.reset());
                    } else {
                        IO_ES.escribirLN("Solo es válido para los medicamentos");
                    }
                    break;
                case 6:
                    if (buscarProductos(producto).getClass() == Medicamento.class) {
                        TipoMedicamento tipoMedicamento = modificarTipoMedicamento();
                        ((Medicamento) buscarProductos(producto)).setTipoMedicamento(tipoMedicamento);
                        IO_ES.escribirLN(Color.verde() + "El tipo de medicamento se ha modificado" + Color.reset());
                    } else {
                        IO_ES.escribirLN("Solo es válido para los medicamentos");
                    }
                    break;
                case 7:
                    if (buscarProductos(producto).getClass() == Parafarmacia.class) {
                        Categoria categoria = modificarCategoria();
                        ((Parafarmacia) buscarProductos(producto)).setCategoria(categoria);
                        IO_ES.escribirLN(Color.verde() + "La categoria se ha modificado" + Color.reset());
                    } else {
                        IO_ES.escribirLN("Solo es válido para los medicamentos");
                    }
                    break;
                case 8:
                    if (buscarProductos(producto).getClass() == Parafarmacia.class) {
                        int nuevaDosis = IO_ES.leerInteger("Escribe la nueva dosis del producto: ");
                        Parafarmacia referencia1 = (Parafarmacia) buscarProductos(producto);
                        referencia1.setDosisUnidades(nuevaDosis);
                        IO_ES.escribirLN(Color.verde() + "La dosis se ha modificado" + Color.reset());
                    } else {
                        IO_ES.escribirLN("Solo es válido para parafarmacia");
                    }
                    break;
                case 9:
                    if (buscarProductos(producto).getClass() == Parafarmacia.class) {
                        double nuevoDescuento = IO_ES.leerReallargo("Escribe el nuevo descuento del producto: ");
                        Parafarmacia referencia2 = (Parafarmacia) buscarProductos(producto);
                        referencia2.setDescuento(nuevoDescuento);
                        IO_ES.escribirLN(Color.verde() + "El descuento se ha modificado" + Color.reset());
                    } else {
                        IO_ES.escribirLN("Solo es válido para parafarmacia");
                    }
                    break;
                case 0:
                    break;
            }
        }
    }

    /**
     * Método para elegir el tipo de medicamento
     *
     * @return el Tipo de medicamento
     */
    public static TipoMedicamento modificarTipoMedicamento() {
        int opciones;
        TipoMedicamento tipoMedicamento = null;

        IO_ES.escribirLN("1.  ANALGESICOS");
        IO_ES.escribirLN("2.  LAXANTES");
        IO_ES.escribirLN("3.  ANTIINFECCIOSOS");
        IO_ES.escribirLN("4.  ANTIDEPRESIVOS");
        IO_ES.escribirLN("5.  ANTITUSIVOS");
        IO_ES.escribirLN("6.  MUCOLITICOS");
        IO_ES.escribirLN("7.  ANTIACIDOS");
        IO_ES.escribirLN("8.  ANTIULCEROSOS");
        IO_ES.escribirLN("9.  ANTIALERGICOS");
        IO_ES.escribirLN("10. ANTIFIARREICO");
        opciones = IO_ES.leerInteger("Indique el tipo de medicamento: ", 1, 10);
        switch (opciones) {
            case 1:
                tipoMedicamento = TipoMedicamento.ANALGESICOS;
                break;
            case 2:
                tipoMedicamento = TipoMedicamento.LAXANTES;
                break;
            case 3:
                tipoMedicamento = TipoMedicamento.ANTIINFECCIOSOS;
                break;
            case 4:
                tipoMedicamento = TipoMedicamento.ANTIDEPRESIVOS;
                break;
            case 5:
                tipoMedicamento = TipoMedicamento.ANTITUSIVOS;
                break;
            case 6:
                tipoMedicamento = TipoMedicamento.MUCOLITICOS;
                break;
            case 7:
                tipoMedicamento = TipoMedicamento.ANTIACIDOS;
                break;
            case 8:
                tipoMedicamento = TipoMedicamento.ANTIULCEROSOS;
                break;
            case 9:
                tipoMedicamento = TipoMedicamento.ANTIALERGICOS;
                break;
            case 10:
                tipoMedicamento = TipoMedicamento.ANTIFIARREICOS;
                break;
        }
        return tipoMedicamento;
    }

    public static Categoria modificarCategoria() {
        int opciones;
        Categoria categoria = null;

        IO_ES.escribirLN("1.  DENTAL");
        IO_ES.escribirLN("2.  FACIAL");
        IO_ES.escribirLN("3.  GELES");
        IO_ES.escribirLN("4.  CABELLO");
        IO_ES.escribirLN("5.  ANTIMOSQUITOS");
        IO_ES.escribirLN("6.  INTIMA");
        IO_ES.escribirLN("7.  NASAL");
        IO_ES.escribirLN("8.  OCULAR");
        IO_ES.escribirLN("9.  BOTIQUIN");
        IO_ES.escribirLN("10. OIDOS");
        IO_ES.escribirLN("11. TOALLITAS");
        IO_ES.escribirLN("12. LIMPIEZA");
        IO_ES.escribirLN("13. HOGAR");
        IO_ES.escribirLN("14. MASCARILLAS");
        opciones = IO_ES.leerInteger("Indique el tipo de Parafarmacia: ", 1, 14);
        switch (opciones) {
            case 1:
                categoria = Categoria.DENTAL;
                break;
            case 2:
                categoria = Categoria.FACIAL;
                break;
            case 3:
                categoria = Categoria.GELES;
                break;
            case 4:
                categoria = Categoria.CABELLO;
                break;
            case 5:
                categoria = Categoria.ANTIMOSQUITOS;
                break;
            case 6:
                categoria = Categoria.INTIMA;
                break;
            case 7:
                categoria = Categoria.NASAL;
                break;
            case 8:
                categoria = Categoria.OCULAR;
                break;
            case 9:
                categoria = Categoria.BOTIQUIN;
                break;
            case 10:
                categoria = Categoria.OIDOS;
                break;
            case 11:
                categoria = Categoria.TOALLITAS;
                break;
            case 12:
                categoria = Categoria.LIMPIEZA;
                break;
            case 13:
                categoria = Categoria.HOGAR;
                break;
            case 14:
                categoria = Categoria.MASCARILLAS;
                break;
        }
        return categoria;
    }

    /**
     * Método para añadir unidades a los productos
     */
    public static void aniadirUnidades() {
        int unidadesAniadidas;
        String buscar;
        boolean encontrado = false;

        IO_ES.escribirLN("\n---------------------------------------");
        IO_ES.escribirLN("AÑADIR UNIDADES");
        buscar = IO_ES.leerCadena("Indica el código del producto: ");
        for (Producto y : MISPRODUCTOS) {
            if (y.getCodigo().equalsIgnoreCase(buscar)) {
                encontrado = true;
                IO_ES.escribirLN("\n---------------------------------------");
                IO_ES.escribirLN(y.toString());
                unidadesAniadidas = IO_ES.leerInteger("Cuantas unidades vas a añadir: ");
                if (y.aniadirUnidades(unidadesAniadidas)) {
                    IO_ES.escribirLN(Color.verde() + "Las unidades se han añadido correctamente" + Color.reset());
                }
            }
        }
        if (!encontrado) {
            IO_ES.escribirLN(Color.rojo() + "El producto no se encuentra en la base de datos" + Color.reset());
        }
    }

    /**
     * Método para eliminar unidades de los productos
     */
    public static void eliminarUnidades() {
        String buscar;
        boolean encontrado = false;
        int unidadesEliminadas;

        IO_ES.escribirLN("\n---------------------------------------");
        IO_ES.escribirLN("ELIMINAR UNIDADES");
        buscar = IO_ES.leerCadena("Indica el código del producto: ");
        for (Producto y : MISPRODUCTOS) {
            if (y.getCodigo().equalsIgnoreCase(buscar)) {
                encontrado = true;
                IO_ES.escribirLN("\n---------------------------------------");
                IO_ES.escribirLN(y.toString());
                unidadesEliminadas = IO_ES.leerInteger("Cuantas unidades vas a eliminar: ");
                if (y.quitarUnidades(unidadesEliminadas)) {
                    IO_ES.escribirLN(Color.verde() + "Las unidades se han eliminado correctamente" + Color.reset());
                }
            }
        }
        if (!encontrado) {
            IO_ES.escribirLN(Color.rojo() + "El producto no se encuentra en la base de datos" + Color.reset());
        }
    }

    /**
     * Método para ordenar los productos
     */
    public static void ordenarProductos() {
        int opciones;

        IO_ES.escribirLN("\n---------------------------------------");
        IO_ES.escribirLN("ORDENAR PRODUCTOS");
        IO_ES.escribirLN("1. Ordenar por ID");
        IO_ES.escribirLN("2. Ordenar por nombre");
        IO_ES.escribirLN("0. Salir");
        opciones = IO_ES.leerInteger("Introduce una opción: ");
        switch (opciones) {
            case 1:
                Collections.sort(MISPRODUCTOS);
                IO_ES.escribirLN(Color.verde() + "Los prodcutos se han ordenado por su ID" + Color.reset());
                break;
            case 2:
                Collections.sort(MISPRODUCTOS, new ComparatorProductoNombre());
                IO_ES.escribirLN(Color.verde() + "Los productos se han ordenado por su nombre" + Color.reset());
                break;
            case 0:
                break;
        }
    }

    /**
     * Método para guardar los datos en XML. la extencion .xml se la añade el
     * método
     *
     */
    public static void escribirXML() {
        String nombreDocumento;

        nombreDocumento = IO_ES.leerCadena("Escribe el nombre del documento: ");
        nombreDocumento = nombreDocumento + ".xml";
        File rutaXml = new File(Constante.RutaXml() + "\\" + nombreDocumento);
        try {
            // Crear una instancia de DocumentBuilderFactory
            DocumentBuilderFactory fabrica = DocumentBuilderFactory.newInstance();
            // Crear un documentBuilder
            DocumentBuilder constructor = fabrica.newDocumentBuilder();
            // Crear un DOMImplementation
            DOMImplementation implementation = constructor.getDOMImplementation();
            // Crear un documento con un elemento raiz
            Document documento = implementation.createDocument(null, nombreDocumento, null);
            documento.setXmlVersion("1.0");

            ///****************************Clientes****************************///
            IO_ES.escribirLN("----------------------------------------------");
            IO_ES.escribirLN("Escribiendo fichero Clientes XML");
            Element Clientes = documento.createElement("Clientes");
            for (Cliente x : MISCLIENTES) {
                IO_ES.escribirLN(" ........ ");
                Element Cliente = x.escribirXML(documento);
                // Añadir al elemento clientes el elemento cliente
                Clientes.appendChild(Cliente);
            }
            // Añado al root el elemento
            documento.getDocumentElement().appendChild(Clientes);

            ///****************************Productos****************************///
            IO_ES.escribirLN("----------------------------------------------");
            IO_ES.escribirLN("Escribiendo fichero Productos XML");
            Element Productos = documento.createElement("Productos");
            for (Producto y : MISPRODUCTOS) {
                IO_ES.escribirLN(" ........ ");
                Element Medicamento = ((Medicamento) y).escribirXML(documento);
                Productos.appendChild(Medicamento);
                IO_ES.escribirLN(" ........ ");
                Element ParaFarmacia = ((Parafarmacia) y).escribirXML(documento);
                Productos.appendChild(ParaFarmacia);

            }
            // Añado al root el elemento
            documento.getDocumentElement().appendChild(Productos);
            // Asociar el source con el Document
            Source fuente = new DOMSource(documento);
            // Crear el Result, indicado que fichero se va a crear
            Result resultado = new StreamResult(rutaXml);
            // Creo un transformer, se crea el fichero XML
            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            transformer.transform(fuente, resultado);

        } catch (ParserConfigurationException | TransformerException ex) {
            IO_ES.escribirLN(ex.getMessage());
        }
    }

    /**
     * Método para leer datos de un archivo XML. la extencion .xml se la añade
     * el método
     *
     */
    public static void leerXML() {
        String etiquetaCliente = "Cliente";
        String etiquetaMedicamento = "Medicamento";
        String etiquetaParafarmacia = "ParaFarmacia";
        String nombreDocumento;
        Producto producto;
        Cliente cliente;

        nombreDocumento = IO_ES.leerCadena("Escribe el nombre del archivo ha leer: ");
        nombreDocumento = nombreDocumento + ".xml";
        nombreDocumento = Constante.RutaXml() + "\\" + nombreDocumento;
        System.out.println("----------------------------------------------");
        System.out.println("Lectura fichero XML");
        MISCLIENTES.clear();
        MISPRODUCTOS.clear();
        try {
            // 1º Creamos una nueva instancia de un fábrica de constructores de documentos.
            DocumentBuilderFactory fabrica = DocumentBuilderFactory.newInstance();
            // 2º A partir de la instancia anterior, fabricamos un constructor de documentos, que procesará el XML.
            DocumentBuilder procesadorXml = fabrica.newDocumentBuilder();
            // 3º Procesamos el documento (almacenado en un archivo) y lo convertimos en un árbol DOM.
            Document documento = procesadorXml.parse(nombreDocumento);

            // Coger todas las etiquetas cliente del documento
            NodeList listaNodos = documento.getElementsByTagName(etiquetaCliente);
            for (int i = 0; i < listaNodos.getLength(); i++) {
                // Cojo el nodo actual
                Node nodo = listaNodos.item(i);
                // Comprobar si el nodo es un elemento
                if (nodo.getNodeType() == Node.ELEMENT_NODE) {
                    // Transformar en Element
                    Element e = (Element) nodo;

                    String id = e.getElementsByTagName("dni").item(0).getTextContent();
                    String nombre = e.getElementsByTagName("nombre").item(0).getTextContent();
                    String direccion = e.getElementsByTagName("direccion").item(0).getTextContent();
                    String telefono = e.getElementsByTagName("telefono").item(0).getTextContent();
                    String baja = e.getElementsByTagName("baja").item(0).getTextContent();

                    if (ValidarDatos.validarNIF(id) && buscarClientes(id) == null) {
                        if (ValidarDatos.validarTelefono(telefono)) {
                            MISCLIENTES.add(new Cliente(id, nombre, direccion, telefono, Boolean.valueOf(baja)));
                        } else {
                            IO_ES.escribirLN(Color.rojo() + "El teléfono no es válido" + Color.reset());
                        }
                    } else {
                        IO_ES.escribirLN(Color.rojo() + "El NIF no es válido" + Color.reset());
                    }
                    IO_ES.escribirLN(" Cliente leido " + (i + 1) + " ..... ");
                }
            }
            // Coger todas las etiquetas medicamento del documento
            NodeList listaMedicamento = documento.getElementsByTagName(etiquetaMedicamento);
            for (int i = 0; i < listaMedicamento.getLength(); i++) {
                // Cojo el nodo actual
                Node nodo = listaMedicamento.item(i);
                // Comprobar si el nodo es un elemento
                if (nodo.getNodeType() == Node.ELEMENT_NODE) {
                    // Transformar en Element
                    Element e = (Element) nodo;

                    String codigo = e.getElementsByTagName("codigo").item(0).getTextContent();
                    String nombre = e.getElementsByTagName("nombre").item(0).getTextContent();
                    String descripcion = e.getElementsByTagName("descripcion").item(0).getTextContent();
                    String precio = e.getElementsByTagName("precio").item(0).getTextContent();
                    String unidades = e.getElementsByTagName("unidades").item(0).getTextContent();
                    String tipoMedicamento = e.getElementsByTagName("tipoMedicamento").item(0).getTextContent();
                    String comoTomar = e.getElementsByTagName("comoTomar").item(0).getTextContent();
                    String efectosAdversos = e.getElementsByTagName("efectosAdversos").item(0).getTextContent();

                    MISPRODUCTOS.add(new Medicamento(codigo, nombre, descripcion, Double.parseDouble(precio),
                            Integer.parseInt(unidades), TipoMedicamento.valueOf(tipoMedicamento), comoTomar, efectosAdversos));
                    IO_ES.escribirLN(" Medicamento leido " + (i + 1) + " ..... ");
                }
            }
            // Coger todas las etiquetas medicamento del documento
            NodeList listaParafarmacia = documento.getElementsByTagName(etiquetaParafarmacia);
            for (int i = 0; i < listaParafarmacia.getLength(); i++) {
                // Cojo el nodo actual
                Node nodo = listaParafarmacia.item(i);
                // Comprobar si el nodo es un elemento
                if (nodo.getNodeType() == Node.ELEMENT_NODE) {
                    // Transformar en Element
                    Element e = (Element) nodo;

                    String codigo = e.getElementsByTagName("codigo").item(0).getTextContent();
                    String nombre = e.getElementsByTagName("nombre").item(0).getTextContent();
                    String descripcion = e.getElementsByTagName("descripcion").item(0).getTextContent();
                    String precio = e.getElementsByTagName("precio").item(0).getTextContent();
                    String unidades = e.getElementsByTagName("unidades").item(0).getTextContent();
                    String categoria = e.getElementsByTagName("categoria").item(0).getTextContent();
                    String dosisUnidades = e.getElementsByTagName("dosisUnidades").item(0).getTextContent();
                    String descuento = e.getElementsByTagName("descuento").item(0).getTextContent();

                    MISPRODUCTOS.add(new Parafarmacia(codigo, nombre, descripcion, Double.parseDouble(precio),
                            Integer.parseInt(unidades), Categoria.valueOf(categoria), Integer.parseInt(dosisUnidades),
                            Double.parseDouble(descuento)));
                    IO_ES.escribirLN(" Parafarmacia leido " + (i + 1) + " ..... ");
                }
            }
        } catch (Exception e) {
            IO_ES.escribirLN("¡Error! No se ha podido cargar el documento XML");
        }
    }
}
