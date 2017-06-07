package fr.epita.basnet.Services;

import java.util.List;

import javax.inject.Inject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import fr.epita.basnet.model.Address;


public class AddressDao implements Dao<Address> {

	
	
	@Inject
	SessionFactory sf;
	
	
	public void write(Address address){
		Session session = sf.openSession();
		Transaction transaction = session.beginTransaction();
		session.save(address);
		transaction.commit();
		session.close();
	}
	
	public void delete(Address address){
		Session session = sf.openSession();
		Transaction transaction = session.beginTransaction();
		session.delete(address);
		transaction.commit();
		session.close();
	}
	
	public void update(Address address){
		Session session = sf.openSession();
		Transaction transaction = session.beginTransaction();
		session.update(address);
		transaction.commit();
		session.close();
	}
	
	@SuppressWarnings("unchecked")
	public List<Address>listall(Address address){
		Session session=sf.openSession();
		List<Address>StList=session.createQuery("from Address").list();
		
		session.close();
		return StList;
	}
	
}
