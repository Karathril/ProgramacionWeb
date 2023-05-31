package io.bmorenoc.democrud.service;

import io.bmorenoc.democrud.endpoint.User;
import io.bmorenoc.democrud.repository.FakeDataBase;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    public List<User> getListUsers() {
        return FakeDataBase.getUsers();
    }

    public User getUserById(int id){
        List<User> users = getListUsers();
        for(User user: users){
            if (user.getId() == id ){
                return user;
            }
        }
        return null;
    }

    public int addUser(User user){
        List<User> users = getListUsers();
        int id = users.size() + 1;
        user.setId(id);
        users.add(user);
        return id;
    }

    public boolean deleteUser(int id){
        List<User> users = getListUsers();
        for (User user : users) {
            if (user.getId() == id) {
                users.remove(user);
                return true;
            }
        }
        return false;
    }
}
