package br.com.letscode.java.omdbclient.rest;

import br.com.letscode.java.omdbclient.client.MovieMinimalRestRepository;
import br.com.letscode.java.omdbclient.client.ResultSearch;
import org.springframework.web.bind.annotation.*;

import java.io.*;
import java.util.Scanner;

@RequestMapping("/search")
@RestController
public record SearchRestController(MovieMinimalRestRepository restRepository) {

    @GetMapping
    public String Csv(@RequestParam String title) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("cache.csv"));
        sc.useDelimiter(",");
        while (sc.hasNextLine())
        {
            String line = sc.nextLine();
            if (line.contains(title)) {
                return line.replaceAll(",", "\n");
            } else {
                throw new FileNotFoundException();
            }
        }
        sc.close();
        throw new FileNotFoundException();
    }
    @GetMapping
    public ResultSearch search(@RequestParam String title) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("cache.csv", true));
            bw.write("Search:");
            bw.write(",");
            bw.write(title);
            bw.write(",");
            bw.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return restRepository.search(title);
    }
}