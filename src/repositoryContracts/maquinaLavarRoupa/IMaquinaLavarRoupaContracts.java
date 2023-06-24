package repositoryContracts.maquinaLavarRoupa;

import java.util.List;

import entities.MaquinaLavarRoupa;

public interface IMaquinaLavarRoupaContracts {
    String create(MaquinaLavarRoupa maquinaLavarRoupa);
    List<MaquinaLavarRoupa> read();
    String update(MaquinaLavarRoupa maquinaLavarRoupa, String idMaquinaLavarRoupa);
    String delete(String idMaquinaLavarRoupa);
}
