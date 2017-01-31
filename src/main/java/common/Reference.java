package common;

import apppages.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;


public class Reference {

    private static Reference refSingleton;
    /**
     * @param args
     */
    public WebDriver driver;
    public Login login;
    public SharePointHomePage sharePointHomePage = new SharePointHomePage();
    public ProjectPage projectPage;
    public GroupsPage groupsPage;
    public UserPage userPage;
    public CreatePage createPage;
    public BlogPage blogPage = new BlogPage();
    public DocsPage docsPage;
    public WikiPage wikiPage;
    public NewsFeedPage newsFeedPage = new NewsFeedPage();
    public ToolsAndResourcesPage toolsAndResourcesPage;
    public NewsPage newsPage;


    public Reference() {
        login = PageFactory.initElements(driver, Login.class);
        sharePointHomePage = PageFactory.initElements(driver, SharePointHomePage.class);
        projectPage = PageFactory.initElements(driver, ProjectPage.class);
        groupsPage = PageFactory.initElements(driver, GroupsPage.class);
        userPage = PageFactory.initElements(driver, UserPage.class);
        createPage = PageFactory.initElements(driver, CreatePage.class);
        blogPage = PageFactory.initElements(driver, BlogPage.class);
        docsPage = PageFactory.initElements(driver, DocsPage.class);
        wikiPage = PageFactory.initElements(driver, WikiPage.class);
        newsFeedPage = PageFactory.initElements(driver, NewsFeedPage.class);
        toolsAndResourcesPage = PageFactory.initElements(driver, ToolsAndResourcesPage.class);
        newsPage = PageFactory.initElements(driver, NewsPage.class);


    }

    /**
     * Method DOCUMENT ME!
     *
     * @return DOCUMENT ME!
     */
    public static synchronized Reference instance() {
        if (refSingleton == null) {
            refSingleton = new Reference();
        }

        return refSingleton;
    }

}