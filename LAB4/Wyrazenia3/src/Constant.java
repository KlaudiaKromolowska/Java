package Wyrazenia;
import java.util.*;
import java.lang;
public class Constant extends Wyrazenia.Node {
    double value;

    Constant(double value) {
        this.sign = value < 0 ? -1 : 1;
        this.value = value < 0 ? -value : value;
    }


    @Override
    double evaluate() {
        return sign * value;
    }

    @Override
    public String toString() {
        String sgn = sign < 0 ? "-" : "";
//        return sgn+Double.toString(value);
        DecimalFormat format = new DecimalFormat("0.#####", new DecimalFormatSymbols(Locale.US));
        return sgn + format.format(value);
    }
}