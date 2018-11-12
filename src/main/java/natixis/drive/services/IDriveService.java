package natixis.drive.services;

import java.io.IOException;

import javax.xml.bind.JAXBException;

import org.w3c.dom.Document;

import natixis.drive.entities.rsa.Records;

public interface IDriveService {
	
	public String returnDriveString();
	public void xmlToXsdStringUsingXsdGen(String xsd) throws Exception ;
	public void convertXmlDocToXsd() throws Exception;
	public Records createRsaObjectRecords(String stringXml) throws IOException, JAXBException;
}
