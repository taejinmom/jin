package controller;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import action.Action;


public class ActionFactory {
	private static ActionFactory factory;
	private Properties prop;
	private ActionFactory() {
		prop = new Properties();
	}
	public static synchronized ActionFactory getFactory() {
		if(factory == null) factory= new ActionFactory();
		return factory;
	}
	/* 책임분리
	if(cmd.equals("hello")) {
		action = new HelloAction();
	}else if(cmd.equals("movielist")) {
		action = new MovieListAction();
	}
	*/
	public Action getAction(String cmd) {
		Action action = null;
		/*if(cmd.equals("hello")) {
			action = new HelloAction();
		}else if(cmd.equals("movielist")) {
			action = new MovieListAction();
		}else if(cmd.equals("profile")) {
			action = new ProfileAction();
		}*/
		
		String path = "D:\\iKosmo113\\web\\workspace\\webMVC0627\\src\\controller\\classinfo.properties";
		try {
			prop.load(new FileReader(path));
			String modelObj = prop.getProperty(cmd);
			// cmd->hello => action.HelloAction
			System.out.println("val :"+modelObj);
			// Class loading
			Class<Action> hc = (Class<Action>) Class.forName(modelObj);
			// 목표완성 action = XX();
			action = hc.newInstance();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return action;
	}
	
}
