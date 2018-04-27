package Astronomy;
import java.text.DecimalFormat;
import java.text.NumberFormat;

public class Calculator {
	/* All of the parameter names are followed by unit of measure. */

	public static void main(String[] args) {
		weightOnPlanet(100, 3390, 6.4185 * Math.pow(10, 23), "Mars");
		distanceToStar(.742, "Star");
		lengthOfYear(1.524, "Mars");
		luminocityOfStar(3, 2, "star");
		
		escapeVelocityOfObject( 5.98 * Math.pow(10, 24), 6.38 * Math.pow(10, 6), "Earth");
	}

	/**
	 * This method uses your weight, the radius of a different planet, and the
	 * mass of that planet to find out how much you would weigh on this planet. 
	 * 
	 * Equation used: weight ~ M/ (R^2)
	 * 
	 * @param weightEarthLBS
	 * @param radiusM
	 * @param PlanetMassKG
	 */
	public static String weightOnPlanet(double weightEarthLBS, double radiusM, double planetMassKG, String name) {
		double propMass = Math.round((planetMassKG / (5.98 * Math.pow(10, 24))) * 1000.0) / 1000.0;
		double propRadius = Math.round((radiusM / 6371) * 1000.0) / 1000.0;

		double propGrav = Math.round((propMass / (propRadius * propRadius)) * 1000.0) / 1000.0;
		double yourWeight = weightEarthLBS * propGrav;
		System.out.println("You are "+yourWeight + " lbs on " + name + ".");
		return "You are "+yourWeight + " lbs on " + name + ".";

	}
	/**
	 * This method uses the angle of parallax to calculate how far away a star is.
	 * d= 1/p
	 * 
	 * p= parallax in arcseconds 
	 * d= distance to star in Parsecs 
	 * 
	 * @param arcParallax
	 * @param name
	 * */ 
	public static String distanceToStar(double arcParallax, String name){
		double d = 1/arcParallax;
		double miles = d * 1.917 * Math.pow(10, 13);
		DecimalFormat formatter = new DecimalFormat("#,###");
		System.out.println(name + " is " + formatter.format(miles) + " miles away.");
		return name + " is " + formatter.format(miles) + " miles away.";
	}
	
	/**
	 * This method uses Kepler's 3rd law to find the orbital period of planets in earth days.
	 * 
	 * p^2 = a^3 or p = a^3/2
	 * 
	 * p = orbital period in yrs
	 * a = distance in AU
	 * 
	 * @param distance
	 * @param name
	 * */
	
	public static String lengthOfYear(double distance, String name){
		double p2 = Math.pow(distance, 3);
		double p = Math.sqrt(p2) * 365;
		DecimalFormat formatter = new DecimalFormat("#,###");
		System.out.println("A year on " + name + " is about " + formatter.format(p)  + " Earth days long.");
		return "A year on " + name + " is about " + formatter.format(p)  + " Earth days long.";
	}
	
	/**
	 * This method finds the luminosity of a star compared to our sun using the star's surface area and surface temperature. 
	 * L = R^2 *T^4
	 * R = radius in solar units
	 * T = temperature in solar units
	 * 
	 * CREATE AN IF STATEMENTS FOR RADIUS'S AND TEMPS <1 SOLAR UNITS
	 * 
	 * */
	public static String luminocityOfStar(double radius, double temp, String name){
		double lum = Math.pow(radius, 2) * Math.pow(temp, 4);
		DecimalFormat formatter = new DecimalFormat("#,###.000");
		System.out.println("" + name + " emits about " + formatter.format(lum)  + " times the light of the sun.");
		return "" + name + " emits about " + formatter.format(lum)  + " times the light of the sun.";
	}
	
	/**
	 * This method finds the escape velocity of an object in space. 
	 * escape = square root of (2GM)/R
	 * G= gravitational constant
	 * M = mass of object 
	 * R= radius of object
	 * 
	 */
	 
	public static String escapeVelocityOfObject(double mass, double radius, String name){
		double numE = 2 * 6.67408 * Math.pow( 10, -11) * mass;
		double escape = Math.sqrt(numE/radius);
		double toMileS = escape * 0.000621371;
		double toMileH = toMileS * 3600;
		DecimalFormat formatter = new DecimalFormat("#,###");
		System.out.println("The escape velocity of " + name + " is about " + formatter.format(toMileS)  + " miles per second or about " + formatter.format(toMileH) + " miles per hour. ");
		return "The escape velocity of " + name + " is about " + formatter.format(toMileS)  + " miles per second or about " + formatter.format(toMileH) + " miles per hour. ";
	}
	
	/**
	 * This method finds the ratio of a planet's radius and Earth's radius. 
	 * ratio = R/ 6,371
	 * R= radius of object (km)
	 * 
	 */
	public static String proportionalSize(double radius, String name){
		double ratio = radius/ 6371;
		DecimalFormat formatter = new DecimalFormat("#,###.000");
		System.out.println("" + name + " is about " + formatter.format(ratio)+ " times the size of Earth.");
		return "" + name + " is about " + formatter.format(ratio)+ " times the size of Earth.";
	}
	
}
