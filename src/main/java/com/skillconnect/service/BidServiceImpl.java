package com.skillconnect.service;

import com.skillconnect.model.Bid;
import com.skillconnect.repository.BidRepository;
import com.skillconnect.service.BidService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BidServiceImpl implements BidService {

    @Autowired
    private BidRepository bidRepository;

    @Override
    public List<Bid> getAllBids() {
        return bidRepository.findAll();
    }

    @Override
    public Optional<Bid> getBidById(int id) {
        return bidRepository.findById(id);
    }

    @Override
    public Bid saveBid(Bid bid) {
        return bidRepository.save(bid);
    }

    @Override
    public void deleteBid(int id) {
        bidRepository.deleteById(id);
    }
}
