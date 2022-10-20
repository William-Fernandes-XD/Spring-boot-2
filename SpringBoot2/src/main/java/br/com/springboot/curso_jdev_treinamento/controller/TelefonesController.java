package br.com.springboot.curso_jdev_treinamento.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.springboot.curso_jdev_treinamento.Dao.PessoaRepository;
import br.com.springboot.curso_jdev_treinamento.Dao.TelefoneRepository;
import br.com.springboot.curso_jdev_treinamento.model.Telefones;
import br.com.springboot.curso_jdev_treinamento.model.Usuario;

@Controller
public class TelefonesController {

	@Autowired
	private TelefoneRepository telefoneRepository;
	
	@Autowired
	private PessoaRepository pessoaRepository;
	
	@PostMapping("/salvarTelefone")
	public ResponseEntity<Telefones> salvarTelefone(@RequestParam("idUser") Long id, @RequestBody Telefones telefones){
		
		Usuario userTelefones = pessoaRepository.findById(id).get();
		
		telefones.setUsuario(userTelefones);
		
		telefones = telefoneRepository.save(telefones);
		return new ResponseEntity<Telefones>(telefones, HttpStatus.CREATED);
	}
}
