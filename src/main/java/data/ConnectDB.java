package data;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;

import java.sql.Connection;

public class ConnectDB {
    //Connect to maria database
    private static EntityManager em = null;

    public static EntityManager connect() {
        em = Persistence.createEntityManagerFactory("maria").createEntityManager();
        return em;
    }

    public static void close(Connection con) {
        em.close();
    }
}
