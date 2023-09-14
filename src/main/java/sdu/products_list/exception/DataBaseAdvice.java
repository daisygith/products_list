package sdu.products_list.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class DataBaseAdvice {
    @ResponseBody // odp mogła zostać przemapowana do odpowiedzi json-a
    @ExceptionHandler(DataBaseException.class) //zawiera klase która bedzie obsługiwana
    @ResponseStatus(HttpStatus.ACCEPTED)
    public String DataBaseHandler(DataBaseException ex){
        return ex.getMessage();
    }
}
