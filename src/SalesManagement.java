public class SalesManagement {
	private final int countSupplier = 3;
	private int selectSupplier;
	private int selectSale;
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
	
	public int getSupplierSelection() {
		return selectSupplier;
	}
	
	public int getSaleSelection() {
		return selectSale;
	}

	//Mutator methods
	public void setSupplierSelection(int selectSupplier) {
		this.selectSupplier = selectSupplier;
	}
	
	public void setSaleSelection(int selectSale) {
		this.selectSale = selectSale;
	}

	public String getSelectedSalesToString(int selectSupplier , int selectSale) {
		return "SalesManagement {sales=" + totalSales[selectSupplier][selectSale].toString() + "}";
	}

	public Sales getSelectedSales(int selectSupplier , int selectSale) {
		return totalSales[selectSupplier][selectSale];
	}

	
	
	
	
	
}
