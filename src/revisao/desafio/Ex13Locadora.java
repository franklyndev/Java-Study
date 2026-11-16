package revisao.desafio;

import revisao.desafio.entities.Carro;
import revisao.desafio.entities.Moto;
import revisao.desafio.entities.Veiculo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
 * ============================================================
 * DESAFIO FINAL — Locadora de veiculos
 * Junta TUDO: classe abstrata, heranca, polimorfismo,
 * List, lambda, metodos static, Scanner com menu.
 *
 * Referência no repo: src/atividade/avaliativa/Main.java (commit 63a12bb,
 *                     o sistema da autoescola) e src/CarRental.java
 * ============================================================
 *
 * REGRAS DO NEGOCIO
 *
 * Uma locadora aluga veiculos. Cada aluguel tem um valor diario e uma
 * quantidade de dias. Existem dois tipos de veiculo, com calculo diferente:
 *
 *   - Carro:  valor = diaria * dias
 *             se dias > 7, aplica 10% de desconto no total
 *   - Moto:   valor = diaria * dias
 *             cobra taxa fixa de R$ 15.00 de seguro, uma vez por aluguel
 *
 * Todo veiculo pode estar DISPONIVEL ou ALUGADO.
 *
 * ESTRUTURA QUE VOCE DEVE CRIAR (em revisao/desafio/entities/)
 *
 * 1) abstract class Veiculo
 *      - private String placa, modelo;
 *      - protected Double diaria;
 *      - private boolean disponivel = true;
 *      - construtor com placa, modelo, diaria
 *      - getters
 *      - public void alugar()    -> marca como indisponivel; se ja estiver
 *                                   alugado, imprime "Veiculo indisponivel"
 *      - public void devolver()  -> marca como disponivel
 *      - public boolean estaDisponivel()
 *      - public abstract double calcularAluguel(int dias);  // cada filha implementa
 *      - toString() -> "ABC1234 - Gol (R$ 120.00/dia) [DISPONIVEL]"
 *
 * 2) class Carro extends Veiculo
 *      - private int portas;
 *      - calcularAluguel com a regra do desconto acima de 7 dias
 *
 * 3) class Moto extends Veiculo
 *      - private int cilindradas;
 *      - public static final double SEGURO = 15.00;   <- constante static final
 *      - calcularAluguel somando o seguro
 *
 * O PROGRAMA (nesta classe)
 *
 * Mantenha um List<Veiculo> e um menu que repete com do-while + switch:
 *
 *      1 - Cadastrar carro
 *      2 - Cadastrar moto
 *      3 - Listar todos os veiculos
 *      4 - Listar somente os disponiveis      (use stream + filter)
 *      5 - Alugar veiculo (pela placa)        -> pede os dias, mostra o valor
 *                                                e marca como alugado
 *      6 - Devolver veiculo (pela placa)
 *      7 - Faturamento total dos alugueis feitos
 *      8 - Remover veiculo pela placa         (use removeIf)
 *      0 - Sair
 *
 * REQUISITOS QUE EU VOU COBRAR DE VOCE
 *  [ ] nenhum atributo public
 *  [ ] nenhuma conta dentro do main: tudo em metodo de entidade ou metodo static
 *  [ ] a busca pela placa feita por um metodo static seu, do tipo
 *          private static Veiculo buscarPorPlaca(List<Veiculo> lista, String placa)
 *      devolvendo null quando nao encontrar
 *  [ ] tratar a placa inexistente sem estourar NullPointerException
 *  [ ] o faturamento acumulado guardado num atributo static da classe
 *  [ ] opcao 4 usando stream().filter(...)
 *  [ ] sc.close() no fim
 *  [ ] formatar todo dinheiro com String.format("%.2f", x)
 *
 * ARMADILHAS QUE JA TE PEGARAM ANTES
 *  - nextInt() seguido de nextLine() come a quebra de linha: leia o numero
 *    do menu e chame sc.nextLine() antes de ler texto
 *  - comparar String com == nao funciona: use placa.equals(outra) ou
 *    equalsIgnoreCase
 *  - metodo de calculo nao deve alterar o estado do objeto (o bug do
 *    "price += fee" do ImportedProduct)
 *
 * QUANDO TERMINAR
 *  Commite e compare seu codigo com o src/atividade/avaliativa/Main.java do
 *  commit 63a12bb. Naquele arquivo voce colocou todas as classes num unico
 *  .java; aqui elas estao separadas em arquivos e pacotes. Pense em qual
 *  dos dois voce preferiria manter daqui a seis meses.
 */
// "QUEBRE O PROBLEMA EM PROBLEMAS MENORES"
public class Ex13Locadora {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Veiculo> veiculos = new ArrayList<>();
        List<Carro> carros = new ArrayList<>();
        Veiculo encontrado;
        double faturamento = 0;

        // TODO menu do-while + switch
        int input;
        String placa;
        String modelo;
        double diaria;
        int portas;
        int cilindradas;

