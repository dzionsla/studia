
public class Guitar implements Instrument{
	public void play() {
		System.out.println("play() from: " + this.getClass().getSimpleName());
	}
}
