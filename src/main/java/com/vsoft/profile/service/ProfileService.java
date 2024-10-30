package com.vsoft.profile.service;

import com.vsoft.profile.entity.ProfileEntity;
import com.vsoft.profile.model.Profile;
import com.vsoft.profile.repository.ProfileRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ProfileService {

    private ProfileRepository profileRepository;

    private ModelMapper modelMapper;

    public Profile getProfile(String profileId) {
        ProfileEntity profileEntity = profileRepository.findById(profileId)
                .orElseThrow(() -> new RuntimeException("Profile not found"));
        return modelMapper.map(profileEntity, Profile.class);
    }

    public Profile createProfile(Profile profile) {
        ProfileEntity profileEntity = modelMapper.map(profile, ProfileEntity.class);
        profileRepository.save(profileEntity);
        return modelMapper.map(profileEntity, Profile.class);
    }

    public Profile updateProfile(String profileId, Profile profile) {
        ProfileEntity profileEntity = profileRepository.findById(profileId)
                .orElseThrow(() -> new RuntimeException("Profile not found"));
        modelMapper.map(profile, profileEntity);
        profileRepository.save(profileEntity);
        return modelMapper.map(profileEntity, Profile.class);
    }

    public void deleteProfile(String profileId) {
        profileRepository.deleteById(profileId);
    }
}
