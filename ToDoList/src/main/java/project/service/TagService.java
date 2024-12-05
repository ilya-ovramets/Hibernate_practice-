package project.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import project.dao.TagRepository;
import project.dto.TagDTO;

import project.mapper.TagMapper;

import java.util.List;

public class TagService implements CrudService<TagDTO>{

    private static final Logger log = LogManager.getLogger(TagService.class);
    private final TagRepository tagDao;
    private final TagMapper tagMapper;

    public TagService(){
        tagDao = new TagRepository();
        tagMapper = new TagMapper();
    }



    @Override
    public TagDTO getById(long id) {
        try {
            TagDTO tagDTO = tagMapper.toDTO(tagDao.findById(id));

            return  tagDTO;
        }catch (Exception e){
            log.error(e.getMessage());
            return null;
        }
    }

    @Override
    public List<TagDTO> getAll() {
        try {
            List<TagDTO> tagDTOS = tagMapper.toDTOS(tagDao.findAll());

            return  tagDTOS;
        }catch (Exception e){
            log.error(e.getMessage());
            return null;
        }
    }

    @Override
    public boolean save(TagDTO tagDTO) {
        try {

            var tag = tagMapper.toEntity(tagDTO);

            tagDao.save(tag);

            return  true;
        }catch (Exception e){
            log.error(e.getMessage());
            return false;
        }
    }

    @Override
    public boolean update(TagDTO tagDTO) {
        try {

            var tag = tagMapper.toEntity(tagDTO);

            tagDao.update(tag);

            return  true;
        }catch (Exception e){
            log.error(e.getMessage());
            return false;
        }
    }

    @Override
    public boolean delete(TagDTO tagDTO) {
        try {

            tagDao.delete(tagDTO.getId());

            return  true;
        }catch (Exception e){
            log.error(e.getMessage());
            return false;
        }
    }
}
