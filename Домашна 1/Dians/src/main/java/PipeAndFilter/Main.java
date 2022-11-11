package PipeAndFilter;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Pipe<String> pipe = new Pipe<>();
        LowercaseAllLetters lowercaseAllLetters = new LowercaseAllLetters();
        UppercaseFirstLetter uppercaseFirstLetter = new UppercaseFirstLetter();
        pipe.addFilter(lowercaseAllLetters);
        pipe.addFilter(uppercaseFirstLetter);
        Pipe<String> pipe2 = new Pipe<>();
        UppercaseAllLetters uppercaseAllLetters = new UppercaseAllLetters();
        pipe2.addFilter(uppercaseAllLetters);

        String[] teststring;
        String line = " ";
        List<List<String>> glavnaLista = new LinkedList<>();

        Scanner scanner = new Scanner(new File("src/main/resources/map.csv"));
        scanner.useDelimiter(",");
        while(scanner.hasNextLine()){
            line = scanner.nextLine();
            teststring = line.split(",");
            if(Objects.equals(teststring[20], "bank") || Objects.equals(teststring[20], "atm")){
                List<String> tmp = new LinkedList<>();
                if(Objects.equals(teststring[20], "bank"))
                {
                    tmp.add(pipe.runFilter(teststring[20]));
                }
                else tmp.add(pipe2.runFilter(teststring[20]));

                tmp.add(teststring[0]);
                if((!teststring[9].isEmpty())){
                    tmp.add(pipe.runFilter(teststring[9]));
                }
                tmp.add(teststring[53]);
                tmp.add(pipe.runFilter(teststring[22]));
                tmp.add(teststring[23]);
                tmp.add(teststring[398]);
                if((!teststring[9].isEmpty())){
                    glavnaLista.add(tmp);
                }

            }
        }
        File file = new File("Output.csv");
         PrintStream printStream = new PrintStream(file);
        String[] nizastringoj;

        for(List<String> string : glavnaLista){
            printStream.println(string.toString());

        }

    }
}