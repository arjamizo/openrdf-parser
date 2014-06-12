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
import org.openrdf.repository.util.RDFInserter;
import org.openrdf.rio.RDFFormat;

/**
 *
 * @author azochniak
 */
class EntitiySaverToRepo {
    RepositoryConnection con;
    Repository repo;
    private Repository repo() throws RepositoryException {
        String sesameServer = "http://localhost:8080/openrdf-sesame/";
        String repositoryID = "companyEmployees";

        repo = new HTTPRepository(sesameServer, repositoryID);
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
        try {
            RepositoryConnection con = repo.getConnection();
            con.setAutoCommit(false);
//            con.add(null, null, RDFFormat.N3, rsrcs);
            con.add(new java.io.File("/tmp/a.nq"), null, RDFFormat.N3);
            con.commit();
        } catch (Exception ex) {
            Logger.getLogger(EntitiySaverToRepo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
}
