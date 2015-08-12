package net.blog.spring.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
 
/**
 * Entity bean with JPA annotations
 * Hibernate provides JPA implementation
 * @author Charlie
 *
 */
@Entity
@Table(name="Workexp")
public class Workexp {
 
    @Id
    @Column(name="id", nullable=false)
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    
    @Column(length=50, nullable=false)
    private String corp;

    @Column(length=20, nullable=false)
    private String title;

    @Column(length=50, nullable=false)
   private String duration;

    @Column(length=2000, nullable=true)
  private String  task;

	public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public String getCorp() {
	return corp;
}

public void setCorp(String corp) {
	this.corp = corp;
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

	@Override
    public String toString(){
        return "id="+id+", corp="+corp+", title="+title+", duration="+duration+", task="+task;
    }
}