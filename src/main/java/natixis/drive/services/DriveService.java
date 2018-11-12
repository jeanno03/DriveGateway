package natixis.drive.services;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.StringReader;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

//import javax.xml.bind.JAXBContext;
//import javax.xml.bind.Unmarshaller;

import org.springframework.stereotype.Service;
import org.wiztools.xsdgen.XsdGen;

//import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import natixis.drive.entities.rsa.Records;

@Service
public class DriveService implements IDriveService{

	@Override
	public String returnDriveString() {
		String str= "<?xml version=\"1.0\" encoding=\"utf-16\"?><Records count=\"3\"><Metadata><FieldDefinitions><FieldDefinition id=\"22682\" guid=\"0bfcbb80-2a02-4d02-8984-5cbf348fb493\" name=\"Control Name\" alias=\"Control_Name\" /><FieldDefinition id=\"22679\" guid=\"ff320dec-379a-4154-83e7-6ef0bbdb606f\" name=\"Nb Antivirus Installes\" alias=\"Nb_Antivirus_Installes\" /><FieldDefinition id=\"22678\" guid=\"0ae11114-ae06-464f-9e08-b1b68aa5f2b0\" name=\"Nb Postes Travail\" alias=\"Nb_Postes_Travail\" /><FieldDefinition id=\"22681\" guid=\"107ce810-0324-4745-8682-ad420a20395c\" name=\"Exploitation Vuln\" alias=\"Exploitation_Vuln\" /><FieldDefinition id=\"22677\" guid=\"d762a559-e32a-45e5-9064-d538c7aacfd0\" name=\"FormuleToApply\" alias=\"FormuleToApply\" /><FieldDefinition id=\"22680\" guid=\"3c19fc58-8517-45e2-94d3-865c98124cf5\" name=\"Pourcentage Conformite\" alias=\"Pourcentage_Conformite\" /></FieldDefinitions></Metadata><LevelCounts><LevelCount id=\"287\" guid=\"6f22f885-b890-4c9e-970b-8d9a9bb58dd5\" count=\"3\" /></LevelCounts><Record contentId=\"3537257\" levelId=\"287\" levelGuid=\"6f22f885-b890-4c9e-970b-8d9a9bb58dd5\" moduleId=\"469\" parentId=\"0\"><Field id=\"22682\" guid=\"0bfcbb80-2a02-4d02-8984-5cbf348fb493\" type=\"1\">CNT-3537257</Field><Field id=\"22679\" guid=\"ff320dec-379a-4154-83e7-6ef0bbdb606f\" type=\"2\">25</Field><Field id=\"22678\" guid=\"0ae11114-ae06-464f-9e08-b1b68aa5f2b0\" type=\"2\">100</Field><Field id=\"22681\" guid=\"107ce810-0324-4745-8682-ad420a20395c\" type=\"2\">0</Field><Field id=\"22677\" guid=\"d762a559-e32a-45e5-9064-d538c7aacfd0\" type=\"1\">[22679]/[22679]*100</Field><Field id=\"22680\" guid=\"3c19fc58-8517-45e2-94d3-865c98124cf5\" type=\"2\" /></Record><Record contentId=\"3537258\" levelId=\"287\" levelGuid=\"6f22f885-b890-4c9e-970b-8d9a9bb58dd5\" moduleId=\"469\" parentId=\"0\"><Field id=\"22682\" guid=\"0bfcbb80-2a02-4d02-8984-5cbf348fb493\" type=\"1\">CNT-3537258</Field><Field id=\"22679\" guid=\"ff320dec-379a-4154-83e7-6ef0bbdb606f\" type=\"2\">0</Field><Field id=\"22678\" guid=\"0ae11114-ae06-464f-9e08-b1b68aa5f2b0\" type=\"2\">100</Field><Field id=\"22681\" guid=\"107ce810-0324-4745-8682-ad420a20395c\" type=\"2\">15</Field><Field id=\"22677\" guid=\"d762a559-e32a-45e5-9064-d538c7aacfd0\" type=\"1\">100-[22681]</Field><Field id=\"22680\" guid=\"3c19fc58-8517-45e2-94d3-865c98124cf5\" type=\"2\" /></Record><Record contentId=\"3537259\" levelId=\"287\" levelGuid=\"6f22f885-b890-4c9e-970b-8d9a9bb58dd5\" moduleId=\"469\" parentId=\"0\"><Field id=\"22682\" guid=\"0bfcbb80-2a02-4d02-8984-5cbf348fb493\" type=\"1\">CNT-3537259</Field><Field id=\"22679\" guid=\"ff320dec-379a-4154-83e7-6ef0bbdb606f\" type=\"2\">0,4</Field><Field id=\"22678\" guid=\"0ae11114-ae06-464f-9e08-b1b68aa5f2b0\" type=\"2\">0,6</Field><Field id=\"22681\" guid=\"107ce810-0324-4745-8682-ad420a20395c\" type=\"2\">5</Field><Field id=\"22677\" guid=\"d762a559-e32a-45e5-9064-d538c7aacfd0\" type=\"1\">100*([22678]-[22679])-[22681]</Field><Field id=\"22680\" guid=\"3c19fc58-8517-45e2-94d3-865c98124cf5\" type=\"2\" /></Record></Records>";
		return str;
	}
	
	@Override
	public void xmlToXsdStringUsingXsdGen(String stringXml) throws Exception {
		// TODO Auto-generated method stub
	    	    java.io.FileWriter fw = new java.io.FileWriter("C:\\Users\\Jeannory.Phou\\eclipse-workspace\\DriveGateway\\documents\\output\\creationFromString.xml");
	    	    fw.write(stringXml);
	    	    fw.close();
	    	    
	    		System.out.println("find your file to C:\\Users\\Jeannory.Phou\\eclipse-workspace\\DriveGateway\\documents\\output\\creationFromString.xml");
	    					
	}
	
	@Override
	public void convertXmlDocToXsd() throws Exception{
		File file = new File("C:\\Users\\Jeannory.Phou\\eclipse-workspace\\DriveGateway\\documents\\output\\creationFromString.xml");

		XsdGen gen = new XsdGen();
		gen.parse(file);

		File out = new File("C:\\Users\\Jeannory.Phou\\eclipse-workspace\\DriveGateway\\documents\\output\\creationFromXml.xsd");
		gen.write(new FileOutputStream(out));	
	}
	
//	public Records createRsaObjectRecords(String stringXml) throws IOException{
//		XmlMapper xmlMapper = new XmlMapper();
//		Records records = xmlMapper.readValue(stringXml, Records.class);
//		return records;
//
//	}
	@Override
	public Records createRsaObjectRecords(String stringXml) throws IOException, JAXBException{
		StringReader sr = new StringReader(stringXml);
		JAXBContext jaxbContext = JAXBContext.newInstance(Records.class);
		Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
		Records records = (Records) unmarshaller.unmarshal(sr);
		return records;
	}

	
	


}
