/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pwr.company;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Logger;

/**
 *
 * @author azochniak
 */
class WebRDFCrawler {
    void crawl(String httplocalhost8080) {
        callEvent("onNewMeasure","New Measure is here "+new java.util.Date().toString());
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
