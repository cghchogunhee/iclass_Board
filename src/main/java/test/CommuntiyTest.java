package test;

import static org.junit.jupiter.api.Assertions.*;

import org.icalss.dao.CommunityCommentsDao;
import org.icalss.dao.CommunityDao;
import org.iclass.vo.Community;
import org.junit.jupiter.api.Test;

class CommuntiyTest {
	CommunityDao communityDao = CommunityDao.getInstance();
	CommunityCommentsDao commentsDao = CommunityCommentsDao.getInstance();
	@Test
	void test() {
		fail("Not yet implemented");
	}
	@Test
	void selectList() {
		assertEquals(communityDao.selectAll().size(), 10);
	}
	@Test
	void update() {
		int result = communityDao.update(Community.builder().idx(10)
				.writer("크크크")
				.title("카카카카")
				.content("호로록")
				.build());
		assertEquals(result, 1);
	}
	@Test
	void count() {
		int result=communityDao.count();
		assertEquals(result, 10);
	}

}
