package org.example.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.entity.Task;
import org.example.repository.TaskRepository;
import org.example.dto.TaskDTO;
import org.example.mapper.TaskMapper;

import java.util.List;
import java.util.Optional;

public class TaskService implements IService<TaskDTO> {

    private static final Logger log = LogManager.getLogger(TaskService.class);

    private final TaskRepository taskRepository;
    private final TaskMapper taskMapper;

    public TaskService(){
        this.taskRepository = new TaskRepository();
        this.taskMapper = new TaskMapper();
    }


    @Override
    public TaskDTO getById(long id) {
        try {

            Optional<Task> optionalTask = taskRepository.findById(id);
            if(optionalTask.isPresent()){
                var task = optionalTask.get();
                TaskDTO taskDTO = taskMapper.toDTO(task);
                return  taskDTO;
            }else {
                throw new Exception("Task doesnt exist");
            }

        }catch (Exception e){
            log.error(e.getMessage());
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<TaskDTO> getAll() {
        try {

            List<TaskDTO> taskDTOS = taskMapper.toDTOS(taskRepository.findAll());

            return taskDTOS;
        }catch (Exception e){
            log.error(e.getMessage());
            return List.of();
        }

    }

    @Override
    public boolean save(TaskDTO taskDTO) {
        try {
            var task = taskMapper.toEntity(taskDTO);

            taskRepository.save(task);

            return true;
        }catch (Exception e){
            log.error(e.getMessage());
            return false;
        }
    }

    @Override
    public boolean update(TaskDTO taskDTO) {
        try {
            var task = taskMapper.toEntity(taskDTO);

            taskRepository.update(task);

            return true;
        }catch (Exception e){
            log.error(e.getMessage());
            return false;
        }
    }

    @Override
    public boolean delete(TaskDTO taskDTO) {
        try {

            taskRepository.delete(taskDTO.getId());

            return true;
        }catch (Exception e){
            log.error(e.getMessage());
            return false;
        }
    }
}
