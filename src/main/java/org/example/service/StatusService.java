package org.example.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.repository.StatusRepository;
import org.example.dto.StatusDTO;
import org.example.mapper.StatusMapper;

import java.util.List;

public class StatusService implements IService<StatusDTO> {

    private static final Logger log = LogManager.getLogger(StatusService.class);
    private final StatusRepository statusRepository;
    private final StatusMapper statusMapper;

    public StatusService(){
        statusRepository = new StatusRepository();
        statusMapper = new StatusMapper();
    }

    @Override
    public StatusDTO getById(long id) {
        try {
            StatusDTO statusDTO = statusMapper.toDTO(statusRepository.findById(id));

            return  statusDTO;
        }catch (Exception e){
            log.error(e.getMessage());
            return null;
        }
    }

    @Override
    public List<StatusDTO> getAll() {
        try {
            List<StatusDTO> statusDTOs = statusMapper.toDTOS(statusRepository.findAll());

            return  statusDTOs;
        }catch (Exception e){
            log.error(e.getMessage());
            return null;
        }
    }

    @Override
    public boolean save(StatusDTO statusDTO) {
        try {
            var status = statusMapper.toEntity(statusDTO);

            statusRepository.save(status);

            return  true;
        }catch (Exception e){
            log.error(e.getMessage());
            return false;
        }
    }

    @Override
    public boolean update(StatusDTO statusDTO) {
        try {
            var status = statusMapper.toEntity(statusDTO);

            statusRepository.update(status);

            return  true;
        }catch (Exception e){
            log.error(e.getMessage());
            return false;
        }
    }

    @Override
    public boolean delete(StatusDTO statusDTO) {
        try {
            var status = statusMapper.toEntity(statusDTO);

            statusRepository.delete(status.getId());

            return  true;
        }catch (Exception e){
            log.error(e.getMessage());
            return false;
        }
    }
}
