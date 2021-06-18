package com.example.my.BooksCart;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.my.BooksCart.Adapter.ProductAdapter;
import com.example.my.BooksCart.Model.ProductModel;
import com.example.my.BooksCart.View.CartActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements ProductAdapter.CallBackUs, ProductAdapter.HomeCallBack {

    public static ArrayList<ProductModel> arrayList = new ArrayList<>();
    public static int cart_count = 0;
    ProductAdapter productAdapter;
    RecyclerView productRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addProduct();
        productAdapter = new ProductAdapter(arrayList, this, this);
        productRecyclerView = findViewById(R.id.product_recycler_view);


        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 3, LinearLayoutManager.VERTICAL, false);
        productRecyclerView.setLayoutManager(gridLayoutManager);
        productRecyclerView.setAdapter(productAdapter);

    }


    private void addProduct() {
        ProductModel productModel = new ProductModel("Book 01", "177", "80", R.drawable.book_one);
        arrayList.add(productModel);
        ProductModel productModel1 = new ProductModel("Book 02", "2000", "70", R.drawable.book_two);
        arrayList.add(productModel1);
        ProductModel productModel2 = new ProductModel("Book 03", "306", "50", R.drawable.book_three);
        arrayList.add(productModel2);

        ProductModel productModel3 = new ProductModel("Book 04", "405", "20", R.drawable.book_four);
        arrayList.add(productModel3);
        ProductModel productModel12 = new ProductModel("Book 05", "500", "10", R.drawable.book_five);
        arrayList.add(productModel12);
        ProductModel productModel23 = new ProductModel("Book 06 ", "360", "90", R.drawable.book_six);
        arrayList.add(productModel23);

        ProductModel productModel4 = new ProductModel("Book 07", "870", "290", R.drawable.book_seven);
        arrayList.add(productModel4);
        ProductModel productModel14 = new ProductModel("Book 08", "480", "140", R.drawable.book_eight);
        arrayList.add(productModel14);
        ProductModel productModel25 = new ProductModel("Book 09", "890", "100", R.drawable.book_nine);
        arrayList.add(productModel25);

        ProductModel productModel5 = new ProductModel("Book 10", "198", "20", R.drawable.book_ten);
        arrayList.add(productModel5);
        ProductModel productModel16 = new ProductModel("Book 11", "207", "190", R.drawable.book_eleven);
        arrayList.add(productModel16);

    }

    @Override
    public void addCartItemView() {

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        MenuItem menuItem = menu.findItem(R.id.cart_action);
        menuItem.setIcon(Converter.convertLayoutToImage(MainActivity.this, cart_count, R.drawable.ic_shopping_cart_white_24dp));
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        switch (item.getItemId()) {
            case R.id.cart_action:
                if (cart_count < 1) {
                    Toast.makeText(this, "There is no item in cart", Toast.LENGTH_SHORT).show();
                } else {
                    startActivity(new Intent(this, CartActivity.class));
                }
                break;
            default:
                return super.onOptionsItemSelected(item);
        }

        return true;
    }

    @Override
    public void updateCartCount(Context context) {
        invalidateOptionsMenu();
    }

    @Override
    protected void onStart() {
        super.onStart();
        invalidateOptionsMenu();
    }
}
