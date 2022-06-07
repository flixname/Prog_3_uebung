package domainLogic.util;

import mediaDB.Content;
import mediaDB.Uploadable;

public class Data<U extends Content,C extends Uploadable> {
    private Uploadable uploadable;
    private Content content;

    public Uploadable getUploadable() {
        return uploadable;
    }

    public void setUploadable(Uploadable uploadable) {
        this.uploadable = uploadable;
    }

    public Content getContent() {
        return content;
    }

    public void setContent(Content content) {
        this.content = content;
    }
}
