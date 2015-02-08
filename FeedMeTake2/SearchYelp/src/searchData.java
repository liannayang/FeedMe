import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;


public class searchData {
	
	public static void main (String[] args){
		List <String> listYelp = new ArrayList <String>();
		List <String> listAmie = new ArrayList <String>();
		File fileAmie = new File("C:\\Users\\houndar\\Desktop\\RCM_dataset.csv");
		File fileYelp = new File("C:\\Users\\houndar\\Desktop\\yelp_academic_dataset_business.json");
	    BufferedReader reader = null;
	
	    try {
	        reader = new BufferedReader(new FileReader(fileYelp));
	        String text = null;
	        while ((text = reader.readLine()) != null) {
	        	listYelp.add(text);
	        }
	     } catch (Exception e) {
	    	 e.printStackTrace();
	     }finally {
	        try {
	           if (reader != null) {
	               reader.close();
	           }
	        } catch (Exception e) {
	        	}
	    }
	    
	    try {
	        reader = new BufferedReader(new FileReader(fileAmie));
	        String text = null;
	        while ((text = reader.readLine()) != null) {
	        	listAmie.add(text);
	        }
	     } catch (Exception e) {
	    	 e.printStackTrace();
	     }finally {
	        try {
	           if (reader != null) {
	               reader.close();
	           }
	        } catch (Exception e) {
	        	}
	    }
	    
	    String str = null;
	    String tempStr = null;
	    List <String> newList = new ArrayList <String>();
	    while(!listYelp.isEmpty()){
	    	double[] tempArr = new double[2];
	    	tempStr="";
	    	str = listYelp.remove(0);
	    	for (int i=12 ; i<20 ; i++){
	    		tempStr += str.charAt(str.indexOf("longitude")+i);
	    	}
	    	tempArr[0] = Float.parseFloat(tempStr);
	    	tempStr="";
	    	for (int i=11 ; i<18 ; i++){
	    		tempStr += str.charAt(str.indexOf("latitude")+i);
	    	}
	    	tempArr[1] = Float.parseFloat(tempStr);
	    	if(getDist(tempArr[0],-73.569879999999999,tempArr[1],45.511852099999999999) < 10){
	    		newList.add(str);
	    	}
	    }
	    
	    
	    while (!newList.isEmpty()){
	    	System.out.println(newList.get(0));
	    	System.out.println(getName(newList.get(0)));
	    	System.out.println(getPrice(listAmie.remove(0)));
	    	System.out.println(getStars(newList.remove(0)));
	    }
	 
	}
	
	private static double getDist(double a, double b, double c, double d){
		return 2*6371*Math.asin(Math.sqrt(Math.pow(Math.sin((d-c)/2 + Math.cos(d)*Math.cos(c)*Math.pow(Math.sin((b-a)/2), 2)),2)));
	}
	private static float getStars(String str){
		String temp="No rating available";
		float numberOfStars = -1;
		if(str.contains("\"stars\"")){
			temp="";
			for (int i=str.indexOf("\"stars\"")+9 ; i<=str.indexOf("\"stars\"")+11 ; i++){
				temp += str.charAt(i);
				
			}
			numberOfStars = Float.parseFloat(temp);
		}
		return numberOfStars;
	}
	private static String getName(String str){
		String temp = "No name available";
		int i=0;
		if(str.contains("\"name\"")){
			temp ="";
			i=str.indexOf("\"name\"")+9;
			if (str.charAt(i) == '\"'){
				i++;
			}
			while (str.charAt(i) != '\"'){
				temp += str.charAt(i);
				i++;
			}
		}
		return temp;
	}
	private static String getOrigin(String str){
		String temp = "No categories information available";
		int i=0;
		if(str.contains("\"categories\"")){
			temp ="";
			i=str.indexOf("\"categories\"")+15;
			while (str.charAt(i) != ']'){
				temp += str.charAt(i);
				i++;
			}
		}
		return temp;
	}
	
	private static String getPrice(String str){
		String temp = "No price information found";
		if(str.contains("$")){
			temp = "";
			int i=0;
			while (str.charAt(str.indexOf('$')+i) == '$'){
				temp += str.charAt(str.indexOf('$')+i);
				i++;
			}
		}
		return temp;
	}
}






/*locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 60000, 150, new LocationListener() {

	  @Override

	  public void onStatusChanged(String provider, int status, Bundle extras) {

	  }

	  @Override

	  public void onProviderEnabled(String provider) {

	  }

	  @Override

	  public void onProviderDisabled(String provider) {

	  }

	  @Override

	  public void onLocationChanged(Location location) {

	    Log.d("GPS", "Latitude " + location.getLatitude() + " et longitude " + location.getLongitude());

	  }

	});*/