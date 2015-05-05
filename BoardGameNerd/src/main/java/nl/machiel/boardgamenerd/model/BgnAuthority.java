package nl.machiel.boardgamenerd.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author mdeswijger
 */
@Entity
@Table(name = "authorities")
public class BgnAuthority {
    @EmbeddedId BgnAuthorityId bgnAuthorityId;

    public BgnAuthorityId getBgnAuthorityId() {
        return bgnAuthorityId;
    }

    public BgnAuthority() {}

    public BgnAuthority(String username, String authority) {
        bgnAuthorityId = new BgnAuthorityId(username, authority);
    }

    @Embeddable
    public static class BgnAuthorityId implements Serializable {
        private String username;
        private String authority;

        public BgnAuthorityId() {}

        public BgnAuthorityId(String username, String authority) {
            this.username = username;
            this.authority = authority;
        }

        public String getUsername() {
            return username;
        }

        public String getAuthority() {
            return authority;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            BgnAuthorityId that = (BgnAuthorityId) o;

            if (username != null ? !username.equals(that.username) : that.username != null) return false;
            return !(authority != null ? !authority.equals(that.authority) : that.authority != null);

        }

        @Override
        public int hashCode() {
            int result = username != null ? username.hashCode() : 0;
            result = 31 * result + (authority != null ? authority.hashCode() : 0);
            return result;
        }
    }
}
