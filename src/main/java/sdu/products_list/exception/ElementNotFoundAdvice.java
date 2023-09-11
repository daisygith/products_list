package sdu.products_list.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ElementNotFoundAdvice {

    @ResponseBody // odp mogła zostać przemapowana do odpowiedzi json-a
    @ExceptionHandler(ElementNotFoundException.class) //zawiera klase która bedzie obsługiwana
    @ResponseStatus(HttpStatus.NOT_FOUND) // status - nie znaleziono wskazanego elementu
    public String ElementNotFoundHandler(ElementNotFoundException ex){
        return ex.getMessage();
    }

}

