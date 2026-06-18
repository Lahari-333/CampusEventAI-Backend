package com.laha.campusevent_backend;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class RegistrationService {

    private final RegistrationRepository registrationRepository;

    public RegistrationService(
            RegistrationRepository registrationRepository) {

        this.registrationRepository = registrationRepository;
    }

    public Registration register(
            Registration registration) {

        return registrationRepository.save(registration);
    }

    public List<Registration> getAllRegistrations() {

        return registrationRepository.findAll();
    }
}