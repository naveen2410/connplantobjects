package connplantsv2.connplantsv2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.CharacterData;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class GetMIIResponse {

	public String executeShopOrderGETService(String stringURL) throws IOException{
		String outValue = null;

		URL url = new URL(stringURL);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();

		InputStream in = conn.getInputStream();

		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = null;
		try {
			db = dbf.newDocumentBuilder();
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Document doc = null;
		try {
			doc = (Document) db.parse(in);
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		NodeList nodes = ((org.w3c.dom.Document) doc).getElementsByTagName("Row");

		for (int i = 0; i < nodes.getLength(); i++) {
			Element element = (Element) nodes.item(i);

			NodeList nl = element.getElementsByTagName("SITE");
			Element line = (Element) nl.item(0);
			String site = getCharacterDataFromElement(line);

			nl = element.getElementsByTagName("SHOP_ORDER");
			line = (Element) nl.item(0);
			String shoporder = getCharacterDataFromElement(line);

			nl = element.getElementsByTagName("HANDLE");
			line = (Element) nl.item(0);
			String handle = getCharacterDataFromElement(line);

			nl = element.getElementsByTagName("ITEM_BO");
			line = (Element) nl.item(0);
			String item = getCharacterDataFromElement(line);

			nl = element.getElementsByTagName("PLANNED_ROUTER_BO");
			line = (Element) nl.item(0);
			String router = getCharacterDataFromElement(line);

			nl = element.getElementsByTagName("QTY_TO_BUILD");
			line = (Element) nl.item(0);
			String qty_to_build = getCharacterDataFromElement(line);

			nl = element.getElementsByTagName("QTY_DONE");
			line = (Element) nl.item(0);
			String qty_done = getCharacterDataFromElement(line);

			nl = element.getElementsByTagName("QTY_SCRAPPED");
			line = (Element) nl.item(0);
			String qty_scrapped = getCharacterDataFromElement(line);

			nl = element.getElementsByTagName("MODIFIED_DATE_TIME");
			line = (Element) nl.item(0);
			String modified_dt = getCharacterDataFromElement(line);

			MySQLConnection myserverCon = new MySQLConnection();
			String returnMsg = myserverCon.insertMIIShopOrderData(site, shoporder, item, qty_to_build, qty_done, qty_scrapped, modified_dt, router, handle);


			System.out.println("Data is inserted "+returnMsg);
		}

		return outValue;
	}

	public String executeSFCGETService(String stringURL) throws IOException{
		String outValue = null;

		URL url = new URL(stringURL);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();

		InputStream in = conn.getInputStream();

		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = null;
		try {
			db = dbf.newDocumentBuilder();
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Document doc = null;
		try {
			doc = (Document) db.parse(in);
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		NodeList nodes = ((org.w3c.dom.Document) doc).getElementsByTagName("Row");

		for (int i = 0; i < nodes.getLength(); i++) {
			Element element = (Element) nodes.item(i);

			NodeList nl = element.getElementsByTagName("SITE");
			Element line = (Element) nl.item(0);
			String site = getCharacterDataFromElement(line);

			nl = element.getElementsByTagName("SHOP_ORDER_BO");
			line = (Element) nl.item(0);
			String shoporder = getCharacterDataFromElement(line);

			nl = element.getElementsByTagName("SFC");
			line = (Element) nl.item(0);
			String sfc = getCharacterDataFromElement(line);

			nl = element.getElementsByTagName("STATUS_BO");
			line = (Element) nl.item(0);
			String status = getCharacterDataFromElement(line);

			nl = element.getElementsByTagName("QTY");
			line = (Element) nl.item(0);
			String qty = getCharacterDataFromElement(line);

			nl = element.getElementsByTagName("QTY_DONE");
			line = (Element) nl.item(0);
			String qty_done = getCharacterDataFromElement(line);

			nl = element.getElementsByTagName("QTY_SCRAPPED");
			line = (Element) nl.item(0);
			String qty_scrapped = getCharacterDataFromElement(line);

			nl = element.getElementsByTagName("MODIFIED_DATE_TIME");
			line = (Element) nl.item(0);
			String modified_dt = getCharacterDataFromElement(line);

			MySQLConnection myserverCon = new MySQLConnection();
			String returnMsg = myserverCon.insertMIISFCData(site, shoporder, sfc, status, qty, qty_done, qty_scrapped, modified_dt );


			System.out.println("Data is inserted "+returnMsg);
		}

		return outValue;
	}

	public String executeOperationService(String operationURL) throws IOException {
		String outValue = null;

		URL url = new URL(operationURL);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();

		InputStream in = conn.getInputStream();

		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = null;
		try {
			db = dbf.newDocumentBuilder();
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Document doc = null;
		try {
			doc = (Document) db.parse(in);
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		NodeList nodes = ((org.w3c.dom.Document) doc).getElementsByTagName("Row");

		for (int i = 0; i < nodes.getLength(); i++) {
			Element element = (Element) nodes.item(i);

			NodeList nl = element.getElementsByTagName("SITE");
			Element line = (Element) nl.item(0);
			String site = getCharacterDataFromElement(line);

			nl = element.getElementsByTagName("SHOP_ORDER");
			line = (Element) nl.item(0);
			String shoporder = getCharacterDataFromElement(line);

			nl = element.getElementsByTagName("SFC");
			line = (Element) nl.item(0);
			String sfc = getCharacterDataFromElement(line);

			nl = element.getElementsByTagName("OPERATION");
			line = (Element) nl.item(0);
			String operation = getCharacterDataFromElement(line);

			nl = element.getElementsByTagName("ROUTER");
			line = (Element) nl.item(0);
			String router = getCharacterDataFromElement(line);

			nl = element.getElementsByTagName("MATERIAL");
			line = (Element) nl.item(0);
			String material = getCharacterDataFromElement(line);

			nl = element.getElementsByTagName("WORK_CENTER");
			line = (Element) nl.item(0);
			String workcenter = getCharacterDataFromElement(line);

			nl = element.getElementsByTagName("QTY_IN_QUEUE");
			line = (Element) nl.item(0);
			String qty_queue = getCharacterDataFromElement(line);

			nl = element.getElementsByTagName("QTY_IN_WORK");
			line = (Element) nl.item(0);
			String qty_work = getCharacterDataFromElement(line);
			
			nl = element.getElementsByTagName("QTY_COMPLETE");
			line = (Element) nl.item(0);
			String qty_complete = getCharacterDataFromElement(line);

			nl = element.getElementsByTagName("STEP_ID");
			line = (Element) nl.item(0);
			String step_id = getCharacterDataFromElement(line);
			
			
			MySQLConnection myserverCon = new MySQLConnection();
			String returnMsg = myserverCon.insertMIIOperationData(site, shoporder, sfc, operation, router, material, workcenter, qty_queue, qty_work, qty_complete, step_id);


			System.out.println("Data is inserted "+returnMsg);
		}

		return outValue;
	}
	
	public String executeSiteService(String siteURL) throws IOException{
		String outValue = null;

		URL url = new URL(siteURL);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();

		InputStream in = conn.getInputStream();

		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = null;
		try {
			db = dbf.newDocumentBuilder();
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Document doc = null;
		try {
			doc = (Document) db.parse(in);
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		NodeList nodes = ((org.w3c.dom.Document) doc).getElementsByTagName("Row");

		for (int i = 0; i < nodes.getLength(); i++) {
			Element element = (Element) nodes.item(i);

			NodeList nl = element.getElementsByTagName("SITE");
			Element line = (Element) nl.item(0);
			String site = getCharacterDataFromElement(line);

			nl = element.getElementsByTagName("DESCRIPTION");
			line = (Element) nl.item(0);
			String description = getCharacterDataFromElement(line);

			nl = element.getElementsByTagName("TIME_ZONE");
			line = (Element) nl.item(0);
			String time_zone = getCharacterDataFromElement(line);

			MySQLConnection myserverCon = new MySQLConnection();
			String returnMsg = myserverCon.insertMIISiteData(site, description, time_zone);


			System.out.println("Data is inserted "+returnMsg);
		}

		return outValue;
	}


	public static String getCharacterDataFromElement(Element e) {
		Node child = e.getFirstChild();
		if (child instanceof CharacterData) {
			CharacterData cd = (CharacterData) child;

			return cd.getData();
		}
		return "?";
	}

	


}
