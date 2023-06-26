package mancala.api;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.ws.rs.core.Response;
import mancala.api.models.MancalaDTO;
import mancala.api.models.PlayerInputDTO;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.mockito.Mockito.*;

public class StartMancalaOptionsTest {
    @Test
    public void startingMancalaReturnsThePits() {
        var response = startMancala("Rick", "Viviyan");
        var entity = (MancalaDTO) response.getEntity();
        var players = entity.players;
        assertEquals(3, players[0].pits.length);
        assertEquals(0, players[0].pits[0].index);
        assertEquals(3, players[1].pits.length);
        assertEquals(3, players[1].pits[0].index);
    }

    @Test
    public void startingMancalaReturnsGivenBalls() {
        var response = startMancala("Rick", "Viviyan");
        var entity = (MancalaDTO) response.getEntity();
        var players = entity.players;
        int[] pitsRick= new int[players[0].pits.length];
        for(int i=0;i<players[0].pits.length; i++){
            pitsRick[i]=players[0].pits[i].nrOfStones;
        }
        int[] pitsViviyan= new int[players[0].pits.length];
        for(int i=0;i<players[1].pits.length; i++){
            pitsViviyan[i]=players[1].pits[i].nrOfStones;
        }
        int[] expectedPitsRick={2,2,0};
        int[] expectedPitsViviyan={2,2,0};

        assertArrayEquals(expectedPitsRick,pitsRick);
        assertArrayEquals(expectedPitsViviyan,pitsViviyan);
    }


    private Response startMancala(String namePlayer1, String namePlayer2) {
        var servlet = new StartMancala();
        var request = createRequestContext();
        var input = playerInput(namePlayer1, namePlayer2);
        System.out.print(request);
        System.out.print(input);
        return servlet.start(request, input);
    }

    private HttpServletRequest createRequestContext() {
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpSession session = mock(HttpSession.class);
        when(request.getSession(true)).thenReturn(session);
        return request;
    }

    private PlayerInputDTO playerInput(String namePlayer1, String namePlayer2) {
        var input = new PlayerInputDTO();
        input.nameplayer1=namePlayer1;
        input.nameplayer2=namePlayer2;
        input.pits=2;
        input.balls=2;
        return input;
    }
}
