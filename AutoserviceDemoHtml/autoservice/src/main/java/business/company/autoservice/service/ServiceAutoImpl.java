package business.company.autoservice.service;

import business.company.autoservice.model.Autoservice;
import business.company.autoservice.repository.InMemoryAutoserviceDAO;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@AllArgsConstructor
@Data
public class ServiceAutoImpl implements ServiceAuto {
    private final InMemoryAutoserviceDAO repository;

    @Override
    public List<Autoservice> findAllAutoservice() {
        return (List<Autoservice>) repository.findAllAutoservice();
    }

    @Override
    public Autoservice saveAutoservice(Autoservice autoservice) {
        return repository.saveAutoservice(autoservice);
    }

    @Override
    public Autoservice findById(int id) {
        //получаем информацию услуги по её id
        return repository.findById(id);
    }

    //autoservice - новый объект, который должен заменить старый
    //id - id существующей услуги с прежними полями
    @Override
    public Autoservice updateAutoservice(Autoservice autoservice) {
        return repository.updateAutoservice(autoservice);
    }

    @Override
    public void deleteAutoservice(int id) {
        repository.deleteAutoservice(id);//удалили услугу по id если она существует
    }
}
