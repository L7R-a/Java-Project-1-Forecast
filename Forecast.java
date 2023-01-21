import java.util.Random;
import java.util.Arrays;
import java.io.*;


//Part 1//

public class Forecast {
	
//Variables//
	
double fahrenheit ;
String sky ;
int rain;

//Constructors//

public Forecast() {
	fahrenheit = 72.0;
	sky = "clear";
	rain = 0;
}

public Forecast(double fahrenheitValue, String skyString , int rainValue ) {
	fahrenheit = fahrenheitValue;
	sky = skyString;
	rain = rainValue;
}

//Accessors and mutators//

public void setFahrenheit(double temperature){

	if (temperature < -100.0 || temperature > 150.0) {
		fahrenheit = 72.0;
	}
	
	else {
		fahrenheit = temperature;	
	}
	
}

public double getFahrenheit(){
	return fahrenheit;
}

public void setSky(String condition){
	
	sky = condition;

}

public String getSky(){
	return sky;
}

public void setRain(int chance){

	if (chance < 0 || chance > 100) {
		
		rain = 0;
	}
	
	else {
		rain = chance;	
	}
	
}

public String getRain(){
	String percentage = (String.valueOf(rain)+"%");
	return percentage ; 
}

//Methods that convert the temperature//

public double fahToCel(double temperature) {
	temperature = (((temperature - 32)*5)/9);
	
	return temperature;
}

public double celToFah(double temperature) {
	temperature = (((temperature)*9)/5)+32;
	
	return temperature;
}

public double fahToKel(double temperature) {
	temperature = (((temperature - 32)*5)/9)+273.15;
	
	return temperature;
}


public double kelToFah(double temperature) {
	temperature = (((temperature - 273.15)*9)/5)+32;
	
	return temperature;
}

// Method that determines whether it rains or not//

public boolean rainOrNot() {
	
	boolean result = false;
	
	String rain = getRain();
	String removePercentage = rain.replaceAll("%","");
	int rainChance = Integer.parseInt(removePercentage);
	
	//Convert the rain percentage into a int value//
	
	int chance = (int) (Math.random()*101);	
	//select a number at random// 
	
	for(int i = 0; i<rainChance;i++) {
		
		int [] record = new int [101];
		
		int compare = (int) (Math.random()*101);
		
		record[i] = compare;
		
		 for(int g = 0; g < record.length; g++) {
	            if(record[g] == compare) {
	            	compare = (int) (Math.random()*101);
	            	record[i] = compare;
	            }
	        }
		// If the value is equal to a previous attempt, it will roll again//
		
		if (compare == chance) {
			
			result = true;
			
			break;
			
		}
		else {
			result = false;
		}
	}
	
	//will run the for loop the same amount that the rain chance have//
	
	return result;
}

public void print() {
	System.out.println("Today the temperature in Fahrenheits is of " + getFahrenheit());
	System.out.println("The sky for this morning is " + getSky());
	System.out.println("As mentioned earlier, there is a " + getRain() + " chance of raining today");
	

}

//Part 2//

public void printToFile(String file) {

	try {
		FileReader reader = new FileReader ("F:\\Programming Project 4\\src\\" + file + ".txt");
	}
	catch(FileNotFoundException e) {
		System.out.println("Caught FileNotFoundException." + e.getMessage());
		return;
	}
	try {
		
	
		File fr = new File ("F:\\Programming Project 4\\src\\" + file + ".txt");
		PrintStream toFile = new PrintStream(fr);
		PrintStream notInFile = System.out;
		
	    System.setOut(toFile);
	    System.out.println("These are the results for the Forecast class");
	    System.out.println("The temperature in Fahrenheits for today is: "+ getFahrenheit());
	    System.out.println("The sky is going to be "+ getSky());
	    System.out.println("And lastly, the probability of raining today is of "+ getRain());
	    
	    System.setOut(notInFile);
        System.out.println("File successfully edited");
	}
	
	catch (IOException ex) {
		System.out.println("Caught IOException." + ex.getMessage());

	}
	catch(Exception exp) {
		System.out.println("Error.");
	}
	}
}
