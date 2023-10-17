package org.example.Exception;

public class Clase11Exception {

    public void prueba(){
        try{
            System.out.println(1 / 0);
        }catch (Exception e){
            System.out.println("Error: No se puede dividir por 0");
        }
    }
    public static void main(String[] args) {
        Clase11Exception test = new Clase11Exception();
        test.prueba();
    }

}
