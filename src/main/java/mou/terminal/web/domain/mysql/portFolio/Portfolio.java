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
@Table(name = "portfolio")
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Portfolio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "type", nullable = false)
    private String type;
//
//    @OneToOne
//    @JoinColumn(name = "id")
//    private PortfolioContent portfolioContent;

    @Column(name = "regDate", nullable = false)
    private LocalDate regDate;


}
