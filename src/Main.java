import java.util.Scanner;

public class Main {
    private static Scanner scanner;
    public static void main(String[] args) {
        ArvoreBinariaMorse arvoreBinariaMorse = new ArvoreBinariaMorse();
        scanner = new Scanner(System.in);
        String opcao = "";
        char escolha = ' ';

        while(escolha != '6'){
            System.out.println("*********** Menu ***********");
            System.out.println("1 - Tabela Morse");
            System.out.println("2 - Inserir caractere");
            System.out.println("3 - Buscar caractere");
            System.out.println("4 - Imprimir árvore binária");
            System.out.println("5 - Remover caractere");
            System.out.println("6 - Sair");
            System.out.println("***************************");
            System.out.print("Digite a opção que deseje: ");
            opcao = scanner.next();
            scanner.nextLine();
            escolha = opcao.charAt(0);

            switch (escolha){
                case '1':
                    imprimirTabelaMorse();
                    break;
                case '2':
                    inserirMenu(arvoreBinariaMorse);
                    break;
                case '3':
                    buscarMenu(arvoreBinariaMorse);
                    break;
                case '4':
                    imprimirArvore(arvoreBinariaMorse);
                    break;
                case '5':
                    removerMenu(arvoreBinariaMorse);
                    break;
                case '6':
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente");
            }

        }


    }

    private static void inserirMenu(ArvoreBinariaMorse arvoreBinariaMorse){
        System.out.println("************ Inserir *************");
        System.out.print("Digite o código morse: ");
        String codigoMorse = scanner.nextLine();

        System.out.print("Digite o caractere correspondente ao código morse: ");
        String caractere = scanner.nextLine();

        char caractereCorrespondente = caractere.charAt(0);

        arvoreBinariaMorse.inserir(codigoMorse, caractereCorrespondente);
        System.out.println("Caractere adicionado!");
        System.out.println("******************************");
    }


    private static void buscarMenu(ArvoreBinariaMorse arvoreBinariaMorse){
        System.out.println("************ Buscar *************");
        System.out.print("Digite o código morse: ");
        String codigoMorse = scanner.nextLine();

        char encontrado = arvoreBinariaMorse.buscar(codigoMorse);

        if (encontrado == '\0')
            System.out.println("Caractere não está na árvore");
        else
            System.out.println("Caractere encontrado: " + encontrado);
        System.out.println("********************************");
    }

    private static void imprimirArvore(ArvoreBinariaMorse arvoreBinariaMorse){
        System.out.println("****** Imprimir ******");
        arvoreBinariaMorse.imprimir();
        System.out.println("**********************");
    }

    private static void removerMenu(ArvoreBinariaMorse arvoreBinariaMorse){
        System.out.println("****** Remover ******");
        System.out.print("Digite o código morse: ");
        String codigoMorse = scanner.nextLine();

        if (arvoreBinariaMorse.remover(codigoMorse))
            System.out.println("Caractere removido!");
        else
            System.out.println("Código inválido");
        System.out.println("********************");
    }

    private static void imprimirTabelaMorse(){
        System.out.println("********* Tabela Morse *********");
        System.out.println("A: .- J: .--- S: ... 2: ..---");
        System.out.println("B: -... K: -.- T: - 3: ...--");
        System.out.println("C: -.-. L: .-.. U: ..- 4: ....-");
        System.out.println("D: -.. M: -- V: ...- 5: .....");
        System.out.println("E: . N: -. W: .-- 6: -....");
        System.out.println("F: ..-. O: --- X: -..- 7: --...");
        System.out.println("G: --. P: .--. Y: -.-- 8: ---..");
        System.out.println("H: .... Q: --.- Z: --.. 9: ----.");
        System.out.println("I: .. R: .-. 1: .---- 0: -----");
        System.out.println("********************************");
    }
}
