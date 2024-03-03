package utilidades;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Daniel Díaz González
 * @version 1.0
 */
public class ValidarDatos {

    /**
     * Método para validar un NIF de un cliente
     *
     * @param nif DNI del cliente
     * @return Devuelve true o false si el DNI es correcto o no
     */
    public static boolean validarNIF(String nif) {
        boolean correcto = false;

        nif = nif.toUpperCase();

        // [0-9]{8}[A-HJ-NP-TV-Z]
        Pattern pNIF = Pattern.compile("([X-Z][0-9]{7}[A-HJ-NP-TV-Z])|([0-9]{8}[A-HJ-NP-TV-Z])");
        Matcher m = pNIF.matcher(nif);

        if (m.matches()) {
            correcto = calcularLetraNIF(nif);
        }

        return correcto;

    }

    //-----------------------------------------------------------------------
    private static boolean calcularLetraNIF(String _nif) {
        boolean correcto = false;
        int num, resto;
        String numInicio = "";
        String letra[] = {"T", "R", "W", "A", "G", "M", "Y", "F", "P", "D", "X", "B", "N", "J", "Z", "S", "Q", "V", "H", "L", "C", "K", "E"};

        String primerTermino = _nif.substring(0, 1);

        switch (primerTermino) {
            case "X":
                numInicio = "0";
                break;
            case "Y":
                numInicio = "1";
                break;
            case "Z":
                numInicio = "2";
                break;
        }

        if (numInicio.equals("")) {
            num = Integer.parseInt(_nif.substring(0, 8));
        } else {
            num = Integer.parseInt(numInicio + _nif.substring(1, 8));
        }

        resto = num % 23;
        if (letra[resto].equals(_nif.substring(8, 9))) {
            correcto = true;

        }

        return correcto;
    }

    /**
     * Método para validar un número de teléfono
     *
     * @param telefono Nuemero de teléfono para verificar
     * @return Devuleve true o false según sea valido o no el número
     */
    public static boolean validarTelefono(String telefono) {
        Pattern p = Pattern.compile("[6789]{1}[0-9]{8}");
        Matcher m = p.matcher(telefono);

        return m.matches();
    }
}
