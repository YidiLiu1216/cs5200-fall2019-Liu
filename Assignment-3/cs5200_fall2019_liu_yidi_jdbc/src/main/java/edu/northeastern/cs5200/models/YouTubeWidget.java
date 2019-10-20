package edu.northeastern.cs5200.models;

public class YouTubeWidget {
  private String url;
  private Boolean shareble=false;
  private Boolean expandable=false;
  private Widget widget;
public String getUrl() {
	return url;
}
public void setUrl(String url) {
	this.url = url;
}
public Boolean getShareble() {
	return shareble;
}
public void setShareble(Boolean shareble) {
	this.shareble = shareble;
}
public Boolean getExpandable() {
	return expandable;
}
public void setExpandable(Boolean expandable) {
	this.expandable = expandable;
}
public Widget getWidget() {
	return widget;
}
public void setWidget(Widget widget) {
	this.widget = widget;
}
  
}
