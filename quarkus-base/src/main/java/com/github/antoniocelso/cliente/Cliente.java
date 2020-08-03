package com.github.antoniocelso.cliente;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Entity;
import java.util.Date;

@Entity
public class Cliente extends PanacheEntity {

    private String nome;
    private Long idade;
    private Long cpf;
    private Date dataNascimento;

    @CreationTimestamp
    private Date dataCriacao;

    @UpdateTimestamp
    private Date dataAtualizacao;

}

//@Getter
//@Setter
//@AllArgsConstructor
//@NoArgsConstructor
//@Entity
//@Table(name = "CRT_N_PSZD_SLCT", schema = "ORAPCBOW0001")
//public class CartaoNonPerso extends PanacheEntityBase {
//
//    @Id // Número do Cartão non-perso
//    @Column(name = "NR_CRT_N_PSZD")
//    private Long nuCartaoNonPerso;
//
//    //data emissão do cartão
//    @Column(name = "DT_EMS_CRT")
//    private LocalDate dtEmissaoCartao;
//
//    //Data de Validade do Cartão
//    @Column(name = "DT_VLD_CRT")
//    private LocalDate dtValidadeCartao;
//
//    //número conta cartão vinculação
//    @Column(name = "NR_CT_CRT_VCLC")
//    private Long nuContaCartaoVinculada;
//
//    //número sequencial titularidade portador vinculado
//    @Column(name = "NR_SEQL_TITD_PORT_VCLD")
//    private Long nuSeqTitularidadePortadorVinculado;
//
//    //estado cartão não personalizado
//    @ManyToOne
//    @JoinColumn(name="CD_EST_CRT_N_PSZD")
//    private EstadoCartaoNonPerso estadoCartaoNonPerso;
//
//    @ManyToOne
//    @JoinColumns({
//            @JoinColumn(name = "NR_RMS_ETO", referencedColumnName = "NR_RMS_ETO"),
//            @JoinColumn(name = "NR_LT_RMS_ETO", referencedColumnName = "NR_LT_RMS_ETO"),
//            @JoinColumn(name = "NR_SLCT_CRT_N_PSZD", referencedColumnName = "NR_SLCT_CRT_N_PSZD"),
//    })
//    private ItemEstoqueCartoesNonPerso estoqueCartoesNonPerso;
//
//    //código tipo cartão
//    @Column(name = "CD_TIP_CRT")
//    private Long cdTipoCartao;
//
//    //Token - SEQUENCIAL
//    @Column(name = "NR_SEQL_LT_RMS")
//    private Long nuSequencialLoteRemessa;
//}

