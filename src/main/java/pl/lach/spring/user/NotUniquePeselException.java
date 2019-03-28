package pl.lach.spring.user;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT, reason = "Użytkownik z takim peselem już istnieje")
public class NotUniquePeselException extends RuntimeException {

}
