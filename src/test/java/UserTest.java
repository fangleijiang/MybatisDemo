import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.map.HashedMap;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.dao.UserDao;
import com.dao.impl.UserDaoImpl;
import com.model.PageBean;
import com.model.User;
import com.util.MybatisUtil;

public class UserTest {
	
	UserDao userdao  = new UserDaoImpl();

	@Test
	public void getUserById() throws IOException {
		User user = this.userdao.getUserById(1);
		System.out.println(JSON.toJSONString(user));
	}

	@Test
	public void addUser() throws IOException {
		User user = new User();
		user.setUsername("fangsir33");
		user.setPassword("67890");
		this.userdao.add(user);
	}

	@Test
	public void update() throws IOException {
		User user = new User();
		user.setUsername("fangsir44");
		user.setPassword("67890");
		user.setId(15);
		this.userdao.update(user);
	}
	
	@Test
	public void delete() throws IOException {
		this.userdao.delete(15);
	}
	
	@Test
	public void listAll(){
			List<User> list  =  this.userdao.listAll();
			System.out.println(JSON.toJSONString(list));
	}
	
	@Test
	public void pageUser(){
		List<User> list = this.userdao.pageUser(3, 5);
		System.out.println(JSON.toJSONString(list));
	}
}
