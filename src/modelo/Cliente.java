
package modelo;

import java.util.Date;
import javax.swing.JOptionPane;



public class Cliente {
    private int id;
    private String cpf;
    private String nome;
    private String email;
    private String telefone;
    private String endereco;
    private Date dataDeNascimento;
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        if (cpf != null && !cpf.isEmpty()) {
            String cpfNumerico = cpf.replaceAll("[^\\d]", "");
            if (cpfNumerico.length() == 11) {
                this.cpf = cpfNumerico.replaceFirst("(\\d{3})(\\d{3})(\\d{3})(\\d{2})", "$1.$2.$3-$4");
            } else {
                JOptionPane.showMessageDialog(null, "CPF inválido! Deve conter 11 dígitos.");
            }
        }
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public Date getDataDeNascimento() {
        return dataDeNascimento;
    }

    public void setDataDeNascimento(Date dataDeNascimento) {
        this.dataDeNascimento = dataDeNascimento;
    }
    
    
}
