package ru.yandex.practicum.catsgram.service;

import org.springframework.stereotype.Service;
import ru.yandex.practicum.catsgram.model.Post;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostService {
    private final List<Post> posts = new ArrayList<>();

    public List<Post> findAll(int size, String sort, int from) {
        if (size == 0) {
            size = posts.size();
        }
        if (sort.equals("asc")){
            Collections.sort(posts, (p1, p2) -> p1.getCreationDate().compareTo(p2.getCreationDate()));
        } else {
            Collections.sort(posts, (p1, p2) -> p2.getCreationDate().compareTo(p1.getCreationDate()));
        }
        if ((from + size) > posts.size()){
            size = posts.size() - from;
        }
        return posts.subList(from, from + size);
    }

    public List<Post> findAllByUserEmail(String author, int size, String sort){
        List<Post> postsByAuthor = posts.stream()
                .filter(u -> u.getAuthor().equals(author))
                .collect(Collectors.toList());
        if (sort.equals("asc")){
            Collections.sort(postsByAuthor, (p1, p2) -> p1.getCreationDate().compareTo(p2.getCreationDate()));
        } else {
            Collections.sort(postsByAuthor, (p1, p2) -> p2.getCreationDate().compareTo(p1.getCreationDate()));
        }

        return postsByAuthor.subList(0, size);
    }

    public Post create(Post post) {
        posts.add(post);
        return post;
    }


}