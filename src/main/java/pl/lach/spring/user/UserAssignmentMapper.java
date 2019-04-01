package pl.lach.spring.user;

import pl.lach.spring.assignment.Assignment;

public class UserAssignmentMapper {

    public static UserAssignmentDto toDto(Assignment assignment) {
        UserAssignmentDto userAssignmentDto = new UserAssignmentDto();
        userAssignmentDto.setId(assignment.getId());
        userAssignmentDto.setStart(assignment.getStart());
        userAssignmentDto.setEnd(assignment.getEnd());
        userAssignmentDto.setAssetId(assignment.getAsset().getId());
        userAssignmentDto.setAssetName(assignment.getAsset().getName());
        userAssignmentDto.setAssetSerialNumber(assignment.getAsset().getSerialNumber());
        return userAssignmentDto;
    }

}
