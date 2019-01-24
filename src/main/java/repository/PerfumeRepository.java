package repository;

import repository.model.Perfume;

import java.util.List;

public interface PerfumeRepository {
    Perfume getPerfume(Integer id);
    List<Perfume> getPerfumeList();
}
