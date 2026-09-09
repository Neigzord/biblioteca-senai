//public class TESTESLAFDS {
//    import java.util.ArrayList;
//import java.util.List;
//
//    public class Biblioteca {
//        private List<Usuario> usuarios = new ArrayList<>();
//        private List<Livro> livros = new ArrayList<>();
//
//        public void cadastrarUsuario(Usuario u) {
//            usuarios.add(u);
//        }
//
//        public void cadastrarLivro(Livro l) {
//            livros.add(l);
//        }
//
//        private Usuario buscarUsuario(String id) {
//            for (Usuario u : usuarios) if (u.getId().equals(id)) return u;
//            return null;
//        }
//
//        private Livro buscarLivro(String id) {
//            for (Livro l : livros) if (l.getId().equals(id)) return l;
//            return null;
//        }
//
//        public String realizarAluguel(String idUser, String idLivro) {
//            Usuario u = buscarUsuario(idUser);
//            Livro l = buscarLivro(idLivro);
//            if (u == null || l == null) return "  Usuário ou Livro não encontrado!";
//            if (!l.estaDisponivel()) return "  Livro já alugado!";
//            if (!u.podeAlugar()) return " Usuário já tem 3 livros!";
//            u.alugarLivro(l);
//            return "  Aluguel realizado!";
//        }
//
//        public String realizarDevolucao(String idUser, String idLivro) {
//            Usuario u = buscarUsuario(idUser);
//            Livro l = buscarLivro(idLivro);
//            if (u == null || l == null) return " Não encontrado!";
//            return u.devolverLivro(l) ? " Devolvido!" : " Livro não está com este usuário!";
//        }
//
//        public String verificarDisponibilidade(String id) {
//            Livro l = buscarLivro(id);
//            if (l == null) return " Livro não encontrado!";
//            return l.estaDisponivel() ? " Disponível" : " Alugado";
//        }
//
//        public List<Usuario> listarUsuarios() { return usuarios; }
//        public List<Livro> listarLivros() { return livros; }
//        public List<Livro> livrosDoUsuario(String id) {
//            Usuario u = buscarUsuario(id);
//            return u == null ? new ArrayList<>() : u.getLivrosAlugados();
//        }
//    }
//    Livr
//    public class Livro {
//        private String id;
//        private String titulo;
//        private String autor;
//        private boolean alugado;
//        public Livro(String id, String titulo, String autor) {
//            this.id = id;
//            this.titulo = titulo;
//            this.autor = autor;
//            this.alugado = false;
//        }
//        public String getId() {
//            return id;
//        }
//        public String getTitulo() {
//            return titulo;
//        }
//        public String getAutor() {
//            return autor;
//        }
//        public boolean estaDisponivel() {
//            return !alugado;
//        }
//        public void setAlugado(boolean alugado) {
//            this.alugado = alugado;
//        }
//        @Override
//        public String toString() {
//            return "ID: " + id + ", Título: " + titulo + ", Autor: " + autor + ", Disponível: " + estaDisponivel();
//        }
//    }
//
//}