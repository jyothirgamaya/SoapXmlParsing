package www.example.org.stock;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name="GetStockPrice")
public class GetStockPrice {
	@XmlElement(namespace="http://www.example.org/stock",required = true)
	String StockName;

	public String getStockName() {
		return StockName;
	}

	public void setStockName(String stockName) {
		this.StockName = stockName;
	}

	@Override
	public String toString() {
		return "GetStockPrice [StockName=" + StockName + "]";
	}	
	
	
	
}
