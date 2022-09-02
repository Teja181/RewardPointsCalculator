package com.vendor.rewardpoints.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vendor.rewardpoints.entity.Customer;
import com.vendor.rewardpoints.bean.Rewards;
import com.vendor.rewardpoints.repository.CustomerRepo;
import com.vendor.rewardpoints.service.RewardsService;

@RestController
@RequestMapping("/rewards")
public class CustomerRewardsController {
    @Autowired
    CustomerRepo customerRepository;
    @Autowired
    RewardsService rewardsService;

    @GetMapping(value = "/{customerId}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> getRewardsByCustomerId(@PathVariable("customerId") int customerId){
        Customer customer = customerRepository.findByCustomerId(customerId);
        if(customer == null)
        {
            return new ResponseEntity<>("Customer Not found for the given Id: " +customerId,HttpStatus.NOT_FOUND);
        }
        Rewards customerRewards = rewardsService.getRewardsByCustomerId(customerId);
        return new ResponseEntity<>(customerRewards,HttpStatus.OK);
    }

}
