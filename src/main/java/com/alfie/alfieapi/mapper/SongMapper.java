package com.alfie.alfieapi.mapper;

import com.alfie.alfieapi.dto.SongDTO;
import com.alfie.alfieapi.entity.Song;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface SongMapper {

    SongMapper INSTANCE = Mappers.getMapper(SongMapper.class);

    SongDTO toDTO(Song song);
    Song toModel(SongDTO songDTO);

}
