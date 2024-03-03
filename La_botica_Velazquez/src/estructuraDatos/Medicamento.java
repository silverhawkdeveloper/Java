package estructuraDatos;

import estructuraDatos.Enumerado.TipoMedicamento;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

/**
 *
 * @author Daniel Díaz González
 * @version 1.0
 */
public class Medicamento extends Producto {

    private TipoMedicamento tipoMedicamento;
    private String comoTomar;
    private String efectosAdversos;

    /**
     * Contructor de la clase Medicamentos
     *
     * @param codigo Código del Medicamento
     * @param nombre Nombre del Medicamento
     * @param descripcion Descripción del Medicamento
     * @param precio Precio del Medicamento
     * @param unidades Unidades del Medicamento
     * @param tipoMedicamento Tipo del Medicamento
     * @param comoTomar Como tomar el Medicamento
     * @param efectosAdversos Efectos adversos del Medicamento
     */
    public Medicamento(String codigo, String nombre, String descripcion, double precio, int unidades,
            TipoMedicamento tipoMedicamento, String comoTomar, String efectosAdversos) {
        super(codigo, nombre, descripcion, precio, unidades);
        this.tipoMedicamento = tipoMedicamento;
        this.comoTomar = comoTomar;
        this.efectosAdversos = efectosAdversos;
    }

    public Medicamento() {

    }

    /**
     * Constructor copia
     *
     * @param medicamento Objeto Medicamento
     */
    public Medicamento(Medicamento medicamento) {
        super(medicamento.getCodigo(), medicamento.getNombre(), medicamento.getDescripcion(), medicamento.getPrecio(),
                medicamento.getUnidades());
        this.tipoMedicamento = medicamento.tipoMedicamento;
        this.comoTomar = medicamento.comoTomar;
        this.efectosAdversos = medicamento.efectosAdversos;
    }

    /**
     * Método para mostrar los datos de los medicamentos
     *
     * @return Devuelve los datos del Medicamento
     */
    @Override
    public String toString() {
        String datosMedicamento = super.toString() + "\nTipo del medicamento: " + this.tipoMedicamento
                + "\nToma del medicamento: " + this.comoTomar + "\nEfectos adversos: " + this.efectosAdversos;
        return datosMedicamento;
    }

    /**
     ** Método que estructura el formato de los datos para su guardado
     *
     * @return Devuelve los datos del Medicamento con un formato de guardado
     */
    @Override
    public String datosProducto() {
        String datosMedicamento = "medicamento" + "&" + super.datosProducto() + this.tipoMedicamento + "&"
                + this.comoTomar + "&" + this.efectosAdversos + "\n";
        return datosMedicamento;
    }

    ///****************************Métodos getter****************************///
    /**
     * Método GET para el tipo de medicamento
     *
     * @return Devuelve el tipo de medicamento
     */
    public TipoMedicamento getTipoMedicamento() {
        return this.tipoMedicamento;
    }

    /**
     * Método GET para el la toma del medicamento
     *
     * @return Devuelve como tomar un medicamento
     */
    public String getComoTomar() {
        return this.comoTomar;
    }

    /**
     * Método GET para los efectos adversos
     *
     * @return Devuelve los efectos adversos de los medicamentos
     */
    public String getEfectosAdversos() {
        return this.efectosAdversos;
    }

    ///****************************Métodos setter****************************///
    /**
     * Método SET para el tipo de medicamento
     *
     * @param tipoMedicamento Nuevo tipo de medicamento
     */
    public void setTipoMedicamento(TipoMedicamento tipoMedicamento) {
        this.tipoMedicamento = tipoMedicamento;
    }

    /**
     * Método SET para la toma del medicamento
     *
     * @param comoTomar Nueva forma de tomar un medicamento
     */
    public void setComoTomar(String comoTomar) {
        this.comoTomar = comoTomar;
    }

    /**
     * Método SET para los efectos adversos
     *
     * @param efectosAdversos Nuevos efectos adeversos para los medicamentos
     */
    public void setEfectosAdversos(String efectosAdversos) {
        this.efectosAdversos = efectosAdversos;
    }

    ///****************************Métodos XML****************************///
    /**
     * Método para guardar los datos del medicamento en un XML
     *
     * @param documentoXml Objeto documento XML
     * @return Devuelve los elementos de medicamento
     */
    public Element escribirXML(Document documentoXml) {
        Element Medicamento = documentoXml.createElement("Medicamento");

        super.escribirXML(documentoXml, Medicamento);

        //Tipo de medicamento
        Element _tipoMedicamento = documentoXml.createElement("tipoMedicamento");
        Text textTipoMedicamento = documentoXml.createTextNode(String.valueOf(tipoMedicamento));
        _tipoMedicamento.appendChild(textTipoMedicamento);
        Medicamento.appendChild(_tipoMedicamento);

        //Como tomar el medicamento
        Element _comoTomar = documentoXml.createElement("comoTomar");
        Text textComoTomar = documentoXml.createTextNode(String.valueOf(comoTomar));
        _comoTomar.appendChild(textComoTomar);
        Medicamento.appendChild(_comoTomar);

        //Efectos adversos
        Element _efectosAdversos = documentoXml.createElement("efectosAdversos");
        Text textEfectosAdversos = documentoXml.createTextNode(String.valueOf(efectosAdversos));
        _efectosAdversos.appendChild(textEfectosAdversos);
        Medicamento.appendChild(_efectosAdversos);

        return Medicamento;
    }
}
