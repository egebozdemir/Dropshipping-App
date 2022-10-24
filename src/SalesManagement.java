import java.io.File;

public class SalesManagement {
  private DynamicArray[] sales;
  private DynamicArray<Sales> S1_Sales = new DynamicArray<>();
  private DynamicArray <Sales> S2_Sales = new DynamicArray<>();
  private DynamicArray<Sales> S3_Sales = new DynamicArray<>();

  public SalesManagement() {
    this.sales = new DynamicArray[]{S1_Sales, S2_Sales, S3_Sales};
  }

  public DynamicArray[] getSales() {
    return sales;
  }

  public void addSale(String supplierID, Sales sale){
    switch (supplierID){
      case "S1":
        sales[0].addItem(sale);
        break;
      case "S2":
        sales[1].addItem(sale);
        break;
        case "S3":
        sales[2].addItem(sale);
        break;
    }

  }

}
