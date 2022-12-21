package it.corso.service;
import java.util.List;
import it.corso.model.Cane;

public interface CaneService {

	String REGEX = "[a-zA-Z\\s'àèéìòù]{1,30}";
	String REGEXD ="[a-zA-Z\\s!,;.-°'àèéìòù]{1,255}";
	boolean checkCane(String... dati);
	public void registraCane(Cane cane, int id, String nome, String razza, String eta, String sesso, boolean sterilizzazione, String[]vax, boolean microchip, String descrizione, String data);
	public Cane getCaneById(int id);
	public List<Cane> getCani();
	public void cancellaCane(Cane cane);
}
