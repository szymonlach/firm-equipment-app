package pl.lach.spring.asset;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/assets")
public class AssetResourceController {

    private AssetService assetService;

    @Autowired
    public AssetResourceController(AssetService assetService) {
        this.assetService = assetService;
    }

    @GetMapping("")
    public List<AssetDto> findAll(@RequestParam(required = false) String text) {
        if (text==null)
            return assetService.findAll();
        else return assetService.findAllByNameOrSerialNumber(text);
    }
}
