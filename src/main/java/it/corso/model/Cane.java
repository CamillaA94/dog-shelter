package it.corso.model;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Pattern;

@Entity
@Table(name = "cani")
public class Cane implements Serializable {

	private static final long serialVersionUID = 1123373316908033284L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Pattern(regexp = "[a-zA-Z\\s'àèéìòù]{1,30}", message = "#")
	@Column(name = "nome", length = 30, nullable = false)
	private String nome;
	
	@Pattern(regexp = "[a-zA-Z\\s'àèéìòù]{1,30}", message = "#")
	@Column(name = "razza", length = 30, nullable = false)
	private String razza;
	
	@Digits(integer = 11, fraction = 0, message = "#")
	@Column(name = "eta", nullable = false)
	private int eta;
	
	@Pattern(regexp = "[MF]{1}", message = "#")
	@Column(name = "sesso", length = 1, nullable = false)
	private char sesso;
	
	@Column(name = "sterilizzazione", nullable = false)
	private boolean sterilizzazione;
	
	@Pattern(regexp = "a-zA-Z\\s&/(),;.-°'àèéìòù{1,255}", message = "#")
	@Column(name = "vaccinazioni", length = 255, nullable = false)
	private String vaccinazioni;
	
	@Column(name = "microchip", nullable = false)
	private boolean microchip;
	
	@Pattern(regexp = "[a-zA-Z\\s!,;.-°'àèéìòù]{1,255}", message = "#")
	@Column(name = "descrizione", length = 255, nullable = false)
	private String descrizione;

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

	public String getRazza() {
		return razza;
	}

	public void setRazza(String razza) {
		this.razza = razza;
	}

	public int getEta() {
		return eta;
	}

	public void setEta(int eta) {
		this.eta = eta;
	}

	public char getSesso() {
		return sesso;
	}

	public void setSesso(char sesso) {
		this.sesso = sesso;
	}

	public boolean isSterilizzazione() {
		return sterilizzazione;
	}

	public void setSterilizzazione(boolean sterilizzazione) {
		this.sterilizzazione = sterilizzazione;
	}

	public String getVaccini() {
		return vaccinazioni;
	}

	public void setVaccini(String vaccini) {
		this.vaccinazioni = vaccini;
	}

	public boolean isMicrochip() {
		return microchip;
	}

	public void setMicrochip(boolean microchip) {
		this.microchip = microchip;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
}
