package com.nyu.repository;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import com.nyu.model.Report;


public interface ReportRepository extends MongoRepository<Report, String>{

    @Query(value="{'user.$username': ?0}")
    List<Report> findAllReportsByUsername(String username);

    @Query(value="{starred: true}")
    List<Report> findAllStarredReports();
    
    // other custom methods
}
