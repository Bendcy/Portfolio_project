class Home {
private int squareFeet;
private String address;
private String city;
private String state;
private int zipCode;
private String modelName;
private String saleStatus;

public Home(int squareFeet, String address, String city, String state, int zipCode, String modelName, String saleStatus) {
    this.squareFeet = squareFeet;
    this.address = address;
    this.city = city;
    this.state = state;
    this.zipCode = zipCode;
    this.modelName = modelName;
    this.saleStatus = saleStatus;
}
public int getSquareFeet() {
    return squareFeet;
}
public String getAddress() {
    return address;
}
public String getCity() {
    return city;
}
public String getState() {
    return state;
}
public int getZipCode() {
    return zipCode;
}
public String getModelName() {
    return modelName;
}
public String getSaleStatus() {
    return saleStatus;
}
public void setSquareFeet(int squareFeet) {
    this.squareFeet = squareFeet;
}
public void setAddress(String address) {
    this.address = address;
}
public void setCity(String city) {
    this.city = city;
}
public void setState(String state) {
    this.state = state;
}
public void setZipCode(int zipCode) {
    this.zipCode = zipCode;
}
public void setModelName(String modelName) {
    this.modelName = modelName;
}
public void setSaleStatus(String saleStatus) {
    this.saleStatus = saleStatus;
}
@Override
public String toString() {
    return "Home{" +
            "squareFeet=" + squareFeet +
            ", address='" + address + '\'' +
            ", city='" + city + '\'' +
            ", state='" + state + '\'' +
            ", zipCode=" + zipCode +
            ", modelName='" + modelName + '\'' +
            ", saleStatus='" + saleStatus + '\'' +
            '}';
}