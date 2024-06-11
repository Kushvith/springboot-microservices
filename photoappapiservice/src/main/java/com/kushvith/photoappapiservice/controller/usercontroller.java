package com.kushvith.photoappapiservice.controller;


import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.modelmapper.spi.MatchingStrategy;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kushvith.photoappapiservice.service.userService;
import com.kushvith.photoappapiservice.shared.userDto;
import com.kushvith.photoappapiservice.ui.modal.createUserRequestModal;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/user")
@AllArgsConstructor
public class usercontroller {
    private userService uService;
    @GetMapping("/status")
    public String status(){
        return "working";
    }
    @PostMapping
    public ResponseEntity<userDto> createUser(@RequestBody createUserRequestModal userDetails){
        ModelMapper mapper = new ModelMapper();
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        userDto userdto = mapper.map(userDetails, userDto.class);
        uService.createUser(userdto);
        return new ResponseEntity<userDto>(userdto,HttpStatus.CREATED);
    }
}
