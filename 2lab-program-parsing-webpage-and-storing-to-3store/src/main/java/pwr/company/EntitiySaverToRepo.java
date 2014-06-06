/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pwr.company;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.openrdf.OpenRDFException;
import org.openrdf.repository.Repository;
import org.openrdf.repository.RepositoryConnection;
import org.openrdf.repository.RepositoryException;
import org.openrdf.repository.http.HTTPRepository;

/**
 *
 * @author azochniak
 */
class EntitiySaverToRepo {
    RepositoryConnection con;
    private static Repository repo() throws RepositoryException {
        String sesameServer = "http://localhost:8080/openrdf-sesame/";
        String repositoryID = "companyEmployees";

        Repository repo = new HTTPRepository(sesameServer, repositoryID);
        repo.initialize();
        return repo;
    }
    
    public EntitiySaverToRepo() {
        try {
            con = repo().getConnection();
            try {
            } finally {
//                con.close();
            }
        } catch (OpenRDFException e) {
            e.printStackTrace();
        }
    }
    public void close() {
        try {
            con.close();
        } catch (RepositoryException ex) {
            Logger.getLogger(EntitiySaverToRepo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public boolean add(Object obj) {
        //INSERT QUERY HERE
        return false;
    }
}
