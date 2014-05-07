package com.example.actionbarsherlockdemo;



import java.util.ArrayList;

import android.os.Bundle;
import android.widget.ListView;

import com.actionbarsherlock.app.SherlockActivity;
import com.example.adapters.SimpleObjectAdapter;
import com.example.data.SimpleObject;

public class MainActivity extends SherlockActivity {
	
	
	private static final int OBJECT_COUNT = 25;
	
	 ListView mListViewItems;
	 ArrayList<SimpleObject> items;
	 SimpleObjectAdapter mAdapter;

	 // ----------------------------------------------------------------------
	 // Class Overrides
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mListViewItems = (ListView) findViewById(R.id.listViewDemoItems);
        
        items = buildObjects(OBJECT_COUNT);
        
        if((items != null) && (items.size() >0))
        {
        	mAdapter = new SimpleObjectAdapter(getApplicationContext(),items);
        
        	mListViewItems.setAdapter(mAdapter);
        }else{
        	//TODO: Set Something else as the View
        }
        
       
    }
    
    /**
     * This method creates the SimpleObject items for the ListView.
     * 
     * @param objectCount
     * @return itemObjects - an ArrayList of SimpleObject data objects
     */
    private ArrayList<SimpleObject> buildObjects(int objectCount) {
    	// ArrayList<SimpleObject> to return
		ArrayList<SimpleObject> itemObjects = new ArrayList<SimpleObject>();
		
		// Initialize the dailyDeals boolean array
		boolean dailyDeals [] = new boolean[objectCount];
		
		// Products Array
		String [] products = {	"Android T-Shirt","Jave Bean Coffee Mug","Basketball","Batman Yo-Yo","iPod 32 GB",
								"Mint Bubble Gum","Gold Bracelet","Red High Heels", "Apple T-Shirt","Jave POJO Coffee Mug",
								"Soccer ball","Spiderman Yo-Yo","iPad Air 32 GB","WinterGreen Bubble Gum","Silver Bracelet",
								"Black Loafers", "Apache T-Shirt","Oasis Coffee Mug","Baseball Glove", "Hulk Yo-Yo",
								"iPhone 5S 64 GB","Motorola Moto X","XDA Developer T-Shirt","Galaxy S5","Google Nexus 7"};
		
		// Prices Array
		String [] prices = {"9.99","12.95","25.00","7.50","399.99",
							"2.99","2000.00","99.99","4.99","9.99",
							"19.85","6.49","699.00","1.49","199.99",
							"25.45","19.49","17.00","64.99","5.99",
							"899.99","150.00","35.00","699.99","239.00"};
		// Ratings Array
		int [] ratings = {	1,4,2,1,5,
							5,2,4,3,2,
							1,3,4,5,4,
							5,3,4,5,2,
							4,1,5,2,3};
		if(objectCount > products.length){
			//TODO: Build an alert Dialog here to catch this error condition and alert the user
			
			
		}else{
			// Create the Daily Deals every 4th Item
			for(int j = 0; j < objectCount; j++){
				if(j % 4 == 1){
					dailyDeals[j] = false;
				}else{
					dailyDeals[j] = true;
				}
			}
		
			// Loop through the Array of objects
			for(int i = 0; i < objectCount; i++){
				// Create a new SimpleObject Item
				SimpleObject item = new SimpleObject();
			
				// Set its Values
				item.setProductName( products[i]);
				item.setProductPrice("$" + prices[i]);
				item.setDailyDeal(dailyDeals[i]);
				item.setRating(ratings[i]);
			
				// Add the Item to the ArrayList<SimpleObject
				itemObjects.add(item);
			}
		}
		
		// Return the itemObjects ArrayList
		return itemObjects;
	}


	

}
