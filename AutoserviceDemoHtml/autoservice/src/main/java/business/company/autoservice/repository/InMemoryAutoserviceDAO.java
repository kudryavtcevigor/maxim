package business.company.autoservice.repository;

import business.company.autoservice.model.Autoservice;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

@Repository
//хранилище данных приложения
public class InMemoryAutoserviceDAO {
    //все услуги будут храниться в коллекции ArrayList

    private List<Autoservice> AUTOSERVICE = new ArrayList<>();

    public List<Autoservice> findAllAutoservice() {
        return AUTOSERVICE;
    }

    public Autoservice findById(int id) {
        return AUTOSERVICE.stream()
                .filter(element -> element.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public Autoservice saveAutoservice(Autoservice autoservice) {
        AUTOSERVICE.add(autoservice);
        return autoservice;
    }

    public Autoservice updateAutoservice(Autoservice autoservice) {
        var autoserviceIndex = IntStream.range(0, AUTOSERVICE.size())
                .filter(index -> AUTOSERVICE.get(index).getId() == autoservice.getId())
                .findFirst()
                .orElse(-1);
        if (autoserviceIndex > -1) {
            AUTOSERVICE.set(autoserviceIndex, autoservice);
            return autoservice;
        }
        return null;
    }

    public void deleteAutoservice(int id) {
        var autoservice = findById(id);
        if (autoservice != null) {
            AUTOSERVICE.remove(autoservice);
        }
    }

}
