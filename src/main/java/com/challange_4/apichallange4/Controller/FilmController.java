package com.challange_4.apichallange4.Controller;


import com.challange_4.apichallange4.Dto.FilmDto;
import com.challange_4.apichallange4.Entity.Film;
import com.challange_4.apichallange4.Service.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FilmController {
    @Autowired
    FilmService filmsService;


    @GetMapping("api/films/display-all")
    public ResponseEntity<?> films_display(){
        try{
            List<Film> responEntity = filmsService.films_display();
            return new ResponseEntity<>(responEntity, HttpStatus.ACCEPTED);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("api/films/display/{code_films}")
    public ResponseEntity<?> films_display_ById(@PathVariable int code_films){
        List<Film> responEntity = filmsService.films_displayById(code_films);

        if (responEntity != null){
            return new ResponseEntity<>(responEntity, HttpStatus.CREATED);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("api/film/submit")
    public ResponseEntity<?> films_submit(@RequestBody FilmDto filmsDto){
        Film responEntity = filmsService.films_submit_srv(filmsDto);
        return new ResponseEntity<>(responEntity, HttpStatus.CREATED);
    }

    @PutMapping("api/films/update/{code_films}")
    public ResponseEntity<?> films_update(@PathVariable int code_films, @RequestBody FilmDto filmsDto){
        filmsService.films_update(code_films,filmsDto);
        List<Film> responEntity = filmsService.films_displayById(code_films);
        return new ResponseEntity<>(responEntity, HttpStatus.ACCEPTED);
    }

    //pagination Film
    @GetMapping("api/film/page-display/{page}/{size}")
    public Page<Film> display_film_page(Pageable pageable,@PathVariable("page") int page,@PathVariable("size") int size){
        pageable = PageRequest.of(page,size);
        return filmsService.page_film(pageable);
    }
    @DeleteMapping("api/film/delete/{code_films}")
    public String films_delete(@PathVariable int code_films){
        filmsService.films_delete(code_films);
        return "File have been deleted";
    }
}
