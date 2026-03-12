import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class App {

    static String URL = "jdbc:postgresql://aws-1-us-east-2.pooler.supabase.com:5432/postgres";
    static String USER = "postgres.fecygxbbsrdmbqhluura";
    static String PASSWORD = "fuDaUfVE330OkaET";

    public static void main(String[] args) throws Exception {

        Connection conexao = DriverManager.getConnection(URL, USER, PASSWORD);
        System.out.println("✅ Conectado ao Supabase!\n");

        inserirDados(conexao);
        listarDados(conexao);
        
        atualizarDados(conexao);
        listarDados(conexao);
        
        deletarDados(conexao);
        listarDados(conexao);

        conexao.close();
    }

    public static void inserirDados(Connection conexao) throws Exception {
        System.out.println("-> Inserindo o Matheus no banco...");
        String sql = "INSERT INTO funcionario (id, nome, cargo) VALUES (10, 'Matheus', 'Dev Junior')";
        
        PreparedStatement stmt = conexao.prepareStatement(sql);
        stmt.executeUpdate();
    }

    public static void atualizarDados(Connection conexao) throws Exception {
        System.out.println("-> Promovendo o Matheus para Senior...");
        String sql = "UPDATE funcionario SET cargo = 'Dev Senior' WHERE id = 10";
        
        PreparedStatement stmt = conexao.prepareStatement(sql);
        stmt.executeUpdate();
    }

    public static void deletarDados(Connection conexao) throws Exception {
        System.out.println("-> Removendo o Matheus do banco...");
        String sql = "DELETE FROM funcionario WHERE id = 10";
        
        PreparedStatement stmt = conexao.prepareStatement(sql);
        stmt.executeUpdate();
    }

    public static void listarDados(Connection conexao) throws Exception {
        System.out.println("-> LISTA DE FUNCIONÁRIOS:");
        String sql = "SELECT * FROM funcionario";
        
        PreparedStatement stmt = conexao.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery(); 

        boolean temGente = false;
        while (rs.next()) {
            temGente = true;
            System.out.println("   Nome: " + rs.getString("nome") + " | Cargo: " + rs.getString("cargo"));
        }
        
        if (!temGente) {
            System.out.println("   (O banco está vazio)");
        }
        System.out.println("----------------------------------\n");
    }
}