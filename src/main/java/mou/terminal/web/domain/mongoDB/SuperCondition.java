package mou.terminal.web.domain.mongoDB;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;

@Getter
@Setter
@NoArgsConstructor
public class SuperCondition {
    @Id
    protected String id;
}
