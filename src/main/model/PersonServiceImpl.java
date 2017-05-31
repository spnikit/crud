package main.model;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by user on 29.05.17.
 */
@WebService(endpointInterface = "main.model.PersonService")

public class PersonServiceImpl implements PersonService {

    //    private Person person;
    private static Map<Integer, Person> persons = new HashMap<Integer, Person>();

    public PersonServiceImpl() {
        for (int i = 0; i < 3; i++) {
            persons.put(i, new Person(i, "defaultName", "defaulSubj"));
        }
    }

    @Override
    public boolean add(int id, String name, String subject) {
        Person p = new Person(id, name, subject);
        System.out.println(p);
        if (persons.get(p.getId()) != null) return false;

        persons.put(p.getId(), p);
        return true;

    }

    @Override
    public boolean deletePerson(int id) {
        if (persons.get(id) == null) {
            return false;
        }
        persons.remove(id);
        return true;
    }

    @Override
    public Person getPerson(int id) {
        return persons.get(id);
    }

    @Override
    public Person[] getAllPersons() {
        Set<Integer> ids = persons.keySet();
        Person[] p = new Person[ids.size()];

        int i = 0;

        for (Integer id : ids) {
            p[i] = persons.get(id);
            i++;
        }
        return p;
    }

    @Override
    public boolean updatePerson(int id, String name, String subject) {
        if (this.getPerson(id) == null) {
            return false;
        }
        Person p = this.getPerson(id);
        p.setName(name);
        p.setSubject(subject);
        persons.put(p.getId(), p);

        return true;


    }
}
