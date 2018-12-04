package com.platform.manager.web.spider;

import cn.edu.hfut.dmic.webcollector.model.CrawlDatums;
import cn.edu.hfut.dmic.webcollector.model.Page;
import cn.edu.hfut.dmic.webcollector.plugin.berkeley.BreadthCrawler;
import com.platform.manager.web.jdbc.DataBaseConnection;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.sql.SQLException;
import java.util.ListIterator;

/**
 * Crawling news from hfut news
 *
 * @author hu
 */
public class NewsCrawler_juzi extends BreadthCrawler {

    DataBaseConnection connection = new DataBaseConnection();

    /**
     * @param crawlPath crawlPath is the path of the directory which maintains
     * information of this crawler
     * @param autoParse if autoParse is true,BreadthCrawler will auto extract
     * links which match regex rules from pag
     */
    public NewsCrawler_juzi(String crawlPath, boolean autoParse) {
        super(crawlPath, autoParse);
        /*start page*/
        for (int i = 1; i <200000 ; i++) {
            this.addSeed("http://www.juzi8.com/default_"+i+".aspx",true);
        }

        /*fetch url like http://news.hfut.edu.cn/show-xxxxxxhtml*/
        this.addRegex("http://www.juzi8.com/default_\\d*.aspx");
        /*do not fetch jpg|png|gif*/
        //this.addRegex("-.*\\.(jpg|png|gif).*");
        /*do not fetch url contains #*/
        //this.addRegex("-.*#.*");
    }

    @Override
    public void visit(Page page, CrawlDatums next) {
        /*if page is news page*/
        System.out.println("====page======>"+page.getUrl()+"------------------------begin");
        if (page.matchUrl("http://www.juzi8.com/default_\\d*.aspx")) {
            /*we use jsoup to parse page*/
            Document doc = page.doc();
            Elements elements = doc.select("div[class=left]>div[class=sons]>div[class=cont]");
            ListIterator<Element> listIterator = elements.listIterator();
            while (listIterator.hasNext()) {
                Element element = listIterator.next();
                System.out.println(element.text());
                //查找span获取内容id值
               String onclickValue= element.select("span[onclick != '']").attr("onclick");
               int id = 0;
               if(onclickValue != null && !"".equals(onclickValue)){
                   int num1 = onclickValue.indexOf("'");
                   int num2 = onclickValue.lastIndexOf("'");
                   id = Integer.valueOf(onclickValue.substring(num1+1,num2));
               }
                System.out.println(onclickValue);
                int size = element.children().size();
                System.out.println("==children node size===============================================================>"+size);
                String content = element.child(0).text();
                String author = "无名";
                String translate="暂无译文";
                if(size==4){
                    author = element.child(2).text();
                }else if(size==2){

                }else if(size==6){
                    author = element.child(3).text();
                    translate=element.child(5).text();
                }else{
                    System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$--->size="+size);
                }
                System.out.println("===content="+content+"   author==="+author+"-----翻译："+translate);

                //存库
                String sql = "insert into tb_phrase values("+id+",'"+content+"','"+author+"','"+translate+"')";
                try {
                    this.connection.excute(sql);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
           /* String urlSeed = "http://www.gushiwen.org/default_pnaugme.aspx";
            int nextPageNum = Integer.valueOf(num)+1;
            System.out.println("======next pageNum is===>"+nextPageNum);
            next = new CrawlDatums();
            String nextUrl = urlSeed.replace("pnaugme",String.valueOf(nextPageNum));
            next.add(nextUrl);
            System.out.println("======next page is===>"+nextUrl);*/

            /*If you want to add urls to crawl,add them to nextLink*/
            /*WebCollector automatically filters links that have been fetched before*/
            /*If autoParse is true and the link you add to nextLinks does not match the regex rules,the link will also been filtered.*/
            //next.add("http://xxxxxx.com");
        }
    }

    public static void main(String[] args) throws Exception {
        NewsCrawler_juzi crawler = new NewsCrawler_juzi("crawl", true);
        crawler.setThreads(1);
        crawler.start(1);
        /*String onclickValue = "javascript:good('53451',0,0)";
        int num1 = onclickValue.indexOf("'");
        int num2 = onclickValue.lastIndexOf("'");
        int id = Integer.valueOf(onclickValue.substring(num1+1,num2));
        System.out.println(id);*/
    }

}
