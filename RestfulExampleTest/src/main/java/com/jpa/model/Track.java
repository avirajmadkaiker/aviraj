package main.java.com.jpa.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="TRACK")
public class Track {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
	@Column(name = "title")
    private String title;
 
    @Column(name = "singer")
    private String singer;

   /* public Track(int id, String title, String singer){
    	this.id=id;
    	this.title=title;
    	this.singer=singer;
    }*/

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSinger() {
		return singer;
	}

	public void setSinger(String singer) {
		this.singer = singer;
	}
}
