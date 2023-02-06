package org.iclass.dao;

import java.util.List;
import java.util.Map;

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
	
	public Community selectByIdx(long idx) {
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
	public int delete(long idx) {
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
	public int setReadCount(long idx) {
		SqlSession mapper = SqlSessionBean.getSession();
		int result = mapper.update("community.setReadCount", idx);
		mapper.commit();
		mapper.close();
		return result;
	}
	
	public int commentsCount(long mref) {
		SqlSession session = SqlSessionBean.getSession();
		int result = session.selectOne("community.commentsCount");
		session.close();
		return result;
	}
	
	
	//mref 메인글의 댓글목록 가져오기
		public List<CommunityComments> comments(long mref){
			SqlSession mapperSession = SqlSessionBean.getSession();
			List<CommunityComments> commentList = mapperSession.selectList("community.comments",mref);
			mapperSession.close();
			return commentList;
		}
		//메인글 목록 가져오기 - 할일 : 한번에(즉 한페이지에) 글 10개씩 가져오도록 변경  
		public List<Community> pagelist(Map<String,Integer> map) {
			SqlSession mapperSession = SqlSessionBean.getSession();
			List<Community> list = mapperSession.selectList("community.pagelist",map);
			mapperSession.close();
			return list;
		}
}
