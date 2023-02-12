package mk.ukim.finki.dians.bankfinder.model;

import lombok.Data;

@Data
public class Amenity {
    private String type;
    private String id;
    private String name;
    private Double latitude;
    private Double longitude;

    public Amenity() {
    }

    public Amenity(String type, String id, String name, Double latitude, Double longitude) {
        this.type = type;
        this.id = id;
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
    }
}

