package com.hello.world.demo.service;

import java.util.HashMap;
import java.util.Map;

public class Player {
	
	String playerName;
	
	int playerId;
	
	
	public Player(String name, int id) {
		this.playerName = name;
		this.playerId = id;
	}
	
	
	public static void main(String[] args) {
		
		Player player1 = new Player("A", 1);
		
		Player player2 = new Player("A", 1);
		
		
		Map<Player, Integer> players = new HashMap<>();
		
		
		players.put(player1, 1);
		players.put(player2, 2);
		
		
	}

}
