package com.kaio.prates.redis.example.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.redis.core.RedisHash;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@RedisHash("Account")
public class AccountSession {
     private String id;
     private List<Account> accountList;
}
