package estructuraDatos;

/**
 *
 * @author Daniel Díaz González
 * @version 1.0
 */
public class Enumerado {

    /**
     * Categoría de productos de parafarmacia
     */
    public enum Categoria {
        DENTAL, FACIAL, GELES, CORPORAL, CABELLO, ANTIMOSQUITOS, INTIMA,
        NASAL, OCULAR, BOTIQUIN, OIDOS, TOALLITAS, LIMPIEZA, HOGAR, MASCARILLAS
    };

    /**
     * Tipo de medicamento
     */
    public enum TipoMedicamento {
        ANALGESICOS, LAXANTES, ANTIINFECCIOSOS, ANTIDEPRESIVOS, ANTITUSIVOS, MUCOLITICOS, ANTIACIDOS,
        ANTIULCEROSOS, ANTIALERGICOS, ANTIFIARREICOS
    };
}
