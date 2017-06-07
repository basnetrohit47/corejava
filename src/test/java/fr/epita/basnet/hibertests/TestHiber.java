package fr.epita.basnet.hibertests;

import static org.junit.Assert.assertEquals;

import java.util.List;

import javax.inject.Inject;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import fr.epita.basnet.Services.AddressDao;
import fr.epita.basnet.Services.Dao;
import fr.epita.basnet.Services.Hiberdao;
import fr.epita.basnet.model.Address;
import fr.epita.basnet.model.Student;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"/applicationContext.xml"})
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations={"/applicationContext.xml"})
public class TestHiber {
	//@Inject
	//Hiberdao dao;
	
	//@Inject
	//AddressDao daoA;
	@Inject
	Dao <Student>dao;
	@Inject
	Dao <Address>daoA;
	@Test
	public void testhiber(){
		Address address=new Address(101,"paris","droncy");
		
		Student student=new Student("rohit","gmail",123,address);
		
		
		//inserting in address table
		daoA.write(address);
		
		
		//Insert testing
		dao.write(student);
		List<Student>l=dao.listall(student);
		//List<Address>lad=daoA.listall();
		Address ad=l.get(0).getAddress();
		System.out.println(ad.getId());
		Assert.assertFalse(l.isEmpty());
		
		
		
		//update testing
	    student.setName("basnet");
	    dao.update(student);
	    List<Student>la=dao.listall(student);
	    String name=la.get(0).getName();
	   
	    assertEquals(name,"basnet");
		
		//delete testing
		dao.delete(student);
		
		List<Student>lao=dao.listall(student);
		Assert.assertTrue(lao.isEmpty());
		
		
	}
}
