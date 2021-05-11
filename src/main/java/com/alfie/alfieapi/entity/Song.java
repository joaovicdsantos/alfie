package com.alfie.alfieapi.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Song {

    @Id
    private String id;
    private String title;
    private String lyric;
    private String author;
    private String year;
    private List<String> tags;

}
