package br.com.senac.api.DTO;

import java.time.LocalDate;
import java.util.List;

public class ClientesRequest {
    private String nome;
    private String sobreNome;
    private String email;
    private String telefone;
    private LocalDate dataNascimento;
    private List<EnderecosRequest> enderecos;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobreNome() {
        return sobreNome;
    }

    public void setSobreNome(String sobreNome) {
        this.sobreNome = sobreNome;
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

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public List<EnderecosRequest> getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(List<EnderecosRequest> enderecos) {
        this.enderecos = enderecos;
    }
}
