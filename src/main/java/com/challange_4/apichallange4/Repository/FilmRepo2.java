package com.challange_4.apichallange4.Repository;

import com.challange_4.apichallange4.Entity.Film;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FilmRepo2 extends JpaRepository<Film, Integer> {
    Film findById(int code_films);
}
