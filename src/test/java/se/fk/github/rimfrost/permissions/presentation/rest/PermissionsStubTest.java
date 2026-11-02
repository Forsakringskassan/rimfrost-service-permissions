package se.fk.github.rimfrost.permissions.presentation.rest;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.jupiter.api.Test;

public class PermissionsStubTest
{
   private static final String TYPE_ID = "116759e4-18fd-4209-849c-90abbd257d22";

   @Test
   void hasSidPermission_identityA_returnsTrue()
   {
      Boolean hasSidPermission = PermissionsStub.hasSidPermission(TYPE_ID, "111111111");
      assertThat(hasSidPermission, is(true));
   }

   @Test
   void hasSidPermission_identityB_returnsFalse()
   {
      Boolean hasSidPermission = PermissionsStub.hasSidPermission(TYPE_ID, "222222222");
      assertThat(hasSidPermission, is(false));
   }

   @Test
   void hasSidPermission_unknownValue_returnsFalse()
   {
      Boolean hasSidPermission = PermissionsStub.hasSidPermission(TYPE_ID, "999999999");
      assertThat(hasSidPermission, is(false));
   }

   @Test
   void hasSidPermission_wrongTypeId_returnsFalse()
   {
      Boolean hasSidPermission = PermissionsStub.hasSidPermission("wrong-typ-id", "111111111");
      assertThat(hasSidPermission, is(false));
   }

   @Test
   void hasSidPermission_nullIdTyp_returnsFalse()
   {
      Boolean hasSidPermission = PermissionsStub.hasSidPermission(null, "111111111");
      assertThat(hasSidPermission, is(false));
   }

   @Test
   void hasSidPermission_nullIdVarde_returnsFalse()
   {
      Boolean hasSidPermission = PermissionsStub.hasSidPermission(TYPE_ID, null);
      assertThat(hasSidPermission, is(false));
   }
}
