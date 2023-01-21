import java.util.Scanner;
import java.io.*;
public class testing {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner scnr = new Scanner(System.in);
		
		Forecast onDefault = new Forecast();
		int rainTest= 0;
		double fahrenheitTest =0; 
		String skyTest="";
		double convert=0;
		String file;
		
		
		Forecast testing = new Forecast(fahrenheitTest,skyTest,rainTest );
		
		
		//Testing when no value is supplied//
		System.out.println("No input");
		System.out.println("Temperature: "+onDefault.getFahrenheit());
		System.out.println("Sky: "+onDefault.getSky());
		System.out.println("Possibility of raining: "+onDefault.getRain());
		
		//Testing when value is supplied//
		System.out.println("Input given");
		fahrenheitTest = scnr.nextDouble();
		skyTest = scnr.next();
		rainTest = scnr.nextInt();
		
		
		testing.setFahrenheit(fahrenheitTest);
		testing.setSky(skyTest);
		testing.setRain(rainTest);
		
		System.out.println("Temperature: "+testing.getFahrenheit());
		System.out.println("Sky: "+testing.getSky());
		System.out.println("Possibility of raining: " +testing.getRain());
		
		//Testing the methods that convert the temperature//
		
		System.out.println("");
		
		System.out.println("Testing convert the temperature");
		
		convert = testing.getFahrenheit();
		System.out.println("From Fahrenheit to Celcius:");
		System.out.println(testing.fahToCel(convert));
		System.out.println("From Fahrenheit to Kelving:");
		System.out.println(testing.fahToKel(convert));
		
		convert = testing.fahToCel(convert);
		System.out.println("From Celcius to Fahrenheit:");
		System.out.println(testing.celToFah(convert));
		
		convert = testing.getFahrenheit();
		convert = testing.fahToKel(convert);
		System.out.println("From Kelvin to Fahrenheit:");
		System.out.println(testing.kelToFah(convert));
		
		//Testing if it will rain or not//
		
		System.out.println("");
		System.out.println("Is it going to rain today?");
		if(testing.rainOrNot()==true) {
			System.out.println("Today will rain");	
		}
		else {
			System.out.println("Today will not rain");	
		}
		
		//Testing the print method//
		System.out.println("");
		System.out.println("Here is a recap of the climate today:");
		testing.print();
		
		//testing the print to file method//
		
		System.out.println("");
		System.out.println("Insert the name of the file that you would like to save these results");	
		
		file = scnr.next();
		
		testing.printToFile(file);
		
		
	}

}
