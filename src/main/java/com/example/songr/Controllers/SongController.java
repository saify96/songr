package com.example.songr.Controllers;

import com.example.songr.Interfaces.AlbumRepo;
import com.example.songr.Interfaces.SongRepo;
import com.example.songr.Models.Album;
import com.example.songr.Models.Song;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class SongController {

    @Autowired
    SongRepo songRepo;
    @Autowired
    AlbumRepo albumRepo;

    @GetMapping("/songs")
    public String getSong(Model model) {
        model.addAttribute("songs", songRepo.findAll());
        return "songs.html";
    }

    @PostMapping("/addSong")
    public RedirectView addNewSong(String title , int length, int trackNumber , int id){
        Album album = albumRepo.findById(id).get();
        Song song = new Song(title,length,trackNumber,album);
        songRepo.save(song);
        return new RedirectView("/albums/"+id);
    }

    @GetMapping("/albums/{id}")
    public String albumDetails(@PathVariable ("id") Integer id, Model m){
        Album album = albumRepo.findById(id).get();

        m.addAttribute("album", album);

        return "albumSongs.html";
    }

}
