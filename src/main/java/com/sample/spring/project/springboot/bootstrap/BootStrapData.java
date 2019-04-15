package com.sample.spring.project.springboot.bootstrap;

import com.sample.spring.project.springboot.domain.Customer;
import com.sample.spring.project.springboot.repoitories.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final CustomerRepository customerRepository;

    public BootStrapData(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }



    @Override
    public void run(String... args) throws Exception {
        Customer c1 = new Customer();
        c1.setFirstname("Jan");
        c1.setLastname("Kowalski");
        customerRepository.save(c1);

        Customer c2 = new Customer();
        c2.setFirstname("Bartek");
        c2.setLastname("Nowak");
        customerRepository.save(c2);

        Customer c3 = new Customer();
        c3.setFirstname("Ignacy");
        c3.setLastname("Krasicki");
        customerRepository.save(c3);

        System.out.println("Customers count: " + customerRepository.count());
    }
}
