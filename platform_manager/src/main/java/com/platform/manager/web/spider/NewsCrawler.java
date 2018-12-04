package com.platform.manager.web.spider;

import cn.edu.hfut.dmic.webcollector.model.CrawlDatums;
import cn.edu.hfut.dmic.webcollector.model.Page;
import cn.edu.hfut.dmic.webcollector.plugin.berkeley.BreadthCrawler;
import com.platform.manager.web.jdbc.DataBaseConnection;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ListIterator;

/**
 * Crawling news from hfut news
 *
 * @author hu
 */
public class NewsCrawler extends BreadthCrawler {

    DataBaseConnection connection = new DataBaseConnection();

    /**
     * @param crawlPath crawlPath is the path of the directory which maintains
     * information of this crawler
     * @param autoParse if autoParse is true,BreadthCrawler will auto extract
     * links which match regex rules from pag
     */
    public NewsCrawler(String crawlPath, boolean autoParse) {
        super(crawlPath, autoParse);
        /*start page*/
        for (int i = 1; i <200000 ; i++) {
            this.addSeed("http://www.gushiwen.org/default_"+i+".aspx",true);
        }

        /*fetch url like http://news.hfut.edu.cn/show-xxxxxxhtml*/
        this.addRegex("http://www.gushiwen.org/default_\\d*.aspx");
        /*do not fetch jpg|png|gif*/
        //this.addRegex("-.*\\.(jpg|png|gif).*");
        /*do not fetch url contains #*/
        //this.addRegex("-.*#.*");
    }

    @Override
    public void visit(Page page, CrawlDatums next) {
        /*if page is news page*/
        System.out.println("====page======>"+page.getUrl()+"------------------------begin");
        if (page.matchUrl("http://www.gushiwen.org/default_\\d*.aspx")) {
            /*we use jsoup to parse page*/
            Document doc = page.doc();
            String num = doc.select("div[class=pages]>span").first().text();
            Elements elements = doc.select("div[class=left]>div[class=sons]");
            ListIterator<Element> listIterator = elements.listIterator();
            while (listIterator.hasNext()) {
                Element element = listIterator.next();
            /*extract title and content of news by css selector*/
                String title = element.select("div[class=cont]>p[class!=source]>a>b").first().text();
                Elements author = element.select("div[class=cont]>p[class=source]");
                String value1 = author.get(0).text();
                String nianDAI = value1.split("：")[0];
                String authorStr = value1.split("：")[1];
                System.out.println(authorStr);
                System.out.println(nianDAI);
                System.out.println(title);
                String id = element.select("div[class=cont]>div[class=contson]").first().id();
                String content = element.select("div[class=cont]>div[class=contson]").first().text();
                System.out.println(content);
                File file = new File("d:/poem/" + id + ".txt");
                if (!file.exists()) {
                    try {
                        file.createNewFile();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                try {
                    FileWriter writer = new FileWriter(file);
                    writer.write(title);
                    writer.write("\n");
                    writer.write(value1);
                    writer.write("\n");
                    writer.write(content);
                    writer.flush();

                //写入数据库---处理数据
                String inserSql = "insert into tb_poem values("+Integer.valueOf(id.replace("contson",""))+",'"+title+"','"+nianDAI+"','"+authorStr+"','"+content+"','"+id+"')";
                    System.out.println(inserSql);
                connection.excute(inserSql);
                } catch (IOException e) {
                    e.printStackTrace();
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
        NewsCrawler crawler = new NewsCrawler("crawl", true);
        crawler.setThreads(1);
        crawler.start(1);

    }

}
