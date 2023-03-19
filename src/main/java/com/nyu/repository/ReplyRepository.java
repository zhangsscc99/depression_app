package com.nyu.repository;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import com.nyu.model.Reply;


public interface ReplyRepository extends MongoRepository<Reply, String>{
    
    @Query("{user_id: '?0'}")
    List<Reply> findAllRepliesByUserId(String user_id);

    @Query("{post_id: '?0'}")
    List<Reply> findAllRepliesByPostId(String post_id);
    
    // other custom methods
}
