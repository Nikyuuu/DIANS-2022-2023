package mk.ukim.finki.diansproekt.repository;

import mk.ukim.finki.diansproekt.model.Amenity;
import org.springframework.stereotype.Repository;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class AmenityRepository {
    public static List<Amenity> list = new ArrayList<>();

    public AmenityRepository() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("src/main/java/mk/ukim/finki/diansproekt/repository/data.csv"));
        String row = "";
        int flag = 0;

        while ((row = reader.readLine()) != null) {
            String[] data = row.split(",");
            if (flag > 0) {
                list.add(new Amenity(data[0], data[1], data[2],
                        Double.parseDouble(data[3]), Double.parseDouble(data[4])));
            }
            flag++;
        }
    }

    public Optional<Amenity> findByNameAndType(String name, String type) {
        return list.stream().filter(r -> r.getName().trim().equals(name) && r.getType().trim().equals(type)).findFirst();
    }

    public Optional<Amenity> search(String text) {
        return list.stream().filter(r -> r.getName().trim().toLowerCase().contains(text.toLowerCase())).findFirst();
    }
}
