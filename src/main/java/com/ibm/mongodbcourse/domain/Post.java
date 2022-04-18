package com.ibm.mongodbcourse.domain;

import com.ibm.mongodbcourse.dto.AuthorDTO;
import com.ibm.mongodbcourse.dto.CommentDTO;
import lombok.*;
import org.springframework.data.annotation.Id;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Post implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @EqualsAndHashCode.Include
    private String id;
    private Date date;
    private String title;
    private String body;
    private AuthorDTO author;
    @Setter(AccessLevel.NONE)
    private List<CommentDTO> comments = new ArrayList<>();

    public Post(String id, Date date, String title, String body, AuthorDTO author) {
        this.id = id;
        this.date = date;
        this.title = title;
        this.body = body;
        this.author = author;
    }
}
