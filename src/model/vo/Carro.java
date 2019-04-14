package model.vo;

public class Carro {

	private int id;
	private Montadora montadora;
	private String modelo;
	private int ano;
	private double valor;
	private String placa;

	public Carro() {
	}

	public Carro(Montadora montadora, String modelo, int ano, double valor, String placa) {
		super();
		this.montadora = montadora;
		this.modelo = modelo;
		this.ano = ano;
		this.valor = valor;
		this.placa = placa;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Montadora getMontadora() {
		return montadora;
	}

	public void setMontadora(Montadora montadora) {
		this.montadora = montadora;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}


	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	@Override
	public String toString() {
		return "Carro [id=" + id + ", montadora=" + montadora + ", modelo=" + modelo + ", ano=" + ano + ", valor="
				+ valor + "]";
	}
}