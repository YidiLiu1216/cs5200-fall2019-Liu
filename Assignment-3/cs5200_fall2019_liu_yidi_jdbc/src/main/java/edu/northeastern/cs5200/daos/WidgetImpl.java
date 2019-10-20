package edu.northeastern.cs5200.daos;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import edu.northeastern.cs5200.Connection;
import edu.northeastern.cs5200.models.HeadingWidget;
import edu.northeastern.cs5200.models.HtmlWidget;
import edu.northeastern.cs5200.models.ImageWidget;
import edu.northeastern.cs5200.models.Page;
import edu.northeastern.cs5200.models.Phone;
import edu.northeastern.cs5200.models.Widget;
import edu.northeastern.cs5200.models.YouTubeWidget;

public interface WidgetImpl {
  default void createWidgetForPage(int pageId, Widget widget) {
	  String create_widget="insert into widget(id,widget.name,width,height,cssClass,cssStyle,widget.text,widget.order,dtype,widget.page,url,shareble,expandable,src,size,html)values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	  try {
			PreparedStatement statement = Connection.getConnection().prepareStatement(create_widget);
			statement.setLong(1,widget.getId());
			statement.setString(2,widget.getName());
			statement.setInt(3,widget.getWidth());
			statement.setInt(4,widget.getHeight());
			statement.setString(5,widget.getCssclass());
			statement.setString(6,widget.getCssstyle());
			statement.setString(7,widget.getText());
			statement.setInt(8, widget.getOrder());
			if (widget.getHeadingwidgets().size()!=0){
				statement.setString(9, "heading");
				statement.setString(11, null);
				statement.setBoolean(12, false);
				statement.setBoolean(13, false);
				statement.setString(14, null);
				statement.setString(16, null);
				Iterator<HeadingWidget> t = widget.getHeadingwidgets().iterator();
				statement.setInt(15, t.next().getSize());
				}else if(widget.getHtmlwidgets().size()!=0) {
					statement.setString(9, "html");
					Iterator<HtmlWidget> t = widget.getHtmlwidgets().iterator();
					statement.setString(11, null);
					statement.setInt(12, 0);
					statement.setInt(13, 0);
					statement.setString(14, null);
					statement.setInt(15, 0);
					statement.setString(16, t.next().getHtml());
				}else if (widget.getYoutubewidgets().size()!=0) {
					statement.setString(9, "youtube");
					Iterator<YouTubeWidget> t = widget.getYoutubewidgets().iterator();
					YouTubeWidget y = t.next();
					statement.setString(11,y.getUrl());
					statement.setBoolean(12,y.getShareble());
					statement.setBoolean(13,y.getExpandable());
					statement.setString(14, null);
					statement.setInt(15, 0);
					statement.setString(16, null);
				}else if(widget.getImagewidgets().size()!=0) {
					statement.setString(11, null);
					statement.setInt(12, 0);
					statement.setInt(13, 0);
					statement.setInt(15, 0);
					statement.setString(16, null);
					statement.setString(9, "image");
					Iterator<ImageWidget> t = widget.getImagewidgets().iterator();
					statement.setString(14, t.next().getSrc());
				}
			statement.setInt(10, pageId);
			statement.executeUpdate();
			Connection.closeConnection();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}			
  }
  default  Collection<Widget> findAllWidgets() {
	  Statement statement;
	  ArrayList<Widget> w = new ArrayList<Widget>();
		try {
			statement = Connection.getConnection().createStatement();
			String find_person="SELECT * from widget";
		    ResultSet  result = statement.executeQuery(find_person);
		    while (result.next()) {
		    	    Widget w1=new Widget(result.getInt("id"),result.getString("name"),result.getInt("width"),result.getInt("height"),result.getString("cssClass"),result.getString("cssStyle"),
		    			result.getString("text"),result.getInt("order"));
		    	    w1.setPage(result.getInt("page"));
		    	if(result.getString("dtype")=="heading") {
		    		HeadingWidget hw=new HeadingWidget();
			    	hw.setSize(result.getInt("size"));
			    	w1.addHeadingWidget(hw);
		    	}
		    	else if(result.getString("dtype")=="html") {
		    		HtmlWidget hw=new HtmlWidget();
			    	hw.setHtml(result.getString("html"));
			    	w1.addHtmlWidget(hw);
		    	}
		    	else if(result.getString("dtype")=="image") {
		    		ImageWidget hw=new ImageWidget();
			    	hw.setSrc(result.getString("src"));
			    	w1.addImageWidget(hw);
		    	}
		    	else if(result.getString("dtype")=="youtube") {
		    		YouTubeWidget hw=new YouTubeWidget();
			    	hw.setUrl(result.getString("url"));
			    	hw.setShareble(result.getBoolean("shareble"));
			    	hw.setExpandable(result.getBoolean("expandable"));
			    	w1.addYouTubeWidget(hw);
		    	}
		    	w.add(w1);
		    }
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		Connection.closeConnection();
	  return w;
  }
  default Widget findWidgetById(int widgetId) {
	  Statement statement;
	  Widget w1=null;
		try {
			statement = Connection.getConnection().createStatement();
			String find_person="SELECT * from widget where widget.id="+widgetId;
		    ResultSet  result = statement.executeQuery(find_person);
		    while (result.next()) {
		    	    w1=new Widget(result.getInt("id"),result.getString("name"),result.getInt("width"),result.getInt("height"),result.getString("cssClass"),result.getString("cssStyle"),
		    			result.getString("text"),result.getInt("order"));
		    	    w1.setPage(result.getInt("page"));
		    	if(result.getString("dtype")=="heading") {
		    		HeadingWidget hw=new HeadingWidget();
			    	hw.setSize(result.getInt("size"));
			    	w1.addHeadingWidget(hw);
		    	}
		    	else if(result.getString("dtype")=="html") {
		    		HtmlWidget hw=new HtmlWidget();
			    	hw.setHtml(result.getString("html"));
			    	w1.addHtmlWidget(hw);
		    	}
		    	else if(result.getString("dtype")=="image") {
		    		ImageWidget hw=new ImageWidget();
			    	hw.setSrc(result.getString("src"));
			    	w1.addImageWidget(hw);
		    	}
		    	else if(result.getString("dtype")=="youtube") {
		    		YouTubeWidget hw=new YouTubeWidget();
			    	hw.setUrl(result.getString("url"));
			    	hw.setShareble(result.getBoolean("shareble"));
			    	hw.setExpandable(result.getBoolean("expandable"));
			    	w1.addYouTubeWidget(hw);
		    	}
		    }
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		Connection.closeConnection();
	  return w1; 
  }
  default Collection<Widget> findWidgetsForPage(int pageId) {
	  Statement statement;
		ArrayList<Widget> w = new ArrayList<Widget>();
		try {
			statement = Connection.getConnection().createStatement();
			String find_person="SELECT * from widget where widget.page="+pageId;
		    ResultSet  result = statement.executeQuery(find_person);
		    while (result.next()) {
		    	Widget w1=new Widget(result.getInt("id"),result.getString("name"),result.getInt("width"),result.getInt("height"),result.getString("cssClass"),result.getString("cssStyle"),
		    			result.getString("text"),result.getInt("order"));
		    	w1.setPage(result.getInt("page"));
		    	if(result.getString("dtype")=="heading") {
		    		HeadingWidget hw=new HeadingWidget();
			    	hw.setSize(result.getInt("size"));
			    	w1.addHeadingWidget(hw);
		    	}
		    	else if(result.getString("dtype")=="html") {
		    		HtmlWidget hw=new HtmlWidget();
			    	hw.setHtml(result.getString("html"));
			    	w1.addHtmlWidget(hw);
		    	}
		    	else if(result.getString("dtype")=="image") {
		    		ImageWidget hw=new ImageWidget();
			    	hw.setSrc(result.getString("src"));
			    	w1.addImageWidget(hw);
		    	}
		    	else if(result.getString("dtype")=="youtube") {
		    		YouTubeWidget hw=new YouTubeWidget();
			    	hw.setUrl(result.getString("url"));
			    	hw.setShareble(result.getBoolean("shareble"));
			    	hw.setExpandable(result.getBoolean("expandable"));
			    	w1.addYouTubeWidget(hw);
		    	}
		        w.add(w1);
		    }
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		Connection.closeConnection();
	  return w;
  }
  default int updateWidget(int widgetId, Widget widget) {
	  Statement statement;
	    try {
			statement = Connection.getConnection().createStatement();
			String find_person="update widget set widget.name='"+widget.getName()
			+"',widget.width="+widget.getWidth()+
			",widget.height="+widget.getHeight()+
			",widget.cssClass='"+widget.getCssclass()+
			"',widget.cssStyle='"+widget.getCssstyle()+"',widget.text='"+widget.getText()+
			"',widget.order="+widget.getOrder()+",widget.page="+widget.getPage()+
			" where widget.id="+widgetId;
			statement.executeUpdate(find_person);
			if(widget.getHeadingwidgets().size()!=0) {
	        	Iterator<HeadingWidget> t = widget.getHeadingwidgets().iterator();
	        	while(t.hasNext()) {
				  HeadingWidget temp=t.next();
				  String create_phone="update widget set dtype='heading',widget.size="+temp.getSize()+"where widget.id="+widgetId;
				  statement.executeUpdate(create_phone);
				}
			}
			if(widget.getHtmlwidgets().size()!=0) {
	        	Iterator<HtmlWidget> t = widget.getHtmlwidgets().iterator();
	        	while(t.hasNext()) {
				  HtmlWidget temp=t.next();
				  String create_phone="update widget set dtype='html',widget.html='"+temp.getHtml()+"'where widget.id="+widgetId;
				  statement.executeUpdate(create_phone);
				}
			}
			if(widget.getImagewidgets().size()!=0) {
	        	Iterator<ImageWidget> t = widget.getImagewidgets().iterator();
	        	while(t.hasNext()) {
				  ImageWidget temp=t.next();
				  String create_phone="update widget set dtype='image',widget.src='"+temp.getSrc()+"'where widget.id="+widgetId;
				  statement.executeUpdate(create_phone);
				}
			}
			if(widget.getYoutubewidgets().size()!=0) {
	        	Iterator<YouTubeWidget> t = widget.getYoutubewidgets().iterator();
	        	while(t.hasNext()) {
				  YouTubeWidget temp=t.next();
				  String create_phone="update widget set dtype='youtube',widget.url='"+temp.getUrl()+
						  "',widget.sharble="+temp.getShareble()+",widget.expandable"+temp.getExpandable()+
						  "where widget.id="+widgetId;
				  statement.executeUpdate(create_phone);
				}
			}
		    return statement.executeUpdate(find_person);

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    Connection.closeConnection();
		 return-1;
  }
  default int deleteWidget(int widgetId) {
	  Statement statement;
		 try {
				statement = Connection.getConnection().createStatement();
				String find_person="delete from widget where widget.id="+widgetId;
			    return statement.executeUpdate(find_person);

			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 Connection.closeConnection();
	     return-1;
	}

 }
