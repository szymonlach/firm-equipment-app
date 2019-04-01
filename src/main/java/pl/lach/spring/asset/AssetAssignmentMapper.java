package pl.lach.spring.asset;

import pl.lach.spring.assignment.Assignment;

public class AssetAssignmentMapper {


    static AssetAssignmentDto toDto(Assignment assignment) {
        AssetAssignmentDto assetAssignmentDto = new AssetAssignmentDto();
        assetAssignmentDto.setId(assignment.getId());
        assetAssignmentDto.setStart(assignment.getStart());
        assetAssignmentDto.setEnd(assignment.getEnd());
        assetAssignmentDto.setUserId(assignment.getUser().getId());
        assetAssignmentDto.setFirstName(assignment.getUser().getFirstName());
        assetAssignmentDto.setLastName(assignment.getUser().getLastName());
        assetAssignmentDto.setPesel(assignment.getUser().getPesel());
        return assetAssignmentDto;
    }
}
