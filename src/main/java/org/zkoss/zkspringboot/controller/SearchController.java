package org.zkoss.zkspringboot.controller;


import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.zkoss.bind.annotation.Init;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Image;
import org.zkoss.zul.Label;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.ext.Selectable;

public class SearchController extends SelectorComposer<Component> {

	private static final long serialVersionUID = 1L;
	
	@Wire
	private Textbox keywordBox;
	@Wire
	private Listbox carListbox;
	@Wire
	private Listbox tabla;
	@Wire
	private Label modelLabel;
	@Wire
	private Label makeLabel;
	@Wire
	private Label priceLabel;
	@Wire
	private Label descriptionLabel;
	@Wire
	private Image previewImage;
	@Wire
	private Component detailBox;
	
	

	//renderizar en la ui despues que los componentes zk hayan cargardos
	@Override
    public void doAfterCompose(Component comp) throws Exception{
        super.doAfterCompose(comp);

        
      //ejemplo 1 se crea un modelo de tipo listmodel list<persona> se selecionar el listbox y 
      //se le aplica el modelo en la ui se usa etiqueta templade se pone atributo name=model 
      //para con ${each.id} recorrer elementos each es el elemento que se envio 
        List<persona> listtapersonas = new LinkedList<persona>();
		listtapersonas.add(
				new persona(1,"kevin","Mosquera")
				);
		
		listtapersonas.add(
				new persona(2,"jose","ss")
				);
		tabla.setModel(new ListModelList<persona>(listtapersonas));
		//ejemplo 1 fin  
        
    }
	
	
    public SearchController() {

		
	
		
    }
 
	
	



	private CarService carService = new CarServiceImpl();
	
	@Listen("onClick = #otra")
	public void otrapagina(){
		Executions.sendRedirect("/mvvm");
		
	}
	
	
	@Listen("onClick = #searchButton")
	public void search(){
		String keyword = keywordBox.getValue();
		List<Car> result = carService.search(keyword);
		carListbox.setModel(new ListModelList<Car>(result));
	}
	
	@Listen("onClick = #btnmostrar")
	public void buscar(){
		
		List<persona> listtapersonas = new LinkedList<persona>();
		listtapersonas.add(
				new persona(1,"kevin","Mosquera")
				);
		
		listtapersonas.add(
				new persona(2,"jose","ss")
				);
		
		tabla.setModel(new ListModelList<persona>(listtapersonas));
	}
	
	
	@Listen("onSelect = #carListbox")
	public void showDetail(){
		
		detailBox.setVisible(true);
		
		Car selected = carListbox.getSelectedItem().getValue();
		
		previewImage.setSrc(selected.getPreview());
		modelLabel.setValue(selected.getModel());
		makeLabel.setValue(selected.getMake());
		priceLabel.setValue(selected.getPrice().toString());
		descriptionLabel.setValue(selected.getDescription());
		
	
		


		
	}
	
	
	@Listen("onSelect = #tabla")
	public void show(){

		Set<persona> selectionp = ((Selectable<persona>)tabla.getModel()).getSelection();
		
		if (selectionp!=null && !selectionp.isEmpty()){
			persona selectedp = selectionp.iterator().next();
			Messagebox.show(""+selectedp.getApellido()+"", "Warning", Messagebox.OK, Messagebox.EXCLAMATION);
		}
		
		
		
	}
	
	
}
