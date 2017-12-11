package Training.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import Training.Employee;

public class ReadEmployeeTrainig {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Employee.class)
									.buildSessionFactory();

		Session session = factory.getCurrentSession();
		
		try {
			
			// create employee object
			System.out.println("Creating new Employee");
			Employee tempEmployee9 = new Employee("Konrad", "Konrad", "Psychiatryk");
			
			// start transaction
			System.out.println("Beginning new transaction");
			session.beginTransaction();
			
			// save employees
			System.out.println("saving employee");
			session.save(tempEmployee9);
			
			Employee myEmployee = session.get(Employee.class, tempEmployee9.getId());
			System.out.println("Naszym studentem jest: " + myEmployee);
			
			// commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
	}

}
