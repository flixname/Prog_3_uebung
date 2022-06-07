package domainLogic;

import mediaDB.Content;

import java.util.LinkedList;

public interface GLContent {

    boolean createContent(String contentType, String uploaderName, String tags, int bitrate, long laenge);

    boolean createTag(String tag, String address);

    LinkedList<Content> readContentByType(String type);

    LinkedList<Content> readContentByTags(String tag);

    long update(String address);

    boolean deleteSingleContent(String address);
}
