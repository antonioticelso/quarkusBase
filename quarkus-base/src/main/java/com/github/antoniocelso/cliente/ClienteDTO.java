package com.github.antoniocelso.cliente;

import java.io.Serializable;
import java.util.Date;

//@Data
//@AllArgsConstructor
//@NoArgsConstructor
public class ClienteDTO implements Serializable {

    private String nome;

    private Long idade;

    private Long cpf;

    private Date dataNascimento;

}

//@Data
//@AllArgsConstructor
//@NoArgsConstructor
//public class CartaoNonPersoDTO implements Serializable {
//
//    private Long nuCartaoNonPerso;
//
//    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
//    private LocalDate dtValidadeCartao;
//
//    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
//    private LocalDate dtEmissaoCartao;
//
//    private Long nuSeqTitularidadePortadorVinculado;
//
//    private Long cdEstadoCartaoNonPerso;
//
//    private ItemEstoqueCartoesNonPersoDTO itemEstoqueCartoesNonPersoDTO ;
//
//    private Long cdTipoCartao;
//
//    private Long nuContaCartaoVinculada;
//
//    private Long nuSequencialLoteRemessa;
//
//}

