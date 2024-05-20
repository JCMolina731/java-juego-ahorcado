import java.util.Scanner;

public class Ahorcado {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        String palabrasecreta = "inteligencia";
        int intentosmaximos = 10;
        int intentos = 0;
        boolean palabraAdivinada = false;

        //Arreglos:
        char[] letrasAdivinadas = new char[palabrasecreta.length()];

        for (int i = 0; i < letrasAdivinadas.length; i++) {
            letrasAdivinadas[i] = '*';
        }

        System.out.println(letrasAdivinadas);
        //hasta que se cumpla esta condicion en el while va seguir ejecutandose el bucle
        while (!palabraAdivinada && intentos < intentosmaximos) {
                System.out.println("Palabras a adivinar: " + String.valueOf(letrasAdivinadas) + " (" + palabrasecreta.length() + " letras)" );
                System.out.println("Ingrese una letra:");
                char letra = Character.toLowerCase(scanner.next().charAt(0)); //charAt(0) toma la letra en la primera ubiacion
                boolean letraCorrecta = false;
                for (int i = 0; i < palabrasecreta.length(); i++) {
                    //Estructura de control condicional
                    if (palabrasecreta.charAt(i) == letra) {
                        //vamos a poner las letras adivinadas en letras adivinadas
                        letrasAdivinadas[i] = letra;
                        letraCorrecta = true;
                    }
                }

                if (!letraCorrecta) {
                    intentos++;
                    System.out.println("¡Letra incorrecta! Te quedan " + (intentosmaximos - intentos) + " intentos.");
                }

                if (String.valueOf(letrasAdivinadas).equals(palabrasecreta)) {
                    palabraAdivinada = true;
                    System.out.println("Felicidades, has adivinado la palabra secreta: " + palabrasecreta);
                }
        }

        if (!palabraAdivinada) {
            System.out.println("¡Que pena te has quedado sin intentos! GAME OVER");
        }

        scanner.close();
    }
}
