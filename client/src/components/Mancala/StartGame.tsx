import React, { useState } from "react";
import { GameState } from "../../types/gameState";
import "./StartGame.css";

type StartGameProps = {
  setGameState(newGameState: GameState): void;
};

/**
 * Allows the players to enter their name. A name is required for both players. They can't have the same names.
 */
export function StartGame({ setGameState }: StartGameProps) {
  const [errorMessage, setErrorMessage] = useState("");
  const [playerOne, setPlayerOne] = useState("");
  const [playerTwo, setPlayerTwo] = useState("");
  const [pitsPerPlayer,setPitsPerPlayer]= useState("6")
  const [ballsPerPit,setBallsPerPit]= useState("4")

  async function tryStartGame() {
    if (!playerOne) {
      setErrorMessage("A name is required for player 1");
      return;
    }
    if (!playerTwo) {
      setErrorMessage("A name is required for player 2");
      return;
    }
    if (playerOne === playerTwo) {
      setErrorMessage("Each player should have a unique name");
      return;
    }
    const numberOfPits=Math.max(Math.floor(Number(pitsPerPlayer)),1)
    const numberOfBalls=Math.max(Math.floor(Number(ballsPerPit)),1)
    if(pitsPerPlayer && numberOfPits){
      try {
        const response = await fetch("mancala/api/start", {
          method: "POST",
          headers: {
            Accept: "application/json",
            "Content-Type": "application/json",
          },
          body: JSON.stringify({
            nameplayer1: playerOne,
            nameplayer2: playerTwo,
            pits: numberOfPits,
            balls: numberOfBalls
          }),
        });
      
        if (response.ok) {
          const gameState = await response.json();
          setGameState(gameState);
        } else {
          console.error(response.statusText);
        }
      } catch (error) {
        console.error(error);
      }
      setErrorMessage("");
    } else {
      setErrorMessage("Please enter only numbers for the number of pits per player and the number of starting balls per pit")
    }
  }


  return (
    <>
      <input
        value={playerOne}
        placeholder="Player 1 name"
        onChange={(e) => setPlayerOne(e.target.value)}
      />

      <input
        value={playerTwo}
        placeholder="Player 2 name"
        onChange={(e) => setPlayerTwo(e.target.value)}
      />

      <input
        value={pitsPerPlayer}
        placeholder="Number of pits per player"
        type="number"
        onChange={(e) => setPitsPerPlayer(e.target.value)}
      />

      <input
        value={ballsPerPit}
        placeholder="Number of balls per pit"
        type="number"
        onChange={(e) => setBallsPerPit(e.target.value)}
      />

      <p className="errorMessage">{errorMessage}</p>

      <button className="startGameButton" onClick={() => tryStartGame()}>
        Play Mancala!
      </button>
    </>
  );
}
