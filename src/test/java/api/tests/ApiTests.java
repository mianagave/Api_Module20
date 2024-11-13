package api.tests; //untuk menyimpan kelas-kelas pengujian


import api.requests.RequestHelper;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ApiTests {

    RequestHelper requestHelper = new RequestHelper();

    @Test
    public void testGetUserList_Valid() {
        Response response = requestHelper.getUserList(2);
        Assertions.assertEquals(200, response.statusCode());

    }

    @Test
    public void testGetUserList_InvalidPage() {
        Response response = requestHelper.getUserList(0);
        Assertions.assertEquals(400, response.statusCode());
    }

    @Test
    public void testGetUserList_MinBoundary() {
        // Menguji batas minimum, yaitu halaman pertama
        Response response = requestHelper.getUserList(1);
        Assertions.assertEquals(200, response.statusCode());

    }

    @Test
    public void testGetUserList_MaxBoundary() {
        // Menguji batas maksimum dengan halaman besar (misalnya, 1000)
        Response response = requestHelper.getUserList(1000);
        Assertions.assertEquals(200, response.statusCode());

    }

}
