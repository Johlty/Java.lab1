package Task5;

public class ReceivePoint {
    private boolean isCourier;
    private Courier courier;
    private DeliveryDepartment deliveryDepartment;

    public ReceivePoint(Courier courier){
        this.courier = courier;
        this.isCourier = true;
    }
    public ReceivePoint(DeliveryDepartment deliveryDepartment){
        this.deliveryDepartment = deliveryDepartment;
        this.isCourier = false;
    }
    public double getMaxWeight(){
        if(isCourier)
            return 30;
        return deliveryDepartment.getMaxWeight();
    }
    public String getAddress(){
        if(isCourier)
            return courier.getAddress();
        return deliveryDepartment.getAddress();
    }
    public boolean getIsCourier()
    {
        return isCourier;
    }
}