package com.skillconnect.controller;

import com.skillconnect.dto.BidDTO;
import com.skillconnect.model.Bid;
import com.skillconnect.model.FreelancerProfile;
import com.skillconnect.model.Project;
import com.skillconnect.service.BidService;
import com.skillconnect.service.FreelancerProfileService;
import com.skillconnect.service.ProjectService;
import com.skillconnect.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
public class BidController {

    @Autowired
    private BidService bidService;
    @Autowired
    private FreelancerProfileService freelancerProfileService;
    @Autowired
    private UserService userService;
    @Autowired
    private ProjectService projectService;
    @GetMapping
    public List<Bid> getAllBids() {
        return bidService.getAllBids();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Bid> getBidById(@PathVariable int id) {
        Optional<Bid> bid = bidService.getBidById(id);
        return bid.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/bids")
    public ResponseEntity<String> createBid(@RequestBody BidDTO bidDTO) {
    	System.out.println(bidDTO);
//        try {
//            bidService.saveBid(bidDTO);
//            return ResponseEntity.ok("Bid created successfully");
//        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error creating bid: ");
        
    }


    @PutMapping("/{id}")
    public ResponseEntity<Bid> updateBid(@PathVariable int id, @RequestBody Bid bid) {
        if (!bidService.getBidById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        bid.setId(id);
        return ResponseEntity.ok(bidService.saveBid(bid));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBid(@PathVariable int id) {
        if (!bidService.getBidById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        bidService.deleteBid(id);
        return ResponseEntity.noContent().build();
    }
}
