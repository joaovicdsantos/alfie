package com.alfie.alfieapi.controller;

import com.alfie.alfieapi.dto.SongDTO;
import com.alfie.alfieapi.exception.SongNotFound;
import com.alfie.alfieapi.exception.TagNotFound;
import com.alfie.alfieapi.model.Response;
import com.alfie.alfieapi.service.SongService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/song")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class SongController {

    public SongService songService;

    @GetMapping
    public ResponseEntity<Response<List<SongDTO>>> findAll() {
        Response<List<SongDTO>> response = new Response<>();
        response.setData(songService.findAll());
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Response<SongDTO>> findById(@PathVariable String id) throws SongNotFound {
        Response<SongDTO> response = new Response<>();
        response.setData(songService.findById(id));
        return ResponseEntity.ok(response);
    }

    @GetMapping("/tag/{tag}")
    public ResponseEntity<Response<List<SongDTO>>> getByTag(@PathVariable String tag) throws TagNotFound {
        Response<List<SongDTO>> response = new Response<>();
        response.setData(songService.findByTag(tag));
        return ResponseEntity.ok(response);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Response<SongDTO>> save(@RequestBody @Valid SongDTO songDTO) {
        Response<SongDTO> response = new Response<>();
        response.setData(songService.save(songDTO));
        response.setStatus(201);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable String id) throws SongNotFound {
        songService.deleteById(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Response<SongDTO>> updateById(@PathVariable String id, @RequestBody SongDTO songDTO)
            throws SongNotFound {
        Response<SongDTO> response = new Response<>();
        response.setData(songService.update(id, songDTO));
        return ResponseEntity.ok(response);
    }

}
