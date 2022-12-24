package mk.ukim.finki.diansproekt.service.impl;

import mk.ukim.finki.diansproekt.model.Amenity;
import mk.ukim.finki.diansproekt.repository.AmenityRepository;
import mk.ukim.finki.diansproekt.service.AmenityService;
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
    public List<Amenity> listAll() {
        return this.amenityRepository.listAll();
    }

    @Override
    public List<Amenity> listAllBanks() {
        return this.amenityRepository.listAllBanks();
    }

    @Override
    public Optional<Amenity> findById(String id) {
        return this.amenityRepository.findById(id);
    }

    @Override
    public List<Amenity> findByType(String type) {
        return this.amenityRepository.findByType(type);
    }

   /* @Override
    public List<Amenity> findByName(String name) {
        return this.amenityRepository.findByName(name);
    } */
    @Override
    public Optional<Amenity> findByName(String name) {
        return this.amenityRepository.findByName(name);
    }

    /*@Override
    public List<Amenity> findByNameAndType(String name, String type) {
        return this.amenityRepository.findByNameAndType(name, type);
    }*/
    @Override
    public Optional<Amenity> findByNameAndType(String name, String type) {
        return this.amenityRepository.findByNameAndType(name, type);
    }

    @Override
    public List<Amenity> search(String text) {
        return this.amenityRepository.search(text);
    }
}
