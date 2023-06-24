package com.utility;

public class objectrespositery2 {

	public static final String Gmoonlinebuttonsubmit=Constant.Id + "&" +"bSubmit";
	public static final String GmoOnlinetext=Constant.Xpath+ "&"+ "//h1[text()='OnLine Catalog']";
	public static final String QtyBackPack=Constant.Name + "&"+ "QTY_BACKPACKS";
	public static final String PlaceAnOrder=Constant.Xpath+ "&"+ "//input[@value='Place An Order']";
	public static final String UnitPrice=Constant.Xpath+ "&"+ "//table[@border='1']/tbody/tr[2]/td[4]";
	public static final String TotalPrice=Constant.Xpath+ "&"+ "//table[@border='1']/tbody/tr[2]/td[5]";
	public static final String AlertButton=Constant.Id+ "&"+ "alertButton";
	public static final String TimerAlertButton=Constant.Id+ "&"+ "timerAlertButton";
	public static final String ConfirmAlertButton=Constant.Id+ "&"+ "confirmButton";
	public static final String ConfirmButtonCancelResult=Constant.Id+ "&"+ "confirmResult";
	public static final String PromptAlertButton=Constant.Id+ "&"+ "promtButton";
	public static final String PromptAlertResult=Constant.Id+ "&"+ "promptResult";
	
	public static final String SingleFrame=Constant.Xpath+ "&"+ "//a[@href='#Single']";
	public static final String TextOfSingleFrame=Constant.Xpath+ "&"+ "//input[@type='text']";
	public static final String IframewithFrame=Constant.Xpath+ "&"+ "//a[@href='#Multiple']";
	public static final String InnerFrame=Constant.Xpath+ "&"+ "//iframe[@src='SingleFrame.html']";
	public static final String OuterFrame=Constant.Xpath+ "&"+ "//iframe[@src='MultipleFrames.html']";
	
	public static final String NewBrowserWindow=Constant.Xpath+ "&"+ "//button[@name='newbrowserwindow123']";
	public static final String MenuOfNew_BrowserWindow=Constant.Xpath+"&"+"//span[contains(text(),'Menu')]";
	public static final String About_Me_NewBrowserWindow=Constant.Xpath+"&"+"/span[text()='About Me']";
	
	public static final String MouseRightClickOperation=Constant.Xpath+"&"+"//span[text()='right click me']";
	public static final String MouseDelteOption=Constant.Xpath+"&"+"//span[text()='Delete']";
	public static final String IframeDoubleClick=Constant.Xpath+"&"+"//iframe";
	public static final String DoubleClickTheBox=Constant.Xpath+"&"+"//span[contains(text(),'Double click the block')]/preceding-sibling::div";
	
	public static final String DraggableOperation=Constant.Id+ "&"+ "draggable";
	public static final String DroppableOperation=Constant.Id+ "&"+ "droppable";
	
	public static final String BrowseButtonofFileUpload=Constant.Xpath+ "&"+ "//input[@id='input-4']/preceding-sibling::span";
	public static final String FileDownload100KB=Constant.Xpath+ "&"+ "//tbody/tr[1]/td[5]/a[1]";
	
	
}


