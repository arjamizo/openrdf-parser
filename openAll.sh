ln -f -s ~/prjs/rdf/Protege_4.2/run.sh ~/bin/protege4.2
chmod +x ~/bin/protege4.2
ps aux | grep protege || ( protege4.2 & )
#xterm -e "bash -c 'cd apache-tomcat-8.0.8; bash startup.sh '" &

xterm -e "bash --init-file <(echo 'cd apache-tomcat-8.0.8; bash bin/startup.sh; tail -f logs/catalina.out')"

firefox http://localhost:8080
