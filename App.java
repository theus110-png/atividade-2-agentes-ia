public class App {
    public static void main(String[] args) {
        try {
            FuncionarioDAO funcDao = new FuncionarioDAO();
            CrachaDAO crachaDao = new CrachaDAO();

            Funcionario matheus = new Funcionario(20, "Matheus", "Desenvolvedor Pleno");
            Cracha crachaMatheus = new Cracha(202, "CRA-DAO-99", 20);

            System.out.println("--- Testando o Padrão DAO ---");
            funcDao.inserir(matheus);
            crachaDao.inserir(crachaMatheus);

            System.out.println("\n✅ Tudo funcionando perfeitamente!");
        } catch (Exception e) {
            System.err.println("Erro: " + e.getMessage());
        }
    }
}