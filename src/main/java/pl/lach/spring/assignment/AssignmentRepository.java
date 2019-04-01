package pl.lach.spring.assignment;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AssignmentRepository extends JpaRepository<Assignment, Long> {

    Optional<Assignment> findByAsset_IdAndEndIsNull(Long assetId);

    Optional<Assignment> findByIdAndEndNotNull(Long assignmentId);
}
