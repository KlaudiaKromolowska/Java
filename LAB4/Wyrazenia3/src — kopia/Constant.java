package Wyrazenia;
import java.util.*;
import java.lang;
public class Constant extends Wyrazenia.Node {
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
    Node diff(Variable variable) {
        return new Constant(0);
    }

    @Override
    boolean isDiffZero(Variable variable) {
        return true;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("");

        if (sign == Sign.MINUS) {
            builder.append("(");
            builder.append(sign.getStringValue());
        }

        builder.append(NODE_FORMAT.format(value));

        if (sign == Sign.MINUS) {
            builder.append(")");
        }

        return builder.toString();
    }
}