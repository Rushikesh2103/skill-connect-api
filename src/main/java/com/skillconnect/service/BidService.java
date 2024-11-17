package com.skillconnect.service;

import com.skillconnect.model.Bid;
import java.util.List;
import java.util.Optional;

public interface BidService {
    List<Bid> getAllBids();
    Optional<Bid> getBidById(int id);
    Bid saveBid(Bid bid);
    void deleteBid(int id);
}
