package project.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import project.dao.TaskRepository;
import project.dto.TaskDTO;
import project.mapper.TaskMapper;

import java.util.List;

public class TaskService implements CrudService<TaskDTO>{

    private static final Logger log = LogManager.getLogger(TaskService.class);

    private final TaskRepository taskDao;
    private final TaskMapper taskMapper;

    public TaskService(){
        this.taskDao = new TaskRepository();
        this.taskMapper = new TaskMapper();
    }


    @Override
    public TaskDTO getById(long id) {
        try {
            TaskDTO taskDTO = taskMapper.toDTO(taskDao.findById(id));

            return  taskDTO;
        }catch (Exception e){
            log.error(e.getMessage());
            return null;
        }
    }

    @Override
    public List<TaskDTO> getAll() {
        try {

            return taskMapper.toDTOS(taskDao.findAll());

        }catch (Exception e){
            log.error(e.getMessage());
            return null;
        }

    }

    @Override
    public boolean save(TaskDTO taskDTO) {
        try {
            var task = taskMapper.toEntity(taskDTO);

            taskDao.save(task);

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

            taskDao.update(task);

            return true;
        }catch (Exception e){
            log.error(e.getMessage());
            return false;
        }
    }

    @Override
    public boolean delete(TaskDTO taskDTO) {
        try {

            taskDao.delete(taskDTO.getId());

            return true;
        }catch (Exception e){
            log.error(e.getMessage());
            return false;
        }
    }
}
