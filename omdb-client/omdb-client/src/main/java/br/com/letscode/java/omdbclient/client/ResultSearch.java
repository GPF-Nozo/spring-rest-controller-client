package br.com.letscode.java.omdbclient.client;

import static java.lang.Boolean.valueOf;
import static java.lang.Integer.parseInt;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public record ResultSearch(List<MovieMinimal> resultList, Integer total, Boolean response) {
    @JsonCreator
    public ResultSearch(
        @JsonProperty("Search") List<MovieMinimal> resultList,
        @JsonProperty("totalResults") String total,
        @JsonProperty("Response") String response) {
        this(resultList, parseInt(total), valueOf(response));
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("cache.csv", true));
            for(int i = 0; i < resultList.size(); i++) {
                bw.write("ImdbId:");
                bw.write(",");
                bw.write(resultList.get(i).imdbId());
                bw.write(",");
                bw.write("Title:");
                bw.write(",");
                bw.write(resultList.get(i).title());
                bw.write(",");
                bw.write("Year:");
                bw.write(",");
                bw.write(String.valueOf(resultList.get(i).year()));
                bw.write(",");
            }
            bw.write(total);
            bw.write(",");
            bw.write(response);
            bw.newLine();
            bw.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

}
