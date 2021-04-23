import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Cores01 {
    public static void main(String[] args) {
        List<String> cores = new ArrayList<>();
        int opcao = 0;
        Scanner ler = new Scanner(System.in);

        do {

            System.out.println("-----------------------------------------------------");
            System.out.println("\nOlá usuário, por favor siga as instruções abaixo:");
            System.out.println("\n1 - para cadastrar uma cor ");
            System.out.println("\n2 - para remover uma cor cadastrada");
            System.out.println("\n3 - para listar as cores cadastradas");
            System.out.println("\n4 - para exibir as cores em ordem alfabética");
            System.out.println("\n0 - para encerrar a aplicação");
            System.out.println("-----------------------------------------------------");
            opcao = ler.nextInt();
            ler.nextLine();


            switch(opcao){
                case 1:
                  System.out.println("\nEntendido! Digite a cor desejada");
                  cores.add(ler.nextLine());
                  break;
                case 2:
                  System.out.println("\nEntendido! Digite a cor que deseja remover: ");
                  cores.remove(ler.nextLine());
                  break;
                case 3:
                  if (cores.isEmpty()) {
                    System.out.println(" Infelizmente não há nenhuma cor cadastrada :( ");
                  } else {
                  System.out.println("\n****** Cores ******** ");
                  for (String cor : cores) {
                      System.out.println(">" + cor);     
                  }}
                  break;
                case 4:
                  cores.sort(null);
                  System.out.println("\n****** Cores ******** ");
                  for (String cor : cores) {
                      System.out.println(">" + cor);     
                  }
                  break;
                case 0:
                  System.out.println("Que pena, esperamos você aqui mais tarde :D");
                  return;
                default:
                  System.out.println("Essa opção não conta no nosso sistema! Tente novamente :D");
            }

        } while (opcao != 0);

        ler.close();
    }
    
}
