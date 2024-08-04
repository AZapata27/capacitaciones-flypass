package com.courses.capacitacionesflypass.sesion3.b.exprimiendoSpring.repository.d.criteria;

import com.courses.capacitacionesflypass.sesion3.b.exprimiendoSpring.entity.Post;
import com.courses.capacitacionesflypass.sesion3.b.exprimiendoSpring.entity.User;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class PostService {

    private final PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Transactional(readOnly = true)
    public List<Post> findPostsByTitleAndAuthor(String title, User author) {
        return postRepository.findAll(Specification.where(PostSpecifications.hasTitle(title))
                                                   .and(PostSpecifications.hasAuthor(author)));
    }
}
