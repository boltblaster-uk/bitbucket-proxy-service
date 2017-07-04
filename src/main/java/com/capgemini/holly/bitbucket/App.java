package com.capgemini.holly.bitbucket;

import org.apache.camel.guice.Main;

public class App {

    public static void main(String[] args) throws Exception{ 
        Main main = new Main();
        main.setJndiProperties("/guiceJndi.properties");
        main.run(args);
    }
}
