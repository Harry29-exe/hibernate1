import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class TestSystem {
    private static EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence.createEntityManagerFactory("hibernate1");

    public static void addCustomer(int id, String firstName, String lastName) {
        EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
        EntityTransaction et = null;
        try {
            et = em.getTransaction();
            et.begin();
            Customer customer = new Customer();
            customer.setCustomerId(id);
            customer.setFirstName(firstName);
            customer.setLastName(lastName);
            em.persist(customer);
            et.commit();
        } catch (Exception ex) {
            if(et != null) {
                et.rollback();
            }
            ex.printStackTrace();
        } finally {
            em.close();
        }
    }

    public static void main(String[] args) {

    }
}
