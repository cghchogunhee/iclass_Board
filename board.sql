CREATE TABLE community(
	idx number(10)NOT NULL,
	writer varchar2(50)NOT NULL,
	title varchar2(100)NOT NULL,
	content varchar2(3000)NOT NULL,
	readCount number(10)default'0',
	createdAt DATE default sysdate,
	ip varchar2(15)default '127.0.0.1',
	commentCount number(10) default '0',
	PRIMARY key(idx)
);

CREATE SEQUENCE community_idx_seq;

CREATE TABLE communityComments(
	idx number(10)NOT NULL,
	mref number(10)NOT NULL,
	writer varchar2(50)NOT NULL,
	content varchar2(1000)NOT NULL,
	createdAt DATE default sysdate,
	ip varchar2(15)default '127.0.0.1',
	commentCount number(10) default '0',
	PRIMARY key(idx)
);
CREATE SEQUENCE comment_idx_seq;

-- 데이터 샘플 추가
INSERT INTO community (idx,writer,title,content)
VALUES (community_idx_seq.nextval, '김모모','알립니다.','오늘 모임 변경안내입니다.');
INSERT INTO community (idx,writer,title,content)
VALUES (community_idx_seq.nextval, '최사나','공지','공지공지');
INSERT INTO community (idx,writer,title,content)
VALUES (community_idx_seq.nextval, '박세리','하이','하이하이!!');
INSERT INTO community (idx,writer,title,content)
VALUES (community_idx_seq.nextval, '김땡땡','이벤트','이벤트 안내입니다.');
INSERT INTO community (idx,writer,title,content)
VALUES (community_idx_seq.nextval, '강감찬','재공지','재공지재공지');
INSERT INTO community (idx,writer,title,content)
VALUES (community_idx_seq.nextval, '이사나','정회원 공지','정회원 안내입니다.');
INSERT INTO community (idx,writer,title,content)
VALUES (community_idx_seq.nextval, '이사나','정회원 공55지','정회원 안내입니다.');
INSERT INTO community (idx,writer,title,content)
VALUES (community_idx_seq.nextval, '이사나','정회원 공66지','정회원 안내입니다.');
INSERT INTO community (idx,writer,title,content)
VALUES (community_idx_seq.nextval, '이사나','정회원 공77지','정회원 안내입니다.');
INSERT INTO community (idx,writer,title,content)
VALUES (community_idx_seq.nextval, '이사나','정회원 공88지','정회원 안내입니다.');
SELECT * FROM community f 
ORDER BY IDX ASC ;

-- 댓글 테이블 데이터
INSERT INTO communityComments (idx,mref,writer,content)
VALUES (comment_idx_seq.nextval,3,'이하니','이글은 메인글 3번 댓글~');
INSERT INTO communityComments (idx,mref,writer,content)
VALUES (comment_idx_seq.nextval,3,'김땡땡','이글은 메인글 3번 댓글~2');
INSERT INTO communityComments (idx,mref,writer,content)
VALUES (comment_idx_seq.nextval,1,'이하니','이글은 메인글 333번 댓글~');
INSERT INTO communityComments (idx,mref,writer,content)
VALUES (comment_idx_seq.nextval,9,'김땡땡','이글은 메인글 333번 댓글~2');
INSERT INTO communityComments (idx,mref,writer,content)
VALUES (comment_idx_seq.nextval,9,'김땡땡','하이!!!하이~~');
SELECT *FROM communityComments ;