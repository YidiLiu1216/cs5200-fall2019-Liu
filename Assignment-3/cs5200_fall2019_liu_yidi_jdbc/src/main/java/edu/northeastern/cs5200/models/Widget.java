package edu.northeastern.cs5200.models;

import java.util.ArrayList;
import java.util.Collection;

public class Widget {
 public Widget(int id, String name, int width, int height, String cssclass, String cssstyle, String text, int order) {
		super();
		this.id=id;
		this.name = name;
		this.width = width;
		this.height = height;
		this.cssclass = cssclass;
		this.cssstyle = cssstyle;
		this.text = text;
		this.order = order;
		this.headingwidgets=new ArrayList<HeadingWidget>();
		this.htmlwidgets=new ArrayList<HtmlWidget>();
		this.youtubewidgets=new ArrayList<YouTubeWidget>();
		this.imagewidgets=new ArrayList<ImageWidget>();
	}
public Widget() {
	
}
private int id;
 private String name;
 private int width;
 private int height;
 private String cssclass;
 private String cssstyle;
 private String text;
 private int order;
 private int page;
 private Collection<HeadingWidget> headingwidgets;
 private Collection<HtmlWidget> htmlwidgets;
 private Collection<YouTubeWidget> youtubewidgets;
 private Collection<ImageWidget> imagewidgets;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public int getWidth() {
	return width;
}
public void setWidth(int width) {
	this.width = width;
}
public int getHeight() {
	return height;
}
public void setHeight(int height) {
	this.height = height;
}
public String getCssclass() {
	return cssclass;
}
public void setCssclass(String cssclass) {
	this.cssclass = cssclass;
}
public String getCssstyle() {
	return cssstyle;
}
public void setCssstyle(String cssstyle) {
	this.cssstyle = cssstyle;
}
public String getText() {
	return text;
}
public void setText(String text) {
	this.text = text;
}
public int getOrder() {
	return order;
}
public void setOrder(int order) {
	this.order = order;
}
public Collection<HeadingWidget> getHeadingwidgets() {
	return headingwidgets;
}
public void setHeadingwidgets(Collection<HeadingWidget> headingwidgets) {
	this.headingwidgets = headingwidgets;
}
public Collection<HtmlWidget> getHtmlwidgets() {
	return htmlwidgets;
}
public void setHtmlwidgets(Collection<HtmlWidget> htmlwidgets) {
	this.htmlwidgets = htmlwidgets;
}
public Collection<YouTubeWidget> getYoutubewidgets() {
	return youtubewidgets;
}
public void setYoutubewidgets(Collection<YouTubeWidget> youtubewidgets) {
	this.youtubewidgets = youtubewidgets;
}
public Collection<ImageWidget> getImagewidgets() {
	return imagewidgets;
}
public void setImagewidgets(Collection<ImageWidget> imagewidgets) {
	this.imagewidgets = imagewidgets;
}


public void addHeadingWidget(HeadingWidget headingwidget) {
	   headingwidgets.add(headingwidget);
}
public void removeHeadingWidget(HeadingWidget headingwidget) {
	   headingwidgets.remove(headingwidget);
}
public void addHtmlWidget(HtmlWidget htmlwidget) {
	   htmlwidgets.add(htmlwidget);
}
public void removeHtmlWidget(HtmlWidget htmlwidget) {
	   htmlwidgets.remove(htmlwidget);
}
public void addYouTubeWidget(YouTubeWidget youtubewidget) {
	   youtubewidgets.add(youtubewidget);
}
public void removeYouTubeWidget(YouTubeWidget youtubewidget) {
	   youtubewidgets.remove(youtubewidget);
}
public void addImageWidget(ImageWidget imagewidget) {
	   imagewidgets.add(imagewidget);
}
public void removeImageWidget(ImageWidget imagewidget) {
	   imagewidgets.remove(imagewidget);
}
public int getPage() {
	return page;
}
public void setPage(int page) {
	this.page = page;
}
}
