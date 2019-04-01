package pl.lach.spring.asset;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

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
        if (text == null)
            return assetService.findAll();
        else return assetService.findAllByNameOrSerialNumber(text);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AssetDto> findById(@PathVariable Long id) {
        Optional<AssetDto> assetDto = assetService.findById(id);
        return assetDto.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/{assetId}/assignments")
    public List<AssetAssignmentDto> findAssignmnents(@PathVariable Long assetId) {
        return assetService.findAllAssignmentsForAsset(assetId);
    }

    @PostMapping("")
    public ResponseEntity<AssetDto> save(@RequestBody AssetDto assetDto) {
        if (assetDto.getId() != null)
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Obiekt nie może mieć ustawionego id");
        AssetDto savedAsset = assetService.save(assetDto);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedAsset.getId())
                .toUri();
        return ResponseEntity.created(location).body(savedAsset);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AssetDto> update(@PathVariable Long id, @RequestBody AssetDto assetDto) {
        if (!id.equals(assetDto.getId()))
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Niezgodne id obiektu z id powanym w ścieżce zasobu");
        return ResponseEntity.ok(assetService.update(assetDto));

    }
}
