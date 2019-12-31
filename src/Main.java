public class Main {
    public static void main(String[] args){
        Date t1 = new Date(1,1,2000);
        Date t2 = new Date(1,1,2001);
        Date t3 = new Date(1,1,2002);
        FoodItem f1 = new FoodItem("Milk", 1111, 12, t1, t2, 7, 10, 5);
        FoodItem f2 = new FoodItem("Honey", 2222, 2, t1, t3, 6, 10, 20);
        FoodItem f3 = new FoodItem("PopCorn", 3333, 2, t1, t3, 6, 10, 12);

        Stock st = new Stock();
        st.addItem(f3);
        st.addItem(f2);
        st.addItem(f1);
        System.out.println(st);
    }
}
