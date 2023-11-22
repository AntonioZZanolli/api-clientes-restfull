package br.com.senac.api.Mappers;

import br.com.senac.api.DTO.EnderecosRequest;
import br.com.senac.api.DTO.EnderecosResponse;
import br.com.senac.api.entidades.Enderecos;

public class EnderecosMapper {
    public static Enderecos enderecosRequestToEnderecos(EnderecosRequest endereco) {
        Enderecos out = new Enderecos();
        out.setId(endereco.getId());
        out.setEstado(endereco.getEstado());
        out.setCidade(endereco.getCidade());
        out.setBairro(endereco.getBairro());
        out.setRua(endereco.getRua());

        return out;
    }

    public static EnderecosResponse enderecosToEnderecosResponse(Enderecos endereco) {
        EnderecosResponse out = new EnderecosResponse();
        out.setId(endereco.getId());
        out.setEstado(endereco.getEstado());
        out.setCidade(endereco.getCidade());
        out.setBairro(endereco.getBairro());
        out.setRua(endereco.getRua());

        return out;
    }
}
