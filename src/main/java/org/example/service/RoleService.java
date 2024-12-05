package org.example.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.repository.RoleRepository;
import org.example.dto.RoleDTO;
import org.example.mapper.RoleMapper;

import java.util.List;

public class RoleService implements IService<RoleDTO> {


    private final static Logger log = LogManager.getLogger(RoleService.class);
    private final RoleRepository roleRepository;
    private final RoleMapper roleMapper;



    public RoleService(){
        roleRepository = new RoleRepository();
        roleMapper = new RoleMapper();
    }


    @Override
    public RoleDTO getById(long id) {
        try {
            RoleDTO roleDTO = roleMapper.toDTO(roleRepository.findById(id));

            return  roleDTO;
        }catch (Exception e){
            log.error(e.getMessage());
            return null;
        }
    }

    @Override
    public List<RoleDTO> getAll() {
        try {
            List<RoleDTO> roleDTOS = roleMapper.toDTOS(roleRepository.findAll());

            return  roleDTOS;
        }catch (Exception e){
            log.error(e.getMessage());
            return null;
        }
    }

    @Override
    public boolean save(RoleDTO roleDTO) {
        try {

            var role = roleMapper.toEntity(roleDTO);
            roleRepository.save(role);

            return true;
        }catch (Exception e){
            log.error(e.getMessage());
            return false;
        }
    }

    @Override
    public boolean update(RoleDTO roleDTO) {
        try {

            var role = roleMapper.toEntity(roleDTO);
            roleRepository.update(role);

            return true;
        }catch (Exception e){
            log.error(e.getMessage());
            return false;
        }
    }

    @Override
    public boolean delete(RoleDTO roleDTO) {
        try {

            var role = roleMapper.toEntity(roleDTO);
            roleRepository.delete(role.getId());

            return true;
        }catch (Exception e){
            log.error(e.getMessage());
            return false;
        }
    }
}
