package org.example.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.entity.Tag;
import org.example.repository.TagRepository;
import org.example.dto.TagDTO;

import org.example.mapper.TagMapper;

import java.util.List;
import java.util.Optional;

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

            Optional<Tag> optionalTag = tagDao.findById(id);

            if(optionalTag.isPresent()){

                Tag tag = new Tag();
                TagDTO tagDTO = tagRepository.toDTO(tag);
                return tagDTO;
            }else {
                throw new Exception("Tag doesnt exist");
            }


        }catch (Exception e){
            log.error(e.getMessage());
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<TagDTO> getAll() {
        try {
            List<TagDTO> tagDTOS = tagRepository.toDTOS(tagDao.findAll());

            return  tagDTOS;
        }catch (Exception e){
            log.error(e.getMessage());
            return List.of();
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
