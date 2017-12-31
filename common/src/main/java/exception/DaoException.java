package exception;

import java.io.StringWriter;

public class DaoException extends Exception{
    public DaoException(){
        super();
    }
    public DaoException(String errorInfo){
        super(errorInfo);
    }
}
