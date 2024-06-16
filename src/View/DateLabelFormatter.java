package View;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.JFormattedTextField.AbstractFormatter;

/**
 * A classe DateLabelFormatter é uma classe utilitária que formata datas para exibição em campos de texto.
 */
public class DateLabelFormatter extends AbstractFormatter {

    private static final long serialVersionUID = 1L;
    private String datePattern = "dd/MM/yyyy"; // O padrão de formato de data
    private SimpleDateFormat dateFormatter = new SimpleDateFormat(datePattern);

    /**
     * Converte uma string em um objeto do tipo Date.
     * @param text A string a ser convertida.
     * @return O objeto Date convertido.
     * @throws ParseException Se ocorrer um erro durante a conversão.
     */
    @Override
    public Object stringToValue(String text) throws ParseException {
        return dateFormatter.parseObject(text);
    }

    /**
     * Converte um objeto do tipo Date em uma string.
     * @param value O objeto Date a ser convertido.
     * @return A representação em string do objeto Date.
     * @throws ParseException Se ocorrer um erro durante a conversão.
     */
    @Override
    public String valueToString(Object value) throws ParseException {
        if (value != null) {
            Calendar cal = (Calendar) value;
            return dateFormatter.format(cal.getTime());
        }

        return "";
    }
}
