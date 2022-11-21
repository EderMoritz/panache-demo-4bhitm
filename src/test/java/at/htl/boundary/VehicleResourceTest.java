package at.htl.boundary;

import at.htl.entity.Vehicle;
import at.htl.entity.dto.VehicleDto;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class VehicleResourceTest {

    @Test
    public void testHelloEndpoint() {
        List<VehicleDto> retrievedVehicles = given()
            .when().get("/vehicle")
            .then()
             .statusCode(200)
                .extract()
                .jsonPath().getList(".", VehicleDto.class);

        assertThat(retrievedVehicles.get(0).getBrand()).isEqualTo("Opel");
        assertThat(retrievedVehicles.get(0).getType()).isEqualTo("Kadett");
    }

}