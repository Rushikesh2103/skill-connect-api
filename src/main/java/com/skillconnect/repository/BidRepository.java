package com.skillconnect.repository;

import com.skillconnect.model.Bid;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BidRepository extends JpaRepository<Bid, Integer> {
   
}
