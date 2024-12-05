package project.mapper;


import project.dto.UserDTO;
import project.entity.User;

import java.util.List;

public class UserMapper {

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

    public List<UserDTO> toDTOS(List<User> users){
        return users.stream().map(this::toDTO).toList();
    }

    public List<User> toEntitys(List<UserDTO> users){
        return users.stream().map(this::toEntity).toList();
    }


}
