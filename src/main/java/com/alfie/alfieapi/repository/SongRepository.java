package com.alfie.alfieapi.repository;

import com.alfie.alfieapi.entity.Song;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SongRepository extends MongoRepository<Song, String> {
}
