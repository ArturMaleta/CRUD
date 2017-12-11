package Training.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import Training.Employee;

public class QuerySomethingEmployeeTrainig {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Employee.class)
									.buildSessionFactory();

		Session session = factory.getCurrentSession();
		
		try {
			// start transaction
			System.out.println("Beginning new transaction");
			session.beginTransaction();
			
			System.out.println("getting list of employees");
			
			List<Employee> theEmployees = session.createQuery("from Employee").getResultList();
			
			System.out.println("lista pracowników: " + theEmployees);
			// commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
	}

}
