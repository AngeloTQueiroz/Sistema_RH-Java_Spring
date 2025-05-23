package com.AppRH.AppRH.repository;

import com.AppRH.AppRH.models.Vaga;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface VagaRepository extends CrudRepository<Vaga, String> {

    // buscar por
    Vaga findByCodigo(long codigo);
    List<Vaga> findByNome(String nome);

}
