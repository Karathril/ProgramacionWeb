package io.bmorenoc.democrud.repository;
import io.bmorenoc.democrud.endpoint.User;

import java.util.ArrayList;
import java.util.List;

public class FakeDataBase {
    private static List<User> users;

    public static void createList(){
        users = new ArrayList<>();

        User user1 = new User();
        user1.setId(1);
        user1.setUsername("pepe1");
        user1.setPassword("popo1");
        user1.setEmail("pepe1@gmail.com");

        User user2 = new User();
        user2.setId(2);
        user2.setUsername("pepe2");
        user2.setPassword("popo2");
        user2.setEmail("pepe2@gmail.com");

        User user3 = new User();
        user3.setId(3);
        user3.setUsername("pepe3");
        user3.setPassword("popo3");
        user3.setEmail("pepe3@gmail.com");

        users.add(user1);
        users.add(user2);
        users.add(user3);
    }

    public static List<User> getUsers(){
        if(users == null){
            createList();
        }
        return users;
    }


}
