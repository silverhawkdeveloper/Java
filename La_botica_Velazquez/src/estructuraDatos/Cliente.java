package estructuraDatos;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

/**
 *
 * @author Daniel Díaz González
 * @version 1.0
 */
public class Cliente implements Comparable {

    private String id;
    private String nombre;
    private String direccion;
    private String telefono;
    private boolean baja;

    /**
     * Método constructor
     *
     * @param id NIF del cliente
     * @param nombre Nombre del cliente
     * @param direccion Dirección del cliente
     * @param telefono Teléfono del cliente
     */
    public Cliente(String id, String nombre, String direccion, String telefono) {
        this.id = id;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.baja = false;
    }

    /**
     * Método constructor para recuperar datos guardados
     *
     * @param id NIF del cliente
     * @param nombre Nombre del cliente
     * @param direccion Dirección del cliente
     * @param telefono Teléfono del cliente
     * @param baja Baja del cliente
     */
    public Cliente(String id, String nombre, String direccion, String telefono, boolean baja) {
        this.id = id;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.baja = baja;
    }

    public Cliente() {

    }

    /**
     * Constructor copia
     *
     * @param cliente Objeto Cliente
     */
    public Cliente(Cliente cliente) {
        this.id = cliente.id;
        this.nombre = cliente.nombre;
        this.direccion = cliente.direccion;
        this.telefono = cliente.telefono;
        this.baja = cliente.baja;
    }

    /**
     * Método para mostrar los datos de los clientes
     *
     * @return Devuleve los datos del cliente
     */
    @Override
    public String toString() {
        String baja;
        if (this.baja) {
            baja = "Si";
        } else {
            baja = "No";
        }
        String datosCliente = "DNI: " + this.id + "\nNombre: " + this.nombre + "\nTeléfono: " + this.telefono + "\nDirección: "
                + this.direccion + "\nBaja: " + baja;
        return datosCliente;
    }

    /**
     * Método que estructura el formato de los datos para su guardado
     *
     * @return Devuelve los datos de clientes con un formato de guardado
     */
    public String datosCliente() {
        String datosCliente = this.id + "&" + this.nombre + "&" + this.direccion + "&" + this.telefono + "&" + this.baja
                + "\n";
        return datosCliente;
    }

    ///****************************Métodos getter****************************///
    /**
     * Método GET para el id
     *
     * @return Devuelve el NIF del cliente
     */
    public String getId() {
        return this.id;
    }

    /**
     * Método GET para el nombre
     *
     * @return Devuelve el nombre del cliente
     */
    public String getNombre() {
        return this.nombre;
    }

    /**
     * Método GET para la dirección
     *
     * @return Devuelve la dirección del cliente
     */
    public String getDireccion() {
        return this.direccion;
    }

    /**
     * Método GET para el teléfono
     *
     * @return Devuelve el teléfono del cliente
     */
    public String getTelefono() {
        return this.telefono;
    }

    /**
     * Método GET para la baja
     *
     * @return Devuelve si el cliente esta de baja
     */
    public boolean getBaja() {
        return baja;
    }

    ///****************************Métodos setter****************************///
    /**
     * Método SET para el id
     *
     * @param id Nuevo NIF
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Método SET para el nombre
     *
     * @param nombre Nuevo nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Método SET para la dirección
     *
     * @param direccion Nueva dirección
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /**
     * Método SET para el teléfono
     *
     * @param telefono Nuevo teléfono
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**
     * Método SET para la baja
     *
     * @param baja Nueva baja
     */
    public void setBaja(boolean baja) {
        this.baja = baja;
    }

    ///****************************Método XML****************************///
    /**
     * Método para guardar los datos del cliente en un XML
     *
     * @param documentoXml Objeto documento XML
     * @return Devuelve los elementos de cliente
     */
    public Element escribirXML(Document documentoXml) {;
        Element Cliente = documentoXml.createElement("Cliente");

        //ID
        Element _dni = documentoXml.createElement("dni");
        Text textId = documentoXml.createTextNode(String.valueOf(id));
        _dni.appendChild(textId);
        Cliente.appendChild(_dni);

        //Nombre
        Element _nombre = documentoXml.createElement("nombre");
        Text textNombre = documentoXml.createTextNode(String.valueOf(nombre));
        _nombre.appendChild(textNombre);
        Cliente.appendChild(_nombre);

        //Direccion
        Element _direccion = documentoXml.createElement("direccion");
        Text textDireccion = documentoXml.createTextNode(String.valueOf(direccion));
        _direccion.appendChild(textDireccion);
        Cliente.appendChild(_direccion);

        //Telefono
        Element _telefono = documentoXml.createElement("telefono");
        Text textTelefono = documentoXml.createTextNode(String.valueOf(telefono));
        _telefono.appendChild(textTelefono);
        Cliente.appendChild(_telefono);

        //Baja
        Element _baja = documentoXml.createElement("baja");
        Text textBaja = documentoXml.createTextNode(String.valueOf(baja));
        _baja.appendChild(textBaja);
        Cliente.appendChild(_baja);

        return Cliente;
    }

    @Override
    /**
     * Método para ordenar por ID
     */
    public int compareTo(Object x) {
        int resultado = 0; // son iguales   

        Cliente otroCliente = (Cliente) x; // habria que quitarlo si ponemos Comparable<Usuario>
        if (this.id.compareToIgnoreCase(otroCliente.getId()) > 0) {
            resultado = 1;
        } else if (this.id.compareToIgnoreCase(otroCliente.getId()) < 0) {
            resultado = -1;
        }
        return resultado;
    }
}
