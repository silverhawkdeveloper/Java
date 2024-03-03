package estructuraDatos;

import java.util.Comparator;

/**
 *
 * @author Daniel Díaz González
 * @version 1.0
 */
public class ComparatorProductoNombre implements Comparator<Producto> {

    /**
     * @param x1
     * @param x2
     * @return vRetorno
     *
     * El método compare debe devolver 0 si son iguales,
     * <0 si el de la izquierda (x1) es menor que el de la derecha (x2) ó
     * >0 si el de la izquierda es mayor que el de la derecha.
     */
    @Override
    public int compare(Producto x1, Producto x2) {
        int vRetorno = 0;
        if (x1.getNombre().compareToIgnoreCase(x2.getNombre()) > 0) {
            vRetorno = 1;
        } else if (x1.getNombre().compareToIgnoreCase(x2.getNombre()) < 0) {
            vRetorno = -1;
        }
        return vRetorno;
    }
}
