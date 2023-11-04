package br.edu.ifms.exercicio.exerciciocinco.domain.service;

import br.edu.ifms.exercicio.exerciciocinco.domain.dto.request.ImovelRequest;
import br.edu.ifms.exercicio.exerciciocinco.domain.dto.response.ImovelResponse;
import br.edu.ifms.exercicio.exerciciocinco.domain.model.Endereco;
import br.edu.ifms.exercicio.exerciciocinco.domain.model.Imovel;
import br.edu.ifms.exercicio.exerciciocinco.domain.model.Locatario;
import br.edu.ifms.exercicio.exerciciocinco.domain.repository.EnderecoRepository;
import br.edu.ifms.exercicio.exerciciocinco.domain.repository.ImovelRepository;
import br.edu.ifms.exercicio.exerciciocinco.domain.repository.LocatarioRepository;
import br.edu.ifms.exercicio.exerciciocinco.exception.MessageExceptionNotFound;
import jakarta.annotation.Nullable;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ImovelService {
    @Autowired
    private ImovelRepository imovelRepository;
    @Autowired
    private EnderecoRepository enderecoRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Transactional
    public ImovelResponse salvarImovel(ImovelRequest request){
        Endereco enderecoId = enderecoRepository.findById(request.getEnderecoId())
                .orElseThrow(()-> new MessageExceptionNotFound("Endereço não encontrado!"));

        Imovel imovel = new Imovel();
        imovel.setRegistro(request.getRegistro());
        imovel.setNumero(request.getNumero());
        imovel.setEndereco(enderecoId);
        imovelRepository.save(imovel);

        ImovelResponse imovelResponse = modelMapper.map(imovel, ImovelResponse.class);
        return imovelResponse;
    }
    public List<ImovelResponse> getAllImovel(){
        List<Imovel> imoveis = imovelRepository.findAll();
        return imoveis.stream()
                .map(imovel -> new ImovelResponse(
                        imovel.getId(),
                        imovel.getRegistro(),
                        imovel.getNumero(),
                        imovel.getEndereco().getId()
                )).toList();
    }
    public ImovelResponse getImovelById(Integer id){
        Imovel imovel = imovelRepository.findById(id)
                .orElseThrow(()-> new MessageExceptionNotFound("Imovel não encontrado!"));
        return modelMapper.map(imovel, ImovelResponse.class);
    }
    @Transactional
    public ImovelResponse updateImovel(Integer id, ImovelRequest request){
        Imovel imovel = imovelRepository.findById(id)
                .orElseThrow(()-> new MessageExceptionNotFound("Imovel não encontrado!"));
        imovel.setRegistro(request.getRegistro());
        imovel.setNumero(request.getNumero());
        imovelRepository.save(imovel);
        return modelMapper.map(imovel, ImovelResponse.class);
    }
    public String deleteImovel(Integer id){
        Imovel imovel = imovelRepository.findById(id)
                .orElseThrow(()-> new MessageExceptionNotFound("Imovel não encontrado!"));
        imovelRepository.delete(imovel);
        return "Imovel deletado com sucesso!";
    }
}
