package com.dao;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.session.SqlSession;
import com.model.PageBean;
import com.util.MybatisUtil;

public class BaseDao<T> {
	public T getObjectById(int id, T obj) {
		try {
			SqlSession session = MybatisUtil.getSession();
			obj = session.selectOne(
					obj.getClass().getName() + ".getObjectById", id);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			MybatisUtil.closeSession();
		}
		return obj;
	}

	public void add(T obj) {
		try {
			SqlSession session = MybatisUtil.getSession();
			session.insert(obj.getClass().getName() + ".add", obj);
			session.commit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			MybatisUtil.closeSession();
		}
	}

	public void update(T obj) {
		try {
			SqlSession session = MybatisUtil.getSession();
			session.update(obj.getClass().getName()+".update",obj);
			session.commit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			MybatisUtil.closeSession();
		}
	}

	public void delete(int id,T obj) {
		try {
			SqlSession session = MybatisUtil.getSession();
			session.delete(obj.getClass().getName()+".delete",id);
			session.commit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			MybatisUtil.closeSession();
		}
	}

	public List<T> listAll(T obj) {
		SqlSession session;
		List<T> list = null;
		try {
			session = MybatisUtil.getSession();
			list = session.selectList(obj.getClass().getName()+".listAll");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			MybatisUtil.closeSession();
		}
		return list;
	}

	@SuppressWarnings("unchecked")
	public List<T> pager(T obj,int page,int pageSize) {
		List<T> list = null;
		try {
			SqlSession session = MybatisUtil.getSession();
			int Allrow = session.selectOne(obj.getClass().getName()+".allRow");
			int totalPage = PageBean.countTotalPage(pageSize, Allrow);
			final int offset  = PageBean.currentOffset(pageSize, page);
			final int currentPage = PageBean.countCurrentPage(page);
			@SuppressWarnings("rawtypes")
			Map map = new HashMap();
			map.put("offset", offset);
			map.put("pageSize", pageSize);
			list = session.selectList(obj.getClass().getName()+".pager",map);
			PageBean pageBean = new PageBean();
			pageBean.setPageSize(pageSize);
			pageBean.setCurrentPage(currentPage);
			pageBean.setAllRow(Allrow);
			pageBean.setTotalPage(totalPage);
			pageBean.setList(list);
			pageBean.init();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

}
