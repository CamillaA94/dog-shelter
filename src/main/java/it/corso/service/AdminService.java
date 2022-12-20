package it.corso.service;

import javax.servlet.http.HttpSession;

public interface AdminService {

	boolean login(String username, String password, HttpSession session);
}
