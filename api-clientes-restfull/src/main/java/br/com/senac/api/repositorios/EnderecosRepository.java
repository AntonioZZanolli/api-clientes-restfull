package br.com.senac.api.repositorios;

import br.com.senac.api.entidades.Enderecos;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnderecosRepository extends JpaRepository<Enderecos, Long> {
}
