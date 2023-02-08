package mk.ukim.finki.diansproekt.service;

import mk.ukim.finki.diansproekt.model.Amenity;

import java.util.List;
import java.util.Optional;

public interface AmenityService {

    Optional<Amenity> findByNameAndType(String name, String type);

    Optional<Amenity> search(String text);
}
