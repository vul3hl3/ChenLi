package net.blog.spring.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Activities")
public class Activities {
	@Id
	@Column(name="name",length=100, nullable=false)
	private String name;
	
	@Column( length=50, nullable=false)
	private String title;
	
	@Column( length=100, nullable=false)
	private String duration;
	
	@Column( length=50, nullable=true)
	private String task;
	
	private Timestamp created;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
	public String getTask() {
		return task;
	}
	public void setTask(String task) {
		this.task = task;
	}
	public Timestamp getCreated() {
		return created;
	}
	public void setCreated(Timestamp created) {
		this.created = created;
	}

	@Override
    public String toString(){
        return "name="+name+", title="+title+", duration="+duration+", task="+task+", created="+created;
    }
}
