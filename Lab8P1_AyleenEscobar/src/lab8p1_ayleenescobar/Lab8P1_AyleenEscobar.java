package lab8p1_ayleenescobar;

import java.util.Scanner;
import java.util.Random;

public class Lab8P1_AyleenEscobar {

 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Scanner sc_p = new Scanner(System.in);
        Random ran=new Random();
        
        libro[][] librero= null;
        int lingresados= 0;
        
        boolean respuesta = true;
        while (respuesta){
            System.out.println("Menu");
            System.out.println("1.Crear biblioteca");
            System.out.println("2.Modificar librero");
            System.out.println("3.SALIR");
            System.out.println("Ingrese su opcion: ");
        
        int opcion = 0;
        opcion = sc.nextInt();
        
        switch (opcion){
            case 1: {
                lingresados ++;
                librero= llenarLibrero();
            } break;
            
            case 2:{
                if(lingresados==0){
                    System.out.println("NO HAY NINGUN LIBRO INGRESADO.");
                    System.out.println("Crea la libreria.");
                } else{
                    System.out.print("Ingrese el título del libro: ");
                    String titulo =sc_p.nextLine();
                    System.out.print("Ingrese el escritor: ");
                    String autor =sc_p.nextLine();
                    System.out.print("Ingrese el año de publicación: ");
                    int publicacion =sc.nextInt();
                    boolean encontrar = buscar(librero,autor,  titulo,  publicacion);
                        if (encontrar) {
                            System.out.println("");
                            System.out.print("Ingrese el nuevo título del libro: ");
                            String nuevoTitulo = sc_p.nextLine();
                            System.out.print("Ingrese el nuevo autor: ");
                            String nuevoAutor = sc_p.nextLine();
                            System.out.print("Ingrese el nuevo año de publicación: ");
                            int nuevoPublicacion = sc.nextInt();

                            modificarLibro(titulo, autor, publicacion,nuevoTitulo, nuevoAutor,nuevoPublicacion, librero);
                            System.out.println("El libro fue modificado exitosamente.");
                            
                            System.out.println("El librero modificado es:");
                            imprimirLibrero(librero);
                        } else {
                            System.out.println("El libro no fue encontrado en el librero.");
                        }
                }
            } break;
            
            case 3: {
                respuesta = false;
            } break;
            
            default: System.out.println("DATOS NO VALIDO.");
            break;
        }
        }
    }
    public static libro[][] llenarLibrero(){
        Scanner sc = new Scanner(System.in);
        Scanner sc_p = new Scanner(System.in);
        
        System.out.print("Ingrese la cantidad de filas para el librero: ");
        int filas =sc.nextInt();
        System.out.print("Ingrese la cantidad de columnas para el librero: ");
        int columnas =sc.nextInt();
        
        System.out.println(" ");
        
        libro [][] librero= new libro [filas][columnas];
        for (int i = 0; i < filas ; i++) {
            for (int j = 0; j < columnas; j++) {
                System.out.print("Ingrese el título del libro: ");
                String titulo =sc_p.nextLine();
                System.out.print("Ingrese el escritor: ");
                String autor =sc_p.nextLine();
                System.out.print("Ingrese el año de publicación: ");
                int publicacion =sc.nextInt();
                       
                librero[i][j]= new libro(titulo, autor, publicacion);
                System.out.println("El libro fue agregado exitosamente");
                System.out.println("");
            }
        }
        System.out.println("El librero completo es: ");
        imprimirLibrero(librero);
        System.out.println("");
        return librero;
    }
    
    public static void imprimirLibrero(libro[][] librero) {
        for (int i = 0; i < librero.length; i++) {
            for (int j = 0; j < librero[i].length; j++) {
                libro libro= librero[i][j];
                System.out.print("["+ (libro.getTitulo())+"] ");
            }
            System.out.println("");
        }
    }

     public static boolean buscar(libro[][] libreria, String autor, String titulo, int publicacion){
        boolean esta=false;
        for (int i = 0; i < libreria.length; i++) {
            for (int j = 0; j < libreria[i].length; j++) {
                
                if (libreria[i][j].getAutor().equals(autor) && libreria[i][j].getTitulo().equals(titulo) && libreria[i][j].getPublicacion()==publicacion){
                    esta =true;
                    System.out.println("El libro fue encontrado en la fila "+(i+1)+ " y en la columna "+(j+1)+ ".");
                }
            }
        }
        return esta;
     }
     public static void modificarLibro(String titulob, String autorb, int publicacionb, String nuevoTitulo, String nuevoAutor, int nuevoPublicacion, libro[][] librero) {
        for (int i = 0; i < librero.length; i++) {
            for (int j = 0; j < librero[i].length; j++) {
                libro libro = librero[i][j];
                if (libro.getTitulo().equals(titulob) && libro.getAutor().equals(autorb) && libro.getPublicacion() == publicacionb) {
                    libro.settitulo(nuevoTitulo);
                    libro.setautor(nuevoAutor);
                    libro.setpublicacion(nuevoPublicacion);
                    return;
                }
            }
        }
    }
}