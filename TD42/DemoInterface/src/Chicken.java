
public class Chicken extends Animal implements Edible {
	@Override
	public String howToEat() {
		return "Fry it";
	}
	@Override
	public String sound() {
		return "ooooooooo";
	}
}
