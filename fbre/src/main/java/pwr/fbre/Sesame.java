package pwr.fbre;

/**
 *
 * @author azochniak
 */
import java.util.logging.Logger;
import org.openrdf.OpenRDFException;
import org.openrdf.model.Value;
import org.openrdf.query.BindingSet;
import org.openrdf.query.QueryLanguage;
import org.openrdf.query.TupleQuery;
import org.openrdf.query.TupleQueryResult;
import org.openrdf.repository.Repository;
import org.openrdf.repository.RepositoryConnection;
import org.openrdf.repository.RepositoryException;
import org.openrdf.repository.http.HTTPRepository;
import org.openrdf.rio.RDFHandlerException;

public class Sesame {

    public static void main(String[] args) throws RepositoryException, RDFHandlerException {

        try {
            RepositoryConnection con = repo().getConnection();
            try {
                String queryString = "PREFIX fbre:<http://www.semanticweb.org/lab05/ontologies/2014/4/untitled-ontology-3#>\n" +
"\n" +
"SELECT DISTINCT ?FirstName ?LastName\n" +
"WHERE{?x fbre:hasFirstName ?FirstName .\n" +
"\n" +
"?x fbre:hasLastName ?LastName.\n" +
"}";
                TupleQuery tupleQuery = con.prepareTupleQuery(QueryLanguage.SPARQL, queryString);

                TupleQueryResult result = tupleQuery.evaluate();
                try {
                    while (result.hasNext()) {  // iterate over the result
                        BindingSet bindingSet = result.next();
                        Value valueOfX = bindingSet.getValue("FirstName");
                        Value valueOfY = bindingSet.getValue("LastName");

                        //LOG.info(String.format("ent %s", valueOfX, valueOfY));
                        //netbeans: sout[tab]
                        System.out.println(String.format("ent %s %s", valueOfX, valueOfY));
                    }
                } finally {
                    result.close();
                }
            } finally {
                con.close();
            }
        } catch (OpenRDFException e) {
            e.printStackTrace();
        }
    }
    private static final Logger LOG = Logger.getLogger(Sesame.class.getName());

    private static Repository repo() throws RepositoryException {
        String sesameServer = "http://localhost:8080/openrdf-sesame/";
        String repositoryID = "facebookReverseEngineering";

        Repository repo = new HTTPRepository(sesameServer, repositoryID);
        repo.initialize();
        return repo;
    }

}
