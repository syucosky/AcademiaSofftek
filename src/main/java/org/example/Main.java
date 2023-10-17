package org.example;


public class Main {
    public static void main(String[] args) {
        try{
            System.out.println(1 / 0);
        }catch (Exception e){
            System.out.println("Error: No se puede dividir por 0");
        }
    }
}