package project.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import project.dao.UserRepository;
import project.dto.UserDTO;
import project.mapper.UserMapper;

import java.util.List;

public class UserService implements CrudService<UserDTO>{

    private final static Logger log = LogManager.getLogger(UserService.class);
    private final UserMapper userMapper;
    private final UserRepository userDao;

    public UserService(){
        userDao = new UserRepository();
        userMapper = new UserMapper();
    }



    @Override
    public UserDTO getById(long id) {
        try {
            UserDTO userDTO = userMapper.toDTO(userDao.findById(id));

            return  userDTO;
        }catch (Exception e){
            log.error(e.getMessage());
            return null;
        }
    }

    @Override
    public List<UserDTO> getAll() {
        try {
            List<UserDTO> usersDTO = userMapper.toDTOS(userDao.findAll());

            return  usersDTO;
        }catch (Exception e){
            log.error(e.getMessage());
            return null;
        }
    }

    @Override
    public boolean save(UserDTO userDTO) {
        try {
            userDao.save(userMapper.toEntity(userDTO));
            return  true;
        }catch (Exception e){
            log.error(e.getMessage());
            return false;
        }
    }

    @Override
    public boolean update(UserDTO userDTO) {
        try {
            userDao.update(userMapper.toEntity(userDTO));
            return  true;
        }catch (Exception e){
            log.error(e.getMessage());
            return false;
        }
    }

    @Override
    public boolean delete(UserDTO userDTO) {
        try {
            userDao.delete(userMapper.toEntity(userDTO).getId());
            return  true;
        }catch (Exception e){
            log.error(e.getMessage());
            return false;
        }
    }
}
