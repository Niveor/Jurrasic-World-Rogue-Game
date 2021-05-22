package game;

import edu.monash.fit2099.engine.*;

import java.util.Arrays;
import java.util.List;

/**
 * The main class for the Jurassic World game.
 *
 */
public class Application {

	public static void main(String[] args) {
		World world = new World(new Display());

		FancyGroundFactory groundFactory = new FancyGroundFactory(new Dirt(), new Wall(),new Sky(), new Floor(), new Tree(), new Lake(), new VendingMachine());
		
		List<String> map = Arrays.asList(
				"`...............................................................................",
				"................................................................................",
				".....#######..........~.........................................................",
				".....#_____#....................................................................",
				".....#_____#.................................~..................................",
				".....###.###................................~~..................................",
				"..........V.....................................................................",
				"......................................+++.............................~.........",
				".......................................++++.....................................",
				"..............................~....+++++........................................",
				".....................................++++++.....................................",
				"......................................+++.......................................",
				".....................................+++.......~................................",
				"................................................................................",
				"............+++.......~.........................................................",
				".............+++++.............................................~................",
				"...............++........................................+++++..................",
				".............+++....................................++++++++....................",
				"............+++.......................................+++.......................",
				".........~........................................~.............................",
				".........................................................................++.....",
				"........................................................................++.++...",
				"....................................................................~....++++...",
				"..........................................................................++....",
				"................................................................................");
		GameMap gameMap = new GameMap(groundFactory, map );
		world.addGameMap(gameMap);

		// the second map for the game that will be accessed from the south when the user goes to top of map one
		List<String> mapTwo = Arrays.asList(
				"`...............................................................................",
				"................................................................................",
				".......++++................................................+++++++++............",
				".......+++..........~~~~....................................+++++...............",
				".......++..........~~~~.......................................+++++.............",
				".......++++.........~~~........................~.............++++...............",
				".........++.....................................................................",
				"......................................................................~.........",
				".......................................++++.....................................",
				"..............................~.....+++++.......................................",
				".....................................++++++.....................................",
				"................................................................................",
				"...............................................~................................",
				"................................................................................",
				"......................~..................................................~......",
				"................................................................++++++..........",
				"..................................................................+++++.........",
				".................................................................++++...........",
				"................++..............................................++++............",
				".........~...+++++................................~...........++++++++..........",
				"..........++++++++++.......................................................~....",
				"..........++++++++++++++++++....................................#######.........",
				"................................................................._____#.........",
				".....................~.........................................V#_____#.........",
				"................................................................#######.........");
		GameMap gameMapTwo = new GameMap(groundFactory, mapTwo );
		world.addGameMap(gameMapTwo);

		// adding the player to map one
		Actor player = new Player("Player", '@', 100);
		world.addPlayer(player, gameMap.at(9, 4));
		
		// Place a pair of stegosaurs in the middle of the map one
		gameMap.at(38, 8).addActor(new Stegosaur("Stegosaur", "male"));
		gameMap.at(48, 8).addActor(new Stegosaur("Stegosaur", "female"));

		// Place 4 Brachiosaurs into the map one
		gameMap.at(48, 19).addActor(new Brachiosaur("Brachiosaur", "female"));
		gameMap.at(60, 19).addActor(new Brachiosaur("Brachiosaur", "male"));
		gameMap.at(18, 12).addActor(new Brachiosaur("Brachiosaur", "male"));
		gameMap.at(12, 16).addActor(new Brachiosaur("Brachiosaur", "female"));
		gameMap.at(48,10).addActor(new Allosaur("Allosaur"));


		world.run();
	}
}
