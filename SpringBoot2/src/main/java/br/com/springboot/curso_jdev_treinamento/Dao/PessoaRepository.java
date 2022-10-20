package br.com.springboot.curso_jdev_treinamento.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.springboot.curso_jdev_treinamento.model.Usuario;

@Repository
@Transactional
public interface PessoaRepository extends CrudRepository<Usuario, Long>{

	@Query("select u from Usuario u where u.login like %:login%")
	List<Usuario> buscarPorLogin(@Param("login") String login) throws Exception;
}
