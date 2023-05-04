import { GameState, Pit, Player } from "../../types/gameState";
import "./Play.css";

type PlayProps = {
  gameState: GameState;
  setGameState(newGameState: GameState): void;
};

function Bak(props: {pit: Pit, player: Player}){
  if(props.pit.index %props.player.pits.length==props.player.pits.length-1){return(
    <div>{props.pit.nrOfStones}</div>
  )} else if(props.player.hasTurn && props.pit.nrOfStones!=0){ return(
    <div>{props.pit.nrOfStones}
    <button>Play pit</button></div>
  )} else {return(
    <div>{props.pit.nrOfStones}</div>
  )}
  
}

export function Play({ gameState, setGameState }: PlayProps) {
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