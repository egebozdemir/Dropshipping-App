
public class SalesManagement {
	private final int maxLength = 30; //gelen array lengthleri karşılaştırılıp büyük olan seçilebilir: improvement
	private final int countSupplier = 3;
	private Sales[] salesArr1;
	private Sales[] salesArr2;
	private Sales[] salesArr3;
	private Sales[][] totalSales = new Sales[countSupplier][];
	
	//Default constructor
	public SalesManagement(){
	}
	
	//Full-arg constructor
	public SalesManagement(Sales[] salesArr1, Sales[] salesArr2, Sales[] salesArr3) {
		this.salesArr1 = salesArr1;
		this.salesArr2 = salesArr2;
		this.salesArr3 = salesArr3;
		
		for(int i=0; i<countSupplier; i++) {
			if(i==0) {
				totalSales[i] = salesArr1;
			}
			else if(i==1) {
				totalSales[i] = salesArr2;
			}
			else {
				totalSales[i] = salesArr3;
			}
		}
	}

	
	//Accessor methods
	public Sales[][] getTotalSales() {
		return totalSales;
	}
	
	public Sales[] getSalesArr1() {
		return salesArr1;
	}
	
	public Sales[] getSalesArr2() {
		return salesArr2;
	}
	
	public Sales[] getSalesArr3() {
		return salesArr3;
	}

	public String getSelectedSalesToString(int selectSupplier , int selectSale) {
		return "SalesManagement {sales=" + totalSales[selectSupplier][selectSale].toString() + "}";
	}

	public Sales getSelectedSales(int selectSupplier , int selectSale) {
		return new Sales(totalSales[selectSupplier][selectSale]);
	}

	
	
	
	
	
}
