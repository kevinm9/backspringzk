package org.zkoss.zkspringboot.controller;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zkmax.zul.Searchbox;
import org.zkoss.zkspringboot.demo.model.Doctor;
import org.zkoss.zkspringboot.demo.model.Especialidad;
import org.zkoss.zkspringboot.demo.model.Identificacion;
import org.zkoss.zkspringboot.demo.model.Paciente;
import org.zkoss.zkspringboot.demo.model.Reservacion;
import org.zkoss.zul.Bandbox;
import org.zkoss.zul.Button;
import org.zkoss.zul.Datebox;
import org.zkoss.zul.Hbox;
import org.zkoss.zul.Intbox;
import org.zkoss.zul.Label;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Radiogroup;
import org.zkoss.zul.Textbox;

public class controladordeapp extends SelectorComposer<Component> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Wire
	private Intbox txtcedula;
	@Wire
	private Listbox ListboxDOCTORES;
	@Wire
	private Listbox Listboxespecialidad;
	@Wire
	private Searchbox searchboxtipodeidentificacion;
	
	
	@Wire
	private Datebox fechacita;
	@Wire
	private Bandbox bddoctores;
	
	@Wire
	private Radiogroup radiogroupHorario;
	
	@Wire
	private Button btnagendarcita,btnguardarcredito,btnguardardebito,btnsalir;
	
	@Wire
	private Hbox detalledecita;
	
	
	@Wire
	private Label lbpaciente,lbiddocumento,lbespecialidad,lbdoctor,lbfecha,lbhora,lbvalor,lbpagado,lbpmetodo;

	Reservacion reservacion;

	Paciente[] arrayPaciente;

	@Override
    public void doAfterCompose(Component comp) throws Exception{
        super.doAfterCompose(comp);

        
      //cargar combobox de tipo de identificacion  
        final String uri = "http://localhost:8080/identificacion";
        RestTemplate restTemplate = new RestTemplate();
        Identificacion[] arraytiposdeidentidades = restTemplate.getForObject(uri, Identificacion[].class);
        List<Identificacion> listatiposdeidentidades = Arrays.asList(arraytiposdeidentidades);
		searchboxtipodeidentificacion.setModel(new ListModelList<Identificacion>(listatiposdeidentidades));
		
		//cargar combobox de tipo de especialidad  
        final String uriEspecialidad = "http://localhost:8080/especialidad";
        RestTemplate restTemplateEspecialidad = new RestTemplate();
        Especialidad[] arrayEspecialidad= restTemplateEspecialidad.getForObject(uriEspecialidad, Especialidad[].class);
        List<Especialidad> listaEspecialidad= Arrays.asList(arrayEspecialidad);
        Listboxespecialidad.setModel(new ListModelList<Especialidad>(listaEspecialidad));
		
		//cargar combobox de tipo de especialidad  
        final String uriDoctor= "http://localhost:8080/doctor";
        RestTemplate restTemplateDoctor = new RestTemplate();
        Doctor[] arrayDoctor= restTemplateDoctor.getForObject(uriDoctor, Doctor[].class);
        List<Doctor> listaDoctor = Arrays.asList(arrayDoctor);
        ListboxDOCTORES.setModel(new ListModelList<Doctor>(listaDoctor));
        
        bloquear();
        
        reservacion = new Reservacion();
        


    }
	
	
	public void bloquear(){
		

        fechacita.setDisabled(true);
        bddoctores.setDisabled(true);
        radiogroupHorario.setDisabled(true);
        btnagendarcita.setDisabled(true);
        
        detalledecita.setVisible(false);

	}
	
	public void desbloquear(){
        
        fechacita.setDisabled(false);
        bddoctores.setDisabled(false);
        radiogroupHorario.setDisabled(false);
        btnagendarcita.setDisabled(false);
        
	}
	
	
    @Listen("onClick = #btnverificarcedula")
	public void verificarcedula(){
    	
    	
    	String uriverificarcedula= "http://localhost:8080/paciente/cedula?cedula="+txtcedula.getValue().toString();
        RestTemplate restPaciente = new RestTemplate();
        arrayPaciente= restPaciente.getForObject(uriverificarcedula, Paciente[].class);
        
    	
        if(arrayPaciente.length>0){
        	reservacion.setIdpaciente((int) arrayPaciente[0].getId());
        	Messagebox.show("Se encontro al cliente: "+arrayPaciente[0].getNombre(), "Information", Messagebox.OK, Messagebox.INFORMATION);
        	desbloquear();
        }
        else{
        	Messagebox.show("No se encontro al cliente:", "Warning", Messagebox.OK, Messagebox.EXCLAMATION);
        	bloquear();
        }
        

    	
	}
    
    
    @Listen("onClick = #btnagendarcita")
	public void nagendarcita(){
    	 detalledecita.setVisible(true);
    	 
    	 
    	 
    	 Especialidad especialidad = Listboxespecialidad.getSelectedItem().getValue();
    	 Doctor doctor = ListboxDOCTORES.getSelectedItem().getValue();
    	    	 
    	 lbpaciente.setValue(""+arrayPaciente[0].getNombre());
    	 lbiddocumento.setValue("");
    	 lbespecialidad.setValue(especialidad.getNombre());
    	 lbdoctor.setValue(doctor.getNombre());
    	 lbfecha.setValue(""+fechacita.getValue());
    	 lbhora.setValue(""+radiogroupHorario.getSelectedItem().getLabel());
    	 lbvalor.setValue("13.20");
    	 
    	 reservacion.setFecha(""+fechacita.getValue());
    	 reservacion.setHora(""+radiogroupHorario.getSelectedItem().getLabel());
    	 reservacion.setIddoctor((int) doctor.getId());
    	 reservacion.setIdespecialidad((int) especialidad.getId());


    	 reservacion.setValor(13.20);
    	 reservacion.setPagado(false);
    	 
    	 
    	 

	}
    
    @Listen("onClick = #btnguardarcredito")
	public void guardarcredito(){
    reservacion.setPagado(true);
   	petisionpost();
   	lbpmetodo.setValue("(credito)");
    	
    
	}
    
    @Listen("onClick = #btnguardardebito")
	public void guardardebito(){
    reservacion.setPagado(true);
   	petisionpost();
   	lbpmetodo.setValue("(debito)");
	}
    
    public void petisionpost(){
        
    	//post de obj reservacion 
    	
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<Reservacion> entity = new HttpEntity<Reservacion>(reservacion,headers);
        
        RestTemplate restpost = new RestTemplate();
        
        Reservacion respuesta = restpost.exchange(
           "http://localhost:8080/reservacion", HttpMethod.POST, entity, Reservacion.class).getBody();
        

        if (Objects.isNull(respuesta) ){
        	Messagebox.show("No se pudo agendar cita y pagar", "Warning", Messagebox.OK, Messagebox.EXCLAMATION);
            reservacion.setPagado(false);
            lbpagado.setValue("(No pagado)");
        } else {
        	Messagebox.show("Tu cita medica ah sido agendada y paga con exito", "Information", Messagebox.OK, Messagebox.INFORMATION);
        	reservacion = respuesta;
        	lbpagado.setValue("(Pagado)");
        	lbiddocumento.setValue(""+reservacion.getId());
        	btnguardardebito.setVisible(true);
        	btnguardardebito.setVisible(true);
        	btnsalir.setVisible(false);
        }
        
        
	}
    
	
	
	
	
}
