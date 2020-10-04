package javaTP1;

import java.util.function.BiFunction;

public enum Operateur {
	
    ADDITION("+", (a, b)->true, Integer::sum),
    SOUSTRACTION("-", (a,b)->(a-b>0),(a,b)->(a-b)),
    MULTIPLICATION("×", (a,b)->true,(a, b)->(a*b)),
    DIVISION("÷",(a,b)->(a%b == 0),(a,b)->(a/b));
    public final String signe;
    public final BiFunction<Integer, Integer, Boolean> test;
    public final BiFunction<Integer, Integer, Integer> calcul;
    
    //Constructeur
    Operateur(String signe, BiFunction<Integer, Integer, Boolean> test,
              BiFunction<Integer, Integer, Integer> calcul) {
        this.calcul = calcul;
        this.test = test;
        this.signe = signe;
    }
}
