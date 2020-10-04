package javaTP1;



public class Main extends Thread {
    public static void main (String[] args){
    	
    	int[]t = {2,3,7,9,15,75};
    	
        Solution s = new Solution();
        Solution u = new Solution();
        Solution v = new Solution();
        Solution m = new Solution();
        Solution a = new Solution();
        
      
        //simu1
        try {
        	s.init(t, 533);
            System.out.println(s.testDesSols(3000));
            
            Thread.sleep(533) ;
         }  catch (InterruptedException e) {
         
             System.out.println("Nombre nn trouvé");
         }
        
        try {
        	
        	 u.init(t, 2012);
             System.out.println(u.testDesSols(3000));
            
            Thread.sleep(2012) ;
         }  catch (InterruptedException e) {
         
        	 System.out.println("Nombre nn trouvé");
         }
        try {
        	v.init(t, 2014);
            System.out.println(v.testDesSols(3000));
            
            Thread.sleep(533) ;
         }  catch (InterruptedException e) {
         
        	 System.out.println("Nombre nn trouvé");
         }
        
        try {
        	 m.init(t, 2018);
             System.out.println(m.testDesSols(3000));
            
            Thread.sleep(2018) ;
         }  catch (InterruptedException e) {
         
        	 System.out.println("Nombre nn trouvé");
         }
        
        try {
        	 a.init(t, 2016);
             System.out.println(a.testDesSols(3000));
           
           Thread.sleep(2016) ;
        }  catch (InterruptedException e) {
        
            System.out.println("Nombre nn trouvé");
        }
        
        
       
        
       
        
    }
}
