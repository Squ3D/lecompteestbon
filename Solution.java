package javaTP1;

import java.lang.reflect.Array;
import java.util.*;

public class Solution extends SolutionAbstraite{
    Random r = new Random();
    @Override
    
    void init(int[] _nombres, int _but) {
    	
        this.nombres = _nombres;
        this.but = _but;
        reinit();
    }

    @Override
    void reinit() {
    	
    	valeursLibres = new Stack<Integer>();
        for (int nb : nombres) {
        	
        	valeursLibres.push(nb);
        	}
        etapes = new StringBuilder();
    }
    
    int getRandom () {
    	
        int value;
        int temp = r.nextInt(valeursLibres.size());
        value = valeursLibres.get(temp);
        valeursLibres.remove(temp);
        return value;
        
    }
    @Override
    int calcule() {
        Integer a;
        Integer b;
        Integer result = 0;

        for (int i = 1 ; i < 6 ; i++) {
            a = getRandom();
            b = getRandom();
            Operateur p = choixOperateurApplicable(a, b);
            result = p.calcul.apply(a, b);
            valeursLibres.push(result);
            etapes.append(String.format("%d", a));
            etapes.append(String.format("%s", p.signe));
            etapes.append(String.format("%d",b));
            etapes.append(String.format("= %d ",result));
            etapes.append(String.format("%n"));
            
            
           
          
            if (result == but) {
                System.out.println("Etape Nécessaire :");
            	return result;}
        }
        return result;
    }

    @Override
    Operateur choixOperateurApplicable(int nb1, int nb2) {
    	Random r = new Random();
        ArrayList<Operateur> p = new ArrayList<>(Arrays.asList(Operateur.values()));
        Operateur[] values = Operateur.values();
		for (int i = 0; i < values.length; i++) {
			Operateur ox = values[i];
			int n = r.nextInt(p.size());
            Operateur op = p.get(n);
            if (op.test.apply(nb1, nb2)) {
            	return op;
            	
            }
            else {
            	
            	p.remove(op);
            	
            }
		}
        return null;
    }

    @Override
    String testDesSols(int nbCalculsMax) {
    	  
           int pc = 0;
           String res = null;
           int bestMax = 0;
           boolean done = false;

           while (!done) {
               int tempSolution = calcule();
               pc++;

               if (tempSolution == but || pc >= nbCalculsMax) {
                   done = true;
                   if (tempSolution == but) {
                	   
                       res = etapes.toString();
                   }
                   
                   System.out.println("Solution trouvée après "+pc+" tentatives.");
                   if(pc == 3000) {
                	   System.out.println("False Positive : 3000 TENTATIVES n'ont pas été suffisantes");
                	   
                   }
               }
               else {
            	   
                   if (Math.abs(tempSolution - but) > Math.abs(bestMax - but)) {
                       bestMax = tempSolution;
                       res = etapes.toString();
                   }
               }
               
               reinit();
           }

           return res;
       }
}
