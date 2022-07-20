package org.wcci.apimastery.repos;

import org.springframework.data.repository.CrudRepository;
import org.wcci.apimastery.Model.Song;

import java.util.Optional;

public interface SongRepository extends CrudRepository<Song, Long> {

    Optional<Song> findByNameIgnoreCase(String name);
}
