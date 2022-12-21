package it.corso.model;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "cani")
public class Cane implements Serializable {

	private static final long serialVersionUID = 1123373316908033284L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "nome", length = 30, nullable = false)
	private String nome;

	@Column(name = "razza", length = 30, nullable = false)
	private String razza;
	
	@Column(name = "eta", nullable = false)
	private int eta;
	
	@Column(name = "sesso", length = 1, nullable = false)
	private String sesso;
	
	@Column(name = "sterilizzazione", nullable = false)
	private boolean sterilizzazione;
	
	@Column(name = "vaccinazioni", length = 255, nullable = false)
	private String vaccinazioni;
	
	@Column(name = "microchip", nullable = false)
	private boolean microchip;
	
	@Column(name = "descrizione", length = 255, nullable = false)
	private String descrizione;
	
	@Column(name = "arrivo", nullable = false)
	@Temporal(TemporalType.DATE)
	private Date arrivo;

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

	public String getSesso() {
		return sesso;
	}

	public void setSesso(String sesso) {
		this.sesso = sesso;
	}

	public boolean isSterilizzazione() {
		return sterilizzazione;
	}

	public void setSterilizzazione(boolean sterilizzazione) {
		this.sterilizzazione = sterilizzazione;
	}

	public String getVaccinazioni() {
		return vaccinazioni;
	}

	public void setVaccinazioni(String vaccinazioni) {
		this.vaccinazioni = vaccinazioni;
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

	public Date getArrivo() {
		return arrivo;
	}

	public void setArrivo(Date arrivo) {
		this.arrivo = arrivo;
	}
}
