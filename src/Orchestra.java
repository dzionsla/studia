import java.util.ArrayList;

public class Orchestra implements Instrument{
	private ArrayList<Instrument> instruments = new ArrayList<>();

	public void addInstrument(Instrument instr) {
		instruments.add(instr);
	}
	
	public void play() {
		for (Instrument instr: instruments) {
			instr.play();
		}
	}
}

