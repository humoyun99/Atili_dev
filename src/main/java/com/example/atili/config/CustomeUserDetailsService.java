package com.example.atili.config;

import com.example.atili.entity.ProfileEntity;
import com.example.atili.exception.AppBadRequestException;
import com.example.atili.repository.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class CustomeUserDetailsService implements UserDetailsService {
    @Autowired
    private ProfileRepository profileRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<ProfileEntity> optional = profileRepository.findByEmail(email);
        if (optional.isEmpty()) {
            throw new AppBadRequestException("Login attempt failed");
        }
        ProfileEntity profileEntity = optional.get();

        return new CustomUserDetails(profileEntity);
    }
}
