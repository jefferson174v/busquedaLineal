import java.util.Scanner;
import java.util.InputMismatchException;

public class com {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        bienvenida();
        int cantid = cantidad(sc);
        String[] arreglo = arreglo(cantid, sc);
        boolean con = true;
        do {
            String elemento = elemento(sc);
            int uno = busquedaLineal(arreglo, elemento);
            comprovacion(uno, arreglo, elemento);
            con = sino(sc);
        } while (con);
    }

    public static void bienvenida() {
        System.out.println("Bienvenido a la pulperia Doña Chilo!");
        System.out.println("A continuacion podras decirme los articulos que tienes interes en ver....");
    }

    public static int cantidad(Scanner sc) {
        while (true) {
            try {
                System.out.println("Digame hijo, cuantos productos desea ver...");
                int cantida = sc.nextInt();
                sc.nextLine(); // aca tuve que consumir la linea pendiente, por que no, no entendi muy bien, le
                               // quitaba -1 a la cantidad de elemento que iba a dijitar el usiario.
                if (cantida <= -1) {
                    System.out.println("Usted esta loco, digame un numero positivo!!");
                } else if (cantida == 0) {
                    System.out.println("Como cree que va a ser 0?");
                } else {
                    return cantida;
                }
            } catch (InputMismatchException e) {
                System.out.println("Digame la cantridad en numeros hijo.");
                sc.nextLine();
            }
        }
    }

    public static String[] arreglo(int x, Scanner sc) {
        String[] arreglo = new String[x];
        System.out.println("Bueno, usted esta interesado en: " + x + " productos.");
        System.out.println("Ahora digame, cales quiere? (Escribalos)");
        for (int i = 0; i < x; i++) {
            System.out.println("Pructo numero: " + (i + 1));
            arreglo[i] = sc.nextLine();
        }
        return arreglo;
    }

    public static String elemento(Scanner sc) {
        System.out.println("Bien, pero, en cual esta interesado?");
        String elemento = sc.nextLine();
        return elemento;
    }

    public static int busquedaLineal(String[] arreglo, String elemento) {
        for (int i = 0; i < arreglo.length; i++) {
            if (arreglo[i].equalsIgnoreCase(elemento)) { // vi que la diferencia de este y el equals era las mayusculas.
                return i;
            }
        }
        return -1;
    }

    public static void comprovacion(int uno, String[] arreglo, String elemento) {
        if (uno != -1) {
            System.out.println("Tenemos " + arreglo[uno] + " aquí en la venta Chilo!!");
        } else {
            System.out.println("No tenemos " + elemento + " en la venta Chilo.");
        }
    }

    public static boolean sino(Scanner sc) {
        System.out.println("Desea ver otro elemento?");
        System.out.println("Dijite 1 si desea, dijite 0 si no");
        while (true) {
            try {
                int option = sc.nextInt();
                sc.nextLine();
                if (option == 1 || option == 0) {
                    return option == 1;
                } else {
                    System.out.println("Por favor, ingrese solo 1 si desea continuar o 0 si no.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Pero solo escriba 1 si, 0 no!!!");
                sc.nextLine();
            }
        }
    }
}
