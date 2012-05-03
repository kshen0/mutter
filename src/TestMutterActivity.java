import edu.upenn.cis350.MutterActivity;
import junit.framework.TestCase;


public class TestMutterActivity extends TestCase {
	private MutterActivity activity;
	public void setUp() {
		activity = new MutterActivity();
	}
	
	// tests that setUpPoints properly formats the data
	public void testSetUpPointsNurse() {
		setUp();
		int x = activity.setupPoints(0).size() % 4;
		assertEquals(0, x);
	}
	
	public void testSetUpPointsSoldier() {
		setUp();
		int x = activity.setupPoints(1).size() % 4;
		assertEquals(0, x);
	}
}
