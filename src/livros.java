public class livros {
    String titulo;
    String autor;
    boolean disponivel = true;
    Clientes cliente;

    public void alugar(Clientes cliente) {
        disponivel = false;
        this.cliente = cliente;
        cliente.livrosAlugados.add(this);
    }

    public void devolver() {
        cliente.livrosAlugados.remove(this);
        cliente = null;
        disponivel = true;
    }

}