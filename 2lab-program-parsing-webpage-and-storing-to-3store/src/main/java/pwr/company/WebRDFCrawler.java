/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pwr.company;

import static java.lang.String.format;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import net.rootdev.javardfa.ParserFactory.Format;
import static net.rootdev.javardfa.ProfileCollector.uri;
import net.rootdev.javardfa.StatementSink;
import net.rootdev.javardfa.output.TurtleSink;
import net.rootdev.javardfa.uri.URIResolver;
import org.xml.sax.XMLReader;

/**
 *
 * @author azochniak
 */
class WebRDFCrawler {
    void crawl(String url) {
        try {
//            callEvent("onNewMeasure", "ell " + url);
//            callEvent("onNewMeasure","New Measure is here "+new java.util.Date().toString());
            StatementSink sink;// = new TurtleSink(System.out);
            sink=new TurtleSink(System.out) {

                @Override
                public void addLiteral(String string, String string1, String string2, String string3, String string4) {
                    String[] info = new String[]{string, string1, string2, string3, string4};
                    LOG.severe(java.util.Arrays.asList(info).toString());
                    callEvent("onNewMeasure", java.util.Arrays.asList(info));
                    super.addLiteral(string, string1, string2, string3, string4);
                }
            };
            XMLReader reader = net.rootdev.javardfa.ParserFactory.createReaderForFormat(sink, Format.HTML, new URIResolver());
            reader.parse(url);
        } catch ( java.net.ConnectException e) {
            String er="try running HTTP server\nbahs: ls ./WebsiteRDFaMicrodataMicroformats.html && python -m SimpleHTTPServer";
            javax.swing.JOptionPane.showMessageDialog(null, er);
            throw new RuntimeException(er, e);
        } catch (Exception ex) {
            Logger.getLogger(WebRDFCrawler.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException(ex);
        }
    }
    
    HashMap<String, List<EvHandler>> listeners=new HashMap();

    void addHandler(String onNewMeasure, EvHandler evHandler) {
        List<EvHandler> hndlrs=listeners.get(onNewMeasure);
        if(hndlrs==null) {
            hndlrs=new LinkedList();
            listeners.put(onNewMeasure, hndlrs);
        }
        if(hndlrs.contains(evHandler))
            LOG.warning("this handler "+evHandler+" implementation already exist");
        hndlrs.add(evHandler);
    }
    private static final Logger LOG = Logger.getLogger(WebRDFCrawler.class.getName());

    private void callEvent(String event, Object context) {
        if(listeners.get(event)==null) LOG.warning("event "+event);
        for (EvHandler evHandler : listeners.get(event)) {
            evHandler.call(context);
        }
    }
    
}
