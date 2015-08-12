package net.blog.spring.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Thesis")
public class Thesis {
	@Id
	@Column(name="name",length=100, nullable=false)
	private String name;
	
	@Column( length=100, nullable=false)
	private String conference;
	
	@Column( length=2000, nullable=false)
	private String brief;
	
	@Column( length=50, nullable=false)
	private String link;
	
	private Timestamp created;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getConference() {
		return conference;
	}
	public void setConference(String conference) {
		this.conference = conference;
	}
	public String getBrief() {
		return brief;
	}
	public void setBrief(String brief) {
		this.brief = brief;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public Timestamp getCreated() {
		return created;
	}
	public void setCreated(Timestamp created) {
		this.created = created;
	}

	@Override
    public String toString(){
        return "name="+name+", conference="+conference+", brief="+brief+", link="+link+", created="+created;
    }
}
