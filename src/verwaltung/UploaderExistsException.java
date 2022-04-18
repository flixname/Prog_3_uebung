package verwaltung;

public class UploaderExistsException extends Exception {
    public UploaderExistsException(String message) {
        super(message);
        System.out.println("Uploader exists already");
    }
}
