package test;

import static org.junit.jupiter.api.Assertions.*;

import org.icalss.dao.CommunityDao;
import org.junit.jupiter.api.Test;

class CommuntiyTest {
	private CommunityDao dao = CommunityDao.getInstance();
	@Test
	void test() {
		fail("Not yet implemented");
	}
	@Test
	void selectList() {
		assertEquals(dao.selectAll().size(), 10);
	}

}
