package Libb;
import java.util.ArrayList;

public class ShoppingCartManualTest {

    public static void run() {
        System.out.println("--- Starting Shopping Cart Calculator Tests ---");
        System.out.println(); // for spacing

        int passedCount = 0;
        int failedCount = 0;

        // Test 1: ตะกร้าเป็น null
        try {
            double total1 = ShoppingCartCalculator.calculateTotalPrice(null);
            if (total1 == 0.0) {
                System.out.println("PASSED: Null cart should return 0.0");
                passedCount++;
            } else {
                System.out.println("FAILED: Null cart expected 0.0 but got " + total1);
                failedCount++;
            }
        } catch (Exception e) {
            System.out.println("FAILED: Null cart caused an exception: " + e.getMessage());
            failedCount++;
        }

        // Test 2: ตะกร้าว่าง
        ArrayList<CartItem> emptyCart = new ArrayList<>();
        double total2 = ShoppingCartCalculator.calculateTotalPrice(emptyCart);
        if (total2 == 0.0) {
            System.out.println("PASSED: Empty cart should return 0.0");
            passedCount++;
        } else {
            System.out.println("FAILED: Empty cart expected 0.0 but got " + total2);
            failedCount++;
        }

        // Test 3: คำนวณปกติ ไม่มีส่วนลด
        ArrayList<CartItem> simpleCart = new ArrayList<>();
        simpleCart.add(new CartItem("NORMAL", "Bread", 25.0, 2)); // 50
        simpleCart.add(new CartItem("NORMAL", "Milk", 15.0, 1));      // 15
        double total3 = ShoppingCartCalculator.calculateTotalPrice(simpleCart);
        if (total3 == 65.0) {
            System.out.println("PASSED: Simple cart total is correct (65.0)");
            passedCount++;
        } else {
            System.out.println("FAILED: Simple cart total expected 65.0 but got " + total3);
            failedCount++;
        }
        //test 4 : คำนวณค่าปกติ เป็น 0 / ติดลบ  
        simpleCart.clear(); 
        simpleCart.add(new CartItem("NORMAL", "Bread", 25.0, 1)); // 25
        simpleCart.add(new CartItem("NORMAL", "Water", 10.0, 0));  // 0
        simpleCart.add(new CartItem("NORMAL", "Milk", 15.0,-1));  // -15
        double total4 = ShoppingCartCalculator.calculateTotalPrice(simpleCart);
        if (total4 == 25.0) {
            System.out.println("PASSED: Simple cart total is correct (25.0)");
            passedCount++;
        } else {
            System.out.println("FAILED: Simple cart total expected 25.0 but got " + total4);
            failedCount++;
        }



        //test 5 : คำนวณซื้อ1แถม1 BOGO
        simpleCart.clear(); // ลบของในตะกร้า(เพื่อไม่ให้ของคำนวณปนกัน)
        simpleCart.add(new CartItem("BOGO" , "Water" , 10.0,4)); //10*4  = 20
        simpleCart.add(new CartItem("BOGO" , "WaterMelon" , 30.0,1)); //30 * 1  =  30
        simpleCart.add(new CartItem("BOGO" , "Butter" , 15.0,2)); // 15*15 = 15 
        double total5 = ShoppingCartCalculator.calculateTotalPrice(simpleCart);
        if (total5  == 65.0 )
            {
                System.out.println("PASSED: Simple cart total is correct (65.0)");
                passedCount++;
            }
            else{
                System.out.println("FAILED: Simple cart total expected 65.0 but got " + total5);
                failedCount++;

            }
        

        //test 6 :  คำนวณมีส่วนลด BULF
        simpleCart.clear(); // ลบของในตะกร้า(เพื่อไม่ให้ของคำนวณปนกัน)
        simpleCart.add(new CartItem("BULK" ,  "Pussy" , 15.0 , 6));  //(15*6)) - ((15*6) / 10) = 81
        simpleCart.add(new CartItem("BULK" ,  "Kuy" , 25.0 , 7)); // (25*7) - ((25*7)/10 ) 157.5
        simpleCart.add(new CartItem("BULK" ,  "Heemean" , 15.0 , 8)); //(15*8 - ((15*8)/10)=108
        double total6 = ShoppingCartCalculator.calculateTotalPrice(simpleCart);
        if (total6 == 346.5)
            {
                System.out.println("PASSED: Simple cart total is correct (346.5)");
                passedCount++;
            }
            else{
                System.out.println("FAILED: Simple cart total expected 346.5.0 but got " + total6);
                failedCount++;
            }
        

        // --- Test Summary ---
        System.out.println("\n--------------------");
        System.out.println("--- Test Summary ---");
        System.out.println("Passed: " + passedCount + ", Failed: " + failedCount);
        if (failedCount == 0) {
            System.out.println("Excellent! All tests passed!");
        } else {
            System.out.println("Some tests failed.");
        }
    }

    public static class run {

        public run() {
        }
    }
}