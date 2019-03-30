package pl.lach.spring.asset;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AssetRepository extends JpaRepository<Asset, Long> {

    @Query("Select a from Asset a where lower(a.name) like lower(concat('%',:input,'%'))" +
            " or lower(a.serialNumber) like lower(concat('%',:input,'%'))")
    List<Asset> findAllByNameOrSerialNumber(@Param("input") String input);
}
