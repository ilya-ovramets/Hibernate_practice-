package org.example.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.entity.User;
import org.example.repository.UserRepository;
import org.example.dto.UserDTO;
import org.example.mapper.UserMapper;

import java.util.List;
import java.util.Optional;

public class UserService implements IService<UserDTO> {

    private final static Logger log = LogManager.getLogger(UserService.class);
    private final UserMapper userMapper;
    private final UserRepository userRepository;

    public UserService(){
        userRepository = new UserRepository();
        userMapper = new UserMapper();
    }



    @Override
    public UserDTO getById(long id) {
        try {
            Optional<User> optionalUser = userRepository.findById(id);

            if(optionalUser.isEmpty()){
                User user = optionalUser.get();

                UserDTO userDTO = userMapper.toDTO(user);
                return  userDTO;
            }else {
                throw new Exception("User doesnt exist");
            }

        }catch (Exception e){
            log.error(e.getMessage());
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<UserDTO> getAll() {
        try {
            List<UserDTO> usersDTO = userMapper.toDTOS(userRepository.findAll());

            return  usersDTO;
        }catch (Exception e){
            log.error(e.getMessage());
            return List.of();
        }
    }

    @Override
    public boolean save(UserDTO userDTO) {
        try {
            userRepository.save(userMapper.toEntity(userDTO));
            return  true;
        }catch (Exception e){
            log.error(e.getMessage());
            return false;
        }
    }

    @Override
    public boolean update(UserDTO userDTO) {
        try {
            userRepository.update(userMapper.toEntity(userDTO));
            return  true;
        }catch (Exception e){
            log.error(e.getMessage());
            return false;
        }
    }

    @Override
    public boolean delete(UserDTO userDTO) {
        try {
            userRepository.delete(userMapper.toEntity(userDTO).getId());
            return  true;
        }catch (Exception e){
            log.error(e.getMessage());
            return false;
        }
    }
}
