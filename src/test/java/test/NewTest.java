package test;

import static org.junit.Assert.*;

import java.sql.Time;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import bean.News;
import dao.DatabaseDao;
import dao.NewsDao;
import tools.PageInformation;

public class NewTest {
	
	@Test
	public void testGetOnePage() throws Exception {
		List<News> newses=new ArrayList<News>();
		NewsDao newsDao=new NewsDao();
		PageInformation pageInformation=new PageInformation();
		pageInformation.setTableName("news");
		pageInformation.setPage(1);
		pageInformation.setPageSize(10);
		DatabaseDao databaseDao=new DatabaseDao();
		newses=newsDao.getOnePage(pageInformation, databaseDao);
		assertNotNull(newses);	
	}
	@Test
	public void testAdd() throws Exception{
		DatabaseDao databaseDao=new DatabaseDao();
		News news=new News();
		NewsDao newsDao=new NewsDao();
		news.setAuthor("wangjie");
		news.setCaption("某男子私闯名宅");
		news.setContent("然后实施犯罪后被警察抓起来了");
		news.setNewsType("国际");
		String a="2017-06-17 05:05:00";
		DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		LocalDateTime localDateTime=LocalDateTime.parse(a,df);		
		news.setNewsTime(localDateTime);
		newsDao.add(news, databaseDao);
	}
}
