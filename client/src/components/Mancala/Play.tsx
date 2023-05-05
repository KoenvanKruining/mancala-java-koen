import { GameState, Pit, Player } from "../../types/gameState";
import "./Play.css";

type PlayProps = {
  gameState: GameState;
  setGameState(newGameState: GameState): void;
};

export function Play({ gameState, setGameState }: PlayProps) {
  async function playPit(playedPit: Number) {
    try {
      const response = await fetch("mancala/api/play", {
        method: "POST",
        headers: {
          Accept: "application/json",
          "Content-Type": "application/json",
        },
        body: JSON.stringify(playedPit),
      })
  
      if (response.ok) {
        const gameState = await response.json()
        setGameState(gameState)
      } else {
        console.error(response.statusText)
      }
    } catch (error) {
      console.error(error)
    }
  }

  function Bak(props: {pit: Pit, player: Player}){
    if(props.pit.index % props.player.pits.length == props.player.pits.length-1){return(
      <div className="bak">{props.pit.nrOfStones}</div>
    )} else if(props.player.hasTurn && props.pit.nrOfStones!=0){ return(
      <div className="bak"><div>{props.pit.nrOfStones}</div>
      <button onClick={()=>playPit(props.pit.index)}>Play pit</button></div>
    )} else {return(
      <div className="bak">{props.pit.nrOfStones}</div>
    )}
    
  }

  function showWinner(gameState: GameState){
    if(gameState.gameStatus.endOfGame){return(<p>
      {gameState.gameStatus.winner} wins!
      </p>)}
  }
  
  return (
    <div className="playField">
      <p>
        {gameState.players[0].name} vs {gameState.players[1].name}
      </p>
      <div className="board">
        <div className="side" id="firstSide">{gameState.players[0].pits.map((pit)=><Bak pit={pit} player={gameState.players[0]}></Bak>)}</div>
        <div className="side" id="secondSide">{gameState.players[1].pits.map((pit)=><Bak pit={pit} player={gameState.players[1]}></Bak>)}</div>
      </div>
      {showWinner(gameState)}
    </div>
  )
}