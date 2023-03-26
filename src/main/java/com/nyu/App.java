package com.nyu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.config.EnableMongoAuditing;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.boot.CommandLineRunner;

import com.nyu.repository.AccountRepository;
import com.nyu.repository.ReportRepository;
import com.nyu.repository.PostRepository;
import com.nyu.repository.ReplyRepository;
import com.nyu.model.Account;
import com.nyu.model.Post;
import com.nyu.model.Reply;
import com.nyu.model.Report;

@SpringBootApplication
@EnableMongoRepositories
@EnableMongoAuditing
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
        postRepo.deleteAll();
        replyRepo.deleteAll();
        
        System.out.println("-------------CREATE ACCONUT AND POSTS-------------------------------\n");
        
        createAccounts();
        createPostAndReply();
        
        System.out.println("\n----------------SHOW ALL ACCOUNTS---------------------------\n");
        
        showAllAccounts();

        System.out.println("\n----------------SHOW ALL POSTS AND REPLIES---------------------------\n");
        
        showAllPostsAndReplies();

        System.out.println("\n-------------TESTING METHODS----------------\n");

        Account account1 = accountRepo.findAccountByUsername("nyu");
        System.out.println(account1.getEmail());

        accountRepo.findAllAdmins().forEach(account2 -> System.out.println(account2.getUsername()));

        postRepo.findAllPostsByUsername(account1.getUsername()).forEach(post -> System.out.println(post.getTitle()));
        
        System.out.println("\n--------------DONE-----------------------------------\n");

    }

    // the following methods are for testing purposes
    //CREATE
    public void createAccounts() {
        System.out.println("Create one user and one admin account started...");
        accountRepo.save(new Account("nyu", "123", "xyz@gmail.com", "user"));
        accountRepo.save(new Account("admin", "234", "admin@gmail.com", "admin"));
        System.out.println("Data creation complete...");
    }

    public void createPostAndReply() {
        Account nyuAccount = accountRepo.findAccountByUsername("nyu");
        Post post = new Post(nyuAccount, "post1", "this is the first post", "regular");
        postRepo.save(post);
        replyRepo.save(new Reply(nyuAccount, post, "this is the first reply"));
        }

    public void showAllAccounts() {
        accountRepo.findAll().forEach(account -> System.out.println(getAccountDetails(account)));
    }

    public void showAllPostsAndReplies() {
        postRepo.findAll().forEach(post -> {
            System.out.print(getPostDetails(post)); 
            replyRepo.findAllRepliesByPostId(post.getId()).forEach(reply -> {System.out.println(reply.getContent());});
        });
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

    public String getPostDetails(Post post) {
        System.out.println(
            "Id: " + post.getId() +
            "\nPosted By: " + post.getUser().getUsername() +
            "\nTitle: " + post.getTitle() + 
            "\nContent: " + post.getContent()
        );
        return "";
    }
}
