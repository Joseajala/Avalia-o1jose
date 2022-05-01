import java.util.InputMismatchException;
import java.util.Scanner;

import controlePiloto.Impl.Piloto;
import controlePiloto.Impl.Excecoes.PilotoNaoEncontradoException;

public class App {
    private final static int TAMANHO_INICIAL_LISTAS = 10;
    private static Scanner scanner = new Scanner(System.in);
    private static Piloto[] _Piloto = new Piloto[TAMANHO_INICIAL_LISTAS];
    private static int _numeroPiloto = 0;
  

    public static void main(String[] args) throws Exception {
        boolean continuarExecutando = true;
        do {
            try {
                imprimirMenu();
                int opcao = lerOpcao();
                continuarExecutando = executarOpcao(opcao);
            } catch (Exception e) {
                System.out.println("Ocorreu um erro durante a operação: " + e.getMessage());
                continuarExecutando = true;
            }
        } while (continuarExecutando);
    }

    private static boolean executarOpcao(int opcao) throws Exception {
        switch (opcao) {
            case 1: {
                cadastrarPiloto();
                break;
            }

            
            case 2: {
                listarPiloto();
                break;
            }
     
        

        case 3: {
            buscarPilotoCPF();
            break;
        }


        case 4: {
            aumentarEspaco();
            break;
        }

            case 9: {
                System.out.println("Saindo do sistema...");
                return false;
            }
            default: {
                System.out.println("Ainda não implementado!");
                break;
            }
        }

        return true;
    }

    private static void listarPiloto() {
        System.out.println("Lista de Piloto cadastrados:");
        for (int i = 0; i < _numeroPiloto; i++) {
            System.out.println(_Piloto[i]);
        }
    }

    
    private static Piloto buscarPilotoCPF() throws PilotoNaoEncontradoException {

        System.out.println("MENU > Buscar Piloto \n");
        System.out.println("Digite o cpf: ");
        String cpf = scanner.nextLine();

        for (Piloto piloto: _Piloto) {
            if (piloto != null && piloto.getCpf().equals(cpf)) {
                System.out.println(piloto);
                return piloto;

            }
        }

        throw new PilotoNaoEncontradoException(cpf);
    }

    





    private static void adicionarPilotoNaLista(Piloto Piloto) {
        if (_numeroPiloto == _Piloto.length) {
            Piloto[] novaLista = new Piloto[_Piloto.length * 2];
            
            // Copio os elementos da lista antiga para a nova lista.
            for (int i = 0; i < _Piloto.length; i++) {
                novaLista[i] = _Piloto[i];
            }

            // Substituo a lista antiga pela nova.
            _Piloto = novaLista;
        }

        // Adiciono o Piloto a lista.
        _Piloto[_numeroPiloto] = Piloto;
        _numeroPiloto++;
    }

    private static void cadastrarPiloto() throws InputMismatchException {
        System.out.println("Cadastro de Piloto");
        System.out.println("Nome: ");
        String nome = scanner.nextLine();
        System.out.println("Matricula: ");
        int matricula = Integer.parseInt(scanner.nextLine());
        System.out.println("CPF: ");
        String cpf = scanner.nextLine();
        

        Piloto Piloto = new Piloto(nome, matricula,  cpf);
        adicionarPilotoNaLista(Piloto);
    }


    private static void aumentarEspaco() throws InputMismatchException {
        System.out.println("Cadastro de piloto");
        System.out.println("Tamanho Atual: "+_Piloto.length);
        System.out.println("Digite um Novo Tamanho: ");
        int tamanho = Integer.parseInt(scanner.nextLine());

        if (tamanho < _numeroPiloto) {
            System.out.println("Digite um tamanho válido");  
        }
        if (tamanho >= _numeroPiloto) {
            Piloto[] novaLista = new Piloto[tamanho];

        
            // Copio os elementos da lista antiga para a nova lista.
            for (int i = 0; i < _numeroPiloto; i++) {
                novaLista[i] = _Piloto[i];
            }
            // Substituo a lista antiga pela nova.
            _Piloto = novaLista;

            System.out.println("Novo Tamanho: "+_Piloto.length);  


        }

    }




    private static void imprimirMenu() {
        System.out.println("\n************\n    MENU    \n************\n");
        System.out.println("1 - Cadastrar Piloto");
        System.out.println("2 - Listar Piloto");
        System.out.println("3 - Localizar piloto pelo CPF");
        System.out.println("4 - Aumentar espaço de armazenamento");
        System.out.println("9 - Sair");
    }

    private static boolean validarOpcaoMenu(int opcao) {
        return (opcao >= 1 && opcao <= 9);
    }

    private static int lerOpcao() {
        int opcao = 0;
        do {
            System.out.println("Selecione a opção desejada: ");
            try {
                opcao = Integer.parseInt(scanner.nextLine());
                if (!validarOpcaoMenu(opcao)) {
                    System.out.println("Opção inválida!");
                }
            } catch (Exception e) {
                System.out.println("Opção inválida!");
                scanner.nextLine();
            }
        } while (!validarOpcaoMenu(opcao));

        return opcao;
    }
}
