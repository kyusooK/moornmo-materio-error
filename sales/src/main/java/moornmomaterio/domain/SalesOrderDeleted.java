package moornmomaterio.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import moornmomaterio.domain.*;
import moornmomaterio.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class SalesOrderDeleted extends AbstractEvent {

    private Long salesOrderNumber;
    private String salesPerson;
    private SalesType salesType;
    private CompanyId companyId;
    private Status status;
    private List<SalesItem> salesItems;

    public SalesOrderDeleted(SalesOrder aggregate) {
        super(aggregate);
    }

    public SalesOrderDeleted() {
        super();
    }
}
//>>> DDD / Domain Event
