package service.maquinaLavarRoupa;

import entities.MaquinaLavarRoupa;
import repositoryImplements.maquinaLavarRoupa.MaquinaLavarRoupaRepository;

public class CreateMaquinaLavarRoupaService {
    private MaquinaLavarRoupaRepository maquinaLavarRoupaRepository;

    public CreateMaquinaLavarRoupaService(){
        this.maquinaLavarRoupaRepository = new MaquinaLavarRoupaRepository();
    }

    public String create(MaquinaLavarRoupa maquinaLavarRoupa){
        String result = this.maquinaLavarRoupaRepository.create(maquinaLavarRoupa);

        return result;
    }
}
