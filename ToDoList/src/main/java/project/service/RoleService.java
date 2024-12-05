package project.service;

import project.dao.RoleRepository;
import project.dto.RoleDTO;
import project.mapper.RoleMapper;

import java.util.List;

public class RoleService{

    RoleRepository roleDao = new RoleRepository();
    RoleMapper roleMapper = new RoleMapper();


    public boolean save(RoleDTO roleDTO){
        roleDao.save(roleMapper.toEntity(roleDTO));
        return true;
    }

    public boolean delete(RoleDTO roleDTO){
        roleDao.delete(roleMapper.toEntity(roleDTO).getId());
        return true;
    }

    public RoleDTO get(RoleDTO roleDTO){
        return roleMapper.toDTO(roleDao.findById(roleDTO.getId()));
    }

    public boolean update(RoleDTO roleDTO){
        roleDao.update(roleMapper.toEntity(roleDTO));
        return true;
    }

    public List<RoleDTO> getAll(List<RoleDTO> roleDTOS){
        return roleMapper.toDTOS(roleDao.findAll());
    }



}
