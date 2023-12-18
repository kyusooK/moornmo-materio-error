package moornmomaterio.domain;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;
import moornmomaterio.BasicApplication;
import moornmomaterio.domain.ProductCreated;

@Entity
@Table(name = "Product_table")
@Data
//<<< DDD / Aggregate Root
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private String code;

    private String spec;

    private ProductStatus productStatus;

    @PostPersist
    public void onPostPersist() {
        ProductCreated productCreated = new ProductCreated(this);
        productCreated.publishAfterCommit();
    }

    public static ProductRepository repository() {
        ProductRepository productRepository = BasicApplication.applicationContext.getBean(
            ProductRepository.class
        );
        return productRepository;
    }
}
//>>> DDD / Aggregate Root
