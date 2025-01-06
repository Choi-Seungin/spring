package com.kh.dto;

import java.io.File;

public class BoardFileDTO {
	private int fno;
	private int bno;
	private String fpath;

	public String getFileName() {
		return new File(fpath).getName();
	}

	public BoardFileDTO() {
		super();
	}

	public BoardFileDTO(int fno, int bno, String fpath) {
		super();
		this.fno = fno;
		this.bno = bno;
		this.fpath = fpath;
	}

	public int getFno() {
		return fno;
	}

	public void setFno(int fno) {
		this.fno = fno;
	}

	public int getBno() {
		return bno;
	}

	public void setBno(int bno) {
		this.bno = bno;
	}

	public String getFpath() {
		return fpath;
	}

	public void setFpath(String fpath) {
		this.fpath = fpath;
	}

}
