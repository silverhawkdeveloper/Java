package estructuraDatos;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;
import utilidades.IO_ES;

/**
 *
 * @author Daniel Díaz González
 * @version 1.0
 */
abstract public class Producto implements Comparable {

    protected String codigo;
    protected String nombre;
    protected String descripcion;
    protected double precio;
    protected int unidades;

    /**
     * Método constructor
     *
     * @param codigo Código del Producto
     * @param nombre Nombre del Producto
     * @param descripcion Descripción del Producto
     * @param precio Precio del Producto
     * @param unidades Unidades del Producto
     */
    public Producto(String codigo, String nombre, String descripcion, double precio, int unidades) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.unidades = unidades;

        if (precio < 0) {
            this.precio = 0;
        }
        if (unidades < 0) {
            this.unidades = 0;
        }
        if (!comprobarCodigo(codigo)) {
            this.codigo = "X";
        }
    }

    public Producto() {

    }

    /**
     * Constructor copia
     *
     * @param producto Objeto Producto
     */
    public Producto(Producto producto) {
        this.codigo = producto.codigo;
        this.nombre = producto.nombre;
        this.descripcion = producto.descripcion;
        this.precio = producto.precio;
        this.unidades = producto.unidades;
    }

    /**
     * Método para mostrar los datos de los los productos
     *
     * @return Devuelve los datos del prodcuto
     */
    @Override
    public String toString() {
        String datosProducto = "Código: " + this.codigo + "\nNombre: " + this.nombre + "\nDescripción: " + this.descripcion + "\nPrecio: " + this.precio + "\nUnidades: " + this.unidades;
        return datosProducto;

    }

    /**
     * Método que estructura el formato de los datos para su guardado
     *
     * @return Devuelve los datos del producto con un formato de guardado
     */
    public String datosProducto() {
        String datosProducto = this.codigo + "&" + this.nombre + "&" + this.descripcion + "&" + this.precio + "&" + this.unidades + "&";
        return datosProducto;
    }

    /**
     * Método para validar que el código tiene 13 dígitos
     *
     * @param codigo del Producto
     * @return Devuelve true o false si el codigo es correcto o falso
     */
    public static boolean comprobarCodigo(String codigo) {
        Pattern codigoPattern = Pattern.compile("[0-9]{13}"); // Patrón para comprobar el código de los productos
        Matcher m = codigoPattern.matcher(codigo);
        return m.matches();
    }

    /**
     * Método para añadir unidades a un producto
     *
     * @param unidades Número de unidades para añadir
     * @return Devuelve true o false si se ha permitido añadir nuevas unidades
     */
    public boolean aniadirUnidades(int unidades) {
        boolean permitido;
        if (unidades > 0) {
            this.unidades += unidades;
            permitido = true;
        } else {
            IO_ES.escribirLN("No se ha realizado la actualización de los datos");
            permitido = false;
        }
        return permitido;
    }

    /**
     * Método para eliminar unidades de un producto
     *
     * @param unidades Número de unidades para eliminar
     * @return Devuelve true o false si se ha permitido eliminar nuevas unidades
     */
    public boolean quitarUnidades(int unidades) {
        boolean permitido;
        if (unidades > 0) {
            if (unidades > this.unidades) {
                IO_ES.escribirLN("Se han eliminado todas las unidades del producto: " + this.unidades);
                this.unidades -= this.unidades;
            } else {
                this.unidades -= unidades;
            }
            permitido = true;
        } else {
            IO_ES.escribirLN("No se ha realizado la actualización de los datos");
            permitido = false;
        }
        return permitido;
    }

    ///****************************Métodos getter****************************///
    /**
     * Método GET para el código
     *
     * @return Devuelve el código del producto
     */
    public String getCodigo() {
        return this.codigo;
    }

    /**
     * Método GET para el nombre
     *
     * @return Devuelve el nombre del producto
     */
    public String getNombre() {
        return this.nombre;
    }

    /**
     * Método GET para la descripción
     *
     * @return Devuelve la descripción del producto
     */
    public String getDescripcion() {
        return this.descripcion;
    }

    /**
     * Método GET para el precio
     *
     * @return Devuelve el precio del producto
     */
    public double getPrecio() {
        return this.precio;
    }

    /**
     * Método GET para las unidades
     *
     * @return Devuelve las unidades del producto
     */
    public int getUnidades() {
        return this.unidades;
    }

    ///****************************Métodos setter****************************///
    /**
     * Método SET para el id
     *
     * @param codigo Nuevo código para el producto
     */
    public void setCodigo(String codigo) {
        if (comprobarCodigo(codigo)) {
            this.codigo = codigo;
        }
    }

    /**
     * Método SET para el nombre
     *
     * @param nombre Nuevo nombre para el producto
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Método SET para la descripción
     *
     * @param descripcion Nueva descripción para el producto
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * Método SET para el precio
     *
     * @param precio Nuevo precio para el producto
     */
    public void setPrecio(double precio) {
        if (precio >= 0) {
            this.precio = precio;
        }
    }

    @Override
    /**
     * Método para ordenar por el código
     */
    public int compareTo(Object x) {
        int resultado = 0; // son iguales   

        Producto otroProducto = (Producto) x; // habria que quitarlo si ponemos Comparable<Usuario>
        if (this.codigo.compareToIgnoreCase(otroProducto.getCodigo()) > 0) {
            resultado = 1;
        } else if (this.codigo.compareToIgnoreCase(otroProducto.getCodigo()) < 0) {
            resultado = -1;
        }
        return resultado;
    }

    ///****************************Método XML****************************///
    /**
     * Método para guardar los datos del producto en un XML
     *
     * @param documentoXml Objeto documento XML
     * @param x Elemento de medicamento o parafarmacia
     * @return Devuelve los elementos de productos
     */
    public Element escribirXML(Document documentoXml, Element x) {
        //Código
        Element _codigo = documentoXml.createElement("codigo");
        Text textCodigo = documentoXml.createTextNode(String.valueOf(codigo));
        _codigo.appendChild(textCodigo);
        x.appendChild(_codigo);

        //Nombre
        Element _nombre = documentoXml.createElement("nombre");
        Text textNombre = documentoXml.createTextNode(String.valueOf(nombre));
        _nombre.appendChild(textNombre);
        x.appendChild(_nombre);

        //Descripción
        Element _descripcion = documentoXml.createElement("descripcion");
        Text textDescripcion = documentoXml.createTextNode(String.valueOf(descripcion));
        _descripcion.appendChild(textDescripcion);
        x.appendChild(_descripcion);

        //Precio
        Element _precio = documentoXml.createElement("precio");
        Text textPrecio = documentoXml.createTextNode(String.valueOf(precio));
        _precio.appendChild(textPrecio);
        x.appendChild(_precio);

        //Unidades
        Element _unidades = documentoXml.createElement("unidades");
        Text textUnidades = documentoXml.createTextNode(String.valueOf(unidades));
        _unidades.appendChild(textUnidades);
        x.appendChild(_unidades);

        return x;
    }
}
