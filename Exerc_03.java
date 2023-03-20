import java.util.Scanner;

public class Exerc_02 {

	public static void main(String[] args) {
		
		
        Scanner sc = new Scanner(System.in);
        System.out.print("Informe um número: ");
        int numero = sc.nextInt();
        
        
        int a = 0, b = 1, c;
        boolean pertence = false;
        while (b <= numero) {
            if (numero == b) {
                pertence = true;
            }
            c = a + b;
            a = b;
            b = c;
        }
        
        
        System.out.println("Sequência de Fibonacci:");
        System.out.print("0 1 ");
        a = 0; b = 1;
        while (b <= numero) {
            System.out.print(b + " ");
            c = a + b;
            a = b;
            b = c;
        }
        if (pertence) {
            System.out.println("\nO número informado pertence à sequência de Fibonacci.");
        } else {
            System.out.println("\nO número informado NÃO pertence à sequência de Fibonacci.");
        }
        
        sc.close();
	}

}