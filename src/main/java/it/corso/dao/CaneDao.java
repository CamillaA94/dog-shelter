package it.corso.dao;
import org.springframework.data.repository.CrudRepository;
import it.corso.model.Cane;

public interface CaneDao extends CrudRepository<Cane, Integer> {

}
