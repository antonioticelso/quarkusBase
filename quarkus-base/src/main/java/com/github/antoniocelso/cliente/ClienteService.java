package com.github.antoniocelso.cliente;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;
//import org.eclipse.microprofile.opentracing.Traced

//@Traced
@RequestScoped
public class ClienteService {

    @Inject
    ClienteDao clienteDao;

    @Transactional
    public List<Cliente> listarClientes() {

        return clienteDao.listarClientes();
    }

    public ClienteDTO incluirCliente(ClienteDTO clienteDTO) {

        Cliente entity = new Cliente();
        clienteDao.incluirCliente(entity);

        return clienteDTO;
    }

}

//    @Transactional
//    public List<CartaoNonPersoDTO> buscaPaginadaVinculados(FiltroCartaoDTO filtroCartaoDTO){
//        return converter.entityListToListDTO(cartaoNonPersoDao.listarCartoesVinculadosFiltrados(filtroCartaoDTO));
//    }
//
//    @Transactional
//    public CartaoNonPersoDTO incluirCartaoNonPerso(CartaoNonPersoDTO listaDTO) throws ErroNegocialException {
//
//        CartaoNonPerso entidade = converter.DTOToEntity(listaDTO);
//
//        cartaoNonPersoDao.incluirCartaoNonPerso(entidade);
//
//        listaDTO.setNuCartaoNonPerso(entidade.getNuCartaoNonPerso());
//
//        return listaDTO;
//    }
//
//    @Transactional
//    public Long excluir(Long id) {
//
//        cartaoNonPersoDao.delete(cartaoNonPersoDao.findById(id));
//
//        return id;
//    }
//    @Transactional
//    public CartaoNonPersoDTO alterar(CartaoNonPersoDTO cartaoDTO) {
//        CartaoNonPerso entidade = cartaoNonPersoDao.findById(cartaoDTO.getNuCartaoNonPerso());
//        if(cartaoDTO.getCdEstadoCartaoNonPerso() != null){
//            EstadoCartaoNonPerso estado = estadoDao.findById(cartaoDTO.getCdEstadoCartaoNonPerso());
//            entidade.setEstadoCartaoNonPerso(estado);
//        } if (cartaoDTO.getDtValidadeCartao() != null){
//            entidade.setDtValidadeCartao(cartaoDTO.getDtValidadeCartao() );
//        } if (cartaoDTO.getNuContaCartaoVinculada() != null){
//            entidade.setNuContaCartaoVinculada(cartaoDTO.getNuContaCartaoVinculada());
//        } if (cartaoDTO.getNuSeqTitularidadePortadorVinculado() != null){
//            entidade.setNuSeqTitularidadePortadorVinculado(cartaoDTO.getNuSeqTitularidadePortadorVinculado());
//        } if (cartaoDTO.getNuSequencialLoteRemessa() != null){
//            entidade.setNuSequencialLoteRemessa(cartaoDTO.getNuSequencialLoteRemessa());
//        }
//        return converter.entityToDTO(entidade);
//    }
//}
