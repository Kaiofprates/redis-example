package com.kaio.prates.redis.example.repository;

import com.kaio.prates.redis.example.model.AccountSession;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountSessionRepository extends CrudRepository<AccountSession, String> {
}
