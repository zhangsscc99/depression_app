package com.nyu.repository;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import com.nyu.model.Account;


public interface AccountRepository extends MongoRepository<Account, String>{
    
    @Query("{username: '?0'}")
    Account findAccountByUsername(String username);

    @Query(value="{role: 'admin'}", fields="{'username': 1, 'email': 1}")
    List<Account> findAllAdmins();

    // other custom methods
}
