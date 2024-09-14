package api;

import business.BaseProcess;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;
import models.Student;

import java.util.List;

@Path("/students")
public class StudentResource {
    @Inject
    private BaseProcess baseProcess;

    @GET
    public Response getAll() {
        Response.ResponseBuilder responseBuilder = Response.ok(baseProcess.getAll());
        return responseBuilder.build();
    }
}
