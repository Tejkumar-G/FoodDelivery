package com.example.fooddelivery.helper;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Toast;

import com.example.fooddelivery.R;
import com.example.fooddelivery.db.Food;
import com.example.fooddelivery.db.category.Category;

import java.util.ArrayList;
import java.util.List;

public class Utills {

   public static List<Food> getFoodList(Context context) {

        List<Food> foodList = new ArrayList<>();

        Food food = new Food("Single Burger", 200, "Burger", "cheeseburger.png","https://thumbs.dreamstime.com/z/fresh-burger-isolated-single-fresh-burger-cheese-bacon-isolated-white-background-123616976.jpg");
        foodList.add(food);
        Food food1 = new Food("Burger Combo", 150, "Burger", "pizza.png", "https://cdn.saharmall.com/Upload//10015//Products//s_637279993786015538_41172.jpg");
        foodList.add(food1);
        Food food2 = new Food("Burger Chicken", 150, "Burger", "pizza.png", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRwKEaJRRHGht9s-EccdsLm-KlJ9OHb-jKS6A&usqp=CAU");
        foodList.add(food2);
        Food food3 = new Food("Chocolate MilkShake", 220, "MilkShake", "Chocolate.png", "https://images.unsplash.com/photo-1572490122747-3968b75cc699?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxzZWFyY2h8MXx8Y2hvY29sYXRlJTIwbWlsa3NoYWtlfGVufDB8fDB8fA%3D%3D&w=1000&q=80");
        foodList.add(food3);
        Food food4 = new Food("Mango MilkShake", 170, "MilkShake", "Mango.png", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQoFi5rYsS4t08giHqjSgUpsPByQD3BvloWcw&usqp=CAU");
        foodList.add(food4);
        Food food5 = new Food("Strawberry MilkShake", 190, "MilkShake", "Strawberry.png","https://foodwithfeeling.com/wp-content/uploads/2021/06/strawberry-milkshake-4.jpg");
        foodList.add(food5);
       Food food6 = new Food("Cheese Sandwich", 120, "Sandwich", "Cheesesandwich.png","https://media.30seconds.com/tip/lg/Grilled-Cheese-Sandwich-Ideas-20-Creative-Ways-to-Make-a-G-20617-88a23048eb-1615952482.jpg");
       foodList.add(food6);
       Food food7 = new Food("Mushroom Sandwich", 180, "Sandwich", "Mushroomsandwich.png","https://simply-delicious-food.com/wp-content/uploads/2019/10/Mushroom-grilled-cheese-1.jpg");
       foodList.add(food7);
       Food food8 = new Food("Coke", 100, "Drinks", "Coke.png","https://www.eatthis.com/wp-content/uploads/sites/4/media/images/ext/108098914/coca-cola-soda-ice.jpg?quality=82&strip=1");
       foodList.add(food8);
       Food food9 = new Food("Red Velvet Cake", 150, "Desserts", "RedVelvetCake.png","https://natashaskitchen.com/wp-content/uploads/2021/02/Red-Velvet-Cake-4.jpg");
       foodList.add(food9);
       Food food10 = new Food("Lays", 50, "Chips", "Lays.png","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRoNDDB0sOiEZ2nYE8nuMFuzXaHVK4tT23KZw&usqp=CAU");
       foodList.add(food10);
       Food food11 = new Food("Cola Vodka", 290, "Cocktail", "Vodka.png","https://thumbs.dreamstime.com/b/cuba-libre-vodka-cola-cuba-libre-vodka-cola-lime-wedge-isolated-white-background-151628963.jpg");
       foodList.add(food11);
       Food food12 = new Food("Cup Cake", 100, "Desserts", "cupcake.png","https://image.shutterstock.com/z/stock-photo-tasty-cupcakes-on-a-white-wooden-table-556435444.jpg");
       foodList.add(food12);
       Food food13 = new Food("Beer", 100, "Cocktail", "beer.png","https://images.unsplash.com/photo-1608270586620-248524c67de9?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxzZWFyY2h8Nnx8YmVlcnxlbnwwfHwwfHw%3D&w=1000&q=80");
       foodList.add(food13);
       Food food14 = new Food("Nachos", 100, "Chips", "nachos.png","https://www.seriouseats.com/thmb/tntNdOAMuxyGZHrYR3YZeO0k7Lo=/1500x1125/filters:fill(auto,1)/cheese-sauce-for-cheese-fries-and-nachos-hero-01-e6ccf966688c43ec8025cf9a19678423.jpg");
       foodList.add(food14);
       Food food15 = new Food("7up", 100, "Drinks", "7up.png","https://image.shutterstock.com/image-photo/st-petersburg-russia-february-29-260nw-1666349866.jpg");
       foodList.add(food15);

        return foodList;

    }

     public static List<Category> getCategoryList(Context context) {

          List<Category> foodList = new ArrayList<>();

          Category food1 = new Category( "Burger","https://cdn-icons-png.flaticon.com/512/71/71928.png");
          foodList.add(food1);

          Category food2 = new Category( "MilkShake", "https://cdn.iconscout.com/icon/premium/png-256-thumb/milkshake-27-986343.png");
          foodList.add(food2);

         Category food3 = new Category( "Sandwich", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRtFXIGS2stipcNHexFhw9ZUbFbfw9SYN2fXjMMiui4VnWxQQj-VJW--d1j7W2cVgHsIyU&usqp=CAU");
         foodList.add(food3);

         Category food4 = new Category( "Drinks", "https://cdn.imgbin.com/13/23/7/imgbin-computer-icons-fizzy-drinks-takeaway-jF25228KSYTUJ96bx1e7KHWi0.jpg");
         foodList.add(food4);

         Category food5 = new Category( "Desserts", "https://flyclipart.com/thumb2/cliparts-hello-kitty-desserts-clipart-697568.png");
         foodList.add(food5);

         Category food6 = new Category( "Chips", "https://cdn.w600.comps.canstockphoto.com/potato-chips-vector-engraving-vintage-vector-clipart_csp51149208.jpg");
         foodList.add(food6);

         Category food7 = new Category( "Cocktails", "https://coloringhome.com/coloring/Kij/gpd/KijgpdyXT.jpg");
         foodList.add(food7);


          return foodList;

     }

     public static void showToast(String message, Context context) {
          Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
     }

    public static void closeKeyboard(View view)
    {

        // if nothing is currently
        // focus then this will protect
        // the app from crash
        if (view != null) {

            // now assign the system
            // service to InputMethodManager
            InputMethodManager manager
                    = (InputMethodManager)
                    view.getContext().getSystemService(
                            Context.INPUT_METHOD_SERVICE);
            manager
                    .hideSoftInputFromWindow(
                            view.getWindowToken(), 0);
        }
    }
}
