package net.blog.spring.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Profile")
public class Profile {
	   
		@Id
		@Column(name="id",length=20, nullable=false)
		private String id;

		@Column( length=20, nullable=false)
		private String chtname;

		@Column( length=20, nullable=false)
		private String engname;

		@Column( length=1, nullable=false)
		private String gender;

		@Column( length=50, nullable=false)
		private String cell;

		@Column( length=50, nullable=false)
		private String birthday;

		@Column( length=50, nullable=false)
		private String email;

		@Column( length=100, nullable=false)
		private String homeaddress;

		@Column( length=100, nullable=false)
		private String bilingaddress;

		private Timestamp created;		
		
		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}

		public String getChtname() {
			return chtname;
		}

		public void setChtname(String chtname) {
			this.chtname = chtname;
		}

		public String getEngname() {
			return engname;
		}

		public void setEngname(String engname) {
			this.engname = engname;
		}

		public String getGender() {
			return gender;
		}

		public void setGender(String gender) {
			this.gender = gender;
		}

		public String getCell() {
			return cell;
		}

		public void setCell(String cell) {
			this.cell = cell;
		}

		public String getBirthday() {
			return birthday;
		}

		public void setBirthday(String birthday) {
			this.birthday = birthday;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getHomeaddress() {
			return homeaddress;
		}

		public void setHomeaddress(String homeaddress) {
			this.homeaddress = homeaddress;
		}

		public String getBilingaddress() {
			return bilingaddress;
		}

		public void setBilingaddress(String bilingaddress) {
			this.bilingaddress = bilingaddress;
		}

		public Timestamp getCreated() {
			return created;
		}

		public void setCreated(Timestamp created) {
			this.created = created;
		}

		@Override
	    public String toString(){
	        return "id="+id+", chtname="+chtname+", engname="+engname+", gender="+gender+", cell="+cell+", birthday="+birthday+", email="+email
	        		+", homeaddress="+homeaddress+", bilingaddress="+bilingaddress+", created="+created;
	    }
}
