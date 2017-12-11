package Training.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import Training.Employee;

public class Update2EmployeeTrainig {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Employee.class)
									.buildSessionFactory();

		Session session = factory.getCurrentSession();
		
		try {
			int employeeId = 9;
			// start transaction
			System.out.println("Beginning new transaction");
			session.beginTransaction();
			
			// update firstName
			System.out.println("getting employee");
			
			Employee myEmployee = session.get(Employee.class, employeeId);
			
			System.out.println("updating name to Kondrat");
			
			myEmployee.setFirstName("Kondrat");
			
			// commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
	}

}
