package com.challange_4.apichallange4.Service;

import com.challange_4.apichallange4.Dto.FilmDto;
import com.challange_4.apichallange4.Entity.Film;
import com.challange_4.apichallange4.Repository.FilmRepo;
import com.challange_4.apichallange4.Repository.FilmRepo2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FilmService {
    @Autowired
    FilmRepo filmsRepo;
    @Autowired
    FilmRepo2 filmsRepo2;

    @Cacheable(cacheNames = "CacheFilm") //memanggil cache yang ada di redisConfig ini juga bisa dipanggil paramater
    public List<Film> films_display(){
        return filmsRepo.findAll();
    }
    public Film films_submit_srv(FilmDto filmsDto){
        Film films = new Film();

        films.setFilmCode(filmsDto.getFilmCode());
        films.setFilmName(filmsDto.getFilmName());
        films.setStatus(filmsDto.isStatus());

        return filmsRepo.save(films);
    }
    public List<Film> films_displayById(int codeFilm){
        return filmsRepo.findById(codeFilm);
    }
    public void films_update(int id, FilmDto filmsDto){
        Film filmsUpdate = filmsRepo2.findById(id);

        if(filmsUpdate != null){
            filmsUpdate.setFilmName(filmsDto.getFilmName());
            filmsUpdate.setStatus(filmsDto.isStatus());
            Film update = filmsRepo2.save(filmsUpdate);
        }
    }
    public void films_delete(int id){
        Film delete = filmsRepo2.findById(id);
        if(delete != null){
            filmsRepo2.deleteById(id);
        }
    }
    //pagination Film
    public Page<Film> page_film(Pageable pageable){
        return filmsRepo.findAll(pageable);
    }
}
