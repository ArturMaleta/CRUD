package Training.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import Training.Employee;

public class QueryAllEmployeesTrainig {

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
			
			List<Employee> theEmployees1 = session.createQuery("from Employee s where s.lastName='Serek'" + "OR s.firstName='pawel'").getResultList();
			List<Employee> theEmployees2 = session.createQuery("from Employee s where" + " s.company='Digital Direct House'").getResultList();
			
			System.out.println("wynik 1: " + theEmployees1);
			System.out.println("wynik 2: " + theEmployees2);
			// commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
	}

}
