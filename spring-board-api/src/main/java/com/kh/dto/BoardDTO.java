package com.kh.dto;

public class BoardDTO {
	private int bno;
	private String id;
	private String nickName;
	private String title;
	private String writeDate;
	private String writeUpdateDate;
	private int bcount;
	private String content;
	private int blike;
	private int bhate;

	public BoardDTO() {
	}

	public BoardDTO(int bno, String id, String nickName, String title, String writeDate, String writeUpdateDate,
			int bcount, String content, int blike, int bhate) {
		super();
		this.bno = bno;
		this.id = id;
		this.nickName = nickName;
		this.title = title;
		this.writeDate = writeDate;
		this.writeUpdateDate = writeUpdateDate;
		this.bcount = bcount;
		this.content = content;
		this.blike = blike;
		this.bhate = bhate;
	}

	public int getBno() {
		return bno;
	}

	public void setBno(int bno) {
		this.bno = bno;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getWriteDate() {
		return writeDate;
	}

	public void setWriteDate(String writeDate) {
		this.writeDate = writeDate;
	}

	public String getWriteUpdateDate() {
		return writeUpdateDate;
	}

	public void setWriteUpdateDate(String writeUpdateDate) {
		this.writeUpdateDate = writeUpdateDate;
	}

	public int getBcount() {
		return bcount;
	}

	public void setBcount(int bcount) {
		this.bcount = bcount;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getBlike() {
		return blike;
	}

	public void setBlike(int blike) {
		this.blike = blike;
	}

	public int getBhate() {
		return bhate;
	}

	public void setBhate(int bhate) {
		this.bhate = bhate;
	}

	@Override
	public String toString() {
		return "BoardDTO [bno=" + bno + ", id=" + id + ", nickName=" + nickName + ", title=" + title + ", writeDate="
				+ writeDate + ", writeUpdateDate=" + writeUpdateDate + ", bcount=" + bcount + ", content=" + content
				+ ", blike=" + blike + ", bhate=" + bhate + "]";
	}

}
