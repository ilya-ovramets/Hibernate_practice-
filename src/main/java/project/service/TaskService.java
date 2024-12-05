package project.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import project.repository.TaskRepository;
import project.dto.TaskDTO;
import project.mapper.TaskMapper;

import java.util.List;

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
            TaskDTO taskDTO = taskMapper.toDTO(taskRepository.findById(id));

            return  taskDTO;
        }catch (Exception e){
            log.error(e.getMessage());
            return null;
        }
    }

    @Override
    public List<TaskDTO> getAll() {
        try {

            return taskMapper.toDTOS(taskRepository.findAll());

        }catch (Exception e){
            log.error(e.getMessage());
            return null;
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
