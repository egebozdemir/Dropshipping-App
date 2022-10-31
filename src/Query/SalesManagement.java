package Query;

public class SalesManagement {
	
	//private instance variables
	private final int countSupplier = 3;
	private int selectSupplier;
	private int selectSale;
	private Sales[] salesArr1;
	private Sales[] salesArr2;
	private Sales[] salesArr3;
	private Sales[][] totalSales = new Sales[countSupplier][]; //Sales class base-typed, 2-dimensional ragged array is declared and created 
	
	//Default constructor
	public SalesManagement(){
	}
	
	//Full-arg constructor
	public SalesManagement(Sales[] SalesArr1, Sales[] SalesArr2, Sales[] SalesArr3) {
		salesArr1 = SalesArr1;
		salesArr2 = SalesArr2;
		salesArr3 = SalesArr3;
		
		//references of the sales arrays passed as argument are copied into 2D Sales array type object created in the scope of the instance 
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
	
	//Copy constructor
	public SalesManagement(SalesManagement _salesmanagement) {
		this.salesArr1 = _salesmanagement.getSalesArr1();
		this.salesArr2 = _salesmanagement.getSalesArr2();
		this.salesArr3 = _salesmanagement.getSalesArr3();
		this.selectSupplier = _salesmanagement.getSupplierSelection();
		this.selectSale = _salesmanagement.getSaleSelection();
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
	
	public String getSelectedSalesToString(int selectSupplier , int selectSale) {
		return "SalesManagement {sales=" + totalSales[selectSupplier][selectSale].toString() + "}";
	}

	public Sales getSelectedSales(int selectSupplier , int selectSale) {
		return new Sales(totalSales[selectSupplier][selectSale]);
	}

	//Mutator methods
	public void setSupplierSelection(int selectSupplier) {
		this.selectSupplier = selectSupplier;
	}
	
	public void setSaleSelection(int selectSale) {
		this.selectSale = selectSale;
	}
}