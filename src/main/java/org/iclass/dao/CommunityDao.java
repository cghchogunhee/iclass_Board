package org.icalss.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.iclass.vo.Community;
import org.iclass.vo.CommunityComments;

import mybatis.SqlSessionBean;

public class CommunityDao {
	private static final CommunityDao dao = new CommunityDao();
	private CommunityDao() {};
	public static CommunityDao getInstance() {
		return dao;
	}
	
	public Community selectByIdx(int idx) {
		SqlSession mapper = SqlSessionBean.getSession();
		Community vo = mapper.selectOne("community.selectByIdx",idx);
		mapper.close();
		return vo;
	}
	public List<Community>selectAll(){
		SqlSession mapper = SqlSessionBean.getSession();
		List<Community>list=mapper.selectList("community.selectAll");
		mapper.close();
		return list;
	}
	public long insert(Community vo) {
		SqlSession mapper = SqlSessionBean.getSession();
		long result = mapper.insert("community.insert",vo);
		mapper.commit();
		mapper.close();
		return result;
	}
	public int update(Community vo) {
		SqlSession mapper = SqlSessionBean.getSession();
		int result = mapper.update("community.update",vo);
		mapper.commit();
		mapper.close();
		return result;
	}
	public int delete(int idx) {
		SqlSession mapper = SqlSessionBean.getSession();
		int result = mapper.delete("community.delete",idx);
		mapper.commit();
		mapper.close();
		return result;
	}
	public int count() {
		SqlSession mapper = SqlSessionBean.getSession();
		int result = mapper.selectOne("community.count");
		mapper.commit();
		mapper.close();
		return result;
	}
	public int maxOf(Community vo) {
		SqlSession mapper = SqlSessionBean.getSession();
		int result = mapper.selectOne("community.maxOf",vo);
		mapper.commit();
		mapper.close();
		return result;
	}
	public int setReadCount(int idx) {
		SqlSession mapper = SqlSessionBean.getSession();
		int result = mapper.update("community.setReadCount", idx);
		mapper.commit();
		mapper.close();
		return result;
	}
	
	public int commentsCount(int mref) {
		SqlSession session = SqlSessionBean.getSession();
		int result = session.selectOne("community.commentsCount", mref);
		session.close();
		return result;
	}
	
	public int setCommentCount(int idx) {
		SqlSession mapper = SqlSessionBean.getSession();
		int result = mapper.update("community.setCommentCount", idx);
		mapper.commit();
		mapper.close();
		return result;
	}
	//mref 메인글의 댓글목록 가져오기
		public List<CommunityComments> comments(int mref){
			SqlSession mapperSession = SqlSessionBean.getSession();
			List<CommunityComments> commentList = mapperSession.selectList("community.comments",mref);
			mapperSession.close();
			return commentList;
		}
	
}
