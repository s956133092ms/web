package app.user;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "video")
public class User {
	@Id  
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@NotNull
	private String webname;
	@NotNull
	private String videoname;
	private String pagetime;
	private String collecttime;
	private String fromwhere;
	public String getPagetime() {
		return pagetime;
	}
	public void setPagetime(String pagetime) {
		this.pagetime = pagetime;
	}
	public String getTime() {
		return collecttime;
	}
	public void setTime(String collecttime) {
		this.collecttime = collecttime;
	}
	public String getFrom() {
		return fromwhere;
	}
	public void setFrom(String fromwhere) {
		this.fromwhere = fromwhere;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getWebname() {
		return webname;
	}
	public void setWebname(String webname) {
		this.webname = webname;
	}
	public String getVideoname() {
		return videoname;
	}
	public void setVideoname(String videoname) {
		this.videoname = videoname;
	}

}
