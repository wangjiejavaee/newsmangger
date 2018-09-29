package test;

import static org.junit.Assert.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import bean.News;
import service.NewsService;
import tools.PageInformation;

public class NewTestService {

	@Test
	public void testGetOnePage(){
		List<News> newses=new ArrayList<News>();
		NewsService newsService = new NewsService();
		PageInformation pageInformation=new PageInformation();
		pageInformation.setTableName("news");
		pageInformation.setPage(1);
		pageInformation.setPageSize(10);
		newses=newsService.getOnePage(pageInformation);
		assertNotNull(newses);
	}
	
	@Test
	public void testAdd(){
		News news=new News();
		NewsService newsService = new NewsService();
		news.setAuthor("王杰");
		news.setCaption("某男子私闯名宅");
		news.setContent("然后实施犯罪后被警察抓起来了");
		news.setNewsType("国际");
		String a="2017-06-17 05:05:00";
		DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		LocalDateTime localDateTime=LocalDateTime.parse(a,df);		
		news.setNewsTime(localDateTime);
		if(newsService.add(news)==1){
			System.out.println("添加成功");
		}else{
			System.out.println("添加失败");
		}
	}

}
