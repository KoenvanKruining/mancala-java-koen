package mancala.api.models;

public class PlayerInputDTO {

	String nameplayer1;
	String nameplayer2;
	int pits;
	int balls;

	public String getNameplayer1() {
		return nameplayer1;
	}

	public void setNameplayer1(String nameplayer1) {
		this.nameplayer1 = nameplayer1;
	}

	public String getNameplayer2() {
		return nameplayer2;
	}

	public void setNameplayer2(String nameplayer2) {
		this.nameplayer2 = nameplayer2;
	}

	public int getPits(){return pits;}
	public void setPits(int pits){this.pits=pits;}
	public int getBalls(){return balls;}
	public void setBalls(int balls){this.balls=balls;}
}