package Query;

public class SalesManagement {
	
	//private instance variables
	private final int countSupplier = 3;
	private int selectSupplier;
	private int selectSale;
	private Sales[] salesArr1;
	private Sales[] salesArr2;
	private Sales[] salesArr3;
	private Sales[][] totalSalesArr = new Sales[countSupplier][]; //Sales class base-typed, 2-dimensional ragged array is declared and created 
	
	//Default constructor
	public SalesManagement(){
	}
	
	//Full-arg constructor
	public SalesManagement(Sales[] salesArr1, Sales[] salesArr2, Sales[] salesArr3) {
		this.salesArr1 = salesArr1;
		this.salesArr2 = salesArr2;
		this.salesArr3 = salesArr3;
		
		//references of the sales arrays passed as argument are copied into 2D Sales array type object created in the scope of the instance 
		for(int i=0; i<countSupplier; i++) {
			if(i==0) {
				totalSalesArr[i] = salesArr1;
			}
			else if(i==1) {
				totalSalesArr[i] = salesArr2;
			}
			else {
				totalSalesArr[i] = salesArr3;
			}
		}
	}
	
	//Accessor methods
	public Sales[][] getTotalSales() {
		return totalSalesArr;
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
	
	public String getSelectedSalesToString(int selectSupplier , int selectSale) {
		return totalSalesArr[selectSupplier][selectSale].toString();
	}

	public Sales getSelectedSales(int selectSupplier , int selectSale) {
		return new Sales(totalSalesArr[selectSupplier][selectSale]);
	}

	//Mutator methods
	public void setSupplierSelection(int selectSupplier) {
		this.selectSupplier = selectSupplier;
	}
	
	public void setSaleSelection(int selectSale) {
		this.selectSale = selectSale;
	}
}