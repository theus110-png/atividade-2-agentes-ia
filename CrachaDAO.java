import java.sql.Connection;
import java.sql.PreparedStatement;

public class CrachaDAO {
    public void inserir(Cracha c) throws Exception {
        String sql = "INSERT INTO cracha (id, codigo, funcionario_id) VALUES (?, ?, ?)";
        try (Connection conn = ConexaoDB.getConexao(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, c.id);
            stmt.setString(2, c.codigo);
            stmt.setInt(3, c.funcionarioId);
            stmt.executeUpdate();
            System.out.println("Crachá " + c.codigo + " inserido via DAO!");
        }
    }
}