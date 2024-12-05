package project.mapper;

import project.dto.StatusDTO;
import project.entity.Status;

import java.util.List;

public class StatusMapper implements IMapper<Status , StatusDTO>{

    @Override
    public StatusDTO toDTO(Status status){
        StatusDTO statusDTO = new StatusDTO();

        statusDTO.setId(status.getId());
        statusDTO.setStatusName(status.getStatusName());
        statusDTO.setTasks(status.getTasks());

        return statusDTO;
    }

    @Override
    public Status toEntity(StatusDTO statusDTO){
        Status status = new Status();
        status.setId(statusDTO.getId());
        status.setStatusName(statusDTO.getStatusName());
        status.setTasks(statusDTO.getTasks());
        return status;
    }

    @Override
    public List<StatusDTO> toDTOS(List<Status> status){

        return status.stream().map(this::toDTO).toList();

    }

    @Override
    public List<Status> toEntitys(List<StatusDTO> statusDTOS){

        return statusDTOS.stream().map(this::toEntity).toList();

    }

}
