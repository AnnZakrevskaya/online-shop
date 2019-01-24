package service;

import repository.PerfumeRepository;
import repository.PerfumeRepositoryImpl;
import service.converter.PerfumeConverter;
import service.model.PerfumeDTO;

import java.util.ArrayList;
import java.util.List;

public class PerfumeServiceImpl implements PerfumeService {
    private static PerfumeServiceImpl instance;

    private PerfumeServiceImpl() {
    }

    public static PerfumeServiceImpl getInstance() {
        if (instance == null) {
            instance = new PerfumeServiceImpl();
        }
        return instance;
    }

    private PerfumeRepository perfumeRepository = PerfumeRepositoryImpl.getInstance();
    private PerfumeConverter perfumeConverter = new PerfumeConverter();

    @Override
    public List<PerfumeDTO> getPerfume() {
        List<PerfumeDTO> perfume = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            PerfumeDTO perfumeDTO = perfumeConverter.perfumeToPerfumeDTO(perfumeRepository.getPerfume((int) (i + 1)));
            perfume.add(perfumeDTO);
        }
        return perfume;
    }

    @Override
    public PerfumeDTO getOnePerfume(int id) {
        PerfumeDTO perfumeDTO = perfumeConverter.perfumeToPerfumeDTO(perfumeRepository.getPerfume((int)(id)));
        return perfumeDTO;
    }

    @Override
    public List<PerfumeDTO> getListAllPerfume() {
        return perfumeConverter.converterPerfumeList(perfumeRepository.getPerfumeList());
    }
}
