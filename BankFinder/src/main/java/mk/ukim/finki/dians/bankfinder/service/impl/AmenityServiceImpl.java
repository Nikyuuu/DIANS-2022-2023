package mk.ukim.finki.dians.bankfinder.service.impl;

import mk.ukim.finki.dians.bankfinder.model.Amenity;
import mk.ukim.finki.dians.bankfinder.repository.AmenityRepository;
import mk.ukim.finki.dians.bankfinder.service.AmenityService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AmenityServiceImpl implements AmenityService {
    private final AmenityRepository amenityRepository;

    public AmenityServiceImpl(AmenityRepository amenityRepository) {
        this.amenityRepository = amenityRepository;
    }

    @Override
    public Optional<Amenity> findByNameAndType(String name, String type) {
        return this.amenityRepository.findByNameAndType(name, type);
    }

    @Override
    public Optional<Amenity> search(String text) {
        return this.amenityRepository.search(text);
    }
}
