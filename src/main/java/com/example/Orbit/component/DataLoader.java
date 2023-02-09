package com.example.Orbit.component;
import com.example.Orbit.models.Caree;
import com.example.Orbit.models.Need;
import com.example.Orbit.models.User;
import com.example.Orbit.repositories.CareeRepository;
import com.example.Orbit.repositories.NeedRepository;
import com.example.Orbit.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    UserRepository userRepository;

    @Autowired
    CareeRepository careeRepository;

    @Autowired
    NeedRepository needRepository;

    public DataLoader(){

    }

    @Override
    public void run (ApplicationArguments args) throws Exception {

        User user_1 = new User("Emma", "HELLO123", "em@hotmail.com", "London");

        User user_2 = new User("Berna", "HELLO123", "berna@hotmail.com", "London");

        User user_3 = new User("Sara", "HELLO123", "sara@hotmail.com", "London");


        User user_4 = new User("Caitlin", "HELLO123", "caitlin@hotmail.com", "London");

        User user_5 = new User("Saad", "HELLO123", "saad@hotmail.com", "London");

        userRepository.saveAll(List.of(user_1, user_2, user_3, user_4, user_5));


        Caree caree_1 = new Caree("Carol", 79, "Em's Nan", "1234");

        Caree caree_2 = new Caree("Bob",  85, "Berna's uncle", "1234");

        Caree caree_3 = new Caree("Lily", 20, "Sara's friend", "1234");

        Caree caree_4 = new Caree("Zsolt", 1, "Caitlin's nephew", "1234");

        Caree caree_5 = new Caree("Franziska", 50, "Saad's family friend", "1234");


        careeRepository.saveAll(List.of(caree_1, caree_2, caree_3, caree_4, caree_5));

        Need need_1  = new Need("food shop", "buy eggs, milk, bread by Wednesday",false,caree_1);

        Need need_2  = new Need("take to appointment", "Monday hospital appointment at 12",false, caree_2);

        Need need_3  = new Need("help with laundry", "wash laundry, dry and fold by Tuesday",false, caree_3);

        Need need_4  = new Need("collect baby prescription from pharmacy", "collect prescription from BNTA Pharmacy in Holborn on Friday",false, caree_4);

        Need need_5  = new Need("read book for 1hr to Franziska for course", "book is found on bookshelf in bedroom or living room read on Thursday",false, caree_5);

        needRepository.saveAll(List.of(need_1, need_2, need_3, need_4, need_5)); 
    }

}
