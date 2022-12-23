package mk.ukim.finki.diansproekt.service;

import mk.ukim.finki.diansproekt.model.Amenity;

import java.util.List;
import java.util.Optional;

public interface AmenityService {
    List<Amenity> listAll();

    List<Amenity> listAllBanks();

    Optional<Amenity> findById(String id);

    List<Amenity> findByType(String type);

    List<Amenity> findByName(String name);

    List<Amenity> findByNameAndType(String name, String type);

    List<Amenity> search(String text);
}
