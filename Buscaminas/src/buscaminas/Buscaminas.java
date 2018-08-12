
package buscaminas;

/**
 *
 * @author JUANFELIPEAREIZAMONS
 */
import java.util.Random;
import java.util.Scanner;
public class Buscaminas {

public static int Filas, Columnas,Minas,fila, columna,conteobanderas ;
public static String [][] Matriz;
public static String [][] Matriz2;
public static String Accion;
public static boolean valminas;
public static boolean Finjuego;
    public static void main(String[] args) {
         System.out.print("BIENVENIDO A BUSCAMINAS \n");
          System.out.print("---------------------------------------------------\n");
          conteobanderas=Minas;
          int j;
          do{PedirDatos();
          Scanner r = new Scanner(System.in);
          CrearyLlenarMatriz();
          ImprimirMatriz();
          int s= 1;
          while(s !=0){
          Jugada();
          
          if (Finjuego){
          s=0;
          Finjuego=false;
          
          }if(valminas){
              s=0;
              System.out.print("Haz Ganado El juego\n");
              valminas=false;
          }
          
          
          }
          System.out.print("¿Deseas Volver a jugar?, 0 para jugar, 1 para salir\n");
          j= r.nextInt();
          }
          while(j==0);
                  
          
          
    }
    public static void PedirDatos(){
   Scanner Entrada = new Scanner(System.in);
        System.out.print("Ingrese la cantidad de filas\n ");
        Filas =Integer.parseInt(Entrada.next());
        System.out.print("Ingrese la cantidad de Columnas\n");
      Columnas=Integer.parseInt(Entrada.next());
      System.out.print("Ingrese la cantidad de Minas\n");
       Minas= Integer.parseInt(Entrada.next());
      conteobanderas=Minas;
     
    }
  
    public static void CrearyLlenarMatriz(){
      
      Matriz = new String [Filas][Columnas];
        Matriz2 = new String [Filas][Columnas];
   
        for (int l = 0; l < Filas; l++) {
            for (int m = 0; m < Columnas; m++) {
                Matriz[l][m] = ".";
            }
        
	}
         
        for (int l = 0; l < Filas; l++) {
           
            for (int m = 0; m < Columnas; m++) {
               int Numero = (int) (Math.random()*5);
             
                Matriz2[l][m] = String.valueOf(Numero);
            }
        }
       
            int i =0;
             out:
            while(i<Filas){
             int y=(int) (Math.random()*(Filas-1));    
            int s=(int) (Math.random()*(Columnas-1));
            
            Matriz2[y][s] ="-";
            i++;
            if(i==Filas){
           break out;
            }
            
        
	}
      
      
      MinasAleatorio();
     
      
       }
    
    public static void ImprimirMatriz(){
        
     for (int i = 0; i < Filas; i++) {
            if (i == 0) {
                System.out.println("---------------------------------\n");
            }
            System.out.printf("%4s", i + " ");
            for (int j = 0; j < Columnas; j++) {
                System.out.printf("%s", "|" + Matriz[i][j] + "|");
            }
            if (i == Filas - 1) {
                System.out.println("");
                for (int j = 0; j < Columnas; j++) {
                    if (j == 0) {
                        System.out.print("    ");
                    }
                    System.out.printf("%3s", j + " ");
                }
            }
            System.out.print("\n");
           
     
     }
     
    }
   
    public static void MinasAleatorio(){
        int i = 0;
        Random r = new Random();
        out:
        while (i <= Minas) {
            {
                    
                   int y=(int) (Math.random()*(Filas-1));
                   int s=(int) (Math.random()*(Columnas-1));
                   
                   if(Matriz2[y][s].equals("*")){
                   
                   
                   }else{
                   Matriz2[y][s] = "*";
                   }
                        
                        ++i;
                        if (i == Minas) {
                            break out;
                        }
                    }
                    
                }
       
               
            }
            

        public static void Jugada()
        {
            conteobandera();
            Scanner m = new Scanner(System.in);
        System.out.print("Ingrese la fila\n");
       fila = m.nextInt();
        System.out.print("Ingrese la Columna\n");
        columna = m.nextInt();
        System.out.print("Ingrese la accion a realizar, Recuerda U para buscar, M para poner bandera\n");
        Accion = m.next();
       Accion= Accion.toUpperCase();
       int des1 = fila, des2 = columna;
       
        Jugar(des1,des2);
        }
      public static void Jugar(int des1, int des2){ 
      if(Validar()){
          if(Accion.equals("U") ){
              int casillorg = fila;
        int casill2org = columna;
        if (fila > Filas - 1 || fila < 0 || columna > Columnas - 1 || columna < 0) {
            return;
        }
         if(Matriz2 [casillorg][casill2org].equals("-")){
          
       }
        if (Matriz2 [casillorg][casill2org].equals("*")) {
            
            System.out.println("La partida ha finalizado \n");
            System.out.println("");
            Matriz[fila][columna] = Matriz2[fila][columna];
            Finjuego =true;
            
        }
      
          else{
          Matriz[fila][columna]=Matriz2[fila][columna];
          
           for (int l = fila/2; l < fila+1; l++) {
            for (int t = columna/2; t < columna+1; t++) {
                if (Matriz2[l][t].equals
                    ("*")){
                
                }else{
                Matriz[l][t]=Matriz2[l][t];
                }
            }
        
	}
           
          }
        ImprimirMatriz();
          }
          if (Accion.equals("M")){
              int m=0;
          Matriz[fila][columna]="p";
          if(Matriz2[fila][columna].equals("*")){
             m++;
            valminas= Validarminas(m);
            
          }
          conteobanderas--;
          ImprimirMatriz();
          }
      } 
      
      
      }
        public static boolean Validar(){
        if(fila<Filas && columna<Columnas && ((Accion.equals("U") || Accion.equals("M"))) ){
            {
                if(Matriz[fila][columna].equals
                    ("p")){
                    System.out.print("Se encuentra una bandera\n");
                            return false;
                }else{return true;}
                
            }
            
        } 
      System.out.print("Ingrese los datos correctamente\n");
       return false;
        
        
        }
       public static boolean Validarminas(int m){
       
           if ( m == Minas){
               return true;
           }
           return false;
       }
      public static void conteobandera(){
      
      System.out.print("Banderas"+" "+"'"+conteobanderas+"'"+"\n");
      
      }     
      
}


    
          
	
        
        
    
    
   

