package mancala.api.models;

import mancala.domain.Playable;

public class PlayerDTO {

	public String name;
	public String type;
	public boolean hasTurn;
	public PitDTO[] pits;

	public PlayerDTO(
			Playable mancala,
			String name) {
		this.name = name;
		this.hasTurn = mancala.isPlayersTurn(name);
		int numberOfPits=mancala.getPitsPerPlayer();
		this.pits= new PitDTO[numberOfPits];

		int firstHoleIndex = this.name == mancala.getNameOfPlayerOne() ? 0 : numberOfPits;
		for (int i = 0; i < numberOfPits; ++i) {
			this.pits[i] = new PitDTO(
					firstHoleIndex + i,
					mancala.getStonesForPit(i + firstHoleIndex));
		}
	}
}