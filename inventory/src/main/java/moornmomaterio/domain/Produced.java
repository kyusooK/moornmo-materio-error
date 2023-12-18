package moornmomaterio.domain;

import java.util.*;
import lombok.*;
import moornmomaterio.domain.*;
import moornmomaterio.infra.AbstractEvent;

@Data
@ToString
public class Produced extends AbstractEvent {

    private Long salesOrderNumber;
    private String salesPerson;
    private Object salesType;
    private Object companyId;
    private Object salesItems;
    private Object salesStatus;
    private String status;
}
