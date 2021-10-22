package com.kaio.prates.redis.example.runners;

import com.kaio.prates.redis.example.model.Account;
import com.kaio.prates.redis.example.model.AccountSession;
import com.kaio.prates.redis.example.repository.AccountSessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
public class RedisRunner implements CommandLineRunner {


    @Autowired
    private AccountSessionRepository repository;

    @Override
    public void run(String... args) throws Exception {

        String id = UUID.randomUUID().toString();

        List<Account> accountList = new ArrayList<>();
        Account account = new Account( "John Doe", LocalDateTime.now());
        Account account2 = new Account( "Mary Doe", LocalDateTime.now());

        accountList.add(account);
        accountList.add(account2);

        Optional<AccountSession> accountSessions= repository.findById("026ede7d-e714-4bf3-85cb-fce3b2e3796e");

        accountSessions.ifPresent(accountSession -> accountList.addAll(accountSession.getAccountList()));

        AccountSession accountSession = new AccountSession(id, accountList);

        repository.save(accountSession);


    }
}
