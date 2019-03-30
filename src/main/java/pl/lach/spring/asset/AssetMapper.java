package pl.lach.spring.asset;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.lach.spring.category.Category;
import pl.lach.spring.category.CategoryRepository;

import java.util.Optional;

@Component
public class AssetMapper {

    private CategoryRepository categoryRepository;

    @Autowired
    public AssetMapper(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    AssetDto toDto(Asset asset) {
        AssetDto assetDto = new AssetDto();
        assetDto.setId(asset.getId());
        assetDto.setName(asset.getName());
        assetDto.setDescription(asset.getDescription());
        assetDto.setSerialNumber(asset.getDescription());
        if (asset.getCategory() != null)
            assetDto.setCategory(asset.getCategory().getName());
        return assetDto;
    }

    Asset toEntity(AssetDto assetDto) {
        Asset asset = new Asset();
        asset.setId(assetDto.getId());
        asset.setName(assetDto.getName());
        asset.setDescription(assetDto.getDescription());
        asset.setSerialNumber(assetDto.getSerialNumber());
        Optional<Category> category = categoryRepository.findByName(assetDto.getCategory());
        category.ifPresent(asset::setCategory);
        return asset;
    }
}
