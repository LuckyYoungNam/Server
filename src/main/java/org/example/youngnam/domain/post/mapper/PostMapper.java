package org.example.youngnam.domain.post.mapper;

import org.example.youngnam.domain.post.dto.response.PostResponseDTO;
import org.example.youngnam.domain.post.entity.Post;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;


@Mapper(componentModel = "spring")
public interface PostMapper {
    PostMapper INSTANCE = Mappers.getMapper(PostMapper.class);

    PostResponseDTO.PostGptContentSaveDTO toPostGptContentSaveDTO(Post post);
    PostResponseDTO.PostFinalContentSaveDTO toPostFinalContentSaveDTO(Post post);
    PostResponseDTO.PostFindDetailDTO toPostFindDetailDTO(Post post);
}
