package mou.terminal.web.domain.mysql.portFolio;

import lombok.*;

import javax.persistence.*;

@Builder
@Entity
@Table(name = "portfolioContent")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PortfolioContent {


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "portFolioId", referencedColumnName = "id")
    private Portfolio portfolio;

    @Column(name = "content", nullable = false)
    private String content;

    @Id
    @Column(name = "ref", nullable = false)
    private String ref;

}
