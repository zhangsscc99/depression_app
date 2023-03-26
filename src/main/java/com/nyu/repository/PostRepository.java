package com.nyu.repository;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import com.nyu.model.Post;

public interface PostRepository extends MongoRepository<Post, String>{
    
    @Query(value="{'user.$username': ?0}")
    List<Post> findAllPostsByUsername(String username);

    @Query(value="{type: 'announcement'}")
    List<Post> findAllAccouncements();
    
    // other custom methods
}
