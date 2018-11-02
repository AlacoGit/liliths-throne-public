package com.lilithsthrone.debug;

import java.util.Scanner;

import javax.script.ScriptEngine;
import javax.script.ScriptException;

import com.lilithsthrone.main.Main;
import jdk.nashorn.api.scripting.NashornScriptEngineFactory;

public class LTConsole{
    private static Scanner in = new Scanner(System.in);

    private static ScriptEngine engine;

    private static LTConsole console;

    private static Thread consoleThread;


    public static LTConsole getInstance() {
        if(console != null){
            return console;
        } else {
            console = new LTConsole();
            return console;
        }
    }

    private LTConsole() {
        NashornScriptEngineFactory factory = new NashornScriptEngineFactory();
        engine = factory.getScriptEngine("-strict", "-scripting");
        engine.put("player", Main.game.getPlayer());
        consoleThread = new Thread(()->{
            while(!Thread.currentThread().isInterrupted()) {
                while(in.hasNextLine()) {
                    String line = in.nextLine();
                    console.eval(line);
                }
            }
        },"Console-thread");
        consoleThread.setDaemon(true);
        consoleThread.start();
    }

    private void eval(String statement) {
        try{
            String msg = (String) engine.eval(statement);
            if(msg != null){
                System.out.println(msg);
            }
        } catch(ScriptException se) {
            System.err.println(se.getMessage());
        }
    }
}
