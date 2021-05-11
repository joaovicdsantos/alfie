package com.alfie.alfieapi.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SongDTO {

    @Id
    private String id;

    @Size(max = 80)
    @NotEmpty
    private String title;

    @NotEmpty
    private String lyric;

    @NotEmpty
    private String author;

    private String year;

    private List<String> tags;

}
