package pl.lach.spring.asset;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Nie istnieje wyposażenie o zadanym id")
public class AssetNotFoundException extends RuntimeException {
}
