package pl.lach.spring.assignment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import pl.lach.spring.asset.AssetRepository;
import pl.lach.spring.user.UserRepository;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class AssignmentService {

    private AssignmentRepository assignmentRepository;
    private AssetRepository assetRepository;
    private UserRepository userRepository;

    @Autowired
    public AssignmentService(AssignmentRepository assignmentRepository, AssetRepository assetRepository, UserRepository userRepository) {
        this.assignmentRepository = assignmentRepository;
        this.assetRepository = assetRepository;
        this.userRepository = userRepository;
    }


    public AssignmentDto save(AssignmentDto assignmentDto) {
        Optional<Assignment> notReturnedAssignment = assignmentRepository.findByAsset_IdAndEndIsNull(assignmentDto.getAssetId());
        notReturnedAssignment.ifPresent(a -> {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Dane wyposażenie jest obecnie niedostępne");
        });

        Assignment assignment = new Assignment();
        assetRepository.findById(assignmentDto.getAssetId()).ifPresentOrElse(assignment::setAsset, () -> {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Wyposażenie o zadanym id jest niedostępne");
        });
        userRepository.findById(assignmentDto.getUserId()).ifPresentOrElse(assignment::setUser, () -> {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Użytkownik o zadanym id jest niedostępny");
        });
        assignment.setStart(LocalDateTime.now());

        return AssignmentMapper.toDto(assignmentRepository.save(assignment));
    }


}



