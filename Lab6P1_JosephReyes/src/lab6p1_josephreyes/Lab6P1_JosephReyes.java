package lab6p1_josephreyes;

import java.util.Random;
import java.util.Scanner;

public class Lab6P1_JosephReyes {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int continuar;
        do {
            System.out.println("- - - - < Menu > - - - -");
            System.out.println("1.     Conjuntos");
            System.out.println("2. Cuantos primos tienes?");
            System.out.println("0.       Salir");
            continuar = scanner.nextInt();
            switch (continuar) {
                case 0:
                    System.out.println("Saliendo del programa...");
                    break;
                case 1:
                    System.out.println("Entrando a Conjuntos...");
                    System.out.print("Size SET1: ");
                    int i = scanner.nextInt();
                    System.out.print("Size SET2: ");
                    int j = scanner.nextInt();
                    int aleatorio = 0;
                    char[] SET1 = getRandCharArray(i);
                    char[] SET2 = getRandCharArray(j);
                    System.out.println("Conjuntos generados:");
                    System.out.print("SET1: ");
                    for (int k = 0; k < i; k++) {
                        System.out.print("[" + SET1[k] + "]");
                    }
                    System.out.println("");
                    System.out.print("SET2: ");
                    for (int k = 0; k < j; k++) {
                        System.out.print("[" + SET2[k] + "]");
                    }
                    System.out.println("");
                    System.out.println("Operaciones");
                    System.out.println("1. Interseccion");
                    System.out.println("2. Diferencia");
                    System.out.print("Ingrese una opcion: ");
                    int operacion = scanner.nextInt();
                    switch (operacion) {
                        case 1:
                            intersection(SET1, SET2);
                            break;
                        case 2:
                            difference(SET1, SET2);
                            break;
                        default:
                            System.out.println("Opcion no valida");
                    }
                    System.out.println("");
                    break;
                case 2:
                    System.out.println("Entrando a Cuantos primos tienes?...");
                    System.out.print("Ingresar tamano del arreglo: ");
                    int tamano = scanner.nextInt();
                    System.out.print("Ingresar el limite inferior: ");
                    int min = scanner.nextInt();
                    System.out.print("Ingresar el limite superior: ");
                    int max = scanner.nextInt();
                    int[] numeros = new int[tamano];
                    System.out.print("Arreglo generado: ");
                    genRandArray(tamano, min, max);
                    int[] primeFactorsCount = new int[numeros.length];
                    for (int a = 0; a < numeros.length; a++) {
                        primeFactorsCount[a] = countPrimeFactors(numeros[a]);
                    }
                    System.out.println("No. Divisores primos: " + getTotalPrimeCount(numeros));
                    break;
                default:
                    System.out.println("Opcion no valida");
            }
        } while (continuar != 0);
    }

    public static char[] getRandCharArray(int tamano) {
        char[] caracter = new char[tamano];
        Random random = new Random();

        for (int i = 0; i < tamano; i++) {
            int ascii = random.nextInt(9) + 65;
            caracter[i] = (char) ascii;
        }

        return caracter;
    }

    public static void intersection(char[] SET1, char[] SET2) {
        System.out.print("INTERSECTION(SET1,SET2): ");
        for (int k = 0; k < SET1.length; k++) {
            for (int l = 0; l < SET2.length; l++) {
                if (SET1[k] == SET2[l]) {
                    System.out.print("[" + SET1[k] + "]");
                }
            }
        }
    }

    public static void difference(char[] SET1, char[] SET2) {
        System.out.print("INTERSECTION(SET1,SET2): ");
        for (int k = 0; k < SET1.length; k++) {
            for (int l = 0; l < SET2.length; l++) {
                if (SET1[k] != SET2[l]) {
                    System.out.print("[" + SET1[k] + "]");
                }
            }
        }
    }

    public static void genRandArray(int tamano, int min, int max) {
        int[] numeros = new int[tamano];
        Random random = new Random();

        for (int i = 0; i < tamano; i++) {
            int numero = random.nextInt(max) + min;
            numeros[i] = numero;
        }

        for (int i = 0; i < tamano; i++) {
            System.out.print("[" + numeros[i] + "]");
        }

    }

    public static boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }

        for (int i = 3; i * i <= n; i += 2) {
            if (n % i == 0) {
                return false;
            }
        }

        return true;
    }

    public static int countPrimeFactors(int n) {
        if (n <= 1) {
            return 0;
        }

        int contador = 0;
        boolean isPrime = true;

        while (isPrime) {
            if (n % 2 == 0) {
                contador++;
                n /= 2;
            } else {
                isPrime = false;
            }

            for (int i = 3; i * i <= n; i += 2) {
                if (n % i == 0) {
                    contador++;
                    n /= i;
                    isPrime = false;
                    break;
                }
            }
        }

        if (isPrime) {
            contador++;
        }

        return contador;
    }

    public static int[] getTotalPrimeCount(int[] numeros) {
        int[] contador = new int[numeros.length];

        for (int i = 0; i < numeros.length; i++) {
            contador[i] = countPrimeFactors(numeros[i]);
        }

        return contador;
    }

}
