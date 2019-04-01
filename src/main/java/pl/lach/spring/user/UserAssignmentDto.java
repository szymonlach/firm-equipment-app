package pl.lach.spring.user;

import java.time.LocalDateTime;
import java.util.Objects;

public class UserAssignmentDto {


    private Long id;
    private LocalDateTime start;
    private LocalDateTime end;
    private Long assetId;
    private String assetName;
    private String assetSerialNumber;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getStart() {
        return start;
    }

    public void setStart(LocalDateTime start) {
        this.start = start;
    }

    public LocalDateTime getEnd() {
        return end;
    }

    public void setEnd(LocalDateTime end) {
        this.end = end;
    }

    public Long getAssetId() {
        return assetId;
    }

    public void setAssetId(Long assetId) {
        this.assetId = assetId;
    }

    public String getAssetName() {
        return assetName;
    }

    public void setAssetName(String assetName) {
        this.assetName = assetName;
    }

    public String getAssetSerialNumber() {
        return assetSerialNumber;
    }

    public void setAssetSerialNumber(String assetSerialNumber) {
        this.assetSerialNumber = assetSerialNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserAssignmentDto)) return false;
        UserAssignmentDto that = (UserAssignmentDto) o;
        return Objects.equals(getId(), that.getId()) &&
                Objects.equals(getStart(), that.getStart()) &&
                Objects.equals(getEnd(), that.getEnd()) &&
                Objects.equals(getAssetId(), that.getAssetId()) &&
                Objects.equals(getAssetName(), that.getAssetName()) &&
                Objects.equals(getAssetSerialNumber(), that.getAssetSerialNumber());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getId(), getStart(), getEnd(), getAssetId(), getAssetName(), getAssetSerialNumber());
    }

    @Override
    public String toString() {
        return "UserAssignmentDto{" +
                "id=" + id +
                ", start=" + start +
                ", end=" + end +
                ", assetId=" + assetId +
                ", assetName='" + assetName + '\'' +
                ", assetSerialNumber='" + assetSerialNumber + '\'' +
                '}';
    }
}
