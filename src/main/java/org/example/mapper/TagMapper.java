package org.example.mapper;

import org.example.dto.TagDTO;
import org.example.entity.Tag;

import java.util.List;

public class TagMapper implements IMapper<Tag,TagDTO>{

    @Override
    public TagDTO toDTO(Tag tag){
        TagDTO tagDTO = new TagDTO();

        tagDTO.setId(tag.getId());
        tagDTO.setName(tag.getName());
        tagDTO.setTasks(tag.getTasks());

        return tagDTO;
    }

    @Override
    public Tag toEntity(TagDTO tagDTO){
        Tag tag = new Tag();

        tag.setId(tagDTO.getId());
        tag.setName(tagDTO.getName());
        tag.setTasks(tagDTO.getTasks());

        return tag;
    }


    @Override
    public  List<TagDTO> toDTOS(List<Tag> tags){
        return tags.stream().map(this::toDTO).toList();
    }

    @Override
    public  List<Tag> toEntitys(List<TagDTO> tags){
        return tags.stream().map(this::toEntity).toList();
    }
}
