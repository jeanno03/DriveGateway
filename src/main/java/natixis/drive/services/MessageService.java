package natixis.drive.services;

import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Service;

import natixis.drive.entities.MyMessage;
import natixis.drive.entities.MyType;

@Service
public class MessageService implements IMessageService{
	
	@Override
	public MyMessage getMessage(Long id) {
		
		MyType myTypeError = getMyType(1L) ;
		MyType myTypeSuccess = getMyType(2L) ;
		
		MyMessage my01 = new MyMessage(1L, "Création du document xml réussis");
		my01.setMyType(myTypeSuccess);
		MyMessage my02 = new MyMessage(2L, "Création du document xsd réussis");
		my02.setMyType(myTypeSuccess);
		MyMessage my03 = new MyMessage(3L, "Création de l'object RSA Records Réussis");
		my03.setMyType(myTypeSuccess);
		
		HashSet<MyMessage> myMessages = new HashSet<MyMessage>() {
			{
			add(my01);
			add(my02);
			add(my03);
			}
		};
		
	
		for(MyMessage my : myMessages) {
			
			if(my.getId()==id) {
				return my;
			}
		}
		
		MyMessage myMessageNoFound = new MyMessage (0L, "Message no found");

		myMessageNoFound.setMyType(myTypeError);
		 return myMessageNoFound;
		
	}
	
	private MyType getMyType(Long id) {
		if(id==1L) {
			MyType myType = new MyType(1L, "error");
			return myType;
		}
		
		if(id==2L) {
			MyType myType = new MyType(2L, "Success");
			return myType;
		}
		return null;		
	}

}
