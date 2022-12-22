package ro.test.cpatrut;


import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;


import io.quarkus.security.identity.SecurityIdentity;
import org.eclipse.microprofile.jwt.JsonWebToken;

@Path("/api/users")
public class UsersResource {

    @Inject
    SecurityIdentity identity;

    @Inject
    JsonWebToken token;

    @GET
    @Path("/me")
    public User me() {
        return new User(identity);
    }

    public static class User {

        private final String userName;

        User(SecurityIdentity identity) {
            this.userName = identity.getPrincipal().getName();
        }

        public String getUserName() {
            return userName;
        }
    }
}