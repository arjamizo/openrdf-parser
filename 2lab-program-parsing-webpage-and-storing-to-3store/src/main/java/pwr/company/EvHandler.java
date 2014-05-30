/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pwr.company;

import java.util.logging.Logger;

/**
 *
 * @author azochniak
 */
abstract public class EvHandler {
    public Object call(Object context) {
        LOG.warning("context object "+context.getClass().getName());
        callable(context);
        return null;
    }
    private static final Logger LOG = Logger.getLogger(EvHandler.class.getName());

    abstract void callable(Object context);
}
