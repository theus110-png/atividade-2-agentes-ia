import java.sql.Connection;
import java.sql.PreparedStatement;

public class FuncionarioDAO {
    public void inserir(Funcionario f) throws Exception {
        String sql = "INSERT INTO funcionario (id, nome, cargo) VALUES (?, ?, ?)";
        try (Connection conn = ConexaoDB.getConexao(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, f.id);
            stmt.setString(2, f.nome);
            stmt.setString(3, f.cargo);
            stmt.executeUpdate();
            System.out.println("Funcionário " + f.nome + " inserido via DAO!");
        }
    }
}