package control;
//import JXC_Model;
import models.AccountManagement;
import models.CommodityManagement;
import models.CustomerManagement;
import models.ExportManagement;
import models.ImportManagement;
import models.LoginManagement;
import models.StockManagement;
import ui.JXC_View;


public class JXC_Controller {
	//JXC_Model jxcmodel;
	JXC_View jxcview;
	public JXC_Controller(JXC_View view){
		jxcview=view;
	}
	
	String instruction;
	String messageText;
	Object messageTable[][];
	public void setInstruction(){
		instruction=jxcview.getInstruction();
	}
	
	public String getMessageText(){
		return messageText;
	}
	public Object[][] getMessageTable(){
		return messageTable;
	}
	public CommodityManagement commodity=new CommodityManagement();
	public StockManagement stock=new StockManagement();
	public ImportManagement importer=new ImportManagement();
	public ExportManagement exporter=new ExportManagement();
	public CustomerManagement customer=new CustomerManagement();
	public AccountManagement account=new AccountManagement();
	public LoginManagement login=new LoginManagement();
	
	public void go(){
		System.out.println(instruction);
		String keyword="";
		keyword=instruction.substring(0, 2);
		switch(keyword){
		case "CO":{
			commodity.setInstruction(instruction.substring(10));
			commodity.go();
			if(instruction.substring(10).charAt(0)=='S'||instruction.substring(10).charAt(0)=='F'){
				messageTable=commodity.getMessageTable();
			}
			break;
		}
		case "AC":{
			account.setInstruction(instruction.substring(8));
			account.go();
			if(instruction.substring(8).charAt(0)=='A'){
				messageText=account.getMessageText();
			}
			if(instruction.substring(8).charAt(0)=='D'){
				messageTable=account.getMessageTable();
			}
			break;
		}
		case "CU":{
			customer.setInstruction(instruction.substring(9));
			customer.go();
			if(instruction.substring(9).charAt(0)=='S'||instruction.substring(9).charAt(0)=='F'){
				messageTable=customer.getMessageTable();
			}
			break;
		}
		case "EX":{
			exporter.setInstruction(instruction.substring(7));
			exporter.go();
			if(instruction.substring(7).charAt(0)=='W'){
				messageTable=exporter.getMessageTable();
			}
			if(instruction.substring(7).charAt(0)=='S'){
				messageTable=exporter.getMessageTable();
			}
			break;
		}
		case "IM":{
			importer.setInstruction(instruction.substring(7));
			importer.go();
			if(instruction.substring(7).charAt(0)=='W'){
				messageTable=importer.getMessageTable();
			}
			if(instruction.substring(7).charAt(0)=='S'){
				messageTable=importer.getMessageTable();
			}
			break;
		}
		case "ST":{
			stock.setInstruction(instruction);
			stock.go();
			messageTable=stock.getMessageTable();
			break;
		}
		case "LO":{
			login.setInstruction(instruction.substring(6));
			login.go();
			break;
		}
		default:System.out.println("��ʽ����");
		    break;
		}
	}

}
