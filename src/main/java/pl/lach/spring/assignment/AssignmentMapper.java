package pl.lach.spring.assignment;

public class AssignmentMapper {

    public static AssignmentDto toDto(Assignment assignment) {
        AssignmentDto assignmentDto = new AssignmentDto();
        assignmentDto.setId(assignment.getId());
        assignmentDto.setStart(assignment.getStart());
        assignmentDto.setEnd(assignment.getEnd());
        assignmentDto.setAssetId(assignment.getAsset().getId());
        assignmentDto.setAssetName(assignment.getAsset().getName());
        assignmentDto.setAssetSerialNumber(assignment.getAsset().getSerialNumber());
        return assignmentDto;
    }

}
