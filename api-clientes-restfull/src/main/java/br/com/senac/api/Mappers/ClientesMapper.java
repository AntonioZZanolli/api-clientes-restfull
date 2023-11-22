package br.com.senac.api.Mappers;

import br.com.senac.api.DTO.ClientesRequest;
import br.com.senac.api.DTO.ClientesResponse;
import br.com.senac.api.DTO.EnderecosResponse;
import br.com.senac.api.entidades.Clientes;
import br.com.senac.api.entidades.Enderecos;

import java.util.List;

public class ClientesMapper {
    public static Clientes clientesRequestToClientes(ClientesRequest cliente){
        Clientes out = new Clientes();
    out.setEmail(cliente.getEmail());
    out.setTelefone(cliente.getTelefone());
    out.setDataNascimento(cliente.getDataNascimento());
    out.setNome(cliente.getNome());
    out.setSobreNome(cliente.getSobreNome());

        List<Enderecos> enderecosList = cliente.getEnderecos().stream().map(EnderecosMapper :: enderecosRequestToEnderecos).toList();

        out.setEnderecos(enderecosList);

        return out;
    }

    public static ClientesResponse clientesToClientesResponse(Clientes cliente){
        ClientesResponse out = new ClientesResponse();

        out.setEmail(cliente.getEmail());
        out.setTelefone(cliente.getTelefone());
        out.setDataNascimento(cliente.getDataNascimento());
        out.setNome(cliente.getNome());
        out.setSobreNome(cliente.getSobreNome());

        List<EnderecosResponse> enderecosResponseList = cliente.getEnderecos().stream().map(EnderecosMapper :: enderecosToEnderecosResponse).toList();

        out.setEnderecos(enderecosResponseList);

        return out;
    }
}
