import javax.swing.AbstractAction;
import javax.swing.ActionMap;

public class PlayerControlledObject {

	ActionMap map;
	
	public PlayerControlledObject() {
		super();
	
	}
	public void putAction(Object command, AbstractAction act) {
		map.put(command, act);
	}
}
