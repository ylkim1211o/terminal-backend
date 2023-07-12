package mou.terminal.web.domain.mysql.portFolio;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Builder
@Entity
@Table(name = "portFolioChangeRecord")
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PortfolioChangeRecord {

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "type", nullable = false)
    private String type;

    @Column(name = "content", nullable = false)
    private String content;

    @Id
    @Column(name = "ref", nullable = false)
    private String ref;

    @Column(name = "regDate", nullable = false)
    private LocalDate regDate;



}
