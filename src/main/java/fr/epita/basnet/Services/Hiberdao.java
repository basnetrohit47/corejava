package fr.epita.basnet.Services;

import java.util.List;

import javax.inject.Inject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;


import fr.epita.basnet.model.Student;

public class Hiberdao implements Dao<Student>{

	
	
	@Inject
	SessionFactory sf;
	
	
	public void write(Student student){
		Session session = sf.openSession();
		Transaction transaction = session.beginTransaction();
		session.save(student);
		transaction.commit();
		session.close();
	}
	
	public void delete(Student student){
		Session session = sf.openSession();
		Transaction transaction = session.beginTransaction();
		session.delete(student);
		transaction.commit();
		session.close();
	}
	
	public void update(Student student){
		Session session = sf.openSession();
		Transaction transaction = session.beginTransaction();
		session.update(student);
		transaction.commit();
		session.close();
	}
	
	@SuppressWarnings("unchecked")
	public List<Student>listall(Student student){
		Session session=sf.openSession();
		List<Student>StList=session.createQuery("from Student").list();
		
		session.close();
		return StList;
	}
	
}
