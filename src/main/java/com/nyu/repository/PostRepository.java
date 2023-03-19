package com.nyu.repository;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import com.nyu.model.Post;


public interface PostRepository extends MongoRepository<Post, String>{
    
    @Query("{user_id: '?0'}")
    List<Post> findAllPostsByUserId(String user_id);

    // other custom methods
}
