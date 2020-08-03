package com.github.antoniocelso.cliente;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.RequestScoped;
import java.util.List;

import static io.quarkus.hibernate.orm.panache.PanacheEntityBase.listAll;

//@Traced
@RequestScoped
public class ClienteDao implements PanacheRepository<Cliente> {
    public List<Cliente> listarClientes() {
        return listAll();
    }
}

//public class CartaoNonPersoDao implements PanacheRepository<CartaoNonPerso> {
//
//    public void incluirCartaoNonPerso(CartaoNonPerso entidade) {
//        persist(entidade);
//    }
//
//    public List<CartaoNonPerso> listarCartoesVinculadosFiltrados(FiltroCartaoDTO filtroCartaoDTO) {
//        Map<String, Object> params = new HashMap<>();
//
//        StringBuilder filters = new StringBuilder();
//        filters.append(" estadoCartaoNonPerso.codigoEstado = 2 ");
//        if (Objects.nonNull(filtroCartaoDTO.getCdAgencia())) {
//
//            filters.append("and estoqueCartoesNonPerso.id.solicitacaoCartaoNonPerso" +
//                    ".cdUnidadeOrganizacionalDestino = :agencia ");
//            params.put("agencia", filtroCartaoDTO.getCdAgencia());
//
//        }
//        if (Objects.nonNull(filtroCartaoDTO.getCodigoModalidadeCartaoCredito()) &&
//                Objects.nonNull(filtroCartaoDTO.getCodigoSubModalidadeCartao())) {
//
//            filters.append("and estoqueCartoesNonPerso.id.solicitacaoCartaoNonPerso.cdModalidadeCartaoNonPerso" +
//                    " = :codigoModalidade and estoqueCartoesNonPerso.id.solicitacaoCartaoNonPerso" +
//                    ".cdSubModalidadeCartaoNonPerso = :codigoSubModalidade ");
//            params.put("codigoModalidade", filtroCartaoDTO.getCodigoModalidadeCartaoCredito());
//            params.put("codigoSubModalidade", filtroCartaoDTO.getCodigoSubModalidadeCartao());
//
//        }
//        // lote
//        if (Objects.nonNull(filtroCartaoDTO.getNuLote())) {
//            filters.append("and estoqueCartoesNonPerso.id.nuLoteEstoque = :nuLote ");
//            params.put("nuLote", filtroCartaoDTO.getNuLote());
//        }
//        //remessa
//        if (Objects.nonNull(filtroCartaoDTO.getNuRemessa())) {
//            filters.append("and estoqueCartoesNonPerso.id.nuRemessaEstoque = :nuRemessa ");
//            params.put("nuRemessa", filtroCartaoDTO.getNuRemessa());
//        }
//        //sequencial
//        if (Objects.nonNull(filtroCartaoDTO.getNuSequencial())) {
//            filters.append("and nuSequencialLoteRemessa = :nuSequencial ");
//            params.put("nuSequencial", filtroCartaoDTO.getNuSequencial());
//        }
//        //data
//        if (Objects.nonNull(filtroCartaoDTO.getDataValidade())) {
//            filters.append("and dtValidadeCartao = :dataValidade");
//            params.put("dataValidade", filtroCartaoDTO.getDataValidade());
//        }
//        return find(filters.toString(), params).list();
//    }
//
//    public List<CartaoNonPerso> listarVinculacoes() {
//        return list("estadoCartaoNonPerso.codigoEstado", EnumEstadoCartaoNonPerso.VINCULACAO_INICIADA.getCodigo());
//    }
//
//    public CartaoNonPerso listarPorToken(ContaTokenCartaoNonPersoDTO contaTokeCartaoDTO) {
//        Map<String, Object> params = new HashMap<>();
//
//        StringBuilder filters = new StringBuilder();
//        filters.append(" estadoCartaoNonPerso.codigoEstado = 1 ");
//
//        // Agencia
//        if (Objects.nonNull(contaTokeCartaoDTO.getLote())) {
//            filters.append("and estoqueCartoesNonPerso.id.solicitacaoCartaoNonPerso.cdUnidadeOrganizacionalDestino" +
//                    " = :nuAgencia ");
//            params.put("nuAgencia", contaTokeCartaoDTO.getAgencia());
//        }
//        // lote
//        if (Objects.nonNull(contaTokeCartaoDTO.getLote())) {
//            filters.append("and estoqueCartoesNonPerso.id.nuLoteEstoque = :nuLote ");
//            params.put("nuLote", contaTokeCartaoDTO.getLote());
//        }
//        //remessa
//        if (Objects.nonNull(contaTokeCartaoDTO.getRemessa())) {
//            filters.append("and estoqueCartoesNonPerso.id.nuRemessaEstoque = :nuRemessa ");
//            params.put("nuRemessa", contaTokeCartaoDTO.getRemessa());
//        }
//        //sequencial
//        if (Objects.nonNull(contaTokeCartaoDTO.getSequencial())) {
//            filters.append("and nuSequencialLoteRemessa = :nuSequencial ");
//            params.put("nuSequencial", contaTokeCartaoDTO.getSequencial());
//        }
//
//        return find(filters.toString(), params).firstResult();
//    }
//
//    public List<CartaoNonPerso> listarCartoesDestruirFiltrados(FiltroCartaoDestruidoDTO filtroCartaoDestruidoDTO) {
//        Map<String, Object> params = new HashMap<>();
//
//        StringBuilder filters = new StringBuilder();
//        filters.append(" 1 = 1 ");
//
//        // Agencia
//        if ( Objects.nonNull(filtroCartaoDestruidoDTO.getAgencia() )) {
//            filters.append("and estoqueCartoesNonPerso.id.solicitacaoCartaoNonPerso.cdUnidadeOrganizacionalDestino = :nuAgencia ");
//            params.put("nuAgencia", filtroCartaoDestruidoDTO.getAgencia() );
//        }
//
//        //Plástico
//        if ( Objects.nonNull(filtroCartaoDestruidoDTO.getPlastico() )) {
//            filters.append("and nuCartaoNonPerso = :nuPlastico ");
//            params.put("nuPlastico", filtroCartaoDestruidoDTO.getPlastico() );
//        }
//
//        // TOKEN
//        // lote
//        if (Objects.nonNull(filtroCartaoDestruidoDTO.getLote())) {
//            filters.append("and estoqueCartoesNonPerso.id.nuLoteEstoque = :nuLote ");
//            params.put("nuLote", filtroCartaoDestruidoDTO.getLote());
//        }
//        //remessa
//        if (Objects.nonNull(filtroCartaoDestruidoDTO.getRemessa())) {
//            filters.append("and estoqueCartoesNonPerso.id.nuRemessaEstoque = :nuRemessa ");
//            params.put("nuRemessa", filtroCartaoDestruidoDTO.getRemessa());
//        }
//        //sequencial
//        if (Objects.nonNull(filtroCartaoDestruidoDTO.getSequencial())) {
//            filters.append("and nuSequencialLoteRemessa = :nuSequencial ");
//            params.put("nuSequencial", filtroCartaoDestruidoDTO.getSequencial());
//        }
//
//
//        return find(filters.toString(), params).list();
//
//    }
//
//}
