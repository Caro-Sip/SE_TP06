public class SessionDemo {

	public static void main(String[] args) {
		System.out.println("Session Demo - Phase 2");

		// Create a valid session (HHmm format)
		Session mathSession = new Session("Math Review", 900, 1100);
		printSession(mathSession);

		// Update duration to a valid new range
		mathSession.setDuration(1000, 1200);
		System.out.println("Updated:");
		printSession(mathSession);

		// Attempt to create an invalid session (end before start)
		try {
			Session invalidSession = new Session("Invalid Planning", 1400, 1300);
			printSession(invalidSession);
		} catch (IllegalArgumentException ex) {
			System.out.println("Caught error creating session: " + ex.getMessage());
		}

		// Attempt to set an invalid duration on an existing session
		try {
			mathSession.setDuration(1200, 1200);
		} catch (IllegalArgumentException ex) {
			System.out.println("Caught error updating duration: " + ex.getMessage());
		}

		// Another valid example
		Session csSession = new Session("CS Practice", 1300, 1500);
		printSession(csSession);

		// Invalid name example
		try {
			Session badName = new Session("   ", 900, 1000);
			printSession(badName);
		} catch (IllegalArgumentException ex) {
			System.out.println("Caught error with name: " + ex.getMessage());
		}
	}

	private static void printSession(Session session) {
		int durationMinutes = session.getDurationMinutes();
		System.out.println(
				"Session: " + session.getSessionName() +
				" | Start: " + session.getStartTime() +
				" | End: " + session.getEndTime() +
				" | Duration: " + durationMinutes + " min"
		);
	}
}
