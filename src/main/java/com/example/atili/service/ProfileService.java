package com.example.atili.service;

import com.example.atili.entity.ProfileEntity;
import com.example.atili.repository.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProfileService {

    @Autowired
    private ProfileRepository profileRepository;

    public List<ProfileEntity> getAllProfiles() {
        List<ProfileEntity> list = new ArrayList<>();
        profileRepository.findAll().forEach(list::add);
        return list;
    }

    public ProfileEntity getProfileById(Long id) {
        return profileRepository.findById(id).orElse(null);
    }

    public ProfileEntity createProfile(ProfileEntity profile) {
        return profileRepository.save(profile);
    }

    public ProfileEntity updateProfile(Long id, ProfileEntity profile) {
        if (profileRepository.existsById(id)) {
            profile.setId(id);
            return profileRepository.save(profile);
        }
        return null;
    }

    public boolean deleteProfile(Long id) {
        if (profileRepository.existsById(id)) {
            profileRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
