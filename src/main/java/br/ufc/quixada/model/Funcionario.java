package br.ufc.quixada.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

@Entity(name = "funcionarios")
@NamedQuery(name = "Funcionario.getInfo", query = "SELECT f FROM funcionarios f")
public class Funcionario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(unique = true)
	private String cpf;

	@Column(unique = true)
	private String matricula;

	private String nome;

	private String email;

	private String telefone;

	@OneToMany(mappedBy = "funcionario", fetch = FetchType.EAGER)
	private List<Dependente> dependentes;

	public Funcionario(Integer id, String cpf, String matrícula, String nome, String email, String telefone) {
		super();
		this.id = id;
		this.cpf = cpf;
		this.matricula = matrícula;
		this.nome = nome;
		this.email = email;
		this.telefone = telefone;
	}

	public Funcionario() {

	}

	public Funcionario(Integer id) {
		this.id = id;
	}

	public Funcionario(Integer id, String nome) {
		this.id = id;
		this.nome = nome;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getMatrícula() {
		return matricula;
	}

	public void setMatrícula(String matrícula) {
		this.matricula = matrícula;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public List<Dependente> getDependentes() {
		return dependentes;
	}

	public void setDependentes(Dependente dependente) {
		this.dependentes.add(dependente);
	}

	@Override
	public String toString() {
		return "Funcionario [id=" + id + ", cpf=" + cpf + ", matricula=" + matricula + ", nome=" + nome + ", email="
				+ email + ", telefone=" + telefone + ", dependentes=" + dependentes + "]";
	}

}