        do {
            System.out.println("1 - Cadastrar Carro");
            System.out.println("2 - Cadastrar Moto");
            System.out.println("3 - Listar todos os veículos");
            System.out.println("4 - Listar somente os disponíveis");
            System.out.println("5 - Alugar veículo (pela placa)");
            System.out.println("6 - Devolver veículo (pela placa)");
            System.out.println("7 - Faturamento total dos alugueis feitos");
            System.out.println("8 - Remover veiculo pela placa");
            System.out.println("0 - Sair");

            System.out.print("Escolha: ");
            input = sc.nextInt(); // Escolha do usuário
            limparTela();




            switch (input) {

                case 1:

                    System.out.println("## CADASTRAR CARRO ##");
                    System.out.print("Placa: ");
                    sc.nextLine(); // Limpa buffer
                    placa = sc.nextLine();

                    System.out.print("Modelo: ");
                    modelo = sc.nextLine();

                    System.out.print("Diária: ");
                    diaria = sc.nextDouble();

                    System.out.print("Portas: ");
                    portas = sc.nextInt();

                    veiculos.add(new Carro(placa, modelo, diaria, portas));

                    break;
                case 2:
                    List<Moto> motos = new ArrayList<>();

                    System.out.println("## CADASTRAR MOTO ##");
                    System.out.print("Placa: ");
                    sc.nextLine(); // Limpa buffer
                    placa = sc.nextLine();

                    System.out.print("Modelo: ");
                    modelo = sc.nextLine();

                    System.out.print("Diária: ");
                    diaria = sc.nextDouble();

                    System.out.print("Cilidradas: ");
                    cilindradas = sc.nextInt();

                    veiculos.add(new Moto(placa, modelo, diaria, cilindradas));
                    break;
                case 3:
                    System.out.println("## LISTA DE VEICULOS ##");
                    veiculos.stream()
                            .forEach(System.out::println);
                    break;
                case 4:
                    System.out.println("## LISTA DE VEICULOS (DISPONIVEIS) ##");
                    veiculos.stream()
                            .filter(v -> v.isDisponivel())
                            .forEach(System.out::println);
                    System.out.println("-------------------------------------");
                    break;
                case 5:
                    System.out.println("## ALUGAR VEICULO (PELA PLACA) ##");
                    System.out.print("Digite a placa do veiculo desejado: ");
                    sc.nextLine();
                    placa = sc.nextLine();
                    encontrado = buscarPlaca(veiculos, placa);

                    if(encontrado == null) {
                        System.out.println("Veiculo nao encontrado");
                        break;
                    } else {
                        System.out.println(encontrado.getPlaca());
                    }
                    if(!encontrado.isDisponivel()) {
                        System.out.println("VEICULO JÁ EM USO!");
                        break;
                    } else {
                        encontrado.alugar();
                    }


                    System.out.print("Quantidade de dias de aluguel: ");
                    int dias = sc.nextInt();

                    double total = encontrado.calcularAluguel(dias);
                    faturamento += total;
                    System.out.printf("Valor total = %.2f\n", total);


                    System.out.printf("VEICULO %s(%s) ALUGADO COM SUCESSO!\n", encontrado.getModelo(), encontrado.getPlaca());

                    System.out.println("-------------------------------------");
                    break;

                case 6:
                    System.out.println("## DEVOLVER VEÍCULO (PELA PLACA) ##");
                    System.out.print("Digite a placa do veiculo desejado: ");
                    sc.nextLine();
                    placa = sc.nextLine();
                    encontrado = buscarPlaca(veiculos, placa);

                    if(encontrado == null) {
                        System.out.println("VEICULO NAO ENCONTRADO!");
                        break;
                    } else {
                        System.out.println(encontrado.getPlaca());
                        encontrado.devolver();
                    }

                    System.out.println("VEÍCULO DEVOLVIDO COM SUCESSO!\n");
                    System.out.println("-------------------------------------");
                    break;
                case 7:
                    System.out.println("## FATURAMENTO TOTAL DOS ALUGUEIS ##");
                    System.out.printf("%.2f\n", faturamento);
                    break;
                case 8:
                    System.out.println("## REMOVER VEÍCULO (PELA PLACA) ##");
                    System.out.print("Digite a placa do veiculo desejado: ");
                    sc.nextLine();
                    placa = sc.nextLine();
                    Veiculo removido = buscarPlaca(veiculos, placa);
                    if(removido == null) {
                        System.out.println("Veiculo nao encontrado");
                    } else {
                        System.out.println(removido.getPlaca());
                        veiculos.removeIf(v -> v.getPlaca().equals(removido.getPlaca()));

                    }
                    break;
                case 0:

                    System.out.println("Saindo...");
                    break;
            }


        } while (input != 0);
        sc.close();
    }

    private static Veiculo buscarPlaca(List<Veiculo> list, String placa) {
        for(Veiculo l : list) {
            if(l.getPlaca().equals(placa)) {
                return l;
            }
        }
        return null;
    }

    public static void limparTela() {
        for (int i = 0; i < 50; i++) {
            System.out.println();
        }
    }
}

