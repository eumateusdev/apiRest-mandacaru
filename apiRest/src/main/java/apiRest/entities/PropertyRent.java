package apiRest.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity(name = "propertyrent")
public class PropertyRent {
	
	@Id
	@GeneratedValue
	private int id;
	private String titulo;
	private String endereco;
	private String metrosTerreno;
	private String metrosContruido;
	private int quantQuartos;
	private int quantBanheiros;
	private int quantGaragem;
	private double preco;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getMetrosTerreno() {
		return metrosTerreno;
	}
	public void setMetrosTerreno(String metrosTerreno) {
		this.metrosTerreno = metrosTerreno;
	}
	public String getMetrosContruido() {
		return metrosContruido;
	}
	public void setMetrosContruido(String metrosContruido) {
		this.metrosContruido = metrosContruido;
	}
	public int getQuantQuartos() {
		return quantQuartos;
	}
	public void setQuantQuartos(int quantQuartos) {
		this.quantQuartos = quantQuartos;
	}
	public int getQuantBanheiros() {
		return quantBanheiros;
	}
	public void setQuantBanheiros(int quantBanheiros) {
		this.quantBanheiros = quantBanheiros;
	}
	public int getQuantGaragem() {
		return quantGaragem;
	}
	public void setQuantGaragem(int quantGaragem) {
		this.quantGaragem = quantGaragem;
	}
	public double getPreco() {
		return preco;
	}
	public void setPreco(double preco) {
		this.preco = preco;
	}
	public PropertyRent(int id, String titulo, String endereco, String metrosTerreno, String metrosContruido,
			int quantQuartos, int quantBanheiros, int quantGaragem, double preco) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.endereco = endereco;
		this.metrosTerreno = metrosTerreno;
		this.metrosContruido = metrosContruido;
		this.quantQuartos = quantQuartos;
		this.quantBanheiros = quantBanheiros;
		this.quantGaragem = quantGaragem;
		this.preco = preco;
	}
	public PropertyRent() {
		super();
	}

}
