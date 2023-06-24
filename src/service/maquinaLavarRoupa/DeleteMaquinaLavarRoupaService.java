package service.maquinaLavarRoupa;

import repositoryImplements.maquinaLavarRoupa.MaquinaLavarRoupaRepository;

public class DeleteMaquinaLavarRoupaService {
    private MaquinaLavarRoupaRepository maquinaLavarRoupaRepository;

    public DeleteMaquinaLavarRoupaService(){
        this.maquinaLavarRoupaRepository = new MaquinaLavarRoupaRepository();
    }

    public String delete(String idMaquinaLavarRoupa){
        String result = this.maquinaLavarRoupaRepository.delete(idMaquinaLavarRoupa);
        return result;
    }
}
