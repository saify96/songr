package com.example.songr.Interfaces;

import com.example.songr.Models.Song;
import org.springframework.data.repository.CrudRepository;

public interface SongRepo extends CrudRepository<Song,Integer> {
}
