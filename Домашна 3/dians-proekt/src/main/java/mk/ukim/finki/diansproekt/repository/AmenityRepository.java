package mk.ukim.finki.diansproekt.repository;

import mk.ukim.finki.diansproekt.model.Amenity;
import org.springframework.stereotype.Repository;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;

@Repository
public class AmenityRepository {
    public static List<Amenity> list = new ArrayList<>();

    public AmenityRepository() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("src/main/java/mk/ukim/finki/diansproekt/repository/data.csv"));
        String row = "";
        int flag = 0;
        Random random = new Random();

        while ((row = reader.readLine()) != null) {
            String[] data = row.split(",");
            if (flag > 0) {
                list.add(new Amenity(data[0], data[1], data[2],
                        Double.parseDouble(data[3]), Double.parseDouble(data[4])));
            }
            flag++;
        }
        for (int i = 0; i < list.size(); i++) {
            System.out.println("\n" + i);
            System.out.println("type: " + list.get(i).getType());
            System.out.println("id: " + list.get(i).getId());
            System.out.println("name: " + list.get(i).getName());
            System.out.println("lat: " + list.get(i).getLatitude());
            System.out.println("lon: " + list.get(i).getLongitude());
        }
    }

    public List<Amenity> listAll() {
        return list;
    }

    public List<Amenity> listAllBanks() {
        List<Amenity> temp = findByType("Bank");
        System.out.println(temp);
        List<Amenity> banks = new ArrayList<>();
        int j = 0;
        for (int i = 0; i < temp.size() - 1; i++) {
            if (!temp.get(i).getName().equals(temp.get(i + 1).getName())) {
                banks.set(j++, temp.get(i));
            }
            banks.set(j++, temp.get(temp.size() - 1));
        }
        System.out.println(banks);
        return banks;
    }


    public Optional<Amenity> findById(String id) {
        return list.stream().filter(r -> r.getId().equals(id)).findFirst();
    }

    public List<Amenity> findByType(String type) {
        return list.stream().filter(r -> r.getType().equalsIgnoreCase(type)).collect(Collectors.toList());
    }

    public List<Amenity> findByName(String name) {
        return list.stream().filter(r -> r.getName().equalsIgnoreCase(name)).collect(Collectors.toList());
    }

    public List<Amenity> findByNameAndType(String name, String type) {
        List<Amenity> temp = list.stream().filter(r -> r.getName().equalsIgnoreCase(name) && r.getType().equalsIgnoreCase(type)).collect(Collectors.toList());
        for (int i = 0; i < temp.size(); i++) {
            System.out.println(temp.get(i));
        }
        return temp;
    }

    public List<Amenity> search(String text) {
        return list.stream().filter(r -> r.getName().equalsIgnoreCase(text)).collect(Collectors.toList());
    }
}
