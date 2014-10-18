/**
 * 
 */
package types;

/**
 * @author Ivaylo Ivanchev
 *
 */
public class ComicBook {
	private Metadata metadata; // this will definately change in time
	private Integer numberOfPages;
	private String fileSystempath;
	private String fileSize;
	private String fileType; // this needs to be replaced by some form of enum
	private Boolean finished; // is this comic read ?
	private Boolean opened; // is this comic book even opened yet ?
	private Integer position; // where did the user stop reading this comic book 
	
	public String getFileSystempath() {
		return fileSystempath;
	}
	public void setFileSystempath(String fileSystempath) {
		this.fileSystempath = fileSystempath;
	}
	public Boolean getFinished() {
		return finished;
	}
	public void setFinished(Boolean finished) {
		this.finished = finished;
	}
	public Boolean getOpened() {
		return opened;
	}
	public void setOpened(Boolean opened) {
		this.opened = opened;
	}
	public Integer getPosition() {
		return position;
	}
	public void setPosition(Integer position) {
		this.position = position;
	}
	
	
}
