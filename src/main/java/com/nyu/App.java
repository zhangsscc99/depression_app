package com.nyu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.boot.CommandLineRunner;

import com.nyu.repository.AccountRepository;
import com.nyu.repository.ReportRepository;
import com.nyu.repository.PostRepository;
import com.nyu.repository.ReplyRepository;
import com.nyu.model.Account;

@SpringBootApplication
@EnableMongoRepositories
public class App implements CommandLineRunner{
    @Autowired
    AccountRepository accountRepo;
    @Autowired
    ReportRepository reportRepo;
    @Autowired
    PostRepository postRepo;
    @Autowired
    ReplyRepository replyRepo;

    public static void main(String[] args) {
        SpringApplication.run(App.class);
    }

    public void run(String... args) {

        // Clean up any previous data
		accountRepo.deleteAll(); // Doesn't delete the collection
        
        System.out.println("-------------CREATE ACCONUT-------------------------------\n");
        
        createAccount();
        
        System.out.println("\n----------------SHOW ALL ACCOUNTS---------------------------\n");
        
        showAllAccounts();
        
        System.out.println("\n--------------DONE-----------------------------------\n");

    }

    // the following methods are for testing purposes
    //CREATE
    public void createAccount() {
        System.out.println("Data creation started...");
        accountRepo.save(new Account("nyu", "123", "xyz@gmail.com", "user"));
        System.out.println("Data creation complete...");
    }

    public void showAllAccounts() {
         
        accountRepo.findAll().forEach(account -> System.out.println(getAccountDetails(account)));
    }

    public String getAccountDetails(Account account) {

        System.out.println(
        "Id: " + account.getId() + 
        ", \nUsername: " + account.getUsername() + 
        ", \nEmail: " + account.getEmail() +
        ", \nRole: " + account.getRole()
        );
        
        return "";
    }
}
