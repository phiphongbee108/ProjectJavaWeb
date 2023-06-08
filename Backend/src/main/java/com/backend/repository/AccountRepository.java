package com.backend.repository;

import com.backend.models.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import  org.springframework.data.repository.CrudRepository;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long>{

}
