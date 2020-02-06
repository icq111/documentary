package pl.minicode.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

@Entity
public class DocumentPage {
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
	
	@NotBlank(message = "Last name is mandatory")
	private String pageTittle;
	
	@Lob
	private String pageContent;

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

	public String getPageTittle() {
		return pageTittle;
	}

	public void setPageTittle(String pageTittle) {
		this.pageTittle = pageTittle;
	}

	public String getPageContent() {
		return pageContent;
	}

	public void setPageContent(String pageContent) {
		this.pageContent = pageContent;
	}

	@Override
	public String toString() {
		return "Page [id=" + id + ", insertStamp=" + insertStamp + ", updateStamp=" + updateStamp + ", active=" + active
				+ ", pageTittle=" + pageTittle + ", pageContent=" + pageContent + "]";
	}
}
