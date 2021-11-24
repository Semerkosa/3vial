package com.jointrivial.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.beans.factory.BeanCreationException;
import java.sql.SQLException;

@SpringBootApplication
public class ServerApplication {

	public static void main(String[] args) {
        try {
            SpringApplication.run(ServerApplication.class, args);
        } catch (BeanCreationException exception) {
            System.err.println("Unhandled exception: " + exception);
            // See if MySQL is involved in the failure.
            if (exception.contains(SQLException.class)) {
                System.err.println("############################################################");
                System.err.println("#                                                          #");
                System.err.println("#       Error: Cannot connect to MySQL;                    #");
                System.err.println("#       search logs for \"Communications link failure\"      #");
                System.err.println("#         (indicates no running MySQL server),             #");
                System.err.println("#       or search logs for \"Access denied for user\"        #");
                System.err.println("#         (indicates TRIVIAL_DB_PASSWORD is not set).      #");
                System.err.println("#                                                          #");
                System.err.println("############################################################");
            }
        }
	}

}
