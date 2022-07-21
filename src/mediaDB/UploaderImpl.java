package mediaDB;

import java.io.Serializable;

/**
 * Uploader erstellen welcher schon einen Eintrag hat und mit selben eine datei hochladen....//TODO: nochmach in ueberpruefung in Uploaderliste schauen, da ist logikfehler mit ueberpruefung der namen
 * //TODO: es muss möglich sein eine datei hochzuladen mit gleichem namen aber nicht in der uploaderliste zu erstellen
 */
public class UploaderImpl implements Serializable {

    private final String NAME;

    public UploaderImpl(String NAME) {
        this.NAME = NAME;
    }


    @Override
    public String getName() {
        return this.NAME;
    }
}
