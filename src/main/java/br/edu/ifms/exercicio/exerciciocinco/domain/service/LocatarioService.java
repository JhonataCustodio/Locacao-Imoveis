package br.edu.ifms.exercicio.exerciciocinco.domain.service;

import br.edu.ifms.exercicio.exerciciocinco.domain.dto.request.LocatarioRequest;
import br.edu.ifms.exercicio.exerciciocinco.domain.dto.response.LocatarioResponse;
import br.edu.ifms.exercicio.exerciciocinco.domain.model.Imovel;
import br.edu.ifms.exercicio.exerciciocinco.domain.model.Locatario;
import br.edu.ifms.exercicio.exerciciocinco.domain.repository.ImovelRepository;
import br.edu.ifms.exercicio.exerciciocinco.domain.repository.LocatarioRepository;
import br.edu.ifms.exercicio.exerciciocinco.exception.MessageExceptionNotFound;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class LocatarioService {
    @Autowired
    private LocatarioRepository locatorioRepository;

    @Autowired
    private ImovelRepository imovelRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Transactional
    public LocatarioResponse salvarLocatario(LocatarioRequest request){
        Imovel imovelId = imovelRepository.findById(request.getImovelId())
                .orElseThrow(()-> new RuntimeException("Imovel não encontrado!"));

        Locatario locatario = new Locatario();
        locatario.setCpf(request.getCpf());
        locatario.setNome(request.getNome());
        locatario.setSexo(request.getSexo());
        locatario.setImovel(imovelId);

        locatorioRepository.save(locatario);
        LocatarioResponse locatarioResponse = modelMapper.map(locatario, LocatarioResponse.class);
        return locatarioResponse;
    }
    public List<LocatarioResponse> getAllLocatario(){
        List<Locatario> locatarios = locatorioRepository.findAll();
        return locatarios.stream()
                .map(locatario -> new LocatarioResponse(
                        locatario.getId(),
                        locatario.getCpf(),
                        locatario.getNome(),
                        locatario.getSexo(),
                        locatario.getImovel().getId()
                )).toList();
    }
    public LocatarioResponse getLocatarioById(Integer id){
        Locatario locatario = locatorioRepository.findById(id)
                .orElseThrow(()-> new MessageExceptionNotFound("Locatario não encontrado!"));
        return modelMapper.map(locatario, LocatarioResponse.class);
    }
    @Transactional
    public LocatarioResponse updateLocatario(Integer id, LocatarioRequest request){
        Locatario locatario = locatorioRepository.findById(id)
                .orElseThrow(()-> new MessageExceptionNotFound("Locatario não encontrado!"));
        locatario.setCpf(request.getCpf());
        locatario.setNome(request.getNome());
        locatario.setSexo(request.getSexo());
        locatorioRepository.save(locatario);
        return modelMapper.map(locatario, LocatarioResponse.class);
    }
    @Transactional
    public String deleteLocatario(Integer id){
        Locatario locatario = locatorioRepository.findById(id)
                .orElseThrow(()-> new MessageExceptionNotFound("Locatario não encontrado!"));
        locatorioRepository.delete(locatario);
        return "Locatario deletado com sucesso!";
    }

}
