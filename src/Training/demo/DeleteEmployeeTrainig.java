package Training.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import Training.Employee;

public class DeleteEmployeeTrainig {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Employee.class)
									.buildSessionFactory();

		Session session = factory.getCurrentSession();
		
		try {
			int employeeId = 2;
			
			// get new session
			System.out.println("\ngetting new session");
			session = factory.getCurrentSession();
			
			// start transaction
			System.out.println("begining new transaction");
			session.beginTransaction();
			
			// getting employee with id=2
			Employee myEmployee = session.get(Employee.class, employeeId);
			
			// delete employee
			System.out.println("deleting employee id=2");
			
			session.delete(myEmployee);
			
			// commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
			
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
	}

}
