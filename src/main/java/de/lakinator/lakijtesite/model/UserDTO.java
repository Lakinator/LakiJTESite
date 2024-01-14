package de.lakinator.lakijtesite.model;

import java.util.Map;

public class UserDTO extends JTEModel {

    private String name;

    private String email;

    private String password;

    private String passwordConfirm;

    public UserDTO( Map<String, String[]> parameterMap ) {
        super( parameterMap );
    }

    public UserDTO( Map<String, String[]> parameterMap, String name, String email, String password ) {
        super( parameterMap );
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public String getName( ) {
        return name;
    }

    public void setName( String name ) {
        this.name = name;
    }

    public String getEmail( ) {
        return email;
    }

    public void setEmail( String email ) {
        this.email = email;
    }

    public String getPassword( ) {
        return password;
    }

    public void setPassword( String password ) {
        this.password = password;
    }

    public String getPasswordConfirm( ) {
        return passwordConfirm;
    }

    public void setPasswordConfirm( String passwordConfirm ) {
        this.passwordConfirm = passwordConfirm;
    }
}
