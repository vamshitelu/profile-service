package com.vsoft.profile.controller;

import com.vsoft.profile.model.Profile;
import com.vsoft.profile.service.ProfileService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/profile")
@AllArgsConstructor
public class ProfileController {

     private ProfileService profileService;
/*
    @Operation(summary = "Get a book by its id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the profile",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Profile.class)) }),
            @ApiResponse(responseCode = "400", description = "Invalid id supplied",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Profile not found",
                    content = @Content) })
                    *
     */
     @GetMapping("/{profileId}")
     public ResponseEntity<Profile> getProfile(@PathVariable String profileId) {
         return ResponseEntity.ok(profileService.getProfile(profileId));
     }

     @PostMapping
     public ResponseEntity<Profile> createProfile(@RequestBody Profile profile) {
         return ResponseEntity.ok(profileService.createProfile(profile));
     }

     @PutMapping("/{profileId}")
     public ResponseEntity<Profile> updateProfile(@PathVariable String profileId, @RequestBody Profile profile) {
         return ResponseEntity.ok(profileService.updateProfile(profileId, profile));
     }

     @DeleteMapping("/{profileId}")
     public ResponseEntity<Void> deleteProfile(@PathVariable String profileId) {
         profileService.deleteProfile(profileId);
         return ResponseEntity.noContent().build();
     }

    // @GetMapping("/{profileId}/address")
    // public ResponseEntity<Address> getAddress(@PathVariable String profileId) {
    //     return ResponseEntity.ok(profileService.getAddress(profileId));
    // }

    // @PostMapping("/{profileId}/address")
    // public ResponseEntity<Address> createAddress(@PathVariable String profileId, @RequestBody Address address) {
    //     return ResponseEntity.ok(profileService.createAddress(profileId, address));
    // }

    // @PutMapping("/{profileId}/address")
    // public ResponseEntity<Address> updateAddress(@PathVariable String profileId, @RequestBody Address address) {
    //     return ResponseEntity.ok(profileService.updateAddress(profileId, address));
    // }

    // @DeleteMapping("/{profileId}/address")
    // public ResponseEntity<Void> deleteAddress(@PathVariable String profileId) {
    //     profileService.deleteAddress(profileId);
    //     return ResponseEntity.noContent().build();
    // }

    // @GetMapping("/{profileId}/address/{addressId
}
