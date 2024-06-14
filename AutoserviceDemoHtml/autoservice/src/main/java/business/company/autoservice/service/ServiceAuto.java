package business.company.autoservice.service;

import business.company.autoservice.model.Autoservice;

import java.util.List;

public interface ServiceAuto {
    //    метод создания новой услуги
    Autoservice saveAutoservice(Autoservice autoservice);

    //метод возвращает список услуг
    List<Autoservice> findAllAutoservice();

    //метод возврашает услугу по идентификатору id
    Autoservice findById(int id);

    //метод обновляет услугу по заданному id
    // возвращает true если данные были обновлены и false если нет
    Autoservice updateAutoservice(Autoservice autoservice);

    //метод удаляет услугу по заданному id
    default void deleteAutoservice(int id) {
    }

}
