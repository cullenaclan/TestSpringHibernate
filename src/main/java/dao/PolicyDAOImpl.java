package dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import model.Policy;

public class PolicyDAOImpl implements PolicyDAO{

	private SessionFactory sessionFactory;
	private Policy policy;
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	

	@Override
	public Policy get(int id) 
	{
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		Policy policy = (Policy) session.get("model.Policy", id);
		tx.commit();
		session.close();
		return policy;
	}
	
	
	public void save(Policy p) 
	{
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.persist(p);
		tx.commit();
		session.close();		
	}

	
	public void delete(int id) 
	{
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
//		session.get(Policy.class, id);
		Object x = session.get("model.Policy", id);
		session.delete("model.Policy", x);
		tx.commit();
		session.close();
	}

	public void update(Policy p) 
	{
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		Policy x = (Policy) session.get("model.Policy", p.getId());
		x.setName(p.getName());
		session.update("model.Policy", x);
		tx.commit();
		session.close();
	}
	
	
	@SuppressWarnings("unchecked")
	public List<Policy> list() 
	{
		Session session = this.sessionFactory.openSession();
		List<Policy> policyList = session.createQuery("from Policy").list();
		session.close();
		return policyList;
	}
	
	
}
