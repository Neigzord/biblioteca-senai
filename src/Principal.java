import java.util.ArrayList;
import java.util.Scanner;
public class Principal {

    public static void menu() {

        System.out.println("\n=============================");
        System.out.println("1 - Cadastrar Usuario");
        System.out.println("2 - Cadastrar Livro");
        System.out.println("3 - Listar Usuarios");
        System.out.println("4 - Listar Livros");
        System.out.println("5 - Realizar Aluguel");
        System.out.println("6 - Realizar Devolucao");
        System.out.println("7 - Consultar Disponibilidade");
        System.out.println("8 - Livros Alugados por Usuario");
        System.out.println("0 - Sair do Sistema");
        System.out.print("Escolha uma opcao: ");
    }

    public static void main(String[] args) {

        Scanner leitor = new Scanner(System.in);

        ArrayList<Clientes> listaClientes = new ArrayList<>();
        ArrayList<livros> listaLivros = new ArrayList<>();

        int opcao;

        do {

            menu();


            opcao = leitor.nextInt();
            leitor.nextLine();

            switch (opcao) {

                case 1:

                    Clientes novoCliente = new Clientes();

                    System.out.print("Digite o nome do usuario: ");
                    novoCliente.nome = leitor.nextLine();

                    listaClientes.add(novoCliente);

                    System.out.println("Usuario cadastrado!");

                    break;


                case 2:

                    livros novoLivro = new livros();

                    System.out.print("Digite o titulo do livro: ");
                    novoLivro.titulo = leitor.nextLine();

                    System.out.print("Digite o autor do livro: ");
                    novoLivro.autor = leitor.nextLine();

                    listaLivros.add(novoLivro);

                    System.out.println("Livro cadastrado!");

                    break;

                case 3:

                    System.out.println("\n===== USUARIOS =====");

                    for (Clientes cliente : listaClientes) {
                        System.out.println("Nome: " + cliente.nome);
                    }

                    break;

                case 4:

                    System.out.println("\n===== LIVROS =====");

                    for (livros livro : listaLivros) {

                        System.out.println("Titulo: " + livro.titulo);
                        System.out.println("Autor: " + livro.autor);

                        if (livro.disponivel) {
                            System.out.println("Estado: Disponivel");
                        } else {
                            System.out.println("Estado: Alugado");
                        }

                        System.out.println("-------------------");
                    }

                    break;

                case 5:

                    System.out.print("Digite o nome do usuario: ");
                    String nomeUsuario = leitor.nextLine();

                    System.out.print("Digite o titulo do livro: ");
                    String tituloLivro = leitor.nextLine();

                    Clientes clienteEncontrado = null;
                    livros livroEncontrado = null;

                    for (Clientes cliente : listaClientes) {

                        if (cliente.nome.equalsIgnoreCase(nomeUsuario)) {
                            clienteEncontrado = cliente;
                        }
                    }

                    for (livros livro : listaLivros) {

                        if (livro.titulo.equalsIgnoreCase(tituloLivro)) {
                            livroEncontrado = livro;
                        }
                    }

                    if (clienteEncontrado == null) {

                        System.out.println("Usuario nao encontrado.");

                    } else if (livroEncontrado == null) {

                        System.out.println("Livro nao encontrado.");

                    } else if (!livroEncontrado.disponivel) {

                        System.out.println("Esse livro ja esta alugado.");

                    } else {

                        livroEncontrado.alugar(clienteEncontrado);

                        System.out.println("Aluguel realizado com sucesso!");
                    }

                    break;

                case 6:

                    System.out.print("Digite o nome do usuario: ");
                    String nomeUsuarioDevolucao = leitor.nextLine();

                    System.out.print("Digite o titulo do livro: ");
                    String tituloLivroDevolucao = leitor.nextLine();

                    Clientes clienteDevolucao = null;

                    for (Clientes cliente : listaClientes) {

                        if (cliente.nome.equalsIgnoreCase(nomeUsuarioDevolucao)) {
                            clienteDevolucao = cliente;
                        }
                    }

                    if (clienteDevolucao == null) {

                        System.out.println("Usuario nao encontrado.");

                    } else {

                        livros livroDevolucao = null;

                        for (livros livro : clienteDevolucao.livrosAlugados) {

                            if (livro.titulo.equalsIgnoreCase(tituloLivroDevolucao)) {
                                livroDevolucao = livro;
                            }
                        }

                        if (livroDevolucao == null) {

                            System.out.println("Esse usuario nao possui esse livro.");

                        } else {

                            livroDevolucao.devolver();

                            System.out.println("Devolucao realizada com sucesso!");
                        }
                    }

                    break;

                case 7:

                    System.out.print("Digite o titulo do livro: ");
                    String tituloConsulta = leitor.nextLine();

                    livros livroConsulta = null;

                    for (livros livro : listaLivros) {

                        if (livro.titulo.equalsIgnoreCase(tituloConsulta)) {
                            livroConsulta = livro;
                        }
                    }

                    if (livroConsulta == null) {

                        System.out.println("Livro nao encontrado.");

                    } else if (livroConsulta.disponivel) {

                        System.out.println("O livro esta disponivel.");

                    } else {

                        System.out.println(
                                "O livro esta alugado para "
                                        + livroConsulta.cliente.nome
                        );
                    }

                    break;

                case 8:

                    System.out.print("Digite o nome do usuario: ");
                    String nomeUsuarioConsulta = leitor.nextLine();

                    Clientes clienteConsulta = null;

                    for (Clientes cliente : listaClientes) {

                        if (cliente.nome.equalsIgnoreCase(nomeUsuarioConsulta)) {
                            clienteConsulta = cliente;
                        }
                    }

                    if (clienteConsulta == null) {

                        System.out.println("Usuario nao encontrado.");

                    } else {

                        System.out.println(
                                "\nLivros alugados por "
                                        + clienteConsulta.nome + ":"
                        );

                        if (clienteConsulta.livrosAlugados.isEmpty()) {

                            System.out.println("Nenhum livro alugado.");

                        } else {

                            for (livros livro : clienteConsulta.livrosAlugados) {

                                System.out.println("- " + livro.titulo);
                            }
                        }
                    }

                    break;

                case 0:

                    System.out.println("Sistema encerrado!");

                    break;

                default:

                    System.out.println("Opcao invalida.");
            }

        } while (opcao != 0);

        leitor.close();
    }
}