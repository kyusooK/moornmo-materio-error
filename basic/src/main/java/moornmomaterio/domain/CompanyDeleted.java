package moornmomaterio.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import moornmomaterio.domain.*;
import moornmomaterio.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class CompanyDeleted extends AbstractEvent {

    private Long id;
    private String name;
    private String industry;
    private Date foundedDate;

    public CompanyDeleted(Company aggregate) {
        super(aggregate);
    }

    public CompanyDeleted() {
        super();
    }
}
//>>> DDD / Domain Event
