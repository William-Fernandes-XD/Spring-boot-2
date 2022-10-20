package br.com.springboot.curso_jdev_treinamento.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.springboot.curso_jdev_treinamento.Dao.PessoaRepository;
import br.com.springboot.curso_jdev_treinamento.model.Usuario;

@Controller
public class PessoaController {
	
	@Autowired
	private PessoaRepository pessoaRepository;

	@GetMapping("/cadastro")
	public String cadastro() {
		return "cadastro/cadastro.html"; 
	}
	
	@PostMapping("/salvar")
	public ResponseEntity<Usuario> salvar(@RequestBody Usuario usuario) {
		
		Usuario user = usuario;
		
		user = pessoaRepository.save(user);
		
		return new ResponseEntity<Usuario>(user, HttpStatus.CREATED);
	}
	
	@GetMapping("/listaUsers")
	public ResponseEntity<List<Usuario>> pessoas() {
		
		List<Usuario> users = (List<Usuario>) pessoaRepository.findAll();
		return new ResponseEntity<List<Usuario>>(users, HttpStatus.OK);
	} 
	
	@GetMapping("/pesquisarUser")
	public ResponseEntity<Usuario> pesquisarUser(@RequestParam("idUser") Long id) {
		
		Usuario users = pessoaRepository.findById(id).get();
		return new ResponseEntity<Usuario>(users, HttpStatus.OK);
	}
	
	@GetMapping("/telefones")
	public ResponseEntity<Usuario> telefones(@RequestParam("idUser") Long id) {
		
		Usuario users = pessoaRepository.findById(id).get();
		return new ResponseEntity<Usuario>(users, HttpStatus.OK);
	}
	
	@GetMapping("/pesquisarUserPorLogin")
	public ResponseEntity<List<Usuario>> pesquisarUserPorLogin(@RequestParam("login") String login) throws Exception {
		
		List<Usuario> users = pessoaRepository.buscarPorLogin(login);
		return new ResponseEntity<List<Usuario>>(users, HttpStatus.OK);
	}
	
	@GetMapping("/deletarUser")
	public ResponseEntity<String> deletarUser(@RequestParam("idUser") Long id) {
		
		pessoaRepository.deleteById(id);
		return new ResponseEntity<String>("Deletado com sucesso", HttpStatus.ACCEPTED);
	}
}