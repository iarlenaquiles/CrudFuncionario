package br.ufc.quixada.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;

@Entity(name = "dependentes")
@NamedQuery(name = "Dependente.findByInicialNamed", query = "SELECT d FROM dependentes d WHERE d.nome LIKE :nome")
public class Dependente {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(unique = true)
	private String cpf;

	private String nome;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "func_id", nullable = false)
	private Funcionario funcionario;

	public Dependente(Integer id, String cpf, String nome) {
		super();
		this.id = id;
		this.cpf = cpf;
		this.nome = nome;
	}

	public Dependente() {

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

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	@Override
	public String toString() {
		return "Dependente [id=" + id + ", cpf=" + cpf + ", nome=" + nome + "]";
	}

}
