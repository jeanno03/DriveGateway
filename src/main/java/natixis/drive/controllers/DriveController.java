package natixis.drive.controllers;

import java.io.File;
import java.io.FileOutputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.wiztools.xsdgen.XsdGen;

import natixis.drive.entities.MyMessage;
import natixis.drive.entities.rsa.Records;
import natixis.drive.services.IDriveService;
import natixis.drive.services.IMessageService;

@RestController
public class DriveController {
	
	@Autowired
	IDriveService iDriveService;
	
	@Autowired
	IMessageService iMessageService;
	
	@CrossOrigin("*")
	@RequestMapping(value = "/convertRsaXmlStringToXmlDoc", method = RequestMethod.GET)
	public MyMessage convertRsaXmlStringToXmlDoc() throws Exception {
		
		//Récupération du xml string de rsa archer
		String rsaString = iDriveService.returnDriveString();
		
		//Trasnforme le xml string to a file
		iDriveService.xmlToXsdStringUsingXsdGen(rsaString);
		
		MyMessage myMessage = iMessageService.getMessage(1L);
		
		return myMessage;
	}
	
	
	@CrossOrigin("*")
	@RequestMapping(value = "/convertXmlDocToXsd", method = RequestMethod.GET)
	public MyMessage convertXmlDocToXsd() throws Exception{
		
		//Attention mettre le xml en utf-8 sinon ca plante
		//https://stackoverflow.com/questions/3030903/content-is-not-allowed-in-prolog-when-parsing-perfectly-valid-xml-on-gae

		//Transform le xml file généré to a xsd
		iDriveService.convertXmlDocToXsd();
		MyMessage myMessage = iMessageService.getMessage(2L);
		
		return myMessage;
	}
	
	//Creation de l'objet rsa archer en parametre un string retourne l'objet
	@CrossOrigin("*")
	@RequestMapping(value = "/createRsaObjectRecords", method = RequestMethod.GET)
	public Records createRsaObjectRecords() throws Exception{
		
		//Récupération du xml string de rsa archer
		String rsaString = iDriveService.returnDriveString();	
		Records records = iDriveService.createRsaObjectRecords(rsaString);
		
		return records;		
	}
	
	//Creation de l'objet rsa archer en parametre un string retourne message de succes
	@CrossOrigin("*")
	@RequestMapping(value = "/createRsaObjectRecordsMessage", method = RequestMethod.GET)
	public MyMessage createRsaObjectRecordsMessage() throws Exception{
		
		//Récupération du xml string de rsa archer
		String rsaString = iDriveService.returnDriveString();		
		Records records = iDriveService.createRsaObjectRecords(rsaString);
		
		MyMessage myMessage = iMessageService.getMessage(3L);
		
		return myMessage;
		
	}
	

}
