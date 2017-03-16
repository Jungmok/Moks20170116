package com.newlecture.web.data.view;

import com.newlecture.web.data.entity.Notice;

public class NoticeView extends Notice{
	String WriterName;
	int CommentCount;
	
	public String getWriterName() {
		return WriterName;
	}
	public void setWriterName(String writerName) {
		WriterName = writerName;
	}
	public int getCommentCount() {
		return CommentCount;
	}
	public void setCommentCount(int commentCount) {
		CommentCount = commentCount;
	}
	
}
