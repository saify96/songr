package com.example.songr.Controllers;

import com.example.songr.Models.Album;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Controller
public class SongrController {

    @RequestMapping("/")
    public String splashPage(){
        return "home.html";
    }


    @RequestMapping("/hello")
    public String hello(){
        return "helloWorld.html";
    }

    @RequestMapping("/capitalize/{word}")
    @ResponseBody
    public String capitalize(@PathVariable("word") String word  ){
        String capital= word.toUpperCase();
        return capital;
    }

    @RequestMapping("/albums")
    public String album(Model album){
        String url = "data:image/jpeg;base64,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";
        Album album1 = new Album("Hybrid Theory","Linkin Park","https://static.qobuz.com/images/covers/da/4a/qzvl42o844ada_600.jpg",12,2265);
        Album album2 = new Album("Uptown Special","Mark Ronson","https://upload.wikimedia.org/wikipedia/en/a/a7/Mark_Ronson_-_Uptown_Funk_%28feat._Bruno_Mars%29_%28Official_Single_Cover%29.png",8,1900);
        Album album3 = new Album("Happier Than Ever","Billie Eilish",url,13,3000);
        List<Album> albums = new ArrayList<Album>();
        albums.add(album1);
        albums.add(album2);
        albums.add(album3);
        album.addAttribute("albums",albums);
        return "albums.html";
    }

}
