package Wyrazenia;

abstract public class Node {
    int sign=1;
    Node minus(){
        sign = -1;
        return this;
    }
    Node plus(){
        sign = 1;
        return this;
    }
    int getSign(){return sign;}

    /**
     * Oblicza wartość wyrażenia dla danych wartości zmiennych
     * występujących w wyrażeniu
     */
    abstract double evaluate();

    /**
     *
     * zwraca tekstową reprezentację wyrażenia
     */
    public String toString(int sign){
        if (sign<0)
            return ("[" +sign + "]";
        else
            return sign;

    }

    /**
     *
     * Zwraca liczbę argumentów węzła
     */
    int getArgumentsCount(){return 0;}

}