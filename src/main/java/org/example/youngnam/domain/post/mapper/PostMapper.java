package org.example.youngnam.domain.post.mapper;

import org.example.youngnam.domain.post.dto.request.PostRequestDTO;
import org.example.youngnam.domain.post.dto.response.PostResponseDTO;
import org.example.youngnam.domain.post.entity.Post;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;


@Mapper(componentModel = "spring")
public interface PostMapper {
    PostMapper INSTANCE = Mappers.getMapper(PostMapper.class);

    @Mapping(target = "postId", ignore = true)
    @Mapping(target = "postStatus", constant = "ACTIVE")
    @Mapping(target = "userId", source = "userId")
    Post toEntity(PostRequestDTO.PostPreContentSaveDTO requestDTO, Long userId);


    PostResponseDTO.PostGptContentSaveDTO toPostGptContentSaveDTO(Post post);
    PostResponseDTO.PostFinalContentSaveDTO toPostFinalContentSaveDTO(Post post);
}
