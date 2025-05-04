package dao;

import factory.ConnectionFactory;
import java.sql.*;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import modelo.Cliente;

public class ClienteDAO {
    private Connection connection;
    
    public ClienteDAO(){
        this.connection = new ConnectionFactory().getConnection();
    }
    
    public List<Cliente> listarClientes() {
    List<Cliente> lista = new ArrayList<>();

    String sql = "SELECT * FROM cliente";

    try {
        PreparedStatement stmt = connection.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            Cliente cliente = new Cliente();
            cliente.setId(rs.getInt("cli_id"));
            cliente.setCpf(rs.getString("cli_cpf"));
            cliente.setNome(rs.getString("cli_nome"));
            cliente.setEmail(rs.getString("cli_email"));
            cliente.setTelefone(rs.getString("cli_telefone"));
            cliente.setEndereco(rs.getString("cli_endereco"));
            cliente.setDataDeNascimento(rs.getDate("cli_dataDeNascimento"));

            lista.add(cliente);
        }

        rs.close();
        stmt.close();
    } catch (SQLException e) {
        throw new RuntimeException(e);
    }

    return lista;
    }
    
    public void remover(String cpf) {
    String sql = "DELETE FROM cliente WHERE cli_cpf = ?";

    try {
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setString(1, cpf);
        stmt.execute();
        stmt.close();
    } catch (SQLException e) {
        throw new RuntimeException(e);
    }
    }
    
    public void adiciona(Cliente cliente){
        if (cpfExiste(cliente.getCpf())) {
            JOptionPane.showMessageDialog(null, "CPF já cadastrado no sistema!", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }
        String sql = "INSERT INTO cliente(cli_cpf, cli_nome, cli_email, cli_telefone, cli_endereco, cli_dataDeNascimento) VALUES(?, ?, ?, ?, ?, ?)";
        try{
            PreparedStatement stmt = connection.prepareStatement(sql);
            
            stmt.setString(1, cliente.getCpf());
            stmt.setString(2, cliente.getNome());
            stmt.setString(3, cliente.getEmail());
            stmt.setString(4, cliente.getTelefone());
            stmt.setString(5, cliente.getEndereco());
            stmt.setDate(6, new java.sql.Date(cliente.getDataDeNascimento().getTime()));
            
            stmt.execute();
            stmt.close();
        }
        catch (SQLException u){
            throw new RuntimeException(u);
        }
    }
    
    public boolean cpfExiste(String cpf) {
    String sql = "SELECT COUNT(*) FROM cliente WHERE cli_cpf = ?";
    
    try (PreparedStatement stmt = connection.prepareStatement(sql)) {
        stmt.setString(1, cpf);
        ResultSet rs = stmt.executeQuery();
        
        if (rs.next()) {
            return rs.getInt(1) > 0; // Se a contagem for maior que 0, já existe
        }
    } catch (SQLException e) {
        throw new RuntimeException(e);
    }
    return false;
    
    }
    
    public void edita(Cliente cliente) {
    String sql = "UPDATE cliente SET cli_nome = ?, cli_email = ?, cli_telefone = ?, cli_endereco = ?, cli_dataDeNascimento = ? WHERE cli_cpf = ?";

    try {
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setString(1, cliente.getNome());
        stmt.setString(2, cliente.getEmail());
        stmt.setString(3, cliente.getTelefone());
        stmt.setString(4, cliente.getEndereco());
        stmt.setDate(5, new java.sql.Date(cliente.getDataDeNascimento().getTime()));
        stmt.setString(6, cliente.getCpf()); 

        stmt.executeUpdate();
        stmt.close();
    } catch (SQLException e) {
        throw new RuntimeException(e);
    }
}
    public Cliente buscarPorCpf(String cpf) {
    String sql = "SELECT * FROM cliente WHERE cli_cpf = ?";
    try {
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setString(1, cpf);
        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {
            Cliente cliente = new Cliente();
            cliente.setCpf(rs.getString("cli_cpf"));
            cliente.setNome(rs.getString("cli_nome"));
            cliente.setEmail(rs.getString("cli_email"));
            cliente.setTelefone(rs.getString("cli_telefone"));
            cliente.setEndereco(rs.getString("cli_endereco"));
            cliente.setDataDeNascimento(rs.getDate("cli_dataDeNascimento"));
            return cliente;
        }

        rs.close();
        stmt.close();
        return null;
    } catch (SQLException e) {
        throw new RuntimeException(e);
    }
}

    
}
