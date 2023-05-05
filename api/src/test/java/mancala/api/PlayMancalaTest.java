package mancala.api;

import java.util.Arrays;
import org.junit.jupiter.api.Test;
import jakarta.servlet.http.*;
import jakarta.ws.rs.core.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;

import mancala.api.models.*;
import mancala.domain.MancalaSpel;

import java.sql.Array;

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
        var players = entity.getPlayers();
        assertEquals(2, players.length);
        assertEquals("Rick", players[0].getName());
        assertEquals("Viviyan", players[1].getName());
    }

    @Test
    public void playMancalaPerformsMove(){
        var zet=playMancala(0);
        var entity = (MancalaDTO) zet.getEntity();
        var players = entity.getPlayers();

        int[] pitsRick= new int[players[0].getPits().length];
        for(int i=0;i<players[0].getPits().length; i++){
            pitsRick[i]=players[0].getPits()[i].nrOfStones;
        }
        int[] pitsViviyan= new int[players[0].getPits().length];
        for(int i=0;i<players[1].getPits().length; i++){
            pitsViviyan[i]=players[1].getPits()[i].nrOfStones;
        }
        int[] expectedPitsRick={0,5,5,5,5,4,0};
        int[] expectedPitsViviyan={4,4,4,4,4,4,0};

        assertTrue(Arrays.equals(expectedPitsRick,pitsRick));
        assertTrue(Arrays.equals(expectedPitsViviyan,pitsViviyan));
    }

    @Test
    public void playMancalaSwitchesTurn(){
        var zet=playMancala(0);
        var entity = (MancalaDTO) zet.getEntity();
        var players = entity.getPlayers();

        assertFalse(players[0].getHasTurn());
        assertTrue(players[1].getHasTurn());
    }

    @Test
    public void playMancalaEndsInKalahaDoesNotSwitchTurn(){
        var zet=playMancala(2);
        var entity = (MancalaDTO) zet.getEntity();
        var players = entity.getPlayers();

        assertTrue(players[0].getHasTurn());
        assertFalse(players[1].getHasTurn());
    }
    @Test
    public void firstTurnYieldsNoWinner(){
        var zet=playMancala(0);
        var entity = (MancalaDTO) zet.getEntity();
        var status = entity.getGameStatus();

        assertNull(status.getWinner());
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

