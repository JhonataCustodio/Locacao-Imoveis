package br.edu.ifms.exercicio.exerciciocinco.domain.service;

import br.edu.ifms.exercicio.exerciciocinco.domain.dto.request.EnderecoRequest;
import br.edu.ifms.exercicio.exerciciocinco.domain.dto.response.EnderecoResponse;
import br.edu.ifms.exercicio.exerciciocinco.domain.model.Endereco;
import br.edu.ifms.exercicio.exerciciocinco.domain.repository.EnderecoRepository;
import br.edu.ifms.exercicio.exerciciocinco.exception.MessageExceptionNotFound;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EnderecoService {
    @Autowired
    private EnderecoRepository enderecoRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Transactional
    public EnderecoResponse salvarEndereco(EnderecoRequest request){
        Endereco endereco = modelMapper.map(request, Endereco.class);

        enderecoRepository.save(endereco);
        EnderecoResponse enderecoResponse = modelMapper.map(endereco, EnderecoResponse.class);
        return enderecoResponse;
    }
    public List<EnderecoResponse> getAllEndereco(){
        List<Endereco> enderecos = enderecoRepository.findAll();
        return enderecos.stream()
                .map(endereco -> new EnderecoResponse(
                        endereco.getId(),
                        endereco.getRua(),
                        endereco.getCep(),
                        endereco.getBairro(),
                        endereco.getCidade(),
                        endereco.getEstado()
                )).toList();
    }
    public EnderecoResponse getEnderecoById(Integer id){
        Endereco endereco = enderecoRepository.findById(id)
                .orElseThrow(()-> new MessageExceptionNotFound("Endereço não encontrado!"));
        return modelMapper.map(endereco, EnderecoResponse.class);
    }
    @Transactional
    public EnderecoResponse updateEndereco(Integer id, EnderecoRequest request){
        Endereco endereco = enderecoRepository.findById(id)
                .orElseThrow(()-> new MessageExceptionNotFound("Endereço não encontrado!"));
        endereco.setRua(request.getRua());
        endereco.setCep(request.getCep());
        endereco.setBairro(request.getBairro());
        endereco.setCidade(request.getCidade());
        endereco.setEstado(request.getEstado());
        enderecoRepository.save(endereco);
        return modelMapper.map(endereco, EnderecoResponse.class);
    }
    @Transactional
    public String deleteEndereco(Integer id){
        Endereco endereco = enderecoRepository.findById(id)
                .orElseThrow(()-> new MessageExceptionNotFound("Endereço não encontrado!"));
        enderecoRepository.delete(endereco);
        return "Endereço deletado com sucesso!";
    }
}
