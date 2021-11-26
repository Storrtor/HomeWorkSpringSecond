package homework6;

import org.hibernate.Session;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("homework6");
        SessionFactoryUtils sessionFactoryUtils = context.getBean(SessionFactoryUtils.class);
//        CustomerDao customerDao = context.getBean(CustomerDaoImpl.class);
        Session session = null;
        try {
            session = sessionFactoryUtils.getSession();
            session.beginTransaction();
//            System.out.println(customerDao.getCustomers());
            session.getTransaction().commit();

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            sessionFactoryUtils.shutdown();
            if (session != null) {
                session.close();
            }
        }

    }



}
