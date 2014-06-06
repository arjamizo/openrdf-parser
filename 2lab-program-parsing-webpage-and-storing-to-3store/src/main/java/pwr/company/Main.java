/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pwr.company;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author azochniak
 */
public class Main
{    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                try {
                    System.out.println("set handler");
                    final MainWindow mainwindow=new MainWindow();
                    final WebRDFCrawler webrdfcrwl = new WebRDFCrawler();
                    mainwindow.setRunHandler(new EvHandler() {

                        @Override
                        void callable(Object context) {
//                            LOG.info("handling "+context);
                            webrdfcrwl.crawl(""+context);
                        }
                    });
                    webrdfcrwl.addHandler("onNewMeasure",new EvHandler() {
                        @Override
                        void callable(Object context) {
//                            System.out.println("added "+context);
                            mainwindow.log("added "+context);
                        }
                    });
                    mainwindow.setVisible(true);
//                    webrdfcrwl.crawl("http://localhost:8080");
                } catch (Throwable ex) {
                    ByteArrayOutputStream baos = new ByteArrayOutputStream();
                    PrintStream ps = new PrintStream(baos);
                    ps.append("If there is error with no symbol found or nodefclass, then download dependencies and clean&build");
                    ps.println("Error: " + ex + " \ncause for this ex: " + ex.getCause() + " \nCWD: " + System.getProperty("user.dir"));
                    ps.println();
                    ex.printStackTrace(ps);
                    JOptionPane.showMessageDialog(null, baos.toString());
                    System.exit(1);
                }
            }
        });
    }
    private static final Logger LOG = Logger.getLogger(Main.class.getName());
}