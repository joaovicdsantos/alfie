package com.alfie.alfieapi.controller;

import com.alfie.alfieapi.dto.SongDTO;
import com.alfie.alfieapi.exception.SongNotFound;
import com.alfie.alfieapi.service.SongService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/song")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class SongController {

    public SongService songService;

    @GetMapping
    public List<SongDTO> findAll() {
        return songService.findAll();
    }

    @GetMapping("/{id}")
    public SongDTO findById(@PathVariable String id) throws SongNotFound {
        return songService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public SongDTO save(@RequestBody @Valid SongDTO songDTO) {
        return songService.save(songDTO);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable String id) throws SongNotFound {
        songService.deleteById(id);
    }

    @PutMapping("/{id}")
    public SongDTO updateById(@PathVariable String id, @RequestBody SongDTO songDTO) throws SongNotFound {
        return songService.update(id, songDTO);
    }

}
