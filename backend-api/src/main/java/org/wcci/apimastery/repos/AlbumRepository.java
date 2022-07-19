package org.wcci.apimastery.repos;

import org.springframework.data.repository.CrudRepository;
import org.wcci.apimastery.Model.Album;

import java.util.Optional;

public interface AlbumRepository extends CrudRepository<Album, Long> {
    Optional<Album> findByNameIgnoreCase(String name);
}
