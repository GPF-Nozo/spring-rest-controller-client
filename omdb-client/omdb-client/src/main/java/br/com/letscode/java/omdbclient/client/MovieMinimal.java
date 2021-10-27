package br.com.letscode.java.omdbclient.client;

import com.fasterxml.jackson.annotation.JsonCreator;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public record MovieMinimal(String imdbId, String title, Integer year ) {

    @JsonCreator
    public MovieMinimal(String imdbId, String title, String year) {
        this(imdbId, title, convertYear(year));
    }

    private static int convertYear(final String year) {
        if (year.matches("\\d+")) {
            return Integer.parseInt(year);
        }
        return Arrays.stream(year.split("\\D"))
            .map(Integer::parseInt)
            .findFirst()
            .orElseThrow();
    }
}
