package mancala.api;

import java.util.Arrays;
import org.junit.jupiter.api.Test;
import jakarta.servlet.http.*;
import jakarta.ws.rs.core.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

import mancala.api.models.*;
import mancala.domain.MancalaSpel;

import java.sql.Array;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class PlayMancalaEindeTest {
    @Test
    public void playMancalaEindigtSpelAlsGeenZetMogelijkIs(){
        var zet=playMancala(0);
        var entity = (MancalaDTO) zet.getEntity();
        var players = entity.getPlayers();
        var status = entity.getGameStatus();


        assertFalse(players[0].getHasTurn());
        assertFalse(players[1].getHasTurn());
        assertTrue(status.getEndOfGame());
        assertEquals("Rick and Viviyan",status.getWinner());

    }

    @Test
    public void PlayMancalaMaaktPuttenLeegAlsSpelVoorbijIs(){
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
        int[] expectedPitsRick={0,1};
        int[] expectedPitsViviyan={0,1};

        assertTrue(Arrays.equals(expectedPitsRick,pitsRick));
        assertTrue(Arrays.equals(expectedPitsViviyan,pitsViviyan));
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
        when(session.getAttribute("mancala")).thenReturn(new MancalaSpel("Rick","Viviyan",1,1));
        return request;
    }

    private HttpServletRequest request;
    private HttpSession session;
}
