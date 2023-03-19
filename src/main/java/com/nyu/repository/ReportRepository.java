package com.nyu.repository;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import com.nyu.model.Report;


public interface ReportRepository extends MongoRepository<Report, String>{
    
    @Query("{user_id: '?0'}")
    List<Report> findAllReportsByUserId(String user_id);

    // other custom methods
}
