package service.maquinaLavarRoupa;

import entities.MaquinaLavarRoupa;
import repositoryImplements.maquinaLavarRoupa.MaquinaLavarRoupaRepository;

public class UpdateMaquinaLavarRoupaService {
    private MaquinaLavarRoupaRepository maquinaLavarRoupaRepository;

    public UpdateMaquinaLavarRoupaService(){
        this.maquinaLavarRoupaRepository = new MaquinaLavarRoupaRepository();
    }

    public String update(MaquinaLavarRoupa maquinaLavarRoupa, String idMaquinaLavarRoupa){
        String result = this.maquinaLavarRoupaRepository.update(maquinaLavarRoupa, idMaquinaLavarRoupa);
        return result;
    }
}
