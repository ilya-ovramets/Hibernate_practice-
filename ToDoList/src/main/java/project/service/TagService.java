package project.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import project.dao.TagRepository;
import project.dto.TagDTO;

import project.mapper.TagMapper;

import java.util.List;

public class TagService implements IService<TagDTO> {

    private static final Logger log = LogManager.getLogger(TagService.class);
    private final TagRepository tagDao;
    private final TagMapper tagRepository;

    public TagService(){
        tagDao = new TagRepository();
        tagRepository = new TagMapper();
    }



    @Override
    public TagDTO getById(long id) {
        try {
            TagDTO tagDTO = tagRepository.toDTO(tagDao.findById(id));

            return  tagDTO;
        }catch (Exception e){
            log.error(e.getMessage());
            return null;
        }
    }

    @Override
    public List<TagDTO> getAll() {
        try {
            List<TagDTO> tagDTOS = tagRepository.toDTOS(tagDao.findAll());

            return  tagDTOS;
        }catch (Exception e){
            log.error(e.getMessage());
            return null;
        }
    }

    @Override
    public boolean save(TagDTO tagDTO) {
        try {

            var tag = tagRepository.toEntity(tagDTO);

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

            var tag = tagRepository.toEntity(tagDTO);

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
