package se.fk.github.rimfrost.permissions.presentation.rest;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import se.fk.rimfrost.permissions.jaxrsspec.controllers.generatedsource.PermissionControllerApi;
import se.fk.rimfrost.permissions.jaxrsspec.controllers.generatedsource.model.SidPermissionRequest;

@Path("")
@Consumes(
{
      "application/json"
})
@Produces(
{
      "application/json"
})
@ApplicationScoped
public class PermissionsController implements PermissionControllerApi
{
   private static final Logger LOGGER = LoggerFactory.getLogger(PermissionsController.class);

   /**
    * Returns whether the given identity has SID-permission.
    *
    * @param sidPermissionRequest the request containing the identity type and value.
    * @return {@code true} if the identity has SID-permission, {@code false} otherwise (including when idTyp/idVarde is not recognized)
    */
   @Path("/hasSidPermission")
   @POST
   @Override
   public Boolean hasSidPermission(@Valid @NotNull SidPermissionRequest sidPermissionRequest)
   {
      return PermissionsStub.hasSidPermission(sidPermissionRequest.getIdTyp(), sidPermissionRequest.getIdVarde());
   }
}
