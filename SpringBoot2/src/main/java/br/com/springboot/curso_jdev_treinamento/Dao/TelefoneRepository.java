package br.com.springboot.curso_jdev_treinamento.Dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.springboot.curso_jdev_treinamento.model.Telefones;

@Repository
@Transactional
public interface TelefoneRepository extends CrudRepository<Telefones, Long>{

}
