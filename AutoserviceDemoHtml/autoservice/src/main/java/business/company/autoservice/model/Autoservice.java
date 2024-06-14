package business.company.autoservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.concurrent.atomic.AtomicInteger;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Autoservice {
    private static AtomicInteger atomicInteger = new AtomicInteger(0);
    private int id = atomicInteger.incrementAndGet()/2;
    private String nameAuto;
    private String nameSupport;
    private int priceSupport;


}

