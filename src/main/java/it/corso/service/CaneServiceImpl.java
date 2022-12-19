package it.corso.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import it.corso.dao.CaneDao;

@Service
public class CaneServiceImpl implements CaneService {

	@Autowired
	private CaneDao caneDao;
}
