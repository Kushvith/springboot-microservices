package com.kushvith.photoappapiservice.service;

import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.kushvith.photoappapiservice.data.userEntity;
import com.kushvith.photoappapiservice.repository.userrepo;
import com.kushvith.photoappapiservice.shared.userDto;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
@Service
@AllArgsConstructor
public class userServiceImpl implements userService {
  private userrepo urepo;
  private final BCryptPasswordEncoder bCryptPasswordEncoder;
    @Override
    public userDto createUser(userDto userDetails) {
      userDetails.setUserId((UUID.randomUUID().toString()));
      userDetails.setEncryptedPassword(bCryptPasswordEncoder.encode(userDetails.getPassword()));
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        userEntity userentity = modelMapper.map(userDetails, userEntity.class);
        urepo.save(userentity);
      return null;
    }

}
