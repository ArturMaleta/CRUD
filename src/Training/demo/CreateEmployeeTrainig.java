package Training.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import Training.Employee;

public class CreateEmployeeTrainig {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Employee.class)
									.buildSessionFactory();

		Session session = factory.getCurrentSession();
		
		try {
			
			// create employee object
			Employee tempEmployee1 = new Employee("Artur", "Maleta", "DDH");
			Employee tempEmployee2 = new Employee("Marta", "Jankowska", "DDB Tribal");
			Employee tempEmployee3 = new Employee("Damian", "Galinski", "Ambasada Nigerii");
			Employee tempEmployee4 = new Employee("Michal", "Wegierek", "DDH");
			Employee tempEmployee5 = new Employee("Adam", "Serek", "Eventy");
			Employee tempEmployee6 = new Employee("Martyna", "Galazka", "bezrobotna");
			Employee tempEmployee7 = new Employee("Pawel", "Pietrzykowski", "IQ");
			Employee tempEmployee8 = new Employee("Szymon", "Ciuraba", "kuptablet");
			
			// start transaction
			session.beginTransaction();
			
			// save employees
			session.save(tempEmployee1);
			session.save(tempEmployee2);
			session.save(tempEmployee3);
			session.save(tempEmployee4);
			session.save(tempEmployee5);
			session.save(tempEmployee6);
			session.save(tempEmployee7);
			session.save(tempEmployee8);
			
			// commit transaction
			session.getTransaction().commit();
			
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
	}

}
