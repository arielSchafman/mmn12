public class Stock {
    private int numberOfItems;
    private FoodItem[] _stock = new FoodItem[]{null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
            null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
            null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
            null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null};

    public Stock() {
        int num = 100;
        for (int i = 0; i < _stock.length; i++) {
            if (_stock[i] == null) {
                --num;
            }
        }
        numberOfItems = num;
    }

    public int getNumOfItems() {
        return numberOfItems;
    }

    public boolean addItem(FoodItem item) {
        if (numberOfItems == 0) {
            _stock[0] = new FoodItem(item);
            numberOfItems++;
            return true;
        }
        for (int i = 0; i <= numberOfItems; i++) {
            if (_stock[i] != null) {
                break;
            } else if (_stock[i].equals(item)) {
                _stock[i].setQuantity(_stock[i].getQuantity() + item.getQuantity());
                return true;
            }
        }
        if (numberOfItems >= 100) {
            return false;
        } else {
            _stock[numberOfItems + 1] = new FoodItem(item);
            ++numberOfItems;
            return true;
        }
    }

    public String order(int amount) {
        String order = "";
        for (int i = 0; i <= numberOfItems; i++) {
            if (_stock[i] == null) {
                i++;
            }
            if (_stock[i].getQuantity() < amount) {
                order = order + _stock[i].getName() + ", ";
            }
        }
        return order;
    }

    public int howMany(int temp) {
        int itemInTemp = 0;
        for (int i = 0; i <= numberOfItems; i++) {
            if (_stock[i] == null) {
                i++;
            }
            if (_stock[i].getMinTemperature() < temp && _stock[i].getMaxTemperature() > temp) {
                itemInTemp += _stock[i].getQuantity();
            }
        }
        return itemInTemp;
    }

    public void removeAfterDate(Date d) {
        for (int i =0; i <= numberOfItems; i++) {
            if (_stock[i] == null) {
                i++;
            }
            if (_stock[i].getExpiryDate().after(d)){
                for (int j = i;j<=numberOfItems;j++){
//                    if (_stock[j] == null) {
//                        j++;
//                    }
                    FoodItem tmp = new FoodItem(_stock[j]);
                    _stock[j] = new FoodItem(tmp);
                }
                _stock[numberOfItems] = null;
                numberOfItems--;
            }
        }
    }

    public FoodItem mostExpensive() {
        int a = 0;
        FoodItem b = null;
        for (int i = 0; i <= numberOfItems; i++) {
            if (_stock[i] == null) {
                i++;
            }
            if (_stock[i].getPrice() > a) {
                b = new FoodItem(_stock[i]);
                a = _stock[i].getPrice();
            }
        }
        if (numberOfItems < 1) {
            return null;
        }
        return b;
    }

    public int howManyPieces() {
        int a = 0;
        for (int i = 0; i <= numberOfItems; i++) {
            if (_stock[i] != null) {
                a += _stock[i].getQuantity();
            }
        }
        return a;
    }

    public String toString() {
        String toString = "";
        for (int i = 0; i <= numberOfItems; i++) {
            if (_stock[i] == null) {
                i++;
            }
            toString = toString + "\n" + "FoodItem: " + _stock[i].getName() + "\t" + "CatalogueNumber:" + _stock[i].getCatalogueNumber() + "\t" + "ProductionDate: " + _stock[i].getProductionDate()
                    + "\t" + "ExpiryDate: " + _stock[i].getExpiryDate() + "\t" + "Quantity: " + _stock[i].getQuantity();
        }
        return toString;
    }

    public void updateStock(String[] items) {
        for (int i = 0; i <= numberOfItems; i++) {
            if (_stock[i] == null) {
                i++;
            }
            for (int j = 0; j < items.length; j++) {
                if (items[j].equals(_stock[i].getName())) {
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