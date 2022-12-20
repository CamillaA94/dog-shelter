package it.corso.dao;
import org.springframework.data.repository.CrudRepository;
import it.corso.model.Admin;

public interface AdminDao extends CrudRepository<Admin, Integer> {

}
