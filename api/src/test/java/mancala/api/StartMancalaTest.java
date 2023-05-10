package mancala.api;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import jakarta.servlet.http.*;
import jakarta.ws.rs.core.*;

import mancala.api.models.*;
import mancala.domain.Playable;

public class StartMancalaTest {
    @Test
    public void startingMancalaShouldBeAllowed() {
        var response = startMancala("Mario", "Luigi");
        assertEquals(200, response.getStatus());
    }

    @Test
    public void startingMancalaReturnsAGameWithoutAWinner() {
        var response = startMancala("Mario", "Luigi");
        var entity = (MancalaDTO) response.getEntity();
        var gameState = entity.gameStatus;
        assertFalse(gameState.endOfGame);
        assertNull(gameState.winner);
    }

    @Test
    public void startingMancalaReturnsThePlayerData() {
        var response = startMancala("Rick", "Viviyan");
        var entity = (MancalaDTO) response.getEntity();
        var players = entity.players;
        assertEquals(2, players.length);
        assertEquals("Rick", players[0].name);
        assertEquals("Viviyan", players[1].name);
    }

    @Test
    public void startingMancalaReturnsThePits() {
        var response = startMancala("Rick", "Viviyan");
        var entity = (MancalaDTO) response.getEntity();
        var players = entity.players;
        assertEquals(7, players[0].pits.length);
        assertEquals(0, players[0].pits[0].index);
        assertEquals(7, players[1].pits.length);
        assertEquals(7, players[1].pits[0].index);
    }

    @Test
    public void startingMancalaStartsANewSession() {
        startMancala("Rick", "Viviyan");
        verify(request).getSession(true);
    }

    @Test
    public void startingMancalaSavesTheNewGameInASession() {
        startMancala("Rick", "Viviyan");
        verify(session).setAttribute(eq("mancala"), any(Playable.class));
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
        request = mock(HttpServletRequest.class);
        session = mock(HttpSession.class);
        when(request.getSession(true)).thenReturn(session);
        return request;
    }

    private HttpServletRequest request;
    private HttpSession session;

    private PlayerInputDTO playerInput(String namePlayer1, String namePlayer2) {
        var input = new PlayerInputDTO();
        input.setNameplayer1(namePlayer1);
        input.setNameplayer2(namePlayer2);
        input.setPits(6);
        input.setBalls(4);
        return input;
    }
}