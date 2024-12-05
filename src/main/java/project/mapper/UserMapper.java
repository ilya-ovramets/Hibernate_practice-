package project.mapper;


import project.dto.UserDTO;
import project.entity.User;

import java.util.List;

public class UserMapper implements IMapper<User,UserDTO>{

    @Override
    public UserDTO toDTO(User user){
        UserDTO userDTO = new UserDTO(
                user.getId(),
                user.getFirstName(),
                user.getLastName(),
                user.getEmail(),
                user.getTasks(),
                user.getPassword(),
                user.getRole()
        );

        return userDTO;
    }

    @Override
    public User toEntity(UserDTO user){
        User userN = new User(
                user.getFirstName(),
                user.getEmail(),
                user.getLastName(),
                user.getPassword()
        );
        userN.setTasks(user.getTasks());
        userN.setId(user.getId());
        userN.setRole(user.getRole());

        return userN;
    }

    @Override
    public List<UserDTO> toDTOS(List<User> users){
        return users.stream().map(this::toDTO).toList();
    }

    @Override
    public List<User> toEntitys(List<UserDTO> users){
        return users.stream().map(this::toEntity).toList();
    }


}
