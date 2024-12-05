package project.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import project.dao.StatusRepository;
import project.dto.StatusDTO;
import project.mapper.StatusMapper;

import java.util.List;

public class StatusService implements CrudService<StatusDTO>{

    private static final Logger log = LogManager.getLogger(StatusService.class);
    private final StatusRepository statusDao;
    private final StatusMapper statusMapper;

    public StatusService(){
        statusDao = new StatusRepository();
        statusMapper = new StatusMapper();
    }

    @Override
    public StatusDTO getById(long id) {
        try {
            StatusDTO statusDTO = statusMapper.toDTO(statusDao.findById(id));

            return  statusDTO;
        }catch (Exception e){
            log.error(e.getMessage());
            return null;
        }
    }

    @Override
    public List<StatusDTO> getAll() {
        try {
            List<StatusDTO> statusDTOs = statusMapper.toStatusDTOS(statusDao.findAll());

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

            statusDao.save(status);

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

            statusDao.update(status);

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

            statusDao.delete(status.getId());

            return  true;
        }catch (Exception e){
            log.error(e.getMessage());
            return false;
        }
    }
}
