import org.junit.Test;

import com.dao.RoleDao;
import com.dao.impl.RoleDaoImpl;
import com.model.Role;


public class RoleTest {

	RoleDao roledao = new RoleDaoImpl();
	
	@Test
	public void add(){
		Role role = new Role();
		role.setText("��������Ա");
		this.roledao.add(role);
	}
	
}
