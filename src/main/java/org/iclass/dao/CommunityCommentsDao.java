package org.iclass.dao;


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
		int result = mapper.insert("communityComments.insert",vo);
		mapper.commit();
		mapper.close();
		return result;
	}
	public int delete(int idx) {
		SqlSession mapper = SqlSessionBean.getSession();
		int result = mapper.delete("communityComments.delete",idx);
		mapper.commit();
		mapper.close();
		return result;
	}
	public int maxOf(CommunityComments vo) {
		SqlSession mapper = SqlSessionBean.getSession();
		int result = mapper.selectOne("communityComments.maxOf",vo);
		mapper.commit();
		mapper.close();
		return result;
	}
	
	public int setCommentCount(long idx) {
		SqlSession mapper = SqlSessionBean.getSession();
		int result = mapper.update("community.setCommentCount", idx);
		mapper.commit();
		mapper.close();
		return result;
	}
}