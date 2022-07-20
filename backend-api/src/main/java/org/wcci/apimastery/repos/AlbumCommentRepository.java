package org.wcci.apimastery.repos;

import org.springframework.data.repository.CrudRepository;
import org.wcci.apimastery.Model.AlbumComment;

public interface AlbumCommentRepository extends CrudRepository<AlbumComment, Long> {
}
