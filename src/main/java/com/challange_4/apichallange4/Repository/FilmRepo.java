package com.challange_4.apichallange4.Repository;

import com.challange_4.apichallange4.Entity.Film;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public interface FilmRepo extends PagingAndSortingRepository<Film, Integer> {
    List<Film> findAll();
    List<Film> findById(int code_films);
    Page<Film> findAll(Pageable pageable);
}
