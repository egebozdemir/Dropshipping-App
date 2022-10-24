
public class Supplier {
  DynamicArray<Product> Products = new DynamicArray<>();


  public void addProduct(Product product){
    Products.addItem(product);
  }


  public Product getProductbyID(String ID) {
    for (int i = 0; i < Products.getSize(); i++) {
      Product currentproduct = Products.getItem(i);
      if (currentproduct.getId().equals(ID)){
        return currentproduct;
      }
    }
    System.out.println("The product cannot be found.");
    return new Product();
  }
  public int getSize(){
    return Products.getSize();
  }
}
