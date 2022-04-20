package spring.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import spring.entity.Customer;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public class CustomerDaoImpl implements CustomerDao{
    @Autowired
    private SessionFactory sessionFactory;
    @Override
    public List<Customer> getCustomers() {
        Session currentSession= sessionFactory.getCurrentSession();
        Query<Customer> theQuery=currentSession.createQuery("from Customer order by lastName",Customer.class);
        List<Customer> customers=theQuery.getResultList();
        return customers;
    }

    @Override
    public void saveCustomer(Customer theCustomer) {
        Session currentSession;
        try {
            currentSession = sessionFactory.getCurrentSession();
        } catch (HibernateException e) {
            currentSession = sessionFactory.openSession();
        }
        currentSession.saveOrUpdate(theCustomer);
    }

    @Override
    public Customer getCustomer(int theId) {
        Session currentSession = sessionFactory.getCurrentSession();
        Customer theCustomer=currentSession.get(Customer.class,theId);
        return theCustomer;
    }

    @Override
    public void deleteCustomer(int theId) {
        Session currentSession = sessionFactory.getCurrentSession();
        Query theQuery= currentSession.createQuery("delete from Customer where id=:customerId");
        theQuery.setParameter("customerId",theId);
        theQuery.executeUpdate();
    }
}
