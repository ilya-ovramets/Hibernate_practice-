package org.example;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import project.dto.RoleDTO;
import project.entity.*;
import project.dao.*;
import project.service.RoleService;

import java.sql.ResultSet;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        RoleService roleService = new RoleService();

        RoleDTO role = new RoleDTO();

        role.setName("Gamer");

        roleService.save(role);

    }
}