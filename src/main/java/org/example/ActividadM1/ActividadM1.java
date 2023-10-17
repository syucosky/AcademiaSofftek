package org.example.ActividadM1;

public class ActividadM1 {
    private int numero = 10;
    private int numero2 = 10;


    // Método que imprime por consola el resultado de sumar la variable numero con la variable numero2;
    public void sumarDosNumeros(){
        System.out.println(numero + numero2);
    }

    public static void main(String[] args) {
        ActividadM1 actividadM1 = new ActividadM1();

        actividadM1.sumarDosNumeros();
    }
}
