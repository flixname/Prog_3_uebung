package domainLogic;

import mediaDB.Tag;

import java.util.Collection;

public abstract class ObservableTag {

        private Collection<Tag> tagCollection;

        public Collection<Tag> getTagCollection() {
            return tagCollection;
        }

    public void setTagCollection(Collection<Tag> tagCollection) {
        this.tagCollection = tagCollection;
    }

    public void addTag(Tag tag) {
            if(this.tagCollection.contains(tag)) return;
            this.tagCollection.add(tag);
            /*
            this.setChanged(); //TODO: Subscribe notify funtionality
            this.notifyObservers();
            */
        }



}
