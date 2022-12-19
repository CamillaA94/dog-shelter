package it.corso.service;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import it.corso.dao.AdminDao;
import it.corso.model.Admin;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	private AdminDao adminDao;

	@Override
	public boolean login(String username, String password, HttpSession session) {
		for(Admin admin : adminDao.findAll()) 
			if(username.equals(admin.getUsername()))
				if(password.equals(admin.getPassword())) {
					session.setAttribute("logged", true);
					return true;
				}
		return false;
	}
}
