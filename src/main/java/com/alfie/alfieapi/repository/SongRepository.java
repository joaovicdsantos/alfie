package com.alfie.alfieapi.repository;

import com.alfie.alfieapi.entity.Song;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;
import java.util.Optional;

public interface SongRepository extends MongoRepository<Song, String> {

    @Query("{tags: /?0/ }")
    Optional<List<Song>> findByTag(String tag);

}
