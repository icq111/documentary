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
import javax.validation.constraints.NotBlank;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

@Entity
public class Chapter {
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
	
	@NotBlank(message = "Chapter is mandatory")
	private String chapterTittle;
	
	@OneToMany(targetEntity=DocumentPage.class, fetch=FetchType.LAZY)
	private List<DocumentPage> pages;

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

	public String getChapterTittle() {
		return chapterTittle;
	}

	public void setChapterTittle(String chapterTittle) {
		this.chapterTittle = chapterTittle;
	}

	public List<DocumentPage> getPages() {
		return pages;
	}

	public void setPages(List<DocumentPage> pages) {
		this.pages = pages;
	}

	@Override
	public String toString() {
		return "Chapter [id=" + id + ", insertStamp=" + insertStamp + ", updateStamp=" + updateStamp + ", active="
				+ active + ", chapterTittle=" + chapterTittle + ", pages=" + pages + "]";
	}
}
