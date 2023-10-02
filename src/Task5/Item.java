package Task5;
public class Item {
    private String description;
    private double weight;
    public Item(double weight, String description) {
        if (weight < 0)
            throw new IllegalArgumentException("Must be positive number");;
        this.weight = weight;
        if (description.length() > 1) {
            this.description = description;
        } else this.description = "No description";
    }
    public double getWeight(){
        return weight;
    }
    public String getDescription(){
        return description;
    }

}