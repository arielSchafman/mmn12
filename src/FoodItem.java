public class FoodItem {
    /**
     * @author ariel schafman
     * @version 2020a
     * @see java.lang.Object
     */

    private String name;
    private long catalogueNumber;
    private int quantity;
    private Date productionDate;
    private Date expiryDate;
    private int minTemperature;
    private int maxTemperature;
    private int price;

    /**
     * build a food item string
     *
     * @param name
     * @param catalogueNumber
     * @param quantity
     * @param productionDate
     * @param expiryDate
     * @param minTemperature
     * @param maxTemperature
     * @param price
     */
    FoodItem(String name, long catalogueNumber, int quantity, Date productionDate, Date expiryDate, int minTemperature, int maxTemperature, int price) {//constructor
        this.name = name;
        this.catalogueNumber = catalogueNumber;
        this.quantity = quantity;
        this.productionDate = productionDate;
        this.expiryDate = expiryDate;
        this.minTemperature = minTemperature;
        this.maxTemperature = maxTemperature;
        this.price = price;
        if (this.expiryDate.before(this.productionDate)) {
            expiryDate.equals(productionDate.tomorrow());
        }
        if (minTemperature > maxTemperature) {
            final int TEMP = minTemperature;
            minTemperature = maxTemperature;
            maxTemperature = TEMP;
        }
    }

    /**
     * copy constructor
     *
     * @param other
     */
    FoodItem(FoodItem other) {//copy constructor
        this.name = (other.name);
        this.catalogueNumber = other.catalogueNumber;
        this.quantity = other.quantity;
        this.productionDate = other.productionDate;
        this.expiryDate = other.expiryDate;
        this.minTemperature = other.minTemperature;
        this.maxTemperature = other.maxTemperature;
        this.price = other.price;
    }

    /**
     * return the name
     *
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * return the CatalogueNumber
     *
     * @return catalogueNumber
     */
    public long getCatalogueNumber() {
        return catalogueNumber;
    }

    /**
     * return the Quantity
     *
     * @return quantity
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * return the ProductionDate
     *
     * @return productionDate
     */
    public Date getProductionDate() {
        return productionDate;
    }

    /**
     * return the ExpiryDate
     *
     * @return expiryDate
     */
    public Date getExpiryDate() {
        return expiryDate;
    }

    /**
     * return the min temperature of an item
     *
     * @return minTemperature
     */
    public int getMinTemperature() {
        return minTemperature;
    }

    /**
     * return the max temperature of an item
     *
     * @return maxTemperature
     */
    public int getMaxTemperature() {
        return maxTemperature;
    }

    /**
     * return the price of an item
     *
     * @return price
     */
    public int getPrice() {
        return price;
    }

    /**
     * set the Production Date
     *
     * @param productionDate
     */
    public void setProductionDate(Date productionDate) {
        this.productionDate = productionDate;
    }

    /**
     * set the Expiry Date
     *
     * @param expiryDate
     */
    public void setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
    }

    /**
     * set the Quantity
     *
     * @param quantity
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     * set the price
     *
     * @param price
     */
    public void setPrice(int price) {
        this.price = price;
    }

    /**
     * compare item to a given item and return true if they are the same
     *
     * @param other
     * @return if they are equals or not
     */
    public boolean equals(FoodItem other) {
        if (this.name.equals(other.name) && this.catalogueNumber == other.catalogueNumber && this.minTemperature == other.minTemperature//check all the item feature to see if they are all the same
                && this.maxTemperature == other.maxTemperature && this.productionDate == other.productionDate && this.expiryDate == other.expiryDate
                && this.price == other.price) {
            return true;
        } else return false;
    }

    /**
     * check if an given item is still fresh and not past it expiration date
     *
     * @param d
     * @return true if it's not past the expiration date
     */
    public boolean isFresh(Date d) {//get a date and day if an given item is still fresh at this date
        if ((this.productionDate.before(d) && this.expiryDate.after(d)) || this.expiryDate.equals(d) || this.productionDate.equals(d)) {
            return true;
        } else return false;
    }

    /**
     * build a string of the item name, production Date, expiration date, quantity
     *
     * @return the string of all the item's features
     */
    public String toString() {//toString
        return "FoodItem: " + name + "\tProductionDate: " + productionDate + "\tExpiryDate: " + expiryDate + "\tQuantity: " + quantity;
    }

    /**
     * check if a given item production date is after this item production date
     *
     * @param other
     * @return if the item is older or not
     */
    public boolean olderFoodItem(FoodItem other) {
        if (this.productionDate.before(other.productionDate)) {
            return true;
        } else return false;
    }

    /**
     * get an amount of money and tell how many of one item you can but ( if there is enough in the store)
     *
     * @param money
     * @return how many items you can bay with the given money
     */
    public int howManyItems(int money) {
        int numberOfItems = money / this.price;
        if (numberOfItems > this.quantity) {
            return this.quantity;
        } else return numberOfItems;
    }

    /**
     * check if this item is cheaper then a given item
     *
     * @param other
     * @return if the item is cheaper or not
     */
    public boolean isCheaper(FoodItem other) {
        if (this.price < other.price) {
            return true;
        } else return false;
    }
}