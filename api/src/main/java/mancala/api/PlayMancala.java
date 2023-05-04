package mancala.api;

import jakarta.servlet.http.*;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;

import mancala.api.models.*;
import mancala.domain.Playable;

@Path("/play")
public class PlayMancala {
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response play(
            @Context HttpServletRequest request,
            int index) {
        // Retrieve HTTP session.
        HttpSession session=request.getSession();
        // Retrieve game.
        Playable mancala=(Playable) session.getAttribute("mancala");
        // Play a pit.
        mancala.playPit(index);
        // Use the game to create a DTO.
        MancalaDTO output = new MancalaDTO(mancala);

        // Send DTO back in response.
        return Response.status(200).entity(output).build();
    }
}
