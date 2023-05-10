package mancala.api;

import org.junit.jupiter.api.Test;
import jakarta.servlet.http.*;
import jakarta.ws.rs.core.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;

import mancala.api.models.*;
import mancala.domain.MancalaSpel;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class PlayMancalaTest {
    @Test
    public void playingMancalaShouldBeAllowed(){
        var zet=playMancala(0);
        assertEquals(200, zet.getStatus());
    }

    @Test
    public void playingMancalaReturnsPlayerData(){
        var zet=playMancala(0);
        var entity = (MancalaDTO) zet.getEntity();
        var players = entity.players;
        assertEquals(2, players.length);
        assertEquals("Rick", players[0].name);
        assertEquals("Viviyan", players[1].name);
    }

    @Test
    public void playMancalaPerformsMove(){
        var zet=playMancala(0);
        var entity = (MancalaDTO) zet.getEntity();
        var players = entity.players;

        int[] pitsRick= new int[players[0].pits.length];
        for(int i=0;i<players[0].pits.length; i++){
            pitsRick[i]=players[0].pits[i].nrOfStones;
        }
        int[] pitsViviyan= new int[players[0].pits.length];
        for(int i=0;i<players[1].pits.length; i++){
            pitsViviyan[i]=players[1].pits[i].nrOfStones;
        }
        int[] expectedPitsRick={0,5,5,5,5,4,0};
        int[] expectedPitsViviyan={4,4,4,4,4,4,0};

        assertArrayEquals(expectedPitsRick,pitsRick);
        assertArrayEquals(expectedPitsViviyan,pitsViviyan);
    }

    @Test
    public void playMancalaSwitchesTurn(){
        var zet=playMancala(0);
        var entity = (MancalaDTO) zet.getEntity();
        var players = entity.players;

        assertFalse(players[0].hasTurn);
        assertTrue(players[1].hasTurn);
    }

    @Test
    public void playMancalaEndsInKalahaDoesNotSwitchTurn(){
        var zet=playMancala(2);
        var entity = (MancalaDTO) zet.getEntity();
        var players = entity.players;

        assertTrue(players[0].hasTurn);
        assertFalse(players[1].hasTurn);
    }
    @Test
    public void firstTurnYieldsNoWinner(){
        var zet=playMancala(0);
        var entity = (MancalaDTO) zet.getEntity();
        var status = entity.gameStatus;

        assertNull(status.winner);
    }
    private Response playMancala(int input) {
        var servlet = new PlayMancala();
        var request = createRequestContext();
        System.out.print(request);
        System.out.print(input);
        return servlet.play(request, input);
    }

    private HttpServletRequest createRequestContext() {
        request = mock(HttpServletRequest.class);
        session = mock(HttpSession.class);
        when(request.getSession(true)).thenReturn(session);
        when(request.getSession()).thenReturn(session);
        when(session.getAttribute("mancala")).thenReturn(new MancalaSpel("Rick","Viviyan"));
        return request;
    }

    private HttpServletRequest request;
    private HttpSession session;
}

