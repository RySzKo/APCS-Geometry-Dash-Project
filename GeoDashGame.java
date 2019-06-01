import java.awt.Graphics;
import java.awt.List;
import java.util.ArrayList;
import java.util.Collection;

public class GeoDashGame {

	private ArrayList<Block> blocks = new ArrayList<>();
	private ArrayList<Triangle> triangles = new ArrayList<>();

	private final int speed = -5, mapSize = 5000;
	private int yloc = 450;
	private Dasher player;
	private Obstacle ob1, ob2, spike1;
	private int floorY;
	private boolean colliding;
	private int tries;
	// add by devang
	boolean done = false;

	private GeoRunner geoRunner = null;

	public GeoDashGame(GeoRunner runner) {
		geoRunner = runner;
		player = new Dasher();
		ArrayList<Integer> temp = randomGen(20);

		// System.out.println("temp = " + temp);

		for (int i = 0; i < temp.size(); i++) {
			int xcoord = temp.get(i);
			double dice =  Math.random();

			// System.out.println("dice = " + dice);
			//dice = 0;
			if (dice > 0.5) {
				blocks.add(new Block(xcoord, yloc, speed));
				// added by Mike
//				boolean judge = true;
//				if(Math.random()>0.5) {
//					yloc = yloc - 50;
//					judge = !judge;
//				}
	
				if (i < temp.size() - 1) {
					int nextXCoord = temp.get(i + 1);
					int distance = nextXCoord - xcoord;
					if (distance > 400 && distance < 500) {
						blocks.add(new Block(xcoord + Obstacle.defaultDim, yloc, speed));
					} else if (distance > 500 && distance <600) {
						blocks.add(new Block(xcoord + Obstacle.defaultDim * 3, yloc - Obstacle.defaultDim, speed));
					} else if(distance > 600) {
						blocks.add(new Block(xcoord + Obstacle.defaultDim , yloc , speed));
						blocks.add(new Block(xcoord + Obstacle.defaultDim * 2 , yloc , speed));
						blocks.add(new Block(xcoord + Obstacle.defaultDim * 3 , yloc - Obstacle.defaultDim , speed));
						blocks.add(new Block(xcoord + Obstacle.defaultDim * 4 , yloc - Obstacle.defaultDim , speed));
						blocks.add(new Block(xcoord + Obstacle.defaultDim * 5 , yloc - Obstacle.defaultDim , speed));
						blocks.add(new Block(xcoord + Obstacle.defaultDim * 6 , yloc - Obstacle.defaultDim , speed));
					}
				}
//				if(judge == false) {
//					yloc += 50;
//				}
				
				// end of add
			} else {
				triangles.add(new Triangle(xcoord, yloc, speed));

				// added by Mike
				if (i < temp.size() - 1) {
					int nextXCoord = temp.get(i + 1);
					int distance = nextXCoord - xcoord;

					if (distance > 400 && distance < 500) {
						triangles.add(new Triangle(xcoord + Obstacle.defaultDim, yloc, speed));
					}else if (distance > 500) {
						triangles.add(new Triangle(xcoord + Obstacle.defaultDim, yloc - Obstacle.defaultDim, speed));

					}

				}
				// end of Add
			}

		}
		floorY = 450;
		colliding = false;
	}

	public void draw(Graphics g) {
		player.draw(g);
		for (Block ob : blocks) {
			ob.draw(g);
		}
		for (Triangle ob : triangles) {
			ob.draw(g);
		}
	}

	public void move() {
		for (Block ob : blocks) {
			ob.move(speed);
		}
		for (Triangle ob : triangles) {
			ob.move(speed);
		}
	}

	public void movePlayer(double gravity) {
		player.move(gravity);
	}

	public int setFloor(Block f) {
		floorY = (int) (f.getY() - f.getDim());
		return floorY;
	}

	public int getFloor() {
		return floorY;
	}

	public int resetFloor() {
		floorY = 450;
		return floorY;
	}

	public Dasher getPlayer() {
		return player;
	}

	public void checkCollisions() {
		for (Block ob : blocks) {
			if (ob.collidesWith(player) == 1) {
				colliding = true;
				setFloor(ob);
				return;
			}
			// added !done and commented out system.exit --Devang
			if (!done && ob.collidesWith(player) == 0) {
				// System.out.println("___GAME_IS_OVER___");
				geoRunner.getOwnFrame().dispose();
				new GameOver().end(geoRunner.getDist());
				done = true;
				// System.exit(1);
			}
			if (ob.collidesWith(player) == -1) {
				resetFloor();
			}
		}
		// added !done
		for (Triangle ob : triangles) {
			if (!done && ob.collidesWith(player) == 0) {
				geoRunner.getOwnFrame().dispose();
				new GameOver().end(geoRunner.getDist());
				done = !done;
			}
			// System.exit(1);
		}
	}

	private ArrayList randomGen1(int numObs) {
		ArrayList<Integer> randomCoords = new ArrayList<>();
		for (int i = 0; i < numObs; i++) {
			int temp = (int) (Math.random() * mapSize / 200);
			randomCoords.add(temp * 200 + 600);
		}
		return randomCoords;

	}

	private ArrayList randomGen(int numObs) {
		ArrayList<Integer> randomCoords = new ArrayList<>();
		int previousValue = 800;
		for (int i = 0; i < numObs; i++) {
			int distance = randomGenDistance();
			randomCoords.add(distance + previousValue);
			previousValue = distance + previousValue;

		}
		return randomCoords;
	}

	public int randomGenDistance() {
		int distance = 0;
		while (distance < 300 || distance > 700) {
			distance = (int) (Math.random() * 1000);
		}
		return distance;
	}

	public int getTries() {
		return tries;
	}

	public void reset() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		tries++;
	}

}
