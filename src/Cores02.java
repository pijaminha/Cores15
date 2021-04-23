//import java.nio.file.DirectoryStream.Filter;
import java.util.ArrayList;
//import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Cores02 {
    public static void main(String[] args) {
        List<Cor> cores = new ArrayList<>();
        int opcao = 0;
        Scanner ler = new Scanner(System.in);

        do {

            System.out.println("-----------------------------------------------------");
            System.out.println("\nOlá usuário, por favor siga as instruções abaixo:");
            System.out.println("\n1 - para cadastrar uma cor ");
            System.out.println("\n2 - para remover uma cor cadastrada");
            System.out.println("\n3 - para listar as cores cadastradas");
            System.out.println("\n4 - para exibir as cores em ordem alfabética");
            System.out.println("\n5 - para exibir as cores em ordem de código");
            System.out.println("\n0 - para encerrar a aplicação");
            System.out.println("-----------------------------------------------------");
            opcao = ler.nextInt();
            ler.nextLine();

            switch(opcao){
                case 1:
                  int cod;
                  do {
                  System.out.println("\nDigite aqui o código da cor ou 99 para encerrar: ");
                  cod = ler.nextInt();
                  ler.nextLine();

                  if (cod != 99) {
                    System.out.println("\nEntendido! Digite o nome cor desejada");
                    String nomeCor = ler.nextLine();
                    cores.add(new Cor(cod, nomeCor));
                    }
                  }while (cod != 99);
                  break;
                case 2:
                  System.out.println("\nEntendido! Digite a cor que deseja remover: ");
                  //cores.remove(ler.nextLine()); 
                  String corRemover = ler.nextLine(); 
                /* for (Cor cor : cores) {
                    if (cor.getNome().equalsIgnoreCase(corRemover)) {
                    cores.remove(cor);
                    }
                  } -  esse metodo não é recomendado pois da erro, metodo certo abaixo: 
                  Iterator<Cor> i = cores.iterator();
                  while (i.hasNext()) {
                      Cor c = (Cor)i.next();
                    if (c.getNome().equalsIgnoreCase(corRemover)) {
                        i.remove();
                    }
                  } Exemplo de Predicado abaixo: */
                  cores.removeIf(p -> p.getNome().equalsIgnoreCase(corRemover));
                  break;
                case 3:
                  if (cores.isEmpty()) {
                    System.out.println(" Infelizmente não há nenhuma cor cadastrada :( ");
                  } else {
                  System.out.println("\n****** Cores ******** ");
                  for (Cor cor : cores) {
                      System.out.println(">" + cor);     
                  }}
                  break;
                case 4:
                  cores.sort(null);
                  System.out.println("\n****** Cores ******** ");
                  for (Cor cor : cores) {
                      System.out.println(">" + cor);     
                  }
                  break;
                case 5:
                    cores.sort(new ComparadorCorPorCodigo());
                    System.out.println("\n****** Cores ******** ");
                    for (Cor cor : cores) {
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

// equalsIgnoreCase é para ignorar se a letra está maiuscula ou minuscula;
