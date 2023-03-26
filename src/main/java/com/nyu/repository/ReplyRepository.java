package com.nyu.repository;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import com.nyu.model.Reply;


public interface ReplyRepository extends MongoRepository<Reply, String>{
    
    @Query(value="{'user.$username': ?0}")
    List<Reply> findAllRepliesByUsername(String username);

    @Query(value="{'post.id': ?0}")
    List<Reply> findAllRepliesByPostId(String id);
    
    // other custom methods
}
