package moornmomaterio.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import moornmomaterio.domain.*;
import moornmomaterio.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class Produced extends AbstractEvent {

    private Long salesOrderNumber;
    private String salesPerson;
    private SalesType salesType;
    private CompanyId companyId;
    private List<SalesItem> salesItems;
    private SalesStatus salesStatus;
    private String status;

    public Produced(SalesOrder aggregate) {
        super(aggregate);
    }

    public Produced() {
        super();
    }
}
//>>> DDD / Domain Event
