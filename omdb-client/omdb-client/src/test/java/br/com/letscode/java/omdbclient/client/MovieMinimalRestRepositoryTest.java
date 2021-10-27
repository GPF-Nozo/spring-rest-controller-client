package br.com.letscode.java.omdbclient.client;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MovieMinimalRestRepositoryTest {

    @Autowired
    private MovieMinimalRestRepository restRepository;

    @Test
    void search() {
        ResultSearch resultSearch = this.restRepository.search("lord of the rings");
        assertTrue(resultSearch.response());
        resultSearch.resultList().forEach(System.out::println);
    }
}
