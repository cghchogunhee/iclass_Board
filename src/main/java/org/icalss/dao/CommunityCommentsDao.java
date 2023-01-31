package org.icalss.dao;


import org.apache.ibatis.session.SqlSession;
import org.iclass.vo.CommunityComments;

import mybatis.SqlSessionBean;

public class CommunityCommentsDao {
	private static final CommunityCommentsDao dao = new CommunityCommentsDao();
	private CommunityCommentsDao() {};
	public static CommunityCommentsDao getInstance() {
		return dao;
	}
	
	public int insert(CommunityComments vo) {
		SqlSession mapper = SqlSessionBean.getSession();
		int result = mapper.insert("insert",vo);
		mapper.commit();
		mapper.close();
		return result;
	}
	public int delete(int idx) {
		SqlSession mapper = SqlSessionBean.getSession();
		int result = mapper.delete("delete",idx);
		mapper.commit();
		mapper.close();
		return result;
	}
}
