package pl.lach.spring.assignment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/api/assignments")
public class AssignmentsResourceController {

    private AssignmentService assignmentService;

    @Autowired
    public AssignmentsResourceController(AssignmentService assignmentService) {
        this.assignmentService = assignmentService;
    }

    @PostMapping("")
    public ResponseEntity<AssignmentDto> save(@RequestBody AssignmentDto assignmentDto) {
        AssignmentDto savedAssignment = assignmentService.save(assignmentDto);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(savedAssignment.getId()).toUri();
        return ResponseEntity.created(location).body(savedAssignment);
    }
}
