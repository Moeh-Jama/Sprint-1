
public class Room {
	private int doorx;
	private int doory;

	private static boolean isKitchen(int x, int y) {
		if ((x <= 140) && (y <= 158)) {
			return true;
		}
		return false;
	}

	private static boolean isBallroom(int x, int y) {

		if ((y >= 40 && y <= 180) && (x >= 195 && x <= 366)) {

			return true;
		} else if ((y >= 0 && y <= 46) && (x >= 235 && x <= 324)) {
			// System.out.println("Ball Room");
			return true;
		} else {
			return false;
		}
	}

	public boolean isDoor() {

		return false;
	}

	private static boolean isLounge(int x, int y) {
		if ((y >= 437 && y <= 573) && (x >= 0 && x <= 163)) {
			return true;
		} else {
			return false;
		}
	}

	private static boolean isHall(int x, int y) {
		if ((y >= 415 && y <= 570) && (x >= 213 && x <= 346)) {
			return true;
		}
		return false;
	}

	private static boolean isBilliardRoom(int x, int y) {
		if ((y >= 180 && y <= 295) && (x >= 420 && x <= 553)) {
			return true;
		}
		return false;
	}

	private static boolean isConservatory(int x, int y) {
		if ((y >= 0 && y <= 112) && (x >= 418 && x <= 550)) {
			return true;
		} else if ((y >= 114 && y <= 133) && (x >= 442 && x <= 554)) {
			return true;
		}
		return false;
	}

	private static boolean isDiningRoom(int x, int y) {
		if ((y >= 232 && y <= 362) && (x >= 0 && x <= 185)) {
			return true;
		} else if ((y >= 204 && y <= 230) && (x >= 0 && x <= 115)) {
			return true;
		}
		return false;
	}

	private static boolean isLibrary(int x, int y) {
		if ((y >= 322 && y <= 432) && (x >= 418 && x <= 550)) {
			return true;
		} else if ((y >= 345 && y <= 409) && (x >= 396 && x <= (396 + 24))) {
			return true;
		}
		return false;
	}

	private static boolean isStudy(int x, int y) {
		if ((y >= 485 && y <= 573) && (x >= 396 && x <= 553)) {
			return true;
		}
		return false;
	}

	private static boolean isCellar(int x, int y) {
		if ((y >= 231 && y <= 387) && (x >= 235 && x <= 346)) {
			return true;
		}
		return false;
	}

	private static boolean isCorridoor(int x, int y) {
		if (isCellar(x, y) || isStudy(x, y) || isLibrary(x, y) || isDiningRoom(x, y) || isConservatory(x, y)) {
			return false;
		} else if (isHall(x, y) || isKitchen(x, y) || isLounge(x, y) || isBallroom(x, y)) {
			return false;
		}
		return true;
	}

	public static String GetRoom(int py, int px) {
		if (isKitchen(px, py)) {
			return ("Kitchen");
		} else if (isBallroom(px, py)) {

			return ("Ball Room");
		} else if (isLounge(px, py)) {
			return ("Lounge");
		} else if (isHall(px, py)) {
			return ("Hall");
		} else if (isBilliardRoom(px, py)) {
			return ("Billiard Room");
		} else if (isConservatory(px, py)) {
			return ("Conservatory");
		} else if (isDiningRoom(px, py)) {
			return ("Dining Room");
		} else if (isStudy(px, py)) {
			// System.out.println("Calculated x, y: "+px+", "+py);
			return ("Study");
		} else if (isLibrary(px, py)) {
			return ("Library");
		} else if (isCellar(px, py)) {
			return ("Cellar");
		} else if (isCorridoor(px, py)) {
			return ("Corridoors");
		} else {
			return "UNKNOWN AREA!!!";
		}
	}
}
