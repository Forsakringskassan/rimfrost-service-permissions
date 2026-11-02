package se.fk.github.rimfrost.permissions.presentation.rest;

import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * Hardcoded stub of handläggare → SID-behörighet. Intended to allow consumers
 * (t.ex. OUL) to integrate against real handläggare-identities before a real
 * permissions source is available.
 */
final class PermissionsStub
{

   private static final List<UUID> knownIdentityTypes = List.of(
         UUID.fromString("116759e4-18fd-4209-849c-90abbd257d22"));

   /** Maps identity value → has SID-permission. */
   private static final Map<String, Boolean> HANDLAGGARE_SID_PERMISSION = Map.of(
         "111111111", true,
         "222222222", false,
         "333333333", false);

   private PermissionsStub()
   {
   }

   /**
    * Returns whether the given handläggare has SID-behörighet. Unknown identity (unknown
    * {@code idTyp} or unknown {@code idVarde}) gives {@code false}, the same as known
    * identity without SID-permission.
    *
    * @param idTyp type of identifier; must match stubs {@code TYP_ID}
    * @param idVarde identifiers value
    * @return {@code true} if identity has SID-permission, {@code false} otherwise
    */
   static Boolean hasSidPermission(String idTyp, String idVarde)
   {
      if (!isKnownIdentityType(idTyp) || idVarde == null)
      {
         return false;
      }
      return HANDLAGGARE_SID_PERMISSION.getOrDefault(idVarde, false);
   }

   private static boolean isKnownIdentityType(String idTyp)
   {
      if (idTyp == null)
      {
         return false;
      }

      try
      {
         return knownIdentityTypes.contains(UUID.fromString(idTyp));
      }
      catch (IllegalArgumentException e)
      {
         return false;
      }

   }
}
