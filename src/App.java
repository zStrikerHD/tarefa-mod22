import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

public class App {
    static void main(String args[]) {
        dadosPessoas();
    }

    private static void dadosPessoas() {
        Scanner sc = new Scanner(System.in);
        Pessoa pessoa;
        List<Pessoa> listaPessoas = new ArrayList<>();
        int opcao = 0;

        do {
            System.out.println("## Escolha uma das opções abaixo ##");
            System.out.println("Opção 1 - Cadastra pessoas");
            System.out.println("Opção 2 - Imprime pessoas cadastradas");
            System.out.println("Opção 3 - Imprime pessoas femininas");
            System.out.println("Opção 0 - Sair do programa");
            System.out.println("_______________________");

            System.out.print("Digite aqui sua opção: ");
            opcao = Integer.parseInt(sc.nextLine());

            if(opcao == 1){
                pessoa = new Pessoa();

                System.out.print("Digite o código: ");
                pessoa.setCodigo(Integer.parseInt(sc.nextLine()));

                System.out.print("Digite o nome: ");
                pessoa.setNome(sc.nextLine());

                System.out.print("Digite o genero: ");
                pessoa.setGenero(sc.nextLine());

                System.out.println();

                listaPessoas.add(pessoa);
            }else if(opcao == 2){
                if(listaPessoas.isEmpty()){
                    System.out.println("Não existem pessoas cadastradas, pressione uma tecla para continuar!");
                    sc.nextLine();
                }else{
                    System.out.println(listaPessoas.toString());

                    System.out.println("Pressione um tecla para continuar.");
                    sc.nextLine();
                }
            } else if (opcao == 3) {
                if (listaPessoas.isEmpty()){
                    System.out.println("Não existem pessoas cadastradas, pressione uma tecla para continuar!");
                    sc.nextLine();
                }else {
                    Stream<Pessoa> stream = listaPessoas.stream()
                            .filter(pessoa1 -> pessoa1.getGenero().equalsIgnoreCase("Feminino"));
                    stream.forEach(p -> System.out.println(p.getNome()));
                }
            }
        } while (opcao != 0);

        sc.close();

    }

    public static List<Pessoa> filtrarFeminino(List<Pessoa> lista) {
        return lista.stream()
                .filter(p -> p.getGenero().equalsIgnoreCase("Feminino"))
                .toList(); // No Java 16+ usa-se .toList(), para versões anteriores use .collect(Collectors.toList())
    }
}
