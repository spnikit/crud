package main.model;

import javax.jws.WebMethod;
import javax.jws.WebService;

/**
 * Created by user on 29.05.17.
 */
@WebService
public interface PersonService {

    @WebMethod
    public boolean add(int id, String name, String subject);

    @WebMethod
    public boolean deletePerson(int id);

    @WebMethod
    public Person getPerson(int id);

    @WebMethod
    public Person[] getAllPersons();

    @WebMethod
    public boolean updatePerson(int id, String name, String subject);

}
