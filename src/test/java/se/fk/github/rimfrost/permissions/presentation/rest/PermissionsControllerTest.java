package se.fk.github.rimfrost.permissions.presentation.rest;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;
import se.fk.rimfrost.permissions.jaxrsspec.controllers.generatedsource.model.SidPermissionRequest;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

@QuarkusTest
public class PermissionsControllerTest
{
   private final static String TYPE_ID = "116759e4-18fd-4209-849c-90abbd257d22";

   @Test
   void hasSidPermission_identityA_returnsTrue()
   {
      var request = createSidPermissionRequest(TYPE_ID, "111111111");

      given()
            .when().contentType(ContentType.JSON).body(request).post("/hasSidPermission")
            .then()
            .statusCode(200)
            .body(is("true"));
   }

   @Test
   void hasSidPermission_identityB_returnsFalse()
   {
      var request = createSidPermissionRequest(TYPE_ID, "222222222");

      given()
            .when().contentType(ContentType.JSON).body(request).post("/hasSidPermission")
            .then()
            .statusCode(200)
            .body(is("false"));
   }

   @Test
   void hasSidPermission_unknownVarde_returnsFalse()
   {
      var request = createSidPermissionRequest(TYPE_ID, "999999999");

      given()
            .when().contentType(ContentType.JSON).body(request).post("/hasSidPermission")
            .then()
            .statusCode(200)
            .body(is("false"));
   }

   @Test
   void hasSidPermission_wrongTypId_returnsFalse()
   {
      var request = createSidPermissionRequest("wrong-typ-id", "111111111");

      given()
            .when().contentType(ContentType.JSON).body(request).post("/hasSidPermission")
            .then()
            .statusCode(200)
            .body(is("false"));
   }

   @Test
   void hasSidPermission_nullRequest_returns_400()
   {
      given()
            .when().contentType(ContentType.JSON).post("/hasSidPermission")
            .then()
            .statusCode(400);
   }

   @Test
   void hasSidPermission_nullTypeId_returns_400()
   {
      var request = createSidPermissionRequest(null, "111111111");

      given()
            .when().contentType(ContentType.JSON).body(request).post("/hasSidPermission")
            .then()
            .statusCode(400);
   }

   @Test
   void hasSidPermission_nullIdValue_returns_400()
   {
      var request = createSidPermissionRequest(TYPE_ID, null);

      given()
            .when().contentType(ContentType.JSON).body(request).post("/hasSidPermission")
            .then()
            .statusCode(400);
   }

   private SidPermissionRequest createSidPermissionRequest(String type, String value)
   {
      SidPermissionRequest request = new SidPermissionRequest();

      if (type != null)
      {
         request.setIdTyp(type);
      }

      if (value != null)
      {
         request.setIdVarde(value);
      }

      return request;
   }
}
