package pl.lach.spring.asset;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AssetService {

    private AssetRepository assetRepository;
    private AssetMapper assetMapper;

    @Autowired
    public AssetService(AssetRepository assetRepository, AssetMapper assetMapper) {
        this.assetRepository = assetRepository;
        this.assetMapper = assetMapper;
    }

    List<AssetDto> findAll() {
        return assetRepository.findAll().stream().map(assetMapper::toDto).collect(Collectors.toList());
    }

    List<AssetDto> findAllByNameOrSerialNumber(String input) {
        return assetRepository.findAllByNameOrSerialNumber(input).stream().map(assetMapper::toDto).collect(Collectors.toList());
    }


    public AssetDto save(AssetDto assetDto) {
        Optional<Asset> foundAsset = assetRepository.findBySerialNumber(assetDto.getSerialNumber());
        foundAsset.ifPresent(f -> {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "W bazie istnieje już obiekt o takim numerze seryjnym");
        });
        Asset savedAsset = assetRepository.save(assetMapper.toEntity(assetDto));
        return assetMapper.toDto(savedAsset);
    }
}
