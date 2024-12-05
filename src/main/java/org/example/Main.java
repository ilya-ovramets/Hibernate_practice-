package org.example;


import org.example.dto.RoleDTO;
import org.example.service.RoleService;

public class Main {

    public static void main(String[] args) {

        RoleService roleService = new RoleService();

        RoleDTO role = new RoleDTO();

        role.setName("Gamer");

        roleService.save(role);

    }
}