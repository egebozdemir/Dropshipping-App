
public class SalesManagement {
	private final int maxLength = 30; //gelen array lengthleri karşılaştırılıp büyük olan seçilebilir: improvement
	private final int countSupplier = 3;
	private int selectSupplier = 0;
	private int selectSale = 0;
	private Sales[] salesArr1;
	private Sales[] salesArr2;
	private Sales[] salesArr3;
	private Sales[][] totalSales = new Sales[countSupplier][maxLength]; 
	
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
				for(int j=0; j<salesArr1.length; j++) {
					totalSales[i][j]=salesArr1[j];
				}
			}
			else if(i==1) {
				for(int j=0; j<salesArr2.length; j++) {
					totalSales[i][j]=salesArr2[j];
				}
			}
			else {
				for(int j=0; j<salesArr3.length; j++) {
					totalSales[i][j]=salesArr3[j];
				}
			}
		}
	}
	
	//Accessor methods
	public Sales[][] getTotalSales() {
		return totalSales;
	}
	
	public int getSupplierSelection() {
		return selectSupplier;
	}
	
	public int getSaleSelection() {
		return selectSale;
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
	//Mutator methods
	public void setSupplierSelection(int selectSupplier) {
		this.selectSupplier = selectSupplier;
	}
	
	public void setSaleSelection(int selectSale) {
		this.selectSale = selectSale;
	}
	
	//To string override
	@Override
	public String toString() {
		return "SalesManagement {sales=" + totalSales[selectSupplier][selectSale] + "}";
	}

	
	
	
	
	
}
