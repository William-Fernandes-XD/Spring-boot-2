package br.com.springboot.curso_jdev_treinamento.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(initialValue = 1, name = "seq_id", allocationSize = 1, sequenceName = "seq_id")
public class Usuario {

	@Id
	@GeneratedValue(generator = "seq_id", strategy = GenerationType.SEQUENCE)
	private Long id;
	
	private String login;
	private String senha;
	private String email;
	private String idade;
	private String cpf;
	
	@OneToMany(mappedBy = "usuario", fetch = FetchType.LAZY)
	private List<Telefones> telefones;
	
	public List<Telefones> getTelefones() {
		return telefones;
	}
	public void setTelefones(List<Telefones> telefones) {
		this.telefones = telefones;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getIdade() {
		return idade;
	}
	public void setIdade(String idade) {
		this.idade = idade;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
}
