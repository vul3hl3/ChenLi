package net.blog.spring.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Education")
public class Education {
	
	@Id
	@Column(name="name", length=50, nullable=false)
	private String name;
	
	@Column( length=50, nullable=false)
	private String department;
	
	@Column( length=20, nullable=false)
	private String degree;

	@Column( length=50, nullable=false)
	private String duration;

	private Timestamp created;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getDegree() {
		return degree;
	}
	public void setDegree(String degree) {
		this.degree = degree;
	}
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
	public Timestamp getCreated() {
		return created;
	}
	public void setCreated(Timestamp created) {
		this.created = created;
	}

	@Override
    public String toString(){
        return "name="+name+", department="+department+", degree="+degree+", duration="+duration+", created="+created;
    }
}
