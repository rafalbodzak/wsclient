package com.rbo.wsclient;

import com.rbo.wsservice.Person;
import com.rbo.wsservice.PersonService;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by rafal on 15.06.19.
 */
public class Client {


    public static void main (String[] args) throws MalformedURLException{
        URL wsdlURL = new URL("http://localhost:8888/wsservice/person?wsdl");
        QName qname = new QName("http://ws.rbo.com/", "PersonServiceImplService");
        Service service = Service.create(wsdlURL, qname);

        PersonService personService = service.getPort(PersonService.class);

        Person p1 = new Person();
        p1.setId(1);
        p1.setName("cos");
        Integer id = personService.addPerson(p1);
        System.out.println("person created. id = " + id);

        System.out.println("all persons: ");
        for(Person p : personService.getAllPersons().getItem()){
            System.out.println("id: " + p.getId() + ", name: " + p.getName());
        }


    }

}
