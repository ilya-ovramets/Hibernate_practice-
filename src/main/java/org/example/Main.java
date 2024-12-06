package org.example;


import org.example.dto.RoleDTO;
import org.example.entity.*;
import org.example.repository.*;

import java.util.List;
import java.util.Optional;

public class Main {

    public static void main(String[] args) {



        var roleRepository = new RoleRepository();

        var role = roleRepository.findById(1);

        List<User> users = new UserRepository().findAll().stream()
                .filter(user -> user.getRole().getId() == role.get().getId()).toList();

        for(var us:users){
            us.toString();
        }

    }
}