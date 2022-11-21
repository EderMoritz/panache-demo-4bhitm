package at.htl.boundary;

import at.htl.control.VehicleRepository;
import at.htl.entity.Vehicle;
import at.htl.entity.dto.VehicleDto;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.stream.Collectors;

@Path("/vehicle")
public class VehicleResource {

    @Inject
    VehicleRepository vehicleRepository;

    /*@GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<VehicleDto> getVehicles() {
        return List.of(
                new VehicleDto("Opel", "Kadett"),
                new VehicleDto("VW", "Käfer")
        );
    }*/

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response allVehicles() {

        return Response.ok(vehicleRepository.listAll()).build();
    }

}