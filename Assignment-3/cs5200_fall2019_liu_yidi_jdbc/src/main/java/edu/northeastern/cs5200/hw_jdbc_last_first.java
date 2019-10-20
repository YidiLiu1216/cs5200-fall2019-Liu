package edu.northeastern.cs5200;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;

import edu.northeastern.cs5200.daos.DeveloperDao;
import edu.northeastern.cs5200.daos.PageDao;
import edu.northeastern.cs5200.daos.RoleDao;
import edu.northeastern.cs5200.daos.UserDao;
import edu.northeastern.cs5200.daos.WebsiteDao;
import edu.northeastern.cs5200.daos.WidgetDao;
import edu.northeastern.cs5200.models.Address;
import edu.northeastern.cs5200.models.Developer;
import edu.northeastern.cs5200.models.HeadingWidget;
import edu.northeastern.cs5200.models.HtmlWidget;
import edu.northeastern.cs5200.models.ImageWidget;
import edu.northeastern.cs5200.models.Page;
import edu.northeastern.cs5200.models.Phone;
import edu.northeastern.cs5200.models.User;
import edu.northeastern.cs5200.models.Website;
import edu.northeastern.cs5200.models.Widget;
import edu.northeastern.cs5200.models.YouTubeWidget;

public class hw_jdbc_last_first {
 //private static Connection conn;
 public void createdeveloper() {
	 Developer dev= new Developer("4321rewq",12,"Alice","Wonder","alice","alice@wonder.com",null,"123 Adam St","123-234-3456");
	 Developer dev1=new Developer("5432trew",23,"Bob","Marley","bob","bob@marley.com",null,"345 Charles St","345-456-5677");
	 Developer dev2=new Developer("6543ytre",34,"Charles","Garcia","charlie","chuch@garcia.com",null,"654 Frank St","321-432-5435");
	 DeveloperDao d=new DeveloperDao();
	 d.createDeveloper(dev);
	 d.createDeveloper(dev1);
	 d.createDeveloper(dev2);
 } 
 public void createuser() {
	 User u=new User(45,"Dan","Martin");
	 u.getPerson().setUsername("dan");
	 u.getPerson().setPassword("7654fda");
	 u.getPerson().setEmail("dan@martin.com");
	 User u1=new User(56,"Ed","Karaz");
	 u1.getPerson().setUsername("ed");
	 u1.getPerson().setPassword("5678dfgh");
	 u1.getPerson().setEmail("ed@kar.com");
	 UserDao ud= new UserDao();
	 ud.createUser(u);
	 ud.createUser(u1);
 }
 public void createwebsite() {
	 Website web=new Website(123,"Facebook","an online social media and social networking service",null,null,1234234);
	 Website web1=new Website(234,"Twitter","an online news and social networking service",null,null,4321543);
	 Website web2=new Website(345,"Wikipedia","a free online encyclopedia",null,null,3456654);
	 Website web3=new Website(456,"CNN","an American basic cable and satellite television news channel",null,null,6543345);
	 Website web4=new Website(567,"CNET"," an American media website that publishes reviews, news, articles, blogs, podcasts and videos on technology and consumer electronics ",null,null,543345);
	 Website web5=new Website(678,"Gizmodo","a design, technology, science and science fiction website that also writes articles on politics",null,null,4322345);
	 WebsiteDao w= new WebsiteDao();
	 w.createWebsiteForDeveloper(12, web);
	 w.createWebsiteForDeveloper(23, web1);
	 w.createWebsiteForDeveloper(34, web2);
	 w.createWebsiteForDeveloper(12, web3);
	 w.createWebsiteForDeveloper(23, web4);
	 w.createWebsiteForDeveloper(34, web5);
 }
 public void createpage() {
	 Page p = new Page(123,"Home","Landing page",null,null,123434);
	 Page p1 = new Page(234,"About","Website description",null,null,234545);
	 Page p2 = new Page(345,"Contact","Addresses, phones, and contact info",null,null,345656);
	 Page p3 = new Page(456,"Preferences","Where users can configure their preferences",null,null,456767);
	 Page p4 = new Page(567,"Profile","Users can configure their personal information",null,null,567878);
	 PageDao pdao=new PageDao();
	 pdao.createPageForWebsite(567, p);
	 pdao.createPageForWebsite(678, p1);
	 pdao.createPageForWebsite(345, p2);
	 pdao.createPageForWebsite(456, p3);
	 pdao.createPageForWebsite(567, p4);
 }
 public void createwidget(){
	 Widget wid = new Widget(1,"head123",0,0,null,null,"Welcome",0);
	 HeadingWidget hw=new HeadingWidget();
	 wid.addHeadingWidget(hw);
	 
	 Widget wid1 = new Widget(2,"post234",0,0,null,null,"<p>Lorem</p>",0);
	 HtmlWidget ht=new HtmlWidget();
	 wid1.addHtmlWidget(ht);
	 
	 Widget wid2 = new Widget(3,"head345",0,0,null,null,"Hi",1);
	 HeadingWidget hw1=new HeadingWidget();
	 wid2.addHeadingWidget(hw1);
	 
	 Widget wid3 = new Widget(4,"intro456",0,0,null,null,"<h1>Hi</h1>",2);
	 HtmlWidget ht1=new HtmlWidget();
	 wid3.addHtmlWidget(ht1);
	 
	 Widget wid4 = new Widget(5,"image345",50,100,null,null,null,3);
	 ImageWidget iw=new ImageWidget();
	 iw.setSrc("/img/567.png ");
	 wid4.addImageWidget(iw);
	 
	 Widget wid5 = new Widget(6,"video456",400,300,null,null,null,0);
	 YouTubeWidget yw=new YouTubeWidget();
	 yw.setUrl("https://youtu.be/h67VX51QXiQ ");
	 wid5.addYouTubeWidget(yw);
	 
	 WidgetDao w= new WidgetDao();
	 w.createWidgetForPage(123, wid);
	 w.createWidgetForPage(234, wid1);
	 w.createWidgetForPage(345, wid2);
	 w.createWidgetForPage(345, wid3);
	 w.createWidgetForPage(345, wid4);
	 w.createWidgetForPage(456, wid5);
 }
 public void createrole() {
	 RoleDao r = new RoleDao();
	 r.assignWebsiteRole(12, 123, 1);
	 r.assignWebsiteRole(23, 123, 4);
	 r.assignWebsiteRole(34, 123, 2);
	 r.assignWebsiteRole(23, 234, 1);
	 r.assignWebsiteRole(34, 234, 4);
	 r.assignWebsiteRole(12, 234, 2);
	 r.assignWebsiteRole(34, 345, 1);
	 r.assignWebsiteRole(12, 345, 4);
	 r.assignWebsiteRole(23, 345, 2);
	 r.assignWebsiteRole(12, 456, 1);
	 r.assignWebsiteRole(23, 456, 4);
	 r.assignWebsiteRole(34, 456, 2);
	 r.assignWebsiteRole(23, 567, 1);
	 r.assignWebsiteRole(34, 567, 4);
	 r.assignWebsiteRole(12, 567, 2);
	 r.assignWebsiteRole(34, 678, 1);
	 r.assignWebsiteRole(12, 678, 4);
	 r.assignWebsiteRole(23, 678, 2);
	 
	 r.assignPageRole(12, 123, 4);
	 r.assignPageRole(23, 123, 5);
	 r.assignPageRole(34, 123, 3);
	 r.assignPageRole(23, 234, 4);
	 r.assignPageRole(34, 234, 5);
	 r.assignPageRole(12, 234, 3);
	 r.assignPageRole(34, 345, 4);
	 r.assignPageRole(12, 345, 5);
	 r.assignPageRole(23, 345, 3);
	 r.assignPageRole(12, 456, 4);
	 r.assignPageRole(23, 456, 5);
	 r.assignPageRole(34, 456, 3);
	 r.assignPageRole(23, 567, 4);
	 r.assignPageRole(34, 567, 5);
	 r.assignPageRole(12, 567, 3);
 }
 public void updates1() {
	 DeveloperDao da=new DeveloperDao();
	 Developer d=da.findDeveloperByUsername("alice");
	 Iterator<Phone> t = d.getPerson().getPhones().iterator();
	 int pid=0;
	 Phone p=null;
	 while(t.hasNext()) {
		 p=t.next();
		 if (p.getPhone_pri()) {
			 pid=p.getId();
			 break;
		 }
	 }
	 d.getPerson().removePhone(p);
		p.setPhone("333-444-5555");
		d.getPerson().addPhone(p);
		da.updateDeveloper(d.getPerson().getId(),d);
 }
 public void updates2() {
	
	//update2
	WidgetDao wd= new WidgetDao();
	Collection<Widget>w=wd.findAllWidgets();
	Iterator<Widget> it_w = w.iterator();
	Widget wig=null;
	int page=-1;
	while(it_w.hasNext()) {
		wig=it_w.next();
		if(wig.getName().contentEquals("head345")) {
			page=wig.getPage();
			break;
		}
	}
	w=wd.findWidgetsForPage(page);
	it_w=w.iterator();
	Widget before=null;
	while(it_w.hasNext()) {
		before=it_w.next();
		if(before.getOrder()==3) {
			break;
		}
	}
	if(before!=null) {
		int mid=wig.getOrder();
		wig.setOrder(3);
		before.setOrder(mid);
		wd.updateWidget(before.getId(), before);
		wd.updateWidget(wig.getId(), wig);
	}else {
		wig.setOrder(3);
		wd.updateWidget(wig.getId(),wig);
	}
 }
 public void updates3() {
	 PageDao pd=new PageDao();
	 WebsiteDao wd=new WebsiteDao();
	 Collection<Website>wc=wd.findAllWebsites();
	 Iterator<Website> it_wc = wc.iterator();
	 Website web=null;
	 Page page=null;
	 while(it_wc.hasNext()) {
		 web=it_wc.next();
		 if(web.getName().equals("CNET")) {
			 break;
		 }
	 }
	 Collection<Page> pc=pd.findPagesForWebsite(web.getId());
	 Iterator<Page> it_pc=pc.iterator();
	 while(it_pc.hasNext()) {
		 page=it_pc.next();
		 page.setTitle("CNET-"+page.getTitle());
		 pd.updatePage(page.getId(), page);
	 }
 }
 public void updates4() {
	 DeveloperDao dd= new DeveloperDao();
	 RoleDao rd= new RoleDao();
	 PageDao pd=new PageDao();
	 Collection<Page>pg=pd.findAllPages();
     Page page=null;
     Iterator<Page> it_pg=pg.iterator();
     while(it_pg.hasNext()) {
    	 page=it_pg.next();
    	 if(page.getTitle().equals("Home")) {
    		 break;
    	 }
     }
	 int cid=dd.findDeveloperByUsername("charlie").getPerson().getId();
	 int bid=dd.findDeveloperByUsername("bob").getPerson().getId();
	 Statement statement;
	 int mid_c=-1,mid_b=-1;
	 try {
			statement = Connection.getConnection().createStatement();
			String find_person="select page_role.role from page_role where page_role.page="+page.getId()+" and developer="+cid;
			ResultSet  result = statement.executeQuery(find_person);
			while(result.next()) {
				mid_c=result.getInt("role");
			}
			find_person="select page_role.role from page_role where page_role.page="+page.getId()+" and developer="+bid;
			result = statement.executeQuery(find_person);
			while(result.next()) {
				mid_b=result.getInt("role");
			}
		    //statement.executeUpdate(find_person);

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 Connection.closeConnection();
	 rd.deletePageRole(bid, page.getId(), mid_b);
	 rd.assignPageRole(bid, page.getId(), mid_c);
	 rd.deletePageRole(cid, page.getId(), mid_c);
	 rd.assignPageRole(cid, page.getId(), mid_b);
 }
 public void deletes1() {
	 //delete1
	 DeveloperDao da=new DeveloperDao();
	 Developer d=da.findDeveloperByUsername("alice");
	 Statement statement;
	 try {
			statement = Connection.getConnection().createStatement();
			String find_person="delete from address where person="+d.getPerson().getId()+" and address.primary=1";
		    statement.executeUpdate(find_person);

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 Connection.closeConnection();
	 
	 
 }
 public void deletes2() {
	 PageDao pd=new PageDao();
	 Collection<Page>pg=pd.findAllPages();
     Page page=null;
     Iterator<Page> it_pg=pg.iterator();
     while(it_pg.hasNext()) {
    	 page=it_pg.next();
    	 if(page.getTitle().equals("Contact")) {
    		 break;
    	 }
     }
	 WidgetDao wd= new WidgetDao();
     Collection<Widget>w=wd.findAllWidgets();
	 Iterator<Widget> it_w = w.iterator();
	 Widget wig=null;
	 w=wd.findWidgetsForPage(page.getId());
	 it_w=w.iterator();
	 int wid=-1;
	 int maxorder=-1;
		while(it_w.hasNext()) {
			wig=it_w.next();
			if(wig.getOrder()>maxorder) {
				wid=wig.getId();
			}
		}
	wd.deleteWidget(wid);
 }
 public void deletes3() {
	 PageDao pd=new PageDao();
	 WebsiteDao wd=new WebsiteDao();
	 WidgetDao wigd=new WidgetDao();
	 Collection<Website>wc=wd.findAllWebsites();
	 Iterator<Website> it_wc = wc.iterator();
	 Website web=null;
	 Page page=null;
	 while(it_wc.hasNext()) {
		 web=it_wc.next();
		 if(web.getName().equals("Wikipedia")) {
			 break;
		 }
	 }
	 Collection<Page>pc=pd.findPagesForWebsite(web.getId());
	 Iterator<Page> it_pc = pc.iterator();
	 Date max=null;
	 SimpleDateFormat simple = new SimpleDateFormat("yyyy-mm-dd");
	 while(it_pc.hasNext()) {
		 page=it_pc.next();
		 if(page.getUpdated()!=null) {
			 try {
				if(simple.parse(page.getUpdated()).after(max)) {
					 break;
				 }
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 }
	 }
	 Statement statement;
	 try {
			statement = Connection.getConnection().createStatement();
			String find_person="delete from page_role where page_role.page="+page.getId();
		    statement.executeUpdate(find_person);

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 Connection.closeConnection();
	 
	 Collection <Widget> wig=wigd.findAllWidgets();
	 Iterator<Widget> it_wig = wig.iterator();
	 Widget widget=null;
	 while(it_wig.hasNext()) {
		 widget=it_wig.next();
		 if(widget.getPage()==page.getId()) {
		 wigd.deleteWidget(widget.getId());}
	 }
	 pd.deletePage(page.getId());
 }
 public void deletes4() {
	 WidgetDao wigd=new WidgetDao();
	 PageDao pd=new PageDao();
	 WebsiteDao wd=new WebsiteDao();
	 Collection<Website>wc=wd.findAllWebsites();
	 Iterator<Website> it_wc = wc.iterator();
	 Website web=null;
	 Page page=null;
	 while(it_wc.hasNext()) {
		 web=it_wc.next();
		 if(web.getName().equals("CNET")) {
			 break;
		 }
	 }
	 Collection<Page>pc=pd.findPagesForWebsite(web.getId());
	 Iterator<Page> it_pc = pc.iterator();
	 while(it_pc.hasNext()) {
		 page=it_pc.next();
		 Statement statement=null;
		 try {
				statement = Connection.getConnection().createStatement();
				String find_person="delete from page_role where page_role.page="+page.getId();
			    statement.executeUpdate(find_person);
			    find_person="delete from website_role where website_role.website="+web.getId();
			    statement.executeUpdate(find_person);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 Collection <Widget> wig=wigd.findAllWidgets();
		 Iterator<Widget> it_wig = wig.iterator();
		 Widget widget=null;
		 while(it_wig.hasNext()) {
			 widget=it_wig.next();
			 if(widget.getPage()==page.getId()) {
			 wigd.deleteWidget(widget.getId());}
		 }
		 
		 pd.deletePage(page.getId());
		
	 }
	 wd.deleteWebsite(web.getId());
 }
 
 
 public static void main(String args[]) {
	 hw_jdbc_last_first hw=new hw_jdbc_last_first();
	 
	 hw.createdeveloper();
	 hw.createuser();
	 hw.createwebsite();
	 hw.createpage();
	 hw.createwidget();
	  hw.createrole();
	 
	 //hw.updates1();
	// hw.updates2();
	// hw.updates3();
	// hw.updates4();
	 //hw.deletes1();
	// hw.deletes2();
	 //hw.deletes3();
	// hw.deletes4();
 }
}


