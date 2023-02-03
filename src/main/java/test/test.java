package test;

import org.iclass.dao.CommunityDao;

public class test {

	public static void main(String[] args) {
		CommunityDao dao = CommunityDao.getInstance();
		System.out.println(dao.count());
		System.out.println(dao.selectAll());
	}

}
