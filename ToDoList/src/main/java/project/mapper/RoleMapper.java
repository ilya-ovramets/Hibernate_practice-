package project.mapper;

import project.dto.RoleDTO;
import project.entity.Role;

import java.util.List;
import java.util.stream.Stream;

public class RoleMapper {
    public RoleDTO toDTO(Role role) {
        RoleDTO roleDTO = new RoleDTO();
        roleDTO.setId(role.getId());
        roleDTO.setName(role.getName());
        return roleDTO;
    }

    public Role toEntity(RoleDTO roleDTO) {
        Role role = new Role();
        role.setId(roleDTO.getId());
        role.setName(roleDTO.getName());
        return role;
    }

    public List<RoleDTO> toDTOS(List<Role> roles){
        return roles.stream().map(this::toDTO).toList();
    }

    public List<Role> toEntitys(List<RoleDTO> roleDTOS){
        return roleDTOS.stream().map(this::toEntity).toList();
    }
}
