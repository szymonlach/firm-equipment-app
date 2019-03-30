package pl.lach.spring.asset;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
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
}
