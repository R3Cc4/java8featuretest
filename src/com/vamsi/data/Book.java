package com.vamsi.data;

import java.util.Date;
import java.util.Objects;


public class Book {

    private String author;
    private String title;
    private String tag;
    private Date published;
    
    public Book(String author,String title,String tag,Date published){
    
      this.author = Objects.requireNonNull(author);
      this.title = Objects.requireNonNull(title);
      this.tag = Objects.requireNonNull(tag);
      this.published = Objects.requireNonNull(published);
    }

    
    /** Getter for instance variable 'author'.
     * 
     * <p>TODO Describe and specify range of return value/oblect
     *            including whether null or an empty object may be returned.</p>
     *
     * @return author.
     */
    public String getAuthor() {
        return author;
    }

    
    /** Setter for instance variable 'author'.
     *
     * <p>TODO Describe and specify acceptable values for the input parameter
     *            including whether empty or null objects are acceptable.</p>
     *
     * @param author The author to set.
     */
    public void setAuthor(String author) {
        this.author = author;
    }

    
    /** Getter for instance variable 'title'.
     * 
     * <p>TODO Describe and specify range of return value/oblect
     *            including whether null or an empty object may be returned.</p>
     *
     * @return title.
     */
    public String getTitle() {
        return title;
    }

    
    /** Setter for instance variable 'title'.
     *
     * <p>TODO Describe and specify acceptable values for the input parameter
     *            including whether empty or null objects are acceptable.</p>
     *
     * @param title The title to set.
     */
    public void setTitle(String title) {
        this.title = title;
    }

    
    /** Getter for instance variable 'tag'.
     * 
     * <p>TODO Describe and specify range of return value/oblect
     *            including whether null or an empty object may be returned.</p>
     *
     * @return tag.
     */
    public String getTag() {
        return tag;
    }

    
    /** Setter for instance variable 'tag'.
     *
     * <p>TODO Describe and specify acceptable values for the input parameter
     *            including whether empty or null objects are acceptable.</p>
     *
     * @param tag The tag to set.
     */
    public void setTag(String tag) {
        this.tag = tag;
    }

    
    /** Getter for instance variable 'published'.
     * 
     * <p>TODO Describe and specify range of return value/oblect
     *            including whether null or an empty object may be returned.</p>
     *
     * @return published.
     */
    public Date getPublished() {
        return published;
    }

    
    /** Setter for instance variable 'published'.
     *
     * <p>TODO Describe and specify acceptable values for the input parameter
     *            including whether empty or null objects are acceptable.</p>
     *
     * @param published The published to set.
     */
    public void setPublished(Date published) {
        this.published = published;
    }
    
}
    
    