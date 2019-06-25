package model.vo;

public class Montadora {

	private int id;
	private String nome;
	private String pais;
	private String cnpj;

	public Montadora() {
		super();
	}

	public Montadora(String nome, String pais, String cnpj) {
		super();
		this.nome = nome;
		this.pais = pais;
		this.cnpj = cnpj;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getPais() {
		return pais;
	}
	public void setPais(String pais) {
		this.pais = pais;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	@Override
	public String toString() {
		//reescrever conforme especificado no item 2.b da avaliação
		return this.nome + " (" +  this.pais + ") - " + this.cnpj;
	}
}