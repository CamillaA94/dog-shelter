package it.corso.service;
import java.util.List;
import it.corso.model.Cane;

public interface CaneService {

	String REGEX = "[a-zA-Zàèéìòù\\s']{1,30}";
	String REGEXD ="[a-zA-Zàèéìòù\\s!,;.-°']{1,10000}";
	boolean checkCane(String... dati);
	public void registraCane(Cane cane, int id, String nome, String razza, String eta, String sesso, boolean sterilizzazione, String[]vax, boolean microchip, String descrizione, String data);
	public Cane getCaneById(int id);
	public List<Cane> getCaniAlfabetico();
	public List<Cane> getCaniPrimi();
	public List<Cane> getCaniUltimi();
	public List<Cane> getCaniEtaCrescente();
	public List<Cane> getCaniEtaDecrescente();
	public List<Cane> getCaniMaschi();
	public List<Cane> getCaniFemmine();
	public void cancellaCane(Cane cane);
}
