package service.converter;

import repository.model.Perfume;
import service.model.PerfumeDTO;

import java.util.ArrayList;
import java.util.List;

public class PerfumeConverter {
    public PerfumeDTO perfumeToPerfumeDTO(Perfume perfume){
        PerfumeDTO perfumeDTO = PerfumeDTO.newBuilder()
                .id_perfume(perfume.getId_perfume())
                .name_perfume(perfume.getName_perfume())
                .size(perfume.getSize())
                .quantity(perfume.getQuantity())
                .price(perfume.getPrice())
                .image(perfume.getImage_adress())
                .type(perfume.getType())
                .build();
        return perfumeDTO;
    }
    public List<PerfumeDTO> converterPerfumeList(List<Perfume> perfumeList){
        List<PerfumeDTO> perfumeDTOList= new ArrayList<>();
        for (Perfume perfume : perfumeList) {
            perfumeDTOList.add(perfumeToPerfumeDTO(perfume));
        }
        return perfumeDTOList;
    }
}
