package com.example.miniapp.repositories;

import com.example.miniapp.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

//    Finding customers by their email domain.
//   • Finding customers by phone prefix

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

//    List<Customer> findByEmailDomain(@Param("domain") String domain);
//
//    List<Customer> findByPhonePrefix(@Param("prefix") String prefix);
}
