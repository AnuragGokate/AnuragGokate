import org.openqa.selenium.interactions.Keyboard;

public class Car {
	public static void start() {
		System.out.println("Car---Starts");
	}

	public static void start(int a) {
		System.out.println("Car---Starts1");
	}
	
	public static void start(int a, int b) {
		System.out.println("Car---Starts11");
	}
	public void stop() {
		System.out.println("Car---Stops");
	}

	public void refuel() {
		System.out.println("Car---Refuel");
	}

}
