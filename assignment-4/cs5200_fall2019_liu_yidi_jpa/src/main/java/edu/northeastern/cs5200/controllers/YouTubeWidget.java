package edu.northeastern.cs5200.controllers;

import javax.persistence.*;

@Entity
public class YouTubeWidget extends Widget{
  private String YouTube;

public String getYouTube() {
	return YouTube;
}

public void setYouTube(String youTube) {
	YouTube = youTube;
}
}
