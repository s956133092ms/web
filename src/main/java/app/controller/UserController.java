package app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import app.dao.UserDao;
import app.user.User;

@RestController
public class UserController {
	@Autowired 
	private UserDao userdao;
	
	@RequestMapping(value = "/getall")   
	public Object getAllUser() {     
		List<User> list = (List<User>) userdao.findAll();     
		if (null == list || list.size() == 0) {       
			return "暂无数据";     
			} 
		else {       
			return list;     
			}     
		}
	
	@RequestMapping(value="/webname",method = RequestMethod.POST)
	public Object getVideo(String webname){//根据网站名得到视频列表
		List<User> list=(List<User>) userdao.findByWebname(webname);
		if(webname==null){
			return "nameerror";
		}
		else{
			if(list == null || list.size() == 0){
				return "nodata";
			}
			else{
				return list;
			}
		}
		
	}
	
	@RequestMapping(value="/sum")
	public Object getsum(String webname){//根据网站名得到视频数量
		List<User> list=(List<User>) userdao.findByWebname(webname);
		if(webname==null){
			return "nameerror";
		}
		else{
			if(list == null || list.size() == 0){
				return "nodata";
			}
			else{
				return list.size();
			}
		}
		
	}
	
	@RequestMapping(value="/add")
	public String add(String webname,String videoname,String fromwhere){
		User list=(User) userdao.findByVideoname(videoname); 
		
		if (null == list) {       
			list = new User();         
			} 
		else{
			return "exist";
		}
		
		list.setWebname(webname);     
		list.setVideoname(videoname);  
		list.setFrom(fromwhere);
		
		User resultUser = userdao.save(list);    
		
		if (null == resultUser) {       
			return "repeat";     
			} 
		else {       
			return "success";     
			}      
	}
	
	@RequestMapping(value = "/delete")   
	public Object delete(String videoname) {   
		User video = userdao.findByVideoname(videoname);
		int id;
		if (null == video) {
			return "没找到该用户";     
			}
		else {   
			id = video.getId(); 
			userdao.delete(id);       
			return "删除用户成功" ;     
			}     
		}  
	
	@RequestMapping(value="/change")
	public Object change(String webname,String videoname,String pagetime,String collecttime,String fromwhere){
		User list = userdao.findByVideoname(videoname);
		
		if(list ==null) return "error";
		else{
		if(webname!=null) list.setWebname(webname);  
		if(videoname!=null) list.setVideoname(videoname);   
		if(fromwhere!=null) list.setFrom(fromwhere); 
		if(pagetime!=null) list.setPagetime(pagetime);
		if(collecttime!=null) list.setTime(collecttime);
		
        User resultUser = userdao.save(list);    
		
		if (null == resultUser) {       
			return "fail";     
			} 
		else {       
			return "success";     
			} 
		}
	}
	

}
