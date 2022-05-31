package com.parsing.SoapParsing;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.soap.MessageFactory;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;

import www.example.org.stock.GetStockPrice;

public class SoapXMLParsing {

	public static void main(String[] args) {
		 //File file=new File("Response.xml");
		try {
			String responseXml="<?xml version=\"1.0\" encoding=\"UTF-8\"?>\r\n"
					+ "<soap:Envelope xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\">\r\n"
					+ "<soap:header/>\r\n"
					+ "<soap:Body xmlns:m=\"http://www.example.org/stock\">\r\n"
					+ "  <m:getStockPrice>\r\n"
					+ "    <m:StockName>IBM</m:StockName>\r\n"
					+ "  </m:getStockPrice>\r\n"
					+ "</soap:Body>\r\n"
					+ "</soap:Envelope>";
			//SOAPMessage message = MessageFactory.newInstance().createMessage(null,new ClassPathResource("Response.xml").getInputStream());
			 //SOAPMessage message=MessageFactory.newInstance().createMessage(null,new FileSystemResource(file).getInputStream());
			SOAPMessage message=MessageFactory.newInstance().createMessage(null,new ByteArrayInputStream(responseXml.getBytes("UTF-8")));
			JAXBContext jaxbContext = JAXBContext.newInstance(GetStockPrice.class);
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			GetStockPrice getStockPrice = (GetStockPrice) jaxbUnmarshaller.unmarshal(message.getSOAPBody().extractContentAsDocument());
			System.out.println(getStockPrice);
			System.out.println(getStockPrice.getStockName()); 
		} catch (IOException|JAXBException | SOAPException e) {
			e.printStackTrace();
		}
				
	}

}
