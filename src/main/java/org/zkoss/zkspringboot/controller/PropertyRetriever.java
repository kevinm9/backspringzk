package org.zkoss.zkspringboot.controller;


import java.util.LinkedList;
import java.util.List;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.util.Composer;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zul.Label;
import org.zkoss.zul.Textbox;

import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.*;
import org.zkoss.zul.*;

public class PropertyRetriever extends SelectorComposer<Window> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Wire
	Textbox input; //wired to a component called input
	@Wire
	Vlayout result; //wired to a component called result
	
	@Listen("onClick=#retrieve")
	public void submit(Event event) { //register a listener to a component called retrieve
		String prop = System.getProperty(input.getValue());
		result.appendChild(new Label(prop));
	}
}
