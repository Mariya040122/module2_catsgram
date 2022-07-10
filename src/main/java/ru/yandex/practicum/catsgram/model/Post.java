package ru.yandex.practicum.catsgram.model;

import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
@Getter
@Setter
public class Post {
    private Integer id;
    private final String author; // автор
    private final Instant creationDate = Instant.now(); // дата создания
    private String description; // описание
    private String photoUrl; // url-адрес фотографии

    public Post(Integer id, String author, String description, String photoUrl) {
        this.id = id;
        this.author = author;
        this.description = description;
        this.photoUrl = photoUrl;
    }




//    @Override
//    public String toString() {
//        String result = "Пост{" +
//                "Автор: '" + this.getAuthor() + '\'' +
//                ", Описание поста: '" + this.getDescription() + '\'' +
//                ", Время создания поста: '" + this.getCreationDate() + '\'' +
//                ", Ссылка на фото: '" + photoUrl;
//        return result;
//    }
}