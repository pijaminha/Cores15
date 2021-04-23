//#region
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.IntSummaryStatistics;
//#endregion
public class Cores03 {
    public static void main(String[] args) {
            List<Cor> cores = new ArrayList<>();
            int opcao = 0;
            Scanner ler = new Scanner(System.in);

        do {
            
            opcao = Menu(ler);
            
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
                
                DateTimeFormatter formatacaoData = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                System.out.println("Digite a data de cadastro da cor no formato dd/mm/aaaa");
                String data = ler.nextLine();
                cores.add(new Cor(cod, nomeCor, LocalDate.parse(data, formatacaoData)));
                }
                
                }while (cod != 99);
            break;
            case 2:
                System.out.println("\nEntendido! Digite a cor que deseja remover: ");
                String corRemover = ler.nextLine(); 
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
                cores.stream()
                .sorted(Comparator.comparing(Cor::getNome))
                .forEach(System.out::println);
            break;
            case 5:
                cores.stream()
                .sorted(Comparator.comparing(Cor::getCodigo))
                .forEach(System.out::println);
            break;
            case 6:
            /*é possivel pegar um filter e jogar para outra coleção. Programa Normal do caso 06:
            cores.stream()
            .filter(p -> p.getNome().contains("a") && p.getCodigo() > 10) .forEach(System.out::println);
            Exemplo: */ 
            List<Cor> corescomACors = cores.stream()
            .filter(p -> p.getNome().contains("a"))
            .collect(Collectors.toList());

            corescomACors.forEach(System.out::println);
            break;
            case 7:
                IntSummaryStatistics dados = cores.stream()
                .collect(Collectors.summarizingInt(Cor::getCodigo)); /*para pegar TODAS as estátisticas da collection*/ 

                System.out.println(dados);
                System.out.println("Total de cores na lista " + dados.getCount()); /* para pegar apenas um dado */
                break;
            case 8:
                int maiorCodigo = cores.stream()
                .collect(Collectors.summarizingInt(Cor::getCodigo)).getMax();

                System.out.println("Maior código digitado foi: " + maiorCodigo);
                break;
            case 9:
                DateTimeFormatter df = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                Map<LocalDate, List<Cor>> coresData = cores.stream()
                .collect(Collectors.groupingBy(Cor::getDataCadastro));

                coresData.entrySet().forEach(p -> System.out.printf("Data: %s - Cores: %s\n", p.getKey().format(df) , p.getValue())

                );
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

    private static int Menu(Scanner ler) {
        int opcao;
        System.out.println("-----------------------------------------------------");
        System.out.println("\nOlá usuário, por favor siga as instruções abaixo:");
        System.out.println("\n1 - para cadastrar uma cor ");
        System.out.println("\n2 - para remover uma cor cadastrada");
        System.out.println("\n3 - para listar as cores cadastradas");
        System.out.println("\n4 - para exibir as cores em ordem alfabética");
        System.out.println("\n5 - para exibir as cores em ordem de código");
        System.out.println("\n6 - para exibir as cores que tem A no nome");
        System.out.println("\n7 - para exibir estátisticas da coleção de cores");
        System.out.println("\n8 - para obter o maior código digitado");
        System.out.println("\n9 - para agrupar cores pela data de cadastro");
        System.out.println("\n0 - para encerrar a aplicação");
        System.out.println("-----------------------------------------------------");
        opcao = ler.nextInt();
        ler.nextLine();
        return opcao;
    }
}
