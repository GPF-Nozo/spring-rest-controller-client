package br.com.letscode.java.omdbclient;

import br.com.letscode.java.omdbclient.client.MovieMinimalRestRepository;
import br.com.letscode.java.omdbclient.client.ResultSearch;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

import java.io.*;
import java.util.Scanner;

@EnableFeignClients
@SpringBootApplication
public class OmdbClientApplication {

    public static void main(String[] args){
        SpringApplication.run(OmdbClientApplication.class, args);
    }
}
