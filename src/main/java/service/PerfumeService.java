package service;

import service.model.PerfumeDTO;

import java.util.List;

public interface PerfumeService {
    List<PerfumeDTO> getPerfume();
    PerfumeDTO getOnePerfume(int id);
    List<PerfumeDTO> getListAllPerfume();
}
