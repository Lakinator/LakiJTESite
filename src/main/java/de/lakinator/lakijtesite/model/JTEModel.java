package de.lakinator.lakijtesite.model;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;

public abstract class JTEModel {

    public JTEModel( Map<String, String[]> parameterMap ) {
        this.init( parameterMap );
    }

    public void init( Map<String, String[]> parameterMap ) {
        parameterMap.forEach( ( field, values ) -> {
            try {
                String setterName = "set" + field.substring( 0, 1 ).toUpperCase() + field.substring( 1 );
                Method setter = this.getClass().getMethod( setterName, String.class );
                setter.invoke( this, values[0] );
                // System.out.println( "Invoked " + setterName + " with value " + values[0] );
            } catch ( NoSuchMethodException e ) {
                System.err.println( "Setter for method for field " + field + " not found!" );
            } catch ( InvocationTargetException e ) {
                System.err.println( "Invocation of setter for field " + field + " failed!" );
            } catch ( IllegalAccessException e ) {
                System.err.println( "Setter for method for field " + field + " is not accessible!" );
            }
        } );
    }

}
