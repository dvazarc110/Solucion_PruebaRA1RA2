package tema2_prueba;

import java.util.Scanner;

public class PiramideSumas {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String resp;

        do {
            int num = leerEntero(sc, "Introduzca un número: ");  //DVA20251031 - Falta cerrar la sentencia con punto y coma (;)

            while (num < 0 || num > 20) {  //DVA20251031 Error Lógico - Al poner && en la condición hace que para cumplirse el número tenga que ser menor que 0 y mayor que 20, lo cual es imposible, se sustituye el "&&" por un "||"
                num = leerEntero(sc, "**Valor fuera de rango** Introduzca un número entre 0 y 20: ");
            }

            System.out.println("\nSu pirámide de sumas es la siguiente:\n" + piramide(num));

            System.out.print("¿Quiere hacer otra pirámide? (s/n) ");
            resp = sc.next().trim().toUpperCase();  //DVA20251031 - La variable resp esta siendo definida de nuevo, lo cual no se debe de hacer, borramos "String" de la sentencia para darle el valor sin definirla

        } while (resp.equals("S"));  //DVA20251031 - Falta un parentesis derecho antes del punto y coma para cerrar el while

        borrarConsola();
        System.out.println("¡¡¡PROGRAMA FINALIZADO!!!");
        
        sc.close();
    }

    private static int leerEntero(Scanner sc, String mensaje) {
        System.out.print(mensaje);
        while (!sc.hasNextInt()) {
            System.out.print("**Valor no válido** Introduzca un número entero: ");
            sc.next();
        }
        return sc.nextInt();
    }

    public static void borrarConsola() {
        for (int i = 0; i < 50; i++) {  //DVA20251031 - En vez de separar la condición  y el incremento con un punto y coma (;), se ha separado con una simple coma (,), lo cual no sirve, se ha sustituido la coma (,) por el punto y coma (;)
            System.out.println();
        }
    }

    public static String piramide(int num) {
        String res = "";
        int n = num;

        while (n >= 0) {  //DVA20251031 Error Lógico - Se pide un número entre el 0 y el 20, por lo que al poner como condicion (n < 0), esta nunca se va a cumplir, por lo que no realiza ninguna acción definida en el while y se sale devolviendo una cadena vacia, se sustituye la condicion (n < 0) por la condición (n >= 0)
            int cont = 1;
            int total = 0;
            res += n + " => 0 ";

            while (cont <= n) {  //DVA20251031 Error Lógico - Falta poner las llaves del while para que realize las tres expresiones siguientes, ya que sin las llaves solo realiza la primera, lo cual mantiene el bucle ejecutándose hasta el infinito
                res += "+ " + cont + " ";
                total += cont;
                cont += 1;
            }

            if (n != 0) {
                res += "= " + total;
            }

            res += "\n";
            n -= 1;
        }

        return res; //DVA20251031 - Se está tratando de devolver el resultado de una variable que no existe, en vez de resultado, lo que se debe de devolver es el valor final de la variable res, se ha sustituido "resultado" por "res"
    }

}