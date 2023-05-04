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
      <div>{props.pit.nrOfStones}</div>
    )} else if(props.player.hasTurn && props.pit.nrOfStones!=0){ return(
      <div>{props.pit.nrOfStones}
      <button onClick={()=>playPit(props.pit.index)}>Play pit</button></div>
    )} else {return(
      <div>{props.pit.nrOfStones}</div>
    )}
    
  }
  
  return (
    <div>
      <p>
        {gameState.players[0].name} vs {gameState.players[1].name}
      </p>
      <div className="side">{gameState.players[0].pits.map((pit)=><Bak pit={pit} player={gameState.players[0]}></Bak>)}</div>
      <div className="side">{gameState.players[1].pits.map((pit)=><Bak pit={pit} player={gameState.players[1]}></Bak>)}</div>
    </div>
  )
}