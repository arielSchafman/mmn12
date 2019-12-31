/**
 * @author ariel
 * @version maman 13
 */

public class Stock {
    private int numberOfItems;//number of itmes in array
    private FoodItem[] _stock = new FoodItem[]{null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
            null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
            null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
            null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null};//the array

    /**
     * Constructor build a array of given items
     */
    public Stock() {//Constructor
        int num = 100;
        for (int i = 0; i < _stock.length; i++) {
            if (_stock[i] == null) {
                --num;
            }
        }
        numberOfItems = num;
    }

    /**
     * @return the number of items in the array
     */
    public int getNumOfItems() {
        return numberOfItems;
    }

    /**
     * add item to array and if item is already in the array it add to the the quantity
     *
     * @param newItem the item to add to the stock
     * @return if item is added return true if the array is full return false
     */
    public boolean addItem(FoodItem newItem) {
        FoodItem tmp;
        if (numberOfItems == 0) {
            _stock[0] = new FoodItem(newItem);
            numberOfItems++;
            return true;
        }

        for (int i = 0; i <= numberOfItems; i++) {
            if (_stock[i] != null) {
                if (_stock[i].equals(newItem)) {
                    _stock[i].setQuantity(_stock[i].getQuantity() + _stock[i].getQuantity());
                    numberOfItems++;
                    break;
                }
            }
            if (numberOfItems >= 100) {
                return false;
            }
            if (_stock[i] == null) {
                _stock[i] = new FoodItem(newItem);
                numberOfItems++;
                break;
            }
        }
        for (int i = 0; i <= numberOfItems; i++) {
            for (int j = 0; j <= numberOfItems; j++) {
                if (_stock[i] != null && _stock[j] != null) {
                    if (_stock[j].getCatalogueNumber() > _stock[i].getCatalogueNumber()) {
                        tmp = new FoodItem(_stock[j]);
                        _stock[j] = new FoodItem(_stock[i]);
                        _stock[i] = new FoodItem(tmp);
                    }
                }
            }
        }
        return true;
    }

    /**
     * tell witch item is running low on supply
     *
     * @param amount the amount of items needed to be int the stock
     * @return the items that are short of quantity in the array
     */

    public String order(int amount) {
        String order = "";
        for (int i = 0; i <= numberOfItems; i++) {
            if (_stock[i] != null) {
                if (_stock[i].getQuantity() < amount) {
                    order = order + _stock[i].getName() + ", ";
                }
            }
        }
        return order;
    }

    /**
     * tell how many items in the array can be stored in a cooler on a given temperature
     *
     * @param temp the temperature of the cooler
     * @return the number of item that can be in the cooler
     */
    public int howMany(int temp) {
        int itemInTemp = 0;
        for (int i = 0; i <= numberOfItems; i++) {
            if (_stock[i] != null) {
                if (_stock[i].getMinTemperature() < temp && _stock[i].getMaxTemperature() > temp) {
                    itemInTemp += _stock[i].getQuantity();
                }
            }
        }
        return itemInTemp;
    }

    /**
     * remove item that are expired
     *
     * @param d date to check what items are expired
     */
    public void removeAfterDate(Date d) {
        for (int i = 0; i < numberOfItems; i++) {
            if (_stock[i] != null) {
                Date exDate = new Date(_stock[i].getExpiryDate());
                if (exDate.after(d)) {
                    _stock[i - 1] = new FoodItem(_stock[i]);
                    _stock[numberOfItems] = null;
                    numberOfItems--;
                }
            }
        }
    }

    /**
     * tell the most expensive item in the array
     *
     * @return the most expensive item toString
     */
    public FoodItem mostExpensive() {
        int a = 0;
        FoodItem b = null;
        for (int i = 0; i <= numberOfItems; i++) {
            if (_stock[i] != null) {
                if (_stock[i].getPrice() > a) {
                    b = new FoodItem(_stock[i]);
                    a = _stock[i].getPrice();
                }
            }
        }
        if (numberOfItems < 1) {
            return null;
        }
        return b;
    }

    /**
     * the amount of items in the array no mater witch item
     *
     * @return the number of all the items
     */
    public int howManyPieces() {
        int a = 0;
        for (int i = 0; i <= numberOfItems; i++) {
            if (_stock[i] != null) {
                a += _stock[i].getQuantity();
            }
        }
        return a;
    }

    /**
     * @return the items in the store in "FoodItem:    CatalogueNumber:      ProductionDate:    ExpiryDate:     Quantity: " format
     */
    public String toString() {
        String toString = "";
        for (int i = 0; i <= numberOfItems - 1; i++) {
            if (_stock[i] == null) {
                i++;
            }
            toString = toString + "\n" + "FoodItem: " + _stock[i].getName() + "\t" + "CatalogueNumber:" + _stock[i].getCatalogueNumber() + "\t" + "ProductionDate: " + _stock[i].getProductionDate()
                    + "\t" + "ExpiryDate: " + _stock[i].getExpiryDate() + "\t" + "Quantity: " + _stock[i].getQuantity();
        }
        return toString;
    }

    /**
     * get a list of items and remove it from the stock
     *
     * @param itemsList list of item to remove from stock
     */
    public void updateStock(String[] itemsList) {
        for (int i = 0; i <= numberOfItems; i++) {
            if (_stock[i] != null) {
                for (int j = 0; j < itemsList.length; j++) {
                    if (itemsList[j].equals(_stock[i].getName())) {
                        _stock[i].setQuantity(_stock[i].getQuantity() - 1);
                    }
                    if (_stock[i].getQuantity() <= 0) {
                        _stock[i] = null;
                        _stock[i] = new FoodItem(_stock[i + 1]);
                        _stock[i + 1] = null;
                        numberOfItems--;
                    }
                }
            }
        }
    }

    /**
     * tell the temperature in witch all the items can be
     *
     * @return the temperature good for all the items
     */
    public int getTempOfStock() {
        int minTemp = Integer.MAX_VALUE;
        for (int i = 0; i <= numberOfItems - 1; i++) {
            if (_stock[i] == null) {
                i++;
            }
            if (_stock[i].getMinTemperature() < minTemp) {
                for (int j = 0; j <= numberOfItems - 1; j++) {
                    if (_stock[j] == null) {
                        j++;
                    }
                    if (_stock[i].getMinTemperature() > _stock[j].getMinTemperature()) {
                        minTemp = _stock[i].getMinTemperature();
                    }
                }
            }
        }
        for (int i = 0; i <= numberOfItems - 1; i++) {
            if (_stock[i] == null) {
                i++;
            }
            if (_stock[i].getMaxTemperature() < minTemp) {
                return Integer.MAX_VALUE;
            }
        }
        return minTemp;
    }
}