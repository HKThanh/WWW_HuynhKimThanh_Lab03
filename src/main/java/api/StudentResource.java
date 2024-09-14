package api;

import business.BaseProcess;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Response;

@Path("/students")
public class StudentResource {
    @Inject
    private BaseProcess baseProcess;

    @GET
    @Produces("application/json")
    public Response getAll() {
        Response.ResponseBuilder responseBuilder = Response.ok(baseProcess.getAll());
        return responseBuilder.build();
    }

    @GET
    @Path("/{id}")
    @Produces("application/json")
    public Response getById(@PathParam("id") long id) {
        Response.ResponseBuilder responseBuilder = Response.ok(baseProcess.getById(id));
        return responseBuilder.build();
    }
}
