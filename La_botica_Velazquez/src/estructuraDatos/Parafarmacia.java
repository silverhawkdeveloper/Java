package estructuraDatos;

import estructuraDatos.Enumerado.Categoria;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

/**
 *
 * @author Daniel Díaz González
 * @version 1.0
 */
public class Parafarmacia extends Producto {

    private Categoria categoria;
    private int dosisUnidades;
    private double descuento;

    /**
     * Contructor de la clase ParaFarmacia
     *
     * @param codigo Código del producto de Parafarmacia
     * @param nombre Nombre del producto de Parafarmacia
     * @param descripcion Descripción del producto de Parafarmacia
     * @param precio Precio del producto de Parafarmacia
     * @param unidades Unidades del producto de Parafarmacia
     * @param categoria Categoria del producto de Parafarmacia
     * @param dosisUnidades Dosis del producto de Parafarmacia
     * @param descuento Descuento del producto de Parafarmacia
     */
    public Parafarmacia(String codigo, String nombre, String descripcion, double precio, int unidades, Categoria categoria,
            int dosisUnidades, double descuento) {
        super(codigo, nombre, descripcion, precio, unidades);
        this.categoria = categoria;
        this.dosisUnidades = dosisUnidades;
        this.descuento = descuento;
    }

    public Parafarmacia() {

    }

    /**
     * Constructor copia
     *
     * @param parafarmacia Objeto Parafarmacia
     */
    public Parafarmacia(Parafarmacia parafarmacia) {
        super(parafarmacia.getCodigo(), parafarmacia.getNombre(), parafarmacia.getDescripcion(), parafarmacia.getPrecio(),
                parafarmacia.getUnidades());
        this.categoria = parafarmacia.categoria;
        this.dosisUnidades = parafarmacia.dosisUnidades;
        this.descuento = parafarmacia.descuento;
    }

    /**
     * Método para mostrar los datos de parafarmacia
     *
     * @return Devuelve los datos de Parafarmacia
     */
    @Override
    public String toString() {
        String datosParafarmacia = super.toString() + "\nCategoria: " + this.categoria + "\nDosis de las unidades: "
                + this.dosisUnidades + "\nDescuento: " + this.descuento;
        return datosParafarmacia;
    }

    /**
     ** Método que estructura el formato de los datos para su guardado
     *
     * @return Devuelve los datos de Parafarmacia con un formato de guardado
     */
    @Override
    public String datosProducto() {
        String datosParafarmacia = "parafarmacia" + "&" + super.datosProducto() + this.categoria + "&" + this.dosisUnidades
                + "&" + this.descuento + "\n";
        return datosParafarmacia;
    }

    ///****************************Métodos getter****************************///
    /**
     * Método GET para la categoría
     *
     * @return Devuelve la categoría del producto de Parafarmacia
     */
    public Categoria getCategoria() {
        return this.categoria;
    }

    /**
     * Método GET para las dosis
     *
     * @return Devuelve las dosis de cada producto
     */
    public int getDosisUnidades() {
        return this.dosisUnidades;
    }

    /**
     * Método GET para el descuento
     *
     * @return Devuelve el descuento de cada producto
     */
    public double getDescuento() {
        return this.descuento;
    }

    ///****************************Métodos setter****************************///
    /**
     * Método SET para la categoría
     *
     * @param categoria Nueva categoria del producto de Parafarmacia
     */
    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    /**
     * Método SET para las dosis
     *
     * @param dosisUnidades Nuevas dosis para el producto
     */
    public void setDosisUnidades(int dosisUnidades) {
        this.dosisUnidades = dosisUnidades;
    }

    /**
     * Método SET para el descuento
     *
     * @param descuento Nuevo descuento del producto
     */
    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }

    ///****************************Método XML****************************///
    /**
     * Método para guardar los datos de parafarmacia en un XML
     *
     * @param documentoXml Objeto documento XML
     * @return Devuelve los elementos de parafarmacia
     */
    public Element escribirXML(Document documentoXml) {
        Element ParaFarmacia = documentoXml.createElement("ParaFarmacia");

        super.escribirXML(documentoXml, ParaFarmacia);

        //Categoría de parafarmacia
        Element _categoria = documentoXml.createElement("categoria");
        Text textCategoria = documentoXml.createTextNode(String.valueOf(categoria));
        _categoria.appendChild(textCategoria);
        ParaFarmacia.appendChild(_categoria);

        //Dosis del producto
        Element _dosisUnidades = documentoXml.createElement("dosisUnidades");
        Text textDosisUnidades = documentoXml.createTextNode(String.valueOf(dosisUnidades));
        _dosisUnidades.appendChild(textDosisUnidades);
        ParaFarmacia.appendChild(_dosisUnidades);

        //Descuento del producto
        Element _descuento = documentoXml.createElement("descuento");
        Text textDescuento = documentoXml.createTextNode(String.valueOf(descuento));
        _descuento.appendChild(textDescuento);
        ParaFarmacia.appendChild(_descuento);

        return ParaFarmacia;
    }
}
