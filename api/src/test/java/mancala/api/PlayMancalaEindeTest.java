package mancala.api;

import org.junit.jupiter.api.Test;
import jakarta.servlet.http.*;
import jakarta.ws.rs.core.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

import mancala.api.models.*;
import mancala.domain.MancalaSpel;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class PlayMancalaEindeTest {
    @Test
    public void playMancalaEindigtSpelAlsGeenZetMogelijkIs(){
        var zet=playMancala(0);
        var entity = (MancalaDTO) zet.getEntity();
        var players = entity.players;
        var status = entity.gameStatus;


        assertFalse(players[0].hasTurn);
        assertFalse(players[1].hasTurn);
        assertTrue(status.endOfGame);
        assertEquals("Rick and Viviyan",status.winner);

    }

    @Test
    public void PlayMancalaMaaktPuttenLeegAlsSpelVoorbijIs(){
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
        int[] expectedPitsRick={0,1};
        int[] expectedPitsViviyan={0,1};

        assertArrayEquals(expectedPitsRick,pitsRick);
        assertArrayEquals(expectedPitsViviyan,pitsViviyan);
    }

    private Response playMancala(int input) {
        var servlet = new PlayMancala();
        var request = createRequestContext();
        System.out.print(request);
        System.out.print(input);
        return servlet.play(request, input);
    }

    private HttpServletRequest createRequestContext() {
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpSession session = mock(HttpSession.class);
        when(request.getSession(true)).thenReturn(session);
        when(request.getSession()).thenReturn(session);
        when(session.getAttribute("mancala")).thenReturn(new MancalaSpel("Rick","Viviyan",1,1));
        return request;
    }
}
