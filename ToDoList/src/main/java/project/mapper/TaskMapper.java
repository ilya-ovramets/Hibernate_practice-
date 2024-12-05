package project.mapper;

import project.dto.TaskDTO;
import project.entity.Task;

import java.util.List;

public class TaskMapper {

    public TaskDTO toDTO(Task task){
        TaskDTO taskDTO = new TaskDTO();

        taskDTO.setId(task.getId());
        taskDTO.setBody(task.getBody());
        taskDTO.setCreateBy(task.getCreateBy());
        taskDTO.setPerformens(task.getPerformens());
        taskDTO.setTags(task.getTags());
        taskDTO.setStartDate(task.getStartDate());
        taskDTO.setFinishDate(task.getFinishDate());
        taskDTO.setTitle(task.getTitle());
        taskDTO.setStatus(task.getStatus());

        return taskDTO;

    }

    public Task toEntity(TaskDTO taskDTO){
        Task task = new Task();

        task.setId(taskDTO.getId());
        task.setBody(taskDTO.getBody());
        task.setCreateBy(taskDTO.getCreateBy());
        task.setPerformens(taskDTO.getPerformens());
        task.setTags(taskDTO.getTags());
        task.setStartDate(taskDTO.getStartDate());
        task.setFinishDate(taskDTO.getFinishDate());
        task.setTitle(taskDTO.getTitle());
        task.setStatus(taskDTO.getStatus());

        return task;

    }

    public List<TaskDTO> toDTOS(List<Task> tasks){
        return tasks.stream().map(this::toDTO).toList();
    }

    public List<Task> toEntitys(List<TaskDTO> tasks){
        return tasks.stream().map(this::toEntity).toList();
    }



}
