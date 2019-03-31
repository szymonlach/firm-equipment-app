package pl.lach.spring.asset;

import pl.lach.spring.assignment.Assignment;
import pl.lach.spring.category.Category;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "assets")
public class Asset {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Column(length = 1024)
    private String description;
    @Column(unique = true, name = "serial_number")
    private String serialNumber;
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
    @OneToMany(mappedBy = "asset")
    private List<Assignment> assignments = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public List<Assignment> getAssignments() {
        return assignments;
    }

    public void setAssignments(List<Assignment> assignments) {
        this.assignments = assignments;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Asset)) return false;
        Asset asset = (Asset) o;
        return Objects.equals(getId(), asset.getId()) &&
                Objects.equals(getName(), asset.getName()) &&
                Objects.equals(getDescription(), asset.getDescription()) &&
                Objects.equals(getSerialNumber(), asset.getSerialNumber()) &&
                Objects.equals(getCategory(), asset.getCategory());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getId(), getName(), getDescription(), getSerialNumber(), getCategory());
    }

    @Override
    public String toString() {
        return "Asset{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", serialNumber='" + serialNumber + '\'' +
                ", category=" + category +
                '}';
    }
}
