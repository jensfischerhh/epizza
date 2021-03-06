package epizza.order;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Basic;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

@Embeddable
@Access(AccessType.FIELD)
@Getter
@Builder
@ToString(of = { "firstname", "lastname" })
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@JsonDeserialize(builder = Address.AddressBuilder.class)
public class Address {

    @NotNull
    @Basic(optional = false)
    private String firstname;

    @NotNull
    @Basic(optional = false)
    private String lastname;

    @NotNull
    @Basic(optional = false)
    private String street;

    @NotNull
    @Basic(optional = false)
    private String city;

    @NotNull
    @Basic(optional = false)
    private String postalCode;

    @NotNull
    @Basic(optional = false)
    private String telephone;

    private String email;

    @JsonPOJOBuilder(withPrefix = "")
    public static class AddressBuilder {

    }
}
