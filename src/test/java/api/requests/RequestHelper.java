package api.requests; //untuk kelas-kelas yang menangani pengiriman permintaan API

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class RequestHelper {
    public Response getUserList(int page) {
        return RestAssured.given()
                .baseUri("https://reqres.in")
                .basePath("/api/users")
                .queryParam("page", page)
                .when()
                .get();
    }
}
