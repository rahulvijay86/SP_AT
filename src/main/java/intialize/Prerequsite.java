package intialize;

import actions.Browser;
import common.ExtendedLibrary;
import org.testng.annotations.*;
import util.DateUtil;
import util.FileUtil;
import actions.ResultUtil;
import org.apache.commons.io.FileUtils;
import org.testng.ITestContext;
import util.XMLUtil;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;


public class Prerequsite extends ExtendedLibrary {

	public static Map<String,String> configMap = new HashMap<String, String>();
	private ITestContext context;

	public ITestContext getContext() {
		return context;
	}

	public void setContext(ITestContext context) {
		this.context = context;
	}

	@BeforeSuite
public void initialize(ITestContext context){
	getExecutionConfig();
		this.context = context;
	createReportSummary(context);
		ResultUtil res=new ResultUtil();
}

//    @AfterClass
//public void ieKill()throws Exception{
//		try{
//			if (BrowserName.contains("ie")) {
//				final String KILL = "taskkill /IM";
//				String processName = "IEDriverServer.exe"; //IE Process
//				Runtime.getRuntime().exec(KILL + processName);
//				waitInMilliSeconds(3000);//Allow OS to kill the process
//			}
//			} catch (Exception e){
//		}
//	}

    @AfterSuite
public void ending(){		
	ResultUtil.endReport();
	
}

public void createReportSummary(final ITestContext context){
	try{	
		String strUrl = Prerequsite.configMap.get("URL");
		final String strSuiteName=context.getCurrentXmlTest().getSuite().getName();
	//	final String strReportFolder="result/"+strSuiteName+"-"+DateUtil.getCurrentDate("yyyy_MM_dd_HH_mm_ss");
    	final String strReportFolder="result/"+strSuiteName;
		System.setProperty("MODULE",  context.getCurrentXmlTest().getName());
		ResultUtil.strResultFolder=strReportFolder;
		FileUtil.createFolder(strReportFolder);
		FileUtil.createFolder(strReportFolder+"/Screenshot");

		/*final String strSummaryContent="<html><head><style>"+ResultUtil.strCSS+"</style></head>"+
			"<body><div class='datagrid'><table id='tblSummary'><thead>"+
			"<tr><th>Script Name</th><th>Machine</th><th>Browser</th><th>Start Time</th><th>Status</th><th>Link</th></tr>"+
			"</thead><tbody></tbody></table></div></body></html>";
		FileUtil.createFileWithContent(strReportFolder+"/Summary.html", strSummaryContent);*/

		String strSummaryFile=strReportFolder+"/Summary.html";
		FileUtils.copyDirectory(new File("template"), new File(strReportFolder));
		XMLUtil.addText(strSummaryFile, "//h1[@id='header']", strSuiteName);
		XMLUtil.addText(strSummaryFile, "//td[@id='QAEnv']", strUrl);
		XMLUtil.addText(strSummaryFile, "//td[@id='date']", DateUtil.getCurrentDate("dd-MM-YYYY"));
		XMLUtil.addText(strSummaryFile, "//td[@id='sTime']", DateUtil.getCurrentDate("HH:mm:ss"));
		ResultUtil.reportFilesMap=new HashMap<String,String>();
		ResultUtil.stepcountMap=new HashMap<String,Integer>();
		ResultUtil.currentReportIdMap=new HashMap<String,String>();
	}
	catch(Exception e){

	}
}
	public void getExecutionConfig() {
		try {
			loadPropertiesToMap("execution.properties");


		} catch (Exception e) {
			System.out.println("ERROR in getExecutionConfig - while loading the properties from file");
		}
	}
	public void loadPropertiesToMap(String fileName) {
		Properties prop = new Properties();
		try {
			prop.load(new FileInputStream("config/" + fileName));
			for (String key : prop.stringPropertyNames()) {
				configMap.put(key, prop.getProperty(key));
			}
			prop.clear();
		} catch (IOException ioe) {
			System.out.println("ERROR - while loading the properties from file: " + fileName);
		}
	}

	private void startSeleniumServer(){
		String[] command;
		String osName=System.getProperty("os.name");
		System.out.println("OSName: "+osName);
		if(osName.contains("Win")) {

			//command =new String[] {"cmd","/c","start", System.getProperty("user.dir")+"/src/main/java/resources/Start.bat"};
			command =new String[] {"cmd","/c","start", System.getProperty("user.dir")+"/src/main/java/resources"+"/Start.bat"};
		}else{
			command=new String[]{"cmd.exe /c start", "/C", /*System.getProperty("user.dir")*/  "/src/main/java/resources/Start.sh"};
		}
		try {
			//Runtime.getRuntime().exec(new String[]{"cmd.exe", "/c", "start", "C:\\Start.bat"});
			Runtime.getRuntime().exec(command);
			System.out.println("ok");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


}
