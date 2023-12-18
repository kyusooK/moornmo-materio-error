package moornmomaterio.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import moornmomaterio.domain.*;
import moornmomaterio.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class ProductCreated extends AbstractEvent {

    private Long id;
    private String name;
    private String code;
    private String spec;
    private Status status;

    public ProductCreated(Product aggregate) {
        super(aggregate);
    }

    public ProductCreated() {
        super();
    }
}
//>>> DDD / Domain Event
