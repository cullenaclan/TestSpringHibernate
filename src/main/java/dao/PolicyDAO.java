package dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;


import model.Policy;

public interface PolicyDAO {

	public Policy get(int id);
	public void save(Policy p);
	public void update(Policy p);
	public void delete(int id);
	public List<Policy> list();
}
