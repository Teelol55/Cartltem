package Libb;
import java.util.ArrayList;

public class ShoppingCartCalculator {

    /**
     * เขียน Javadoc ที่นี่เพื่ออธิบายกฎการทำงานและกรณีพิเศษ:
     * - จะทำอย่างไรถ้า items เป็น null หรือ empty?
     * - จะทำอย่างไรถ้า CartItem มี price หรือ quantity ติดลบ?
     * - กฎส่วนลด BOGO (ซื้อ 1 แถม 1)
     * - กฎส่วนลด BULK (ซื้อ >= 6 ชิ้น ลด 10%)
     */

    public static double calculateTotalPrice(ArrayList<CartItem> items) {
        
        if (items==null || items.size() <= 0) {
            return 0.0;
        }

       double Total = 0.0;
         for (CartItem i : items) {
            if (i.price() <= 0 || i.quantity() <= 0){
                continue;
}

            if ("NORMAL".equals(i.sku())) {
                Total += i.price() * i.quantity();
            }

            else if("BOGO".equals(i.sku())){
                Total += (i.price()*i.quantity()) - (i.price() * ((i.quantity()/2)));
            }

            else if("BULK".equals(i.sku())){
                if (i.quantity() >= 6){
                    Total += (i.price()*i.quantity()  - ((i.price() * i.quantity())/10));
                }
                else Total += i.price()*i.quantity();
            }
        }
    
        return Total;
    }
}
