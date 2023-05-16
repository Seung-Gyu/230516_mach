package mach.domain;

import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;
import mach.BasicApplication;
import mach.domain.SpecAdded;
import org.springframework.context.ApplicationContext;

@Entity
@Table(name = "Spec_table")
@Data
public class Spec {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @PostPersist
    public void onPostPersist() {
        SpecAdded specAdded = new SpecAdded(this);
        specAdded.publishAfterCommit();
    }

    public static SpecRepository repository() {
        SpecRepository specRepository = applicationContext()
            .getBean(SpecRepository.class);
        return specRepository;
    }

    public static ApplicationContext applicationContext() {
        return BasicApplication.applicationContext;
    }
}
