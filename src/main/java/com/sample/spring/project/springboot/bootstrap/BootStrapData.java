package com.sample.spring.project.springboot.bootstrap;

import com.sample.spring.project.springboot.domain.User;
import com.sample.spring.project.springboot.repoitories.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final UserRepository userRepository;

    public BootStrapData(UserRepository userRepository) {
        this.userRepository = userRepository;
    }



    @Override
    public void run(String... args) throws Exception {
        User c1 = new User();
        c1.setFirstname("Jan");
        c1.setLastname("Kowalski");
        c1.setLogin("jkowalski");
        c1.setPassword("test1234");
        c1.setEmail("jkowal@gmail.com");
        c1.setPhone("500-600-700");
        userRepository.save(c1);

        User c2 = new User();
        c2.setFirstname("Bartek");
        c2.setLastname("Nowak");
        c2.setLogin("bnowak");
        c2.setPassword("nowak1234");
        c2.setEmail("bnowak@gmail.com");
        c2.setPhone("500-800-900");
        userRepository.save(c2);

        User c3 = new User();
        c3.setFirstname("Ignacy");
        c3.setLastname("Krasicki");
        c3.setLogin("ikrasicki");
        c3.setPassword("krasicki1234");
        c3.setEmail("ikrasicki@gmail.com");
        c3.setPhone("600-400-700");
        userRepository.save(c3);



        System.out.println("User count: " + userRepository.count());
    }
}
