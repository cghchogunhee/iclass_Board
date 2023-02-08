package org.iclass.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.iclass.vo.NewBooks;

import mybatis.SqlSessionBean;

public class NewBooksDao {
	private static final NewBooksDao dao = new NewBooksDao();
	private NewBooksDao() {};
	public static NewBooksDao getInstance() {
		return dao;
	}
	public List<NewBooks>selectAll(){
		SqlSession mapper = SqlSessionBean.getSession();
		List<NewBooks>list=mapper.selectList("books.selectAll");
		mapper.close();
		return list;
	}
	public int insert(NewBooks vo) {
		SqlSession mapper = SqlSessionBean.getSession();
		int result = mapper.insert("books.insert",vo);
		mapper.commit();
		mapper.close();
		return result;
	}
}
