package openjanela.model.eao.genericEAO;

/**
 * Generic Persitence DAO Exception
 *
 * Created by IntelliJ IDEA.
 * User: Eddy Montenegro
 * Date: 09-05-2010
 * Time: 10:36:48 PM
 */
public class GenericPersistenceEAOException extends Exception{

    /**
     * Exception con un mensaje de error
     * @param message, Mensaje de error
     */
    public GenericPersistenceEAOException(String message){
        super(message);
    }

    /**
     * Exception con un mensaje de error y un lanzamiento de error
     * @param message, Mensaje de error
     * @param cause, Causa del error
     */

    public GenericPersistenceEAOException(String message, Throwable cause){
        super(message, cause);
    }

    /**
     * Exception con un lanzamiento de error
     * @param cause, Causa del error
     */
    public GenericPersistenceEAOException(Throwable cause){
        super(cause);
    }
}
