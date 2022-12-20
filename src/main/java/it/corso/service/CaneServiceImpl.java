package it.corso.service;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.regex.Pattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import it.corso.dao.CaneDao;
import it.corso.model.Cane;

@Service
public class CaneServiceImpl implements CaneService {

	@Autowired
	private CaneDao caneDao;

	@Override
	public void registraCane(Cane cane, int id, String nome, String razza, String eta, String sesso, boolean sterilizzazione, 
							String[]vax, boolean microchip, String descrizione, String data) {
		cane.setNome(nome);
		cane.setRazza(razza);
		cane.setEta(Integer.parseInt(eta));
		cane.setSesso(sesso);
		cane.setSterilizzazione(sterilizzazione);
		String vaccinazioni = "";
		for(String v : vax) {
			vaccinazioni = vaccinazioni + v + ", ";
		}
		vaccinazioni = vaccinazioni.substring(0, (vaccinazioni.length() - 2));
		cane.setVaccinazioni(vaccinazioni);
		cane.setMicrochip(microchip);
		cane.setDescrizione(descrizione);
		String arrivo = (String) data;
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		try
		{
			cane.setArrivo(format.parse(arrivo));
		} catch (ParseException e)
		{
			cane.setArrivo(new Date());
		}
		caneDao.save(cane);
	}

	@Override
	public Cane getCaneById(int id) {
		return caneDao.findById(id).get();
	}

	@Override
	public List<Cane> getCani() {
		return (List<Cane>)caneDao.findAll();
	}

	@Override
	public void cancellaCane(Cane cane) {
		caneDao.save(cane);
		caneDao.delete(cane);
	}

	@Override
	public boolean checkCane(String... dati) {
		if(Pattern.matches(REGEX, dati[0]) && Pattern.matches(REGEX, dati[1]) && Pattern.matches(REGEXD, dati[2])) {
			return true;
		}
		return false;
	}
}
