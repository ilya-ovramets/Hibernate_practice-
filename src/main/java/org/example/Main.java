package org.example;


import org.example.dto.RoleDTO;
import org.example.entity.*;
import org.example.repository.*;
import org.hibernate.Session;

import java.util.List;
import java.util.Optional;

public class Main {

    public static void main(String[] args) {

        try (Session session = HibernateUtil.getSessionFactory().openSession()){

            Optional<Role> roleOptional = Optional.ofNullable(session.get(Role.class,2));

            Role role = roleOptional.get();

            role.setUsers(new UserRepository().findAll()
                    .stream()
                    .filter(user -> user.getRole().getId() == role.getId()).toList());
            for (var us : role.getUsers()){
                us.toString();

            }
            role.toString();


        }catch (Exception e){
        }



    }
}