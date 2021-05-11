package com.alfie.alfieapi.service;

import com.alfie.alfieapi.dto.SongDTO;
import com.alfie.alfieapi.entity.Song;
import com.alfie.alfieapi.exception.SongNotFound;
import com.alfie.alfieapi.mapper.SongMapper;
import com.alfie.alfieapi.repository.SongRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class SongService {

    private SongRepository songRepository;
    private final SongMapper songMapper = SongMapper.INSTANCE;

    public SongDTO save(SongDTO songDTO) {
        return saveSongByDTO(songDTO);
    }

    public List<SongDTO> findAll() {
        List<Song> songList = songRepository.findAll();
        return songList.stream().map(songMapper::toDTO).collect(Collectors.toList());
    }

    public SongDTO findById(String id) throws SongNotFound {
        SongDTO song = songMapper.toDTO(verifyIfExists(id));
        return song;
    }

    public void deleteById(String id) throws SongNotFound {
        verifyIfExists(id);
        songRepository.deleteById(id);
    }

    public SongDTO update(String id, SongDTO songDTO) throws SongNotFound {
        verifyIfExists(id);
        return saveSongByDTO(songDTO);
    }

    private Song verifyIfExists(String id) throws SongNotFound {
        return songRepository.findById(id).orElseThrow(() -> new SongNotFound(id));
    }

    private SongDTO saveSongByDTO(SongDTO songDTO) {
        Song songToSave = songMapper.toModel(songDTO);
        return songMapper.toDTO(songRepository.save(songToSave));
    }

}
