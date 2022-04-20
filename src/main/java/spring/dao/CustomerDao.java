package spring.dao;

import spring.entity.Customer;

import java.util.List;


public interface CustomerDao {
    public List<Customer> getCustomers();


    public void saveCustomer(Customer theCustomer);

    public Customer getCustomer(int theId);

    public void deleteCustomer(int theId);
}
