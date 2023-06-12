package sky.pro.course221.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class IsEmptyException extends RuntimeException {
    public IsEmptyException (String msg){
        super(msg);
    }
}
