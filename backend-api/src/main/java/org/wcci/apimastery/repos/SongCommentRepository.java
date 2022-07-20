package org.wcci.apimastery.repos;

import org.springframework.data.repository.CrudRepository;
import org.wcci.apimastery.Model.SongComment;

public interface SongCommentRepository extends CrudRepository<SongComment, Long> {
}
