
package domain;

import java.io.Serializable;

/**
 *
 * @author 730676
 */
public class Note implements Serializable{
    String title;
    String contents;

    
    public Note(String title, String contents) {
        this.title = title;
        this.contents = contents;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }
    
    public Note getNote(){
        return this;
    }
}
