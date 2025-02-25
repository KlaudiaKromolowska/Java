package Wyrazenia;
import java.text.Format;
import java.util.*;
import Wyrazenia.Sign;

public class Constant extends Wyrazenia.Node {
    private final Wyrazenia.Sign sign;
    double value;

    public Constant(double value) {
        this.sign = Sign.parse(value);
        this.value = Math.abs(value);
    }

    @Override
    double evaluate() {
        return sign.getValue() * value;
    }

    @Override
    Node diff(Wyrazenia.Variable variable) {
        return new Constant(0);
    }

    @Override
    boolean isDiffZero(Wyrazenia.Variable variable) {
        return true;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("");

        if (sign == Sign.MINUS) {
            builder.append("(");
            builder.append(sign.getStringValue());
        }

        builder.append(Node.NODE_FORMAT.format(value));

        if (sign == Sign.MINUS) {
            builder.append(")");
        }

        return builder.toString();
    }
}