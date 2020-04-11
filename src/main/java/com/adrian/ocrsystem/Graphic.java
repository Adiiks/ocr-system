package com.adrian.ocrsystem;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Graphic {

    @Id
    private Long id;

    private String url;
    private String content;

    public Graphic(String url, String content) {
        this.url = url;
        this.content = content;
    }
}
