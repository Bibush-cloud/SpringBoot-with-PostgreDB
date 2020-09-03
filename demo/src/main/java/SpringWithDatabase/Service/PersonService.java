package SpringWithDatabase.Service;

import SpringWithDatabase.Dal.PersonDal;
import SpringWithDatabase.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PersonService {
    private final PersonDal personDal;

    @Autowired
    public PersonService(@Qualifier("postgres") PersonDal personDal) {
        this.personDal = personDal;
    }

    public int addPerson(Person person){
        return personDal.insertPerson(person);
    }
    public List<Person> getAllPeople() throws SQLException {
        return personDal.selectAllPeople();
    }

    public Optional<Person> getPersonById(UUID id){
        return personDal.selectPersonById(id);
    }

    public int deletePerson(UUID id){
        return personDal.deletePersonById(id);
    }

    public int updatePerson(UUID id, Person newPerson){
        return personDal.updatePersonById(id,newPerson);
    }
}
