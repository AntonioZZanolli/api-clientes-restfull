package br.com.senac.api.controller;

import br.com.senac.api.DTO.ClientesRequest;
import br.com.senac.api.DTO.ClientesResponse;
import br.com.senac.api.Mappers.ClientesMapper;
import br.com.senac.api.entidades.Clientes;
import br.com.senac.api.repositorios.ClientesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/clientes")
public class ClientesController {
    @Autowired
    private ClientesRepository clientesRepository;

    @GetMapping("/")
    @CrossOrigin
    public ResponseEntity<List<ClientesResponse>> carregarClientes() {
        List<Clientes> retorno = clientesRepository.findAll();

        List<ClientesResponse> out = retorno.stream().map(ClientesMapper :: clientesToClientesResponse).toList();
        return ResponseEntity.ok().body(out);
    }

    @PostMapping("/")
    @CrossOrigin
    public ResponseEntity<ClientesResponse> criarCliente(@RequestBody ClientesRequest cliente) {
        Clientes envio = ClientesMapper.clientesRequestToClientes(cliente)
        Clientes retorno = clientesRepository.save(envio);

        return ResponseEntity.status(HttpStatus.CREATED).body(ClientesMapper.clientesToClientesResponse(retorno));
    }

    @DeleteMapping("/{id}")
    @CrossOrigin
    public ResponseEntity<Void> deletarCliente(@PathVariable Long id) {
        clientesRepository.deleteById(id);

        return ResponseEntity.ok(null);
    }

    @PutMapping("/{id}")
    @CrossOrigin
    public ResponseEntity<ClientesResponse> atualizarCLiente(@PathVariable Long id, @RequestBody ClientesRequest cliente) {
        Clientes retorno = clientesRepository.findById(id).map(record -> {
            record.setNome(cliente.getNome());
            record.setSobreNome(cliente.getSobreNome());
            record.setTelefone(cliente.getTelefone());
            record.setDataNascimento(cliente.getDataNascimento());
            record.setEmail(cliente.getEmail());
            return clientesRepository.save(record);
        }).get();

        return ResponseEntity.ok(ClientesMapper.clientesToClientesResponse(retorno));
    }

    @GetMapping("/{id}")
    @CrossOrigin
    public ResponseEntity<ClientesResponse> carregarClientesById(@PathVariable Long id) {
        Clientes retorno = clientesRepository.findById(id).get();

        return ResponseEntity.ok(ClientesMapper.clientesToClientesResponse(retorno));
    }

    @GetMapping("/{nome}/buscar")
    @CrossOrigin
    public ResponseEntity<List<ClientesResponse>> carregarClienteByNome(@PathVariable String nome) {
        List<Clientes> retorno = clientesRepository.findByNome(nome);

        List<ClientesResponse> out = retorno.stream().map(ClientesMapper :: clientesToClientesResponse).toList();
        return ResponseEntity.ok(out);
    }
}
