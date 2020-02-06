package pl.minicode.domain;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

@Entity
public class Book extends Domain {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
	
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date insertStamp;
    
    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    private Date updateStamp;
	
	private boolean active;
	
	private String title;
	
	@OneToMany(targetEntity=Chapter.class, fetch=FetchType.LAZY)
	private List<Chapter> chapters;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getInsertStamp() {
		return insertStamp;
	}

	public void setInsertStamp(Date insertStamp) {
		this.insertStamp = insertStamp;
	}

	public Date getUpdateStamp() {
		return updateStamp;
	}

	public void setUpdateStamp(Date updateStamp) {
		this.updateStamp = updateStamp;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<Chapter> getChapters() {
		return chapters;
	}

	public void setChapters(List<Chapter> chapters) {
		this.chapters = chapters;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", insertStamp=" + insertStamp + ", updateStamp=" + updateStamp + ", active=" + active
				+ ", title=" + title + ", chapters=" + chapters + "]";
	}
}
